package com.zyy.dao.book;

import java.util.List;

import com.zyy.vo.book.bookInfo;
import com.zyy.vo.book.bookType;
import com.zyy.vo.book.publisher;

public interface IBookDao {
	/**
	 * 通过bookId来返回相应书籍信息
	 * @param bookID
	 * @return
	 */
	public bookInfo getBook(int bookID);
	/**
	 * 添加书本信息
	 * @param bookinfo
	 * @return
	 */
	public int addBook(bookInfo bookinfo);
	/**
	 * 根据书本ID删除书本
	 * @param bookID
	 * @return
	 */
	public int deleteBook(int bookID);
	/**
	 * 编辑书本信息
	 * @param bookinfo
	 * @return
	 */
	public int editBook(bookInfo bookinfo);
	/**
	 * 获取书本列表
	 * @return
	 */
	public List<bookInfo>getBookList();
	/**
	 * 根据类型id获取书籍类型
	 * @param typeId
	 * @return
	 */
	public bookType getBooktype(int typeId);
	/**
	 * 根据出版社Id获取出版社名称
	 * @param pubId
	 * @return
	 */
	public publisher getBookPublisher(int pubId);
	
	/**
	 * 获取书本列表通过类型
	 * @return
	 */
	public List<bookInfo>getBookListByType(int typeId);
	
	
	/**
	 * 分页展示
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<bookInfo> getBookListByPage(int pageNo,int pageSize);
	/**
	 * 数据总数
	 * @return
	 */
	public int bookCount();
}
