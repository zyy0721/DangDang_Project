package com.neusoft.biz.user;

import java.util.List;

import com.neusoft.vo.user.UserInfo;

public interface IUserBiz {
	/**
	 * 用户登录校验
	 * @param name
	 * @param pwd
	 * @return
	 */
	public String validateLogin(String name,String pwd);
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
}
