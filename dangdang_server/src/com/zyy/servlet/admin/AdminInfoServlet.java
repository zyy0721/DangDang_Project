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
		//�����û��������������룻
		System.out.println("������dopost Admin");
		request.setCharacterEncoding("utf-8");
		//���û���Ӧʱ������������
		response.setCharacterEncoding("utf-8");
		//��ȡ�û��ύ�ı�����
		String admname = request.getParameter("username");
		String admpwd =request.getParameter("password");
		//�{�ØI�Ռ��еķ����õ����ص���֤�ɹ�����û���
		String name = admBiz.validateLogin(admname, admpwd);
		//���û���Ϣ���� session
		//����session
		HttpSession session = request.getSession();
		//���û���Ϣ����session
		session.setAttribute("adminName", name);
		
		//�ж�name�Ƿ�Ϊnull.�����Ϊnull��������ҳ�棬�����ض��򵽵�¼ҳ��
		if(null!=name) {
			
			//����ת�����󡾲�������ָҪת�����ĵĵ�ַ��������ҳ�棬Ҳ���������servlet..xx.do��
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request,response);
			return;
		}
		response.sendRedirect("login.jsp");
	}
	

}
