package com.zyy.dao.user;

import java.util.List;
import com.zyy.vo.user.*;


public interface IUserDao {
	/**
	 * 通过用户名，密码 获取登录用户的信息
	 * @param name
	 * @param pwd
	 * @return
	 */
	public userInfo getUser(String name,String pwd);
	/**
	 * 添加新用户
	 * @param userInfo
	 * @return
	 */
	public int addUser(userInfo userInfo);
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
	public int editUser(userInfo userInfo);
	/**
	 * 查询用户列表
	 * @return
	 */
	public List<userInfo> getUserList();
}
