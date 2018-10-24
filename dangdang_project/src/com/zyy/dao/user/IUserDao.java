package com.zyy.dao.user;

import java.util.List;
import com.zyy.vo.user.*;


public interface IUserDao {
	/**
	 * ͨ���û��������� ��ȡ��¼�û�����Ϣ
	 * @param name
	 * @param pwd
	 * @return
	 */
	public userInfo getUser(String name,String pwd);
	/**
	 * ������û�
	 * @param userInfo
	 * @return
	 */
	public int addUser(userInfo userInfo);
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
	public int editUser(userInfo userInfo);
	/**
	 * ��ѯ�û��б�
	 * @return
	 */
	public List<userInfo> getUserList();
}
