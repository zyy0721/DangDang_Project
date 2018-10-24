package com.zyy.biz.user;

import java.util.List;

import com.zyy.vo.user.UserInfo;

public interface IUserBiz {
	/**
	 * 用户注册
	 * @param userInfo
	 * @return
	 */
	public boolean register(UserInfo userInfo);
	/**
	 * 用户信息修改
	 * @param userInfo
	 * @return
	 */
	public boolean editInfo(UserInfo userInfo);
	/**
	 * 根据用户Id删除
	 * @param userId
	 * @return
	 */
	public boolean delUserInfoById(int userId);
	/**
	 * 用户列表
	 * @return
	 */
	public List<UserInfo> userInfoDetails();
	
	/**
	 * 根据用户id查
	 * @param userId
	 * @return
	 */
	public UserInfo getUserById(int userId);
}
