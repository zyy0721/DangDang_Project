package com.zyy.dao.admin.impl;

import java.sql.SQLException;

import com.zyy.dao.BaseDao;
import com.zyy.dao.admin.IAdminDao;
import com.zyy.vo.admin.AdminInfo;

public class AdminDaoImpl extends BaseDao implements IAdminDao {

	@Override
	public AdminInfo getAdmin(String name, String pwd) {
		//声明用户对象
		AdminInfo adminInfo = null;
		//编写SQL命令
		String sql="SELECT admin_Id, adm_name,adm_pwd, adm_role FROM admin WHERE adm_name=? AND adm_pwd =?";
		//组装查询参数
		Object[] params = {name,pwd};
		//调用父类的查询方法获得结果集
		resultSet = super.excuteSelect(params, sql);
		//在解析结果的同事封装数据对象
		try {
			if(resultSet.next()) {
				//创建用户数据对象
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
