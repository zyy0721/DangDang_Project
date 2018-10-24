package com.zyy.dao.user.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyy.dao.BaseDao;
import com.zyy.dao.user.IUserDao;
import com.zyy.vo.user.UserInfo;

public class UserDaoImpl extends BaseDao implements IUserDao {

	@Override
	public UserInfo getUser(int userId) {
		//声明用户对象
		UserInfo userInfo = null;
		//编写SQL命令
		String sql="SELECT userId, username,userpwd FROM userinfo WHERE userId=?";
		//组装查询参数
		Object[] params = {userId};
		//调用父类的查询方法获得结果集
		resultSet = super.excuteSelect(params, sql);
		//在解析结果的同事封装数据对象
		try {
			if(resultSet.next()) {
				//创建用户数据对象
				userInfo=new UserInfo();
				userInfo.setUserId(resultSet.getInt("userId"));
				userInfo.setUserName(resultSet.getString("username"));
				userInfo.setUserPwd(resultSet.getString("userpwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return userInfo;
	}

	@Override
	public int addUser(UserInfo userInfo) {
		//声明用户对象
		UserInfo userInfoTmp = userInfo;
		//编写SQL命令
		String sql="INSERT INTO userinfo (username,userpwd) VALUES(?,?)";
		//组装查询参数
		String userName = userInfoTmp.getUserName();
		String userPwd = userInfoTmp.getUserPwd();
		Object[] params = {userName,userPwd};
		//调用父类的查询方法获得结果集
		int line = super.excuteEdit(params, sql);
		//在解析结果的同事封装数据对象
		/**
		 * 没有写如果line小于0的情况，try catch咋写
		 */
		this.closeAll();
		return line;
	}

	@Override
	public int delUser(int userId) {

		//编写SQL命令
		String sql="DELETE FROM userinfo WHERE userId=?";
		//组装查询参数
		Object[] params = {userId};
		//调用父类的查询方法获得结果集
		int line = super.excuteEdit(params, sql);
		//在解析结果的同事封装数据对象
		/**
		 * 没有写如果line小于0的情况，try catch咋写
		 */
		this.closeAll();
		return line;
	}

	@Override
	public int editUser(UserInfo userInfo) {
		//编写SQL命令
		UserInfo userInfoTmp = userInfo;
		String sql="UPDATE userinfo set username= ?, userpwd=?  WHERE userId=?";
		//组装查询参数
		String uname= userInfoTmp.getUserName();
		String upwd = userInfoTmp.getUserPwd();
		int uId = userInfoTmp.getUserId();
		Object[] params = {uname,upwd,uId};
		//调用父类的查询方法获得结果集
		int line = super.excuteEdit(params, sql);
		//在解析结果的同事封装数据对象
		/**
		 * 没有写如果line小于0的情况，try catch咋写
		 */
		this.closeAll();
		return line;
	}

	@Override
	public List<UserInfo> getUserList() {
		//创建用户集合
		List<UserInfo> infos =new ArrayList<UserInfo>();
		String sql = "SELECT userId, username,userpwd FROM userinfo";
		//创建参数数组
		Object[] params = null;
		//调用查询的方法接受结果集
		resultSet = super.excuteSelect(params, sql);
		//解析结果集，封装数据集合
		try {
			while(resultSet.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUserId(resultSet.getInt("userId"));
				userInfo.setUserName(resultSet.getString("username"));
				userInfo.setUserPwd(resultSet.getString("userpwd"));
				infos.add(userInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return infos;
	}

}
