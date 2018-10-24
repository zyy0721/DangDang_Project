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
		System.out.println("������dopost useradd");

		//�����û��������������룻
		request.setCharacterEncoding("utf-8");
		//���û���Ӧʱ������������
		response.setCharacterEncoding("utf-8");
		//��ȡ�û��ύ�ı�����
		String uname = request.getParameter("userName");
		String upwd =request.getParameter("userpassword");
		String urepwd = request.getParameter("userRemi");
		System.out.println(upwd);
		System.out.println(urepwd);
		if(upwd.equals(urepwd))
		{
			UserInfo userInfo = new UserInfo();
			userInfo.setUserId(0);//������ʼֵ������ע��ʱ�����õ�
			userInfo.setUserName(uname);
			userInfo.setUserPwd(upwd);
			boolean flag = userBiz.register(userInfo);
			if(flag)
			{
				System.out.println("����û���Ϣ�ɹ�");
				List<UserInfo> infos = userBiz.userInfoDetails();
				//�������б����request������ת��
				request.setAttribute("infos", infos);
				//����ת�����󡾲�������ָҪת�����ĵĵ�ַ��������ҳ�棬Ҳ���������servlet..xx.do��
				RequestDispatcher rd = request.getRequestDispatcher("userList.jsp");
				rd.forward(request,response);
			}
		}
		
	}

}
