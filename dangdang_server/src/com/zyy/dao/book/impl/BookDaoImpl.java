package com.zyy.dao.book.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyy.dao.BaseDao;
import com.zyy.dao.book.IBookDao;
import com.zyy.vo.book.BookInfo;
import com.zyy.vo.book.BookType;
import com.zyy.vo.book.Publisher;



public class BookDaoImpl extends BaseDao implements IBookDao {

	@Override
	public BookInfo getBook(int bookId) {
		//�����û�����
		BookInfo bookInfo = null;
		//��дSQL����
		String sql="SELECT book_Id,bookName,bookAuthor,bookType,typeName,publisherId,pub_name,pub_address,bookPrice,realPrice,bookContent,bookImage,book_score FROM bookinfo INNER JOIN booktype ON bookinfo.bookType=booktype.typeId INNER JOIN publisher ON bookinfo.publisherId=publisher.pub_Id WHERE book_Id=?";
		//��װ��ѯ����
		Object[] params = {bookId};
		//���ø���Ĳ�ѯ������ý����
		resultSet = super.excuteSelect(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		try {
			if(resultSet.next()) {
				//�����û����ݶ���
                bookInfo=new BookInfo();
				bookInfo.setBookId(resultSet.getInt("book_Id"));
				bookInfo.setBookName(resultSet.getString("bookName"));
				bookInfo.setBookAuthor(resultSet.getString("bookAuthor"));
				
				BookType booktype = new BookType();
				booktype.setTypeId(resultSet.getInt("bookType"));
				booktype.setTypeName(resultSet.getString("typeName"));
				bookInfo.setBookType(booktype);
				
				Publisher pub = new Publisher();
				pub.setPubId(resultSet.getInt("publisherId"));
				pub.setPubName(resultSet.getString("pub_name"));
				pub.setPubAddress(resultSet.getString("pub_address"));
				bookInfo.setPublisher(pub);
	
				bookInfo.setBookPrice(resultSet.getFloat("bookPrice"));
				bookInfo.setRealPrice(resultSet.getFloat("realPrice"));
				bookInfo.setBookContent(resultSet.getString("bookContent"));
				bookInfo.setBookImage(resultSet.getString("bookImage"));
				bookInfo.setBookScore(resultSet.getInt("book_score"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return bookInfo;
	}

	@Override
	public int addBook(BookInfo bookInfo) {
		//�����û�����
		BookInfo bookInfoTmp = bookInfo;
		//��дSQL����
		String sql="INSERT INTO bookinfo (bookName,bookAuthor,bookType,publisherId,bookPrice,realPrice,bookContent,bookImage,book_score) VALUES(?,?,?,?,?,?,?,?,?)";
		//��װ��ѯ����
		String bookName = bookInfoTmp.getBookName();
		String bookAuthor = bookInfoTmp.getBookAuthor();
		BookType bookType = bookInfoTmp.getBookType();
		int booktype = bookType.getTypeId();
		Publisher publisher = bookInfoTmp.getPublisher();
		int publisherId = publisher.getPubId();
		float bookPrice = bookInfoTmp.getBookPrice();
		float realPrice = bookInfoTmp.getRealPrice();
		String bookContent = bookInfoTmp.getBookContent();
		String bookImage = bookInfoTmp.getBookImage();
		int bookScore = bookInfoTmp.getBookScore();
		Object[] params = {bookName,bookAuthor,booktype,publisherId,bookPrice,realPrice,bookContent,bookImage,bookScore};
		//���ø���Ĳ�ѯ������ý����
		int line = super.excuteEdit(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		/**
		 * û��д���lineС��0�������try catchզд
		 */
		this.closeAll();
		return line;
	}

	@Override
	public int delBook(int bookId) {

		//��дSQL����
		String sql="DELETE FROM bookinfo WHERE book_Id=?";
		//��װ��ѯ����
		Object[] params = {bookId};
		//���ø���Ĳ�ѯ������ý����
		int line = super.excuteEdit(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		/**
		 * û��д���lineС��0�������try catchզд
		 */
		this.closeAll();
		return line;
	}

	@Override
	public int editBook(BookInfo bookInfo) {
		//��дSQL����
		BookInfo bookInfoTmp = bookInfo;
		String sql="UPDATE bookinfo set bookName= ?, bookAuthor=?,bookType=?,publisherId=?,bookPrice=?,realPrice=?,bookContent=?,bookImage=?,book_score=?  WHERE book_Id=?";
		//��װ��ѯ����
		String bookName = bookInfoTmp.getBookName();
		String bookAuthor = bookInfoTmp.getBookAuthor();
		BookType bookType = bookInfoTmp.getBookType();
		int booktype = bookType.getTypeId();
		Publisher publisher = bookInfoTmp.getPublisher();
		int publisherId = publisher.getPubId();
		float bookPrice = bookInfoTmp.getBookPrice();
		float realPrice = bookInfoTmp.getRealPrice();
		String bookContent = bookInfoTmp.getBookContent();
		String bookImage = bookInfoTmp.getBookImage();
		int bookScore = bookInfoTmp.getBookScore();
		int bookId = bookInfoTmp.getBookId();
		Object[] params = {bookName,bookAuthor,booktype,publisherId,bookPrice,realPrice,bookContent,bookImage,bookScore,bookId};
		//���ø���Ĳ�ѯ������ý����
		int line = super.excuteEdit(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		/**
		 * û��д���lineС��0�������try catchզд
		 */
		this.closeAll();
		return line;
	}

	@Override
	public List<BookInfo> getBookList() {
		//�����û�����
		List<BookInfo> infos =new ArrayList<BookInfo>();
		String sql = "SELECT book_Id,bookName,bookAuthor,bookType,typeName,publisherId,pub_name,pub_address,bookPrice,realPrice,bookContent,bookImage,book_score FROM bookinfo INNER JOIN booktype ON bookinfo.bookType=booktype.typeId INNER JOIN publisher ON bookinfo.publisherId=publisher.pub_Id";
		//������������
		Object[] params = null;
		//���ò�ѯ�ķ������ܽ����
		resultSet = super.excuteSelect(params, sql);
		//�������������װ���ݼ���
		try {
			while(resultSet.next()) {
				BookInfo bookInfo=new BookInfo();
				bookInfo.setBookId(resultSet.getInt("book_Id"));
				bookInfo.setBookName(resultSet.getString("bookName"));
				bookInfo.setBookAuthor(resultSet.getString("bookAuthor"));
				
				BookType booktype = new BookType();
				booktype.setTypeId(resultSet.getInt("bookType"));
				booktype.setTypeName(resultSet.getString("typeName"));
				bookInfo.setBookType(booktype);
				
				Publisher pub = new Publisher();
				pub.setPubId(resultSet.getInt("publisherId"));
				pub.setPubName(resultSet.getString("pub_name"));
				pub.setPubAddress(resultSet.getString("pub_address"));
				bookInfo.setPublisher(pub);
				
				bookInfo.setBookPrice(resultSet.getFloat("bookPrice"));
				bookInfo.setRealPrice(resultSet.getFloat("realPrice"));
				bookInfo.setBookContent(resultSet.getString("bookContent"));
				bookInfo.setBookImage(resultSet.getString("bookImage"));
				bookInfo.setBookScore(resultSet.getInt("book_score"));
				infos.add(bookInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return infos;
	}
	@Override
	public List<BookInfo> getBookListByPage(int pageNo,int pageSize) {
		//�����û�����
		List<BookInfo> infos =new ArrayList<BookInfo>();
		String sql = "SELECT * FROM (SELECT book_Id,bookName,bookAuthor,bookType,typeName,publisherId,pub_name,pub_address,bookPrice,realPrice,bookContent,bookImage,book_score FROM bookinfo INNER JOIN booktype ON bookinfo.bookType=booktype.typeId INNER JOIN publisher ON bookinfo.publisherId=publisher.pub_Id) as t LIMIT ?,?";
		//������������
		int pageNoTmp = (pageNo-1)*pageSize;
		Object[] params = {pageNoTmp,pageSize};
		//���ò�ѯ�ķ������ܽ����
		resultSet = super.excuteSelect(params, sql);
		//�������������װ���ݼ���
		try {
			while(resultSet.next()) {
				BookInfo bookInfo=new BookInfo();
				bookInfo.setBookId(resultSet.getInt("book_Id"));
				bookInfo.setBookName(resultSet.getString("bookName"));
				bookInfo.setBookAuthor(resultSet.getString("bookAuthor"));
				
				BookType booktype = new BookType();
				booktype.setTypeId(resultSet.getInt("bookType"));
				booktype.setTypeName(resultSet.getString("typeName"));
				bookInfo.setBookType(booktype);
				
				Publisher pub = new Publisher();
				pub.setPubId(resultSet.getInt("publisherId"));
				pub.setPubName(resultSet.getString("pub_name"));
				pub.setPubAddress(resultSet.getString("pub_address"));
				bookInfo.setPublisher(pub);
				
				bookInfo.setBookPrice(resultSet.getFloat("bookPrice"));
				bookInfo.setRealPrice(resultSet.getFloat("realPrice"));
				bookInfo.setBookContent(resultSet.getString("bookContent"));
				bookInfo.setBookImage(resultSet.getString("bookImage"));
				bookInfo.setBookScore(resultSet.getInt("book_score"));
				infos.add(bookInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return infos;
	}
	@Override
	public int bookCount() {
		int count=0;
		String sql="SELECT COUNT(1) bookCount FROM bookinfo";
		Object[] params = null;
		resultSet = super.excuteSelect(params, sql);
		try {
			if(resultSet.next()) {
				count = resultSet.getInt("bookCount");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		
		return count;
		
	}
}
