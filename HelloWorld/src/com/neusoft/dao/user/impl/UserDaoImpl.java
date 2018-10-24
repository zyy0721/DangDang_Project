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
		//�����û�����
				UserInfo userInfo = null;
				//��дSQL����
				String sql="SELECT u_id, u_name,u_pwd, u_gender, u_age, u_address FROM book_userinfo WHERE u_name=? AND u_pwd =?";
				//��װ��ѯ����
				Object[] params = {name,pwd};
				//���ø���Ĳ�ѯ������ý����
				resultSet = super.excuteSelect(params, sql);
				//�ڽ��������ͬ�·�װ���ݶ���
				try {
					if(resultSet.next()) {
						//�����û����ݶ���
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
		//�����û�����
		List<UserInfo> infos =new ArrayList<UserInfo>();
		String sql = "SELECT u_id, u_name,u_pwd, u_gender, u_age, u_address FROM book_userinfo";
		//������������
		Object[] params = null;
		//���ò�ѯ�ķ������ܽ����
		resultSet = super.excuteSelect(params, sql);
		//�������������װ���ݼ���
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
