package com.neusoft.vo.user;
/**
 * 用户类
 * @author zyy
 *
 */
public class UserInfo {
	private int userId;//用户编号
	private String userName;//用户名
	private String userPwd;//用户密码
	private String userGender;//用户性别
	private int userAge;//用户年龄
	private String address;//用户地址、
	public UserInfo() {
		super();
	}
	public UserInfo(int userId, String userName, String userPwd, String userGender, int userAge, String address) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userGender = userGender;
		this.userAge = userAge;
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
