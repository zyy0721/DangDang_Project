package com.zyy.biz.book;

import java.util.List;

import com.zyy.vo.book.BookInfo;


public interface IBookBiz {
	/**
	 * 书籍添加
	 * @param userInfo
	 * @return
	 */
	public boolean addInfo(BookInfo bookInfo);
	/**
	 * 书籍信息修改
	 * @param userInfo
	 * @return
	 */
	public boolean editInfo(BookInfo bookInfo);
	/**
	 * 根据书籍Id删除
	 * @param userId
	 * @return
	 */
	public boolean delBookInfoById(int bookId);
	/**
	 * 书籍列表
	 * @return
	 */
	public List<BookInfo> bookInfoDetails();
	
	/**
	 * 根据书籍Id查找信息
	 * @param bookId
	 * @return
	 */
	public BookInfo getBookById(int bookId);
	public List<BookInfo> bookInfoDetailsByPage(int pageNo,int pageSize);
	
	/**
	 * 找书籍总数
	 * @return
	 */
	public int searchBookCount();
}
