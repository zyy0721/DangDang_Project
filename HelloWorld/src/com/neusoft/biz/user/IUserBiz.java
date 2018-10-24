package com.neusoft.biz.user;

import java.util.List;

import com.neusoft.vo.user.UserInfo;

public interface IUserBiz {
	/**
	 * �û���¼У��
	 * @param name
	 * @param pwd
	 * @return
	 */
	public String validateLogin(String name,String pwd);
	/**
	 * �û�ע��
	 * @param userInfo
	 * @return
	 */
	public boolean register(UserInfo userInfo);
	/**
	 * �û���Ϣ�޸�
	 * @param userInfo
	 * @return
	 */
	public boolean editInfo(UserInfo userInfo);
	/**
	 * �����û�Idɾ��
	 * @param userId
	 * @return
	 */
	public boolean delUserInfoById(int userId);
	/**
	 * �û��б�
	 * @return
	 */
	public List<UserInfo> userInfoDetails();
}
