package com.zyy.biz.user;

import java.util.List;

import com.zyy.vo.user.UserInfo;

public interface IUserBiz {
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
	
	/**
	 * �����û�id��
	 * @param userId
	 * @return
	 */
	public UserInfo getUserById(int userId);
}
