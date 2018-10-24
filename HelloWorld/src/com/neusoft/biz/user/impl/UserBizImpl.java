package com.neusoft.biz.user.impl;

import java.util.List;

import com.neusoft.biz.user.IUserBiz;
import com.neusoft.dao.BaseDao;
import com.neusoft.dao.user.IUserDao;
import com.neusoft.vo.user.UserInfo;
import com.neusoft.dao.user.impl.*;

public class UserBizImpl extends BaseDao implements IUserBiz {
	
	IUserDao UserDao = new UserDaoImpl();
	@Override
	public String validateLogin(String name, String pwd) {
		// TODO Auto-generated method stub
		UserInfo userInfo = UserDao.getUser(name,pwd);
		String uname = null;
		if(null!=userInfo) {
			uname = userInfo.getUserName();		
		}
		return uname;
	}

	@Override
	public boolean register(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delUserInfoById(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserInfo> userInfoDetails() {
		// TODO Auto-generated method stub
		List<UserInfo> infos = UserDao.getUserList();
		return infos;
	}

}
