package com.zyy.dao.user.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.zyy.dao.BaseDao;
import com.zyy.dao.user.IUserDao;
import com.zyy.vo.user.userInfo;

public class UserDaoImpl extends BaseDao implements IUserDao {

	@Override
	public userInfo getUser(String name, String pwd) {
		//声明用户对象
		userInfo userInfo = null;
		//编写SQL命令
		String sql="SELECT userId, username,userpwd FROM userinfo WHERE username=? AND userpwd =?";
		//组装查询参数
		Object[] params = {name,pwd};
		//调用父类的查询方法获得结果集
		resultSet = super.excuteSelect(params, sql);
		//在解析结果的同事封装数据对象
		try {
			if(resultSet.next()) {
				//创建用户数据对象
				userInfo=new userInfo();
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
	public int addUser(userInfo userInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editUser(userInfo userInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<userInfo> getUserList() {
		// TODO Auto-generated method stub
		//创建用户集合
				List<userInfo> infos =new ArrayList<userInfo>();
				String sql = "SELECT userId, username,userpwd FROM userinfo";
				//创建参数数组
				Object[] params = null;
				//调用查询的方法接受结果集
				resultSet = super.excuteSelect(params, sql);
				//解析结果集，封装数据集合
				try {
					while(resultSet.next()) {
						userInfo userInfo = new userInfo();
						userInfo=new userInfo();
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
