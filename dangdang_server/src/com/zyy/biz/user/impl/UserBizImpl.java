package com.zyy.biz.user.impl;

import java.util.List;

import com.zyy.biz.user.IUserBiz;
import com.zyy.dao.BaseDao;
import com.zyy.dao.user.IUserDao;
import com.zyy.dao.user.impl.UserDaoImpl;
import com.zyy.vo.user.UserInfo;

public class UserBizImpl extends BaseDao implements IUserBiz {
	IUserDao UserDao = new UserDaoImpl();
	@Override
	public boolean register(UserInfo userInfo) {
		// TODO Auto-generated method stub
		int line = UserDao.addUser(userInfo);
		if(line>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean editInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		int line = UserDao.editUser(userInfo);
		if(line>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean delUserInfoById(int userId) {
		// TODO Auto-generated method stub
		int line = UserDao.delUser(userId);
		if(line>0)
			return true;
		else
			return false;
	}

	@Override
	public List<UserInfo> userInfoDetails() {
		// TODO Auto-generated method stub
		List<UserInfo> infos = UserDao.getUserList();
		return infos;
	}
	
	@Override
	public UserInfo getUserById(int userId) {
		UserInfo user = UserDao.getUser(userId);
		return user;
	}

}
