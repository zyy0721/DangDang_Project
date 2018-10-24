package com.zyy.dao.user;

import java.util.List;

import com.zyy.vo.user.UserInfo;

public interface IUserDao {
	/**
	 * ͨ���û�id,��ȡ��¼�û�����Ϣ
	 * @param name
	 * @param pwd
	 * @return
	 */
	public UserInfo getUser(int userId);
	/**
	 * ������û�
	 * @param userInfo
	 * @return
	 */
	public int addUser(UserInfo userInfo);
	/**
	 * ͨ��Idɾ���û���Ϣ
	 * @param userId
	 * @return
	 */
	public int delUser(int userId);
	/**
	 * ���û�����Ϣ�޸�
	 * @param userInfo
	 * @return
	 */
	public int editUser(UserInfo userInfo);
	/**
	 * ��ѯ�û��б�
	 * @return
	 */
	public List<UserInfo> getUserList();
}
