package com.neusoft.vo.user;
/**
 * �û���
 * @author zyy
 *
 */
public class UserInfo {
	private int userId;//�û����
	private String userName;//�û���
	private String userPwd;//�û�����
	private String userGender;//�û��Ա�
	private int userAge;//�û�����
	private String address;//�û���ַ��
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
