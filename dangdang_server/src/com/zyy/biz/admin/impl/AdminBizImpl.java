package com.zyy.biz.admin.impl;

import com.zyy.biz.admin.IAdminBiz;
import com.zyy.dao.BaseDao;
import com.zyy.dao.admin.IAdminDao;
import com.zyy.dao.admin.impl.AdminDaoImpl;
import com.zyy.vo.admin.AdminInfo;

public class AdminBizImpl extends BaseDao implements IAdminBiz {
	IAdminDao AdminDao = new AdminDaoImpl();
	@Override
	public String validateLogin(String name, String pwd) {
		// TODO Auto-generated method stub
		AdminInfo adminInfo = AdminDao.getAdmin(name,pwd);
		String uname = null;
		if(null!=adminInfo) {
			uname = adminInfo.getAdminName();		
		}
		return uname;
	}

}
