package com.zyy.dao.admin;

import com.zyy.vo.admin.AdminInfo;

public interface IAdminDao {
	/**
	 * ͨ���û��������� ��ȡ��¼�û�����Ϣ
	 * @param name
	 * @param pwd
	 * @return
	 */
	public AdminInfo getAdmin(String name,String pwd);
}
