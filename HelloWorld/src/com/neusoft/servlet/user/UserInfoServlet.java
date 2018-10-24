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
		//�����û��������������룻
		request.setCharacterEncoding("utf-8");
		//���û���Ӧʱ������������
		response.setCharacterEncoding("utf-8");
		
		
		//��ȡ�û��ύ�ı�����
		String uname = request.getParameter("uname");
		String upwd =request.getParameter("upwd");
		//�{�ØI�Ռ��еķ����õ����ص���֤�ɹ�����û���
		String name = userBiz.validateLogin(uname, upwd);
		//���û���Ϣ���� session
		//����session
		HttpSession session = request.getSession();
		//���û���Ϣ����session
		session.setAttribute("uname", name);
		//�ж�name�Ƿ�Ϊnull.�����Ϊnull��������ҳ�棬�����ض��򵽵�¼ҳ��
		if(null!=name) {
			List<UserInfo> infos = userBiz.userInfoDetails();
			//�������б����request������ת��
			request.setAttribute("infos", infos);
			//����ת�����󡾲�������ָҪת�����ĵĵ�ַ��������ҳ�棬Ҳ���������servlet..xx.do��
			RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
			rd.forward(request,response);
			return;
		}
		response.sendRedirect("login.jsp");
	}

}
