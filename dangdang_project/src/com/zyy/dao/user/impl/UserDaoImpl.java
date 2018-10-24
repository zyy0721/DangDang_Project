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
		//�����û�����
		userInfo userInfo = null;
		//��дSQL����
		String sql="SELECT userId, username,userpwd FROM userinfo WHERE username=? AND userpwd =?";
		//��װ��ѯ����
		Object[] params = {name,pwd};
		//���ø���Ĳ�ѯ������ý����
		resultSet = super.excuteSelect(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		try {
			if(resultSet.next()) {
				//�����û����ݶ���
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
		//�����û�����
				List<userInfo> infos =new ArrayList<userInfo>();
				String sql = "SELECT userId, username,userpwd FROM userinfo";
				//������������
				Object[] params = null;
				//���ò�ѯ�ķ������ܽ����
				resultSet = super.excuteSelect(params, sql);
				//�������������װ���ݼ���
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
