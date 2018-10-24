package com.neusoft.dao.user;

import java.util.List;
import com.neusoft.vo.user.*;
public interface IUserDao {
	/**
	 * ͨ���û��������� ��ȡ��¼�û�����Ϣ
	 * @param name
	 * @param pwd
	 * @return
	 */
	public UserInfo getUser(String name,String pwd);
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
