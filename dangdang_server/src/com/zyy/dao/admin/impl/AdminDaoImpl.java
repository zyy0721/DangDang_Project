package com.zyy.dao.admin.impl;

import java.sql.SQLException;

import com.zyy.dao.BaseDao;
import com.zyy.dao.admin.IAdminDao;
import com.zyy.vo.admin.AdminInfo;

public class AdminDaoImpl extends BaseDao implements IAdminDao {

	@Override
	public AdminInfo getAdmin(String name, String pwd) {
		//�����û�����
		AdminInfo adminInfo = null;
		//��дSQL����
		String sql="SELECT admin_Id, adm_name,adm_pwd, adm_role FROM admin WHERE adm_name=? AND adm_pwd =?";
		//��װ��ѯ����
		Object[] params = {name,pwd};
		//���ø���Ĳ�ѯ������ý����
		resultSet = super.excuteSelect(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		try {
			if(resultSet.next()) {
				//�����û����ݶ���
				adminInfo=new AdminInfo();
				adminInfo.setAdminId(resultSet.getInt("admin_Id"));
				adminInfo.setAdminName(resultSet.getString("adm_name"));
				adminInfo.setAdminPwd(resultSet.getString("adm_pwd"));
				adminInfo.setAdminRole(resultSet.getInt("adm_role"));
			
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return adminInfo;
	}

}
