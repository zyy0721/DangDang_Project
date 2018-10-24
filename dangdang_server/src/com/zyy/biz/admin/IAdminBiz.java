package com.zyy.biz.admin;

public interface IAdminBiz {
	/**
	 * 管理员登录校验
	 * @param name
	 * @param pwd
	 * @return
	 */
	public String validateLogin(String name,String pwd);
}
