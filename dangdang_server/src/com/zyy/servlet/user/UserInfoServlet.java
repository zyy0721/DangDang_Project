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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("进入了doGet user");
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("进入了dopost user");
		//处理用户请求中中文乱码；
		request.setCharacterEncoding("utf-8");
		//给用户相应时出现中文乱码
		response.setCharacterEncoding("utf-8");
		RequestDispatcher rd =null;
		int type=0;
		try {
			type = Integer.valueOf(request.getParameter("type"));
		}catch(NumberFormatException e) {
			type=1;
		}
		switch(type) {
		case 1:

			break;
		case 2:
			//类型2 代表 展示用户列表
			System.out.println("进入了dopost userinfolist");
			List<UserInfo> infos = userBiz.userInfoDetails();
			//将数据列表放入request作用域转发
			request.setAttribute("infos", infos);
			//创建转发对象【参数中是指要转发到哪的地址。可以是页面，也可是另外的servlet..xx.do】
			rd = request.getRequestDispatcher("userList.jsp");
			rd.forward(request,response);
			break;
		case 3:
			//类型3代表添加用户
			System.out.println("进入了dopost useradd");
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
					List<UserInfo> infosadd = userBiz.userInfoDetails();
					//将数据列表放入request作用域转发
					request.setAttribute("infosadd", infosadd);
					//创建转发对象【参数中是指要转发到哪的地址。可以是页面，也可是另外的servlet..xx.do】
					rd = request.getRequestDispatcher("user.do?type=2");
					rd.forward(request,response);
				}
			}
			
			break;
		case 4:
			//类型4代表删除用户
			System.out.println("进入了dopost userdelete");
			int id= Integer.valueOf(request.getParameter("userId"));
			boolean flag = userBiz.delUserInfoById(id);
			if(flag) {
				System.out.println("删除用户成功");
				List<UserInfo> infodel = userBiz.userInfoDetails();
				//将数据列表放入request作用域转发
				request.setAttribute("infos", infodel);
				rd = request.getRequestDispatcher("user.do?type=2");
				rd.forward(request,response);
			}
			
			break;
		case 5:
			//类型5代表查看用户
			System.out.println("进入了dopost userview");
			int uid= Integer.valueOf(request.getParameter("userId"));
			int flagId = Integer.valueOf(request.getParameter("flag"));
			UserInfo user = userBiz.getUserById(uid);
			request.setAttribute("user", user);
			if(flagId==1)
				rd = request.getRequestDispatcher("userView.jsp");
			if(flagId==2)
				rd = request.getRequestDispatcher("userUpdate.jsp");
			rd.forward(request, response);
			break;
		case 6:
			//类型6代表编辑用户信息
			System.out.println("进入了dopost userEdit");
			int uId = Integer.valueOf(request.getParameter("userId"));
			String uName =request.getParameter("userName");
			String uPwd = request.getParameter("userPwd");
			UserInfo userI = new UserInfo();
			userI.setUserId(uId);
			userI.setUserName(uName);
			userI.setUserPwd(uPwd);
			boolean flagEdit = userBiz.editInfo(userI);
			if(flagEdit) {
				System.out.println("修改用户信息成功");
				List<UserInfo> infodel = userBiz.userInfoDetails();
				//将数据列表放入request作用域转发
				request.setAttribute("infos", infodel);
				rd = request.getRequestDispatcher("user.do?type=2");
				rd.forward(request,response);
			}
			
					
			break;
			
			
		}

		
	}

}
