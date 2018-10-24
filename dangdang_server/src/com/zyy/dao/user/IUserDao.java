package com.zyy.dao.user;

import java.util.List;

import com.zyy.vo.user.UserInfo;

public interface IUserDao {
	/**
	 * 通过用户id,获取登录用户的信息
	 * @param name
	 * @param pwd
	 * @return
	 */
	public UserInfo getUser(int userId);
	/**
	 * 添加新用户
	 * @param userInfo
	 * @return
	 */
	public int addUser(UserInfo userInfo);
	/**
	 * 通过Id删除用户信息
	 * @param userId
	 * @return
	 */
	public int delUser(int userId);
	/**
	 * 对用户的信息修改
	 * @param userInfo
	 * @return
	 */
	public int editUser(UserInfo userInfo);
	/**
	 * 查询用户列表
	 * @return
	 */
	public List<UserInfo> getUserList();
}
