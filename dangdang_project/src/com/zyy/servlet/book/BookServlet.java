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
		System.out.println("进入了doPost ");
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
			//从web.xml进来的
			List<bookInfo> infos1 = bookBiz.bookInfoDetailsByTypeId(1);
			List<bookInfo> infos2 = bookBiz.bookInfoDetailsByTypeId(2);
			List<bookInfo> infos3 = bookBiz.bookInfoDetailsByTypeId(3);
			//将数据列表放入request作用域转发
			request.setAttribute("infos", infos1);
			request.setAttribute("infosFocus1", infos2);
			request.setAttribute("infosFocus2", infos3);
			rd = request.getRequestDispatcher("index.jsp");
			//rd.forward(request,response);
			System.out.println("size is "+ infos1.size());
			break;
		case 2:
			System.out.println("进入type2 book分页");
			//创建页码变量
			int pageNo=0;
			try{
				pageNo = Integer.valueOf(request.getParameter("pageNo"));
			}catch(NumberFormatException e) {
				pageNo = 1;
			}
			
			//创建页大小变量（每页显示的数据行数）
			int pageSize = 4;
			//得到总数据行数用来计算总页数
			int maxPage=0;
			int count = bookBiz.searchBookCount();
			if(count%pageSize==0) {
				maxPage = count/pageSize;
			}else {
				maxPage = count/pageSize+1;
			}
			//将页码，总页数放入request作用域转发到product.jsp
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
