package com.zyy.dao.book;

import java.util.List;

import com.zyy.vo.book.BookInfo;

public interface IBookDao {
	/**
	 * ͨ���û�id,��ȡ��¼�û�����Ϣ
	 * @param name
	 * @param pwd
	 * @return
	 */
	public BookInfo getBook(int bookId);
	/**
	 * �������
	 * @param bookInfo
	 * @return
	 */
	public int addBook(BookInfo bookInfo);
	/**
	 * ͨ��Idɾ���鼮��Ϣ
	 * @param bookId
	 * @return
	 */
	public int delBook(int bookId);
	/**
	 * ���鼮����Ϣ�޸�
	 * @param bookInfo
	 * @return
	 */
	public int editBook(BookInfo bookInfo);
	/**
	 * ��ѯ�鼮�б�
	 * @return
	 */
	public List<BookInfo> getBookList();
	
	/**
	 * ��ҳչʾ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<BookInfo> getBookListByPage(int pageNo,int pageSize);
	
	public int bookCount();
}
