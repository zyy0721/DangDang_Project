package com.zyy.dao.admin;

import com.zyy.vo.admin.AdminInfo;

public interface IAdminDao {
	/**
	 * 通过用户名，密码 获取登录用户的信息
	 * @param name
	 * @param pwd
	 * @return
	 */
	public AdminInfo getAdmin(String name,String pwd);
}
