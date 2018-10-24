package com.zyy.vo.admin;
/**
 * 管理员类
 * @author zyy79
 *
 */
public class AdminInfo {
	private int adminId;//管理员Id
	private String adminName;//管理员名字
	private String adminPwd;//管理员密码
	private int adminRole;//管理员角色
	public AdminInfo() {
		super();
	}
	public AdminInfo(int adminId, String adminName, String adminPwd, int adminRole) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.adminRole = adminRole;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPwd() {
		return adminPwd;
	}
	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}
	public int getAdminRole() {
		return adminRole;
	}
	public void setAdminRole(int adminRole) {
		this.adminRole = adminRole;
	}
	
}
