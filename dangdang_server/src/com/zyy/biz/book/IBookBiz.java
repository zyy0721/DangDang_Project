package com.zyy.biz.book;

import java.util.List;

import com.zyy.vo.book.BookInfo;


public interface IBookBiz {
	/**
	 * �鼮���
	 * @param userInfo
	 * @return
	 */
	public boolean addInfo(BookInfo bookInfo);
	/**
	 * �鼮��Ϣ�޸�
	 * @param userInfo
	 * @return
	 */
	public boolean editInfo(BookInfo bookInfo);
	/**
	 * �����鼮Idɾ��
	 * @param userId
	 * @return
	 */
	public boolean delBookInfoById(int bookId);
	/**
	 * �鼮�б�
	 * @return
	 */
	public List<BookInfo> bookInfoDetails();
	
	/**
	 * �����鼮Id������Ϣ
	 * @param bookId
	 * @return
	 */
	public BookInfo getBookById(int bookId);
	public List<BookInfo> bookInfoDetailsByPage(int pageNo,int pageSize);
	
	/**
	 * ���鼮����
	 * @return
	 */
	public int searchBookCount();
}
