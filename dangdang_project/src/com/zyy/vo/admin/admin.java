package com.zyy.vo.admin;
/**
 * ����Ա��
 * @author zyy79
 *
 */
public class admin {
	private int adminId;//����ԱId
	private String adminName;//����Ա����
	private String adminPwd;//����Ա����
	private int adminRole;//����Ա��ɫ��0 ��������Ա��1��������Ա
	public admin() {
		super();
	}
	public admin(int adminId, String adminName, String adminPwd, int adminRole) {
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
