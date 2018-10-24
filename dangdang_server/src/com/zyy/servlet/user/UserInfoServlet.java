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
		System.out.println("������doGet user");
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("������dopost user");
		//�����û��������������룻
		request.setCharacterEncoding("utf-8");
		//���û���Ӧʱ������������
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
			//����2 ���� չʾ�û��б�
			System.out.println("������dopost userinfolist");
			List<UserInfo> infos = userBiz.userInfoDetails();
			//�������б����request������ת��
			request.setAttribute("infos", infos);
			//����ת�����󡾲�������ָҪת�����ĵĵ�ַ��������ҳ�棬Ҳ���������servlet..xx.do��
			rd = request.getRequestDispatcher("userList.jsp");
			rd.forward(request,response);
			break;
		case 3:
			//����3��������û�
			System.out.println("������dopost useradd");
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
					List<UserInfo> infosadd = userBiz.userInfoDetails();
					//�������б����request������ת��
					request.setAttribute("infosadd", infosadd);
					//����ת�����󡾲�������ָҪת�����ĵĵ�ַ��������ҳ�棬Ҳ���������servlet..xx.do��
					rd = request.getRequestDispatcher("user.do?type=2");
					rd.forward(request,response);
				}
			}
			
			break;
		case 4:
			//����4����ɾ���û�
			System.out.println("������dopost userdelete");
			int id= Integer.valueOf(request.getParameter("userId"));
			boolean flag = userBiz.delUserInfoById(id);
			if(flag) {
				System.out.println("ɾ���û��ɹ�");
				List<UserInfo> infodel = userBiz.userInfoDetails();
				//�������б����request������ת��
				request.setAttribute("infos", infodel);
				rd = request.getRequestDispatcher("user.do?type=2");
				rd.forward(request,response);
			}
			
			break;
		case 5:
			//����5����鿴�û�
			System.out.println("������dopost userview");
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
			//����6����༭�û���Ϣ
			System.out.println("������dopost userEdit");
			int uId = Integer.valueOf(request.getParameter("userId"));
			String uName =request.getParameter("userName");
			String uPwd = request.getParameter("userPwd");
			UserInfo userI = new UserInfo();
			userI.setUserId(uId);
			userI.setUserName(uName);
			userI.setUserPwd(uPwd);
			boolean flagEdit = userBiz.editInfo(userI);
			if(flagEdit) {
				System.out.println("�޸��û���Ϣ�ɹ�");
				List<UserInfo> infodel = userBiz.userInfoDetails();
				//�������б����request������ת��
				request.setAttribute("infos", infodel);
				rd = request.getRequestDispatcher("user.do?type=2");
				rd.forward(request,response);
			}
			
					
			break;
			
			
		}

		
	}

}
