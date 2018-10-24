package com.neusoft.dao.user.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neusoft.dao.BaseDao;
import com.neusoft.dao.user.IUserDao;
import com.neusoft.vo.user.UserInfo;

public class UserDaoImpl extends BaseDao implements IUserDao {

	@Override
	public UserInfo getUser(String name, String pwd) {
		//声明用户对象
				UserInfo userInfo = null;
				//编写SQL命令
				String sql="SELECT u_id, u_name,u_pwd, u_gender, u_age, u_address FROM book_userinfo WHERE u_name=? AND u_pwd =?";
				//组装查询参数
				Object[] params = {name,pwd};
				//调用父类的查询方法获得结果集
				resultSet = super.excuteSelect(params, sql);
				//在解析结果的同事封装数据对象
				try {
					if(resultSet.next()) {
						//创建用户数据对象
						userInfo=new UserInfo();
						userInfo.setUserId(resultSet.getInt("u_id"));
						userInfo.setUserName(resultSet.getString("u_name"));
						userInfo.setUserGender(resultSet.getString("u_gender"));
						userInfo.setUserAge(resultSet.getInt("u_age"));
						userInfo.setUserPwd(resultSet.getString("u_pwd"));
						userInfo.setAddress(resultSet.getString("u_address"));
						//userInfo.setUserName(resultSet.getString("u_name"));
						
					
					
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editUser(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserInfo> getUserList() {
		// TODO Auto-generated method stub
		//创建用户集合
		List<UserInfo> infos =new ArrayList<UserInfo>();
		String sql = "SELECT u_id, u_name,u_pwd, u_gender, u_age, u_address FROM book_userinfo";
		//创建参数数组
		Object[] params = null;
		//调用查询的方法接受结果集
		resultSet = super.excuteSelect(params, sql);
		//解析结果集，封装数据集合
		try {
			while(resultSet.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo=new UserInfo();
				userInfo.setUserId(resultSet.getInt("u_id"));
				userInfo.setUserName(resultSet.getString("u_name"));
				userInfo.setUserGender(resultSet.getString("u_gender"));
				userInfo.setUserAge(resultSet.getInt("u_age"));
				userInfo.setUserPwd(resultSet.getString("u_pwd"));
				userInfo.setAddress(resultSet.getString("u_address"));
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
