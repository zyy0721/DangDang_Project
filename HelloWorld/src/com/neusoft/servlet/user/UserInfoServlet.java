package com.neusoft.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.biz.user.IUserBiz;
import com.neusoft.biz.user.impl.UserBizImpl;
import com.neusoft.vo.user.UserInfo;


public class UserInfoServlet extends HttpServlet {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//处理用户请求中中文乱码；
		request.setCharacterEncoding("utf-8");
		//给用户相应时出现中文乱码
		response.setCharacterEncoding("utf-8");
		
		
		//获取用户提交的表单数据
		String uname = request.getParameter("uname");
		String upwd =request.getParameter("upwd");
		//調用業務層中的方法得到返回的验证成功后的用户名
		String name = userBiz.validateLogin(uname, upwd);
		//将用户信息放入 session
		//创建session
		HttpSession session = request.getSession();
		//将用户信息放入session
		session.setAttribute("uname", name);
		//判断name是否为null.如果不为null，进入主页面，否则重定向到登录页面
		if(null!=name) {
			List<UserInfo> infos = userBiz.userInfoDetails();
			//将数据列表放入request作用域转发
			request.setAttribute("infos", infos);
			//创建转发对象【参数中是指要转发到哪的地址。可以是页面，也可是另外的servlet..xx.do】
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request,response);
			return;
		}
		response.sendRedirect("login.jsp");
	}

}
