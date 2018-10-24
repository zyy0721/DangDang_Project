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
import com.zyy.biz.user.IUserBiz;
import com.zyy.biz.user.impl.UserBizImpl;
import com.zyy.vo.book.BookInfo;
import com.zyy.vo.book.BookType;
import com.zyy.vo.book.Publisher;

import com.zyy.vo.user.UserInfo;


public class BookInfoServlet extends HttpServlet {
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
		System.out.println("进入了dopost bookinfo");
		//处理用户请求中中文乱码；
		request.setCharacterEncoding("utf-8");
		//给用户相应时出现中文乱码
		response.setCharacterEncoding("utf-8");
		RequestDispatcher rd =null;
		int type=0;
		try {
			type = Integer.valueOf(request.getParameter("type"));
		}catch(NumberFormatException e) {
			type = 1;
		}
		switch(type) {
		case 1:
			System.out.println("进入type1 book分页");
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
			List<BookInfo>infos4 = bookBiz.bookInfoDetailsByPage(pageNo, pageSize);
			request.setAttribute("pageBooks", infos4);
			rd = request.getRequestDispatcher("providerList.jsp");
			rd.forward(request,response);
			break;
		case 2:
			List<BookInfo> infos = bookBiz.bookInfoDetails();
			//将数据列表放入request作用域转发
			request.setAttribute("infos", infos);
			//创建转发对象【参数中是指要转发到哪的地址。可以是页面，也可是另外的servlet..xx.do】
			rd = request.getRequestDispatcher("providerList.jsp");
			rd.forward(request,response);
			break;
		case 3:
			//类型3代表添加书籍
			System.out.println("进入了dopost bookadd");
			String bname = request.getParameter("bookName");
			String bauthor =request.getParameter("bookAuthor");
			int btype = Integer.valueOf(request.getParameter("bookType"));
			int bpub = Integer.valueOf(request.getParameter("publisherId"));
			float bprice = Float.valueOf(request.getParameter("bookPrice"));
			float brealPrice = Float.valueOf(request.getParameter("realPrice"));
			String bcontent = request.getParameter("bookContent");
			String bimage = request.getParameter("bookImage");
			int bscore = Integer.valueOf(request.getParameter("bookScore"));
			BookInfo book = new BookInfo();
			book.setBookName(bname);
			book.setBookAuthor(bauthor);
			
			BookType booktype = new BookType();
			booktype.setTypeId(btype);
			booktype.setTypeName("");
			book.setBookType(booktype);
			
			Publisher pub = new Publisher();
			pub.setPubId(bpub);
			pub.setPubName("");
			pub.setPubAddress("");
			book.setPublisher(pub);
			
			book.setBookPrice(bprice);
			book.setRealPrice(brealPrice);
			book.setBookContent(bcontent);
			book.setBookImage(bimage);
			book.setBookScore(bscore);
			
			boolean flagadd = bookBiz.addInfo(book);
			if(flagadd)
			{
				System.out.println("添加书本信息成功");
				List<BookInfo> infosadd = bookBiz.bookInfoDetails();
				//将数据列表放入request作用域转发
				request.setAttribute("infosadd", infosadd);
				//创建转发对象【参数中是指要转发到哪的地址。可以是页面，也可是另外的servlet..xx.do】
				rd = request.getRequestDispatcher("bookList.do?type=1");
				rd.forward(request,response);
			}
			
			break;
		case 4:
			//类型4代表删除图书
			System.out.println("进入了dopost bookdelete");
			int id= Integer.valueOf(request.getParameter("bookId"));
			boolean flag = bookBiz.delBookInfoById(id);
			if(flag) {
				System.out.println("删除图书成功");
				List<BookInfo> infodel = bookBiz.bookInfoDetails();
				//将数据列表放入request作用域转发
				request.setAttribute("infos", infodel);
				rd = request.getRequestDispatcher("bookList.do?type=1");
				rd.forward(request,response);
			}
			
			break;
		case 5:
			//类型5代表查看书籍
			System.out.println("进入了dopost bookview");
			int bid= Integer.valueOf(request.getParameter("bookId"));
			int flagId = Integer.valueOf(request.getParameter("flag"));
			BookInfo bookCheck = bookBiz.getBookById(bid);
			request.setAttribute("book", bookCheck);
			if(flagId==1)
				rd = request.getRequestDispatcher("providerView.jsp");
			if(flagId==2)
				rd = request.getRequestDispatcher("providerUpdate.jsp");
			rd.forward(request, response);
			break;
		case 6:
			//类型6代表编辑用户信息
			System.out.println("进入了dopost bookEdit");
			int bookId = Integer.valueOf(request.getParameter("bookId"));
			String bookname = request.getParameter("bookName");
			String bookauthor =request.getParameter("bookAuthor");
			int bookType = Integer.valueOf(request.getParameter("bookType"));
			int bookPub = Integer.valueOf(request.getParameter("publisherId"));
			float bookprice = Float.valueOf(request.getParameter("bookPrice"));
			float bookrealPrice = Float.valueOf(request.getParameter("realPrice"));
			String bookcontent = request.getParameter("bookContent");
			String bookimage = request.getParameter("bookImage");
			int bookscore = Integer.valueOf(request.getParameter("bookScore"));
			BookInfo bookTmp = new BookInfo();
			bookTmp.setBookId(bookId);
			bookTmp.setBookName(bookname);
			bookTmp.setBookAuthor(bookauthor);
			
			BookType bookTYPE = new BookType();
			bookTYPE.setTypeId(bookType);
			bookTYPE.setTypeName("");
			bookTmp.setBookType(bookTYPE);
			
			Publisher Pub = new Publisher();
			Pub.setPubId(bookPub);
			Pub.setPubName("");
			Pub.setPubAddress("");
			bookTmp.setPublisher(Pub);
			
			bookTmp.setBookPrice(bookprice);
			bookTmp.setRealPrice(bookrealPrice);
			bookTmp.setBookContent(bookcontent);
			bookTmp.setBookImage(bookimage);
			bookTmp.setBookScore(bookscore);
			
			boolean flagEdit = bookBiz.editInfo(bookTmp);
			if(flagEdit) {
				System.out.println("修改图书信息成功");
				List<BookInfo> infodel = bookBiz.bookInfoDetails();
				//将数据列表放入request作用域转发
				request.setAttribute("infos", infodel);
				rd = request.getRequestDispatcher("bookList.do?type=1");
				rd.forward(request,response);
			}
			break;
		}

	}

}
