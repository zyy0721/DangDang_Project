package com.zyy.biz.book.impl;

import java.util.List;

import com.zyy.biz.book.IBookBiz;
import com.zyy.dao.BaseDao;
import com.zyy.dao.book.IBookDao;
import com.zyy.dao.book.impl.BookDaoImpl;

import com.zyy.vo.book.BookInfo;


public class BookBizImpl extends BaseDao implements IBookBiz {
	IBookDao BookDao = new BookDaoImpl();
	@Override
	public boolean addInfo(BookInfo bookInfo) {
		int line = BookDao.addBook(bookInfo);
		if(line>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean editInfo(BookInfo bookInfo) {
		int line = BookDao.editBook(bookInfo);
		if(line>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean delBookInfoById(int bookId) {
		int line = BookDao.delBook(bookId);
		if(line>0)
			return true;
		else
			return false;
	}

	@Override
	public List<BookInfo> bookInfoDetails() {
		List<BookInfo> infos = BookDao.getBookList();
		return infos;
	}
	
	@Override
	public BookInfo getBookById(int bookId) {
		BookInfo book = BookDao.getBook(bookId);
		return book;
	}
	@Override
	public List<BookInfo> bookInfoDetailsByPage(int pageNo,int pageSize) {
		List<BookInfo> infos = BookDao.getBookListByPage(pageNo,pageSize);
		return infos;
	}
	
	@Override
	public int searchBookCount() {
		int count = BookDao.bookCount();
		return count;
	}
	
}
