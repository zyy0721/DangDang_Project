package com.zyy.servlet.book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyy.biz.book.IBookBiz;
import com.zyy.biz.book.impl.BookBizImpl;
import com.zyy.vo.book.bookInfo;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IBookBiz bookBiz = new BookBizImpl();
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
		System.out.println("������doPost ");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		RequestDispatcher rd=null;
		int type=0;
		try {
			 type = Integer.valueOf(request.getParameter("type"));
		}catch(NumberFormatException e) {
			type=1;
		}
		switch(type)
		{
		case 1:
			//��web.xml������
			List<bookInfo> infos1 = bookBiz.bookInfoDetailsByTypeId(1);
			List<bookInfo> infos2 = bookBiz.bookInfoDetailsByTypeId(2);
			List<bookInfo> infos3 = bookBiz.bookInfoDetailsByTypeId(3);
			//�������б����request������ת��
			request.setAttribute("infos", infos1);
			request.setAttribute("infosFocus1", infos2);
			request.setAttribute("infosFocus2", infos3);
			rd = request.getRequestDispatcher("index.jsp");
			//rd.forward(request,response);
			System.out.println("size is "+ infos1.size());
			break;
		case 2:
			System.out.println("����type2 book��ҳ");
			//����ҳ�����
			int pageNo=0;
			try{
				pageNo = Integer.valueOf(request.getParameter("pageNo"));
			}catch(NumberFormatException e) {
				pageNo = 1;
			}
			
			//����ҳ��С������ÿҳ��ʾ������������
			int pageSize = 4;
			//�õ���������������������ҳ��
			int maxPage=0;
			int count = bookBiz.searchBookCount();
			if(count%pageSize==0) {
				maxPage = count/pageSize;
			}else {
				maxPage = count/pageSize+1;
			}
			//��ҳ�룬��ҳ������request������ת����product.jsp
			request.setAttribute("pageNo", pageNo);
			request.setAttribute("maxPage", maxPage);
			List<bookInfo>infos4 = bookBiz.bookInfoDetailsByPage(pageNo, pageSize);
			request.setAttribute("pageBooks", infos4);
			rd = request.getRequestDispatcher("product.jsp");
			break;
		case 3:
			break;
		case 4:
			break;
		}
		
		rd.forward(request, response);

	}

}
