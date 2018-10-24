package com.zyy.dao.book;

import java.util.List;

import com.zyy.vo.book.bookInfo;
import com.zyy.vo.book.bookType;
import com.zyy.vo.book.publisher;

public interface IBookDao {
	/**
	 * ͨ��bookId��������Ӧ�鼮��Ϣ
	 * @param bookID
	 * @return
	 */
	public bookInfo getBook(int bookID);
	/**
	 * ����鱾��Ϣ
	 * @param bookinfo
	 * @return
	 */
	public int addBook(bookInfo bookinfo);
	/**
	 * �����鱾IDɾ���鱾
	 * @param bookID
	 * @return
	 */
	public int deleteBook(int bookID);
	/**
	 * �༭�鱾��Ϣ
	 * @param bookinfo
	 * @return
	 */
	public int editBook(bookInfo bookinfo);
	/**
	 * ��ȡ�鱾�б�
	 * @return
	 */
	public List<bookInfo>getBookList();
	/**
	 * ��������id��ȡ�鼮����
	 * @param typeId
	 * @return
	 */
	public bookType getBooktype(int typeId);
	/**
	 * ���ݳ�����Id��ȡ����������
	 * @param pubId
	 * @return
	 */
	public publisher getBookPublisher(int pubId);
	
	/**
	 * ��ȡ�鱾�б�ͨ������
	 * @return
	 */
	public List<bookInfo>getBookListByType(int typeId);
	
	
	/**
	 * ��ҳչʾ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<bookInfo> getBookListByPage(int pageNo,int pageSize);
	/**
	 * ��������
	 * @return
	 */
	public int bookCount();
}
