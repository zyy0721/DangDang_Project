package com.zyy.dao;
/**
 * ���ݷ��ʲ㳬��
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
	private static final String URL="jdbc:mysql://localhost:3306/project?serverTimezone=GMT";//���ݿ� ��ַ(��ͬ�����ݿ��в�ͬ�Ĺ��з�����
	private static final String DRIVER="com.mysql.jdbc.Driver";//��ͬ���ݿ��������ĵ�ַ
	private static final String UNAME="root";//��¼���ݿ�� �û���/Ȩ����
	private static final String UPWD="zyy123";//��¼���ݿ������ 
	//ʹ�þ�̬��������ݿ�����
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//����JDBC�е�������Ķ���
	private Connection conn = null;//���ݿ����Ӷ���
	protected ResultSet resultSet = null;//���ݿ��ѯ��Ľ����
	private PreparedStatement pstmt = null;//���ݿ��������Ԥ�������
	/**
	 * �������ݿ����Ӷ���ķ���
	 */
	private void getConn() {
		try {
			conn = DriverManager.getConnection(URL,UNAME,UPWD);
			System.out.println("���ӳɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ʧ��"+e.getMessage());
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
	 * ִ�����ݿ�Ĳ�ѯ����
	 * ע�⣺�ڴ˷����в���ʹ��finally���ر����ݿ�������Լ��ͷ���Դ
	 * ��Ϊ��resultSet�����б����˲�ѯ����ı�ʾ
	 * @param params
	 * @param sql
	 * @return
	 */
	protected ResultSet excuteSelect(Object[] params,String sql) {
		//�������ݿ����ӵķ���
		this.getConn();
		try {
			//����Ԥ�������
			pstmt = conn.prepareStatement(sql);
			
			//�Բ�ѯ��������Ԥ����
			if(null!=params) {
				for(int i=0;i<params.length;i++) {
					pstmt.setObject(i+1, params[i]);
				}
			}
			//ִ�в�ѯ���������ؽ��������
			resultSet = pstmt.executeQuery();
		}catch(SQLException e) {
			//
			e.printStackTrace();
		}
		return resultSet;
	}
	//��ɾ��
	protected int excuteEdit(Object[] params,String sql) {
		int count=0;
		//�������ݿ����ӵķ���
		this.getConn();
		try {
			//����Ԥ�������
			pstmt = conn.prepareStatement(sql);
			
			//�Բ�ѯ��������Ԥ����

				for(int i=0;i<params.length;i++) {
					pstmt.setObject(i+1, params[i]);
				}
			
			//ִ�в�ѯ���������ؽ��������
			count = pstmt.executeUpdate();
		}catch(SQLException e) {
			//
			e.printStackTrace();
		}finally {//���try������return ��Ҫ�ȿ�finally��û����䣬�о���ִ�У��ٷ���ִ��return
			this.closeAll();
		}
		return count;
	}


}
