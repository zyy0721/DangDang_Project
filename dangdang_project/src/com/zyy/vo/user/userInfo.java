package com.zyy.vo.user;
/**
 *�û���
 * @author zyy79
 *
 */
public class userInfo {
	private int userId;//�û�ID
	private String userName;//�û�����
	private String userPwd;//�û�����
	public userInfo() {
		super();
	}
	public userInfo(int userId, String userName, String userPwd) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
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
	
	
}
