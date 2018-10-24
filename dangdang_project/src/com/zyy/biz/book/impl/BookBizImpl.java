package com.zyy.biz.book.impl;

import java.util.List;


import com.zyy.biz.book.IBookBiz;
import com.zyy.dao.BaseDao;
import com.zyy.dao.book.IBookDao;
import com.zyy.dao.book.impl.BookDaoImpl;
import com.zyy.vo.book.bookInfo;

public class BookBizImpl extends BaseDao implements IBookBiz {
	IBookDao bookDao = new BookDaoImpl();
	@Override
	public List<bookInfo> bookInfoDetails() {
		List<bookInfo> infos = bookDao.getBookList();
		return infos;
	}
	@Override
	public List<bookInfo> bookInfoDetailsByTypeId(int typeId){
		List<bookInfo>books = bookDao.getBookListByType(typeId);
		return books;
	}
	@Override
	public List<bookInfo> bookInfoDetailsByPage(int pageNo,int pageSize) {
		List<bookInfo> infos = bookDao.getBookListByPage(pageNo,pageSize);
		return infos;
	}
	
	@Override
	public int searchBookCount() {
		int count = bookDao.bookCount();
		return count;
	}
}
