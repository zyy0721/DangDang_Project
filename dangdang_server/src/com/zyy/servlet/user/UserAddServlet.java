package com.zyy.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyy.biz.user.IUserBiz;
import com.zyy.biz.user.impl.UserBizImpl;
import com.zyy.vo.user.UserInfo;

public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IUserBiz userBiz = new UserBizImpl();
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	public void destroy() {
		// TODO Auto-generated method stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("进入了dopost useradd");

		//处理用户请求中中文乱码；
		request.setCharacterEncoding("utf-8");
		//给用户相应时出现中文乱码
		response.setCharacterEncoding("utf-8");
		//获取用户提交的表单数据
		String uname = request.getParameter("userName");
		String upwd =request.getParameter("userpassword");
		String urepwd = request.getParameter("userRemi");
		System.out.println(upwd);
		System.out.println(urepwd);
		if(upwd.equals(urepwd))
		{
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(0);//给个初始值但是在注册时不会用到
			userInfo.setUserName(uname);
			userInfo.setUserPwd(upwd);
			boolean flag = userBiz.register(userInfo);
			if(flag)
			{
				System.out.println("添加用户信息成功");
				List<UserInfo> infos = userBiz.userInfoDetails();
				//将数据列表放入request作用域转发
				request.setAttribute("infos", infos);
				//创建转发对象【参数中是指要转发到哪的地址。可以是页面，也可是另外的servlet..xx.do】
				RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
				rd.forward(request,response);
			}
		}
		
	}

}
