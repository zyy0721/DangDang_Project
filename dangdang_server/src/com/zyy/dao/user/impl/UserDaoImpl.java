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
		//�����û�����
		UserInfo userInfo = null;
		//��дSQL����
		String sql="SELECT userId, username,userpwd FROM userinfo WHERE userId=?";
		//��װ��ѯ����
		Object[] params = {userId};
		//���ø���Ĳ�ѯ������ý����
		resultSet = super.excuteSelect(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		try {
			if(resultSet.next()) {
				//�����û����ݶ���
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
		//�����û�����
		UserInfo userInfoTmp = userInfo;
		//��дSQL����
		String sql="INSERT INTO userinfo (username,userpwd) VALUES(?,?)";
		//��װ��ѯ����
		String userName = userInfoTmp.getUserName();
		String userPwd = userInfoTmp.getUserPwd();
		Object[] params = {userName,userPwd};
		//���ø���Ĳ�ѯ������ý����
		int line = super.excuteEdit(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		/**
		 * û��д���lineС��0�������try catchզд
		 */
		this.closeAll();
		return line;
	}

	@Override
	public int delUser(int userId) {

		//��дSQL����
		String sql="DELETE FROM userinfo WHERE userId=?";
		//��װ��ѯ����
		Object[] params = {userId};
		//���ø���Ĳ�ѯ������ý����
		int line = super.excuteEdit(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		/**
		 * û��д���lineС��0�������try catchզд
		 */
		this.closeAll();
		return line;
	}

	@Override
	public int editUser(UserInfo userInfo) {
		//��дSQL����
		UserInfo userInfoTmp = userInfo;
		String sql="UPDATE userinfo set username= ?, userpwd=?  WHERE userId=?";
		//��װ��ѯ����
		String uname= userInfoTmp.getUserName();
		String upwd = userInfoTmp.getUserPwd();
		int uId = userInfoTmp.getUserId();
		Object[] params = {uname,upwd,uId};
		//���ø���Ĳ�ѯ������ý����
		int line = super.excuteEdit(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		/**
		 * û��д���lineС��0�������try catchզд
		 */
		this.closeAll();
		return line;
	}

	@Override
	public List<UserInfo> getUserList() {
		//�����û�����
		List<UserInfo> infos =new ArrayList<UserInfo>();
		String sql = "SELECT userId, username,userpwd FROM userinfo";
		//������������
		Object[] params = null;
		//���ò�ѯ�ķ������ܽ����
		resultSet = super.excuteSelect(params, sql);
		//�������������װ���ݼ���
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
