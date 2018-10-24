package com.zyy.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zyy.biz.admin.IAdminBiz;
import com.zyy.biz.admin.impl.AdminBizImpl;


public class AdminInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IAdminBiz admBiz = new AdminBizImpl();
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
		//处理用户请求中中文乱码；
		System.out.println("进入了dopost Admin");
		request.setCharacterEncoding("utf-8");
		//给用户相应时出现中文乱码
		response.setCharacterEncoding("utf-8");
		//获取用户提交的表单数据
		String admname = request.getParameter("username");
		String admpwd =request.getParameter("password");
		//調用業務層中的方法得到返回的验证成功后的用户名
		String name = admBiz.validateLogin(admname, admpwd);
		//将用户信息放入 session
		//创建session
		HttpSession session = request.getSession();
		//将用户信息放入session
		session.setAttribute("adminName", name);
		
		//判断name是否为null.如果不为null，进入主页面，否则重定向到登录页面
		if(null!=name) {
			
			//创建转发对象【参数中是指要转发到哪的地址。可以是页面，也可是另外的servlet..xx.do】
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
			return;
		}
		response.sendRedirect("login.jsp");
	}
	

}
