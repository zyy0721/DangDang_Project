package com.zyy.dao;
/**
 * 数据访问层超类
 * @author zyy79
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.zyy.vo.book.BookInfo;

public class BaseDao {
	private static final String URL="jdbc:mysql://localhost:3306/project?serverTimezone=GMT";//数据库 地址(不同的数据库有不同的固有方法）
	private static final String DRIVER="com.mysql.jdbc.Driver";//不同数据库的驱动类的地址
	private static final String UNAME="root";//登录数据库的 用户名/权限名
	private static final String UPWD="zyy123";//登录数据库的密码 
	//使用静态块加载数据库驱动
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//声明JDBC中的三大核心对象
	private Connection conn = null;//数据库连接对象
	protected ResultSet resultSet = null;//数据库查询后的结果集
	private PreparedStatement pstmt = null;//数据库操作命令预处理对象
	/**
	 * 创建数据库连接对象的方法
	 */
	private void getConn() {
		try {
			conn = DriverManager.getConnection(URL,UNAME,UPWD);
			System.out.println("连接成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("失败"+e.getMessage());
		}
		
	}
	
	protected void closeAll() {
		if(null!=resultSet) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=pstmt) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 执行数据库的查询方法
	 * 注意：在此方法中不能使用finally来关闭数据库的连接以及释放资源
	 * 因为：resultSet对象中保存了查询结果的表示
	 * @param params
	 * @param sql
	 * @return
	 */
	protected ResultSet excuteSelect(Object[] params,String sql) {
		//调用数据库连接的方法
		this.getConn();
		try {
			//创建预处理对象
			pstmt = conn.prepareStatement(sql);
			
			//对查询条件进行预处理
			if(null!=params) {
				for(int i=0;i<params.length;i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			//执行查询操作并返回结果集对象
			resultSet = pstmt.executeQuery();
		}catch(SQLException e) {
			//
			e.printStackTrace();
		}
		return resultSet;
	}
	//增删改
	protected int excuteEdit(Object[] params,String sql) {
		int count=0;
		//调用数据库连接的方法
		this.getConn();
		try {
			//创建预处理对象
			pstmt = conn.prepareStatement(sql);
			
			//对查询条件进行预处理

				for(int i=0;i<params.length;i++) {
					pstmt.setObject(i+1, params[i]);
				}
			
			//执行查询操作并返回结果集对象
			count = pstmt.executeUpdate();
		}catch(SQLException e) {
			//
			e.printStackTrace();
		}finally {//如果try块中有return ，要先看finally有没有语句，有就先执行，再返回执行return
			this.closeAll();
		}
		return count;
	}


}
