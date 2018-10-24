package com.zyy.dao.book;

import java.util.List;

import com.zyy.vo.book.BookInfo;

public interface IBookDao {
	/**
	 * 通过用户id,获取登录用户的信息
	 * @param name
	 * @param pwd
	 * @return
	 */
	public BookInfo getBook(int bookId);
	/**
	 * 添加新书
	 * @param bookInfo
	 * @return
	 */
	public int addBook(BookInfo bookInfo);
	/**
	 * 通过Id删除书籍信息
	 * @param bookId
	 * @return
	 */
	public int delBook(int bookId);
	/**
	 * 对书籍的信息修改
	 * @param bookInfo
	 * @return
	 */
	public int editBook(BookInfo bookInfo);
	/**
	 * 查询书籍列表
	 * @return
	 */
	public List<BookInfo> getBookList();
	
	/**
	 * 分页展示
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<BookInfo> getBookListByPage(int pageNo,int pageSize);
	
	public int bookCount();
}
