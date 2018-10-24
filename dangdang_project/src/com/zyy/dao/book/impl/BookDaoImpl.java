package com.zyy.dao.book.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zyy.dao.BaseDao;
import com.zyy.dao.book.IBookDao;

import com.zyy.vo.book.bookInfo;
import com.zyy.vo.book.bookType;
import com.zyy.vo.book.publisher;
import com.zyy.vo.user.userInfo;

public class BookDaoImpl extends BaseDao implements IBookDao {

	@Override
	public bookInfo getBook(int bookID) {
		//�����û�����
		bookInfo bookInfo = null;
		//��дSQL����
		String sql="SELECT book_Id, bookName,bookAuthor,bookType,publisherId,bookPrice,realPrice,bookContent,bookImage,book_score FROM bookinfo WHERE book_Id=?";
		//��װ��ѯ����
		Object[] params = {bookID};
		//���ø���Ĳ�ѯ������ý����
		resultSet = super.excuteSelect(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		try {
			if(resultSet.next()) {
				//�����û����ݶ���
				bookInfo=new bookInfo();
				bookInfo.setBookId(resultSet.getInt("book_Id"));
				bookInfo.setBookName(resultSet.getString("bookName"));
				bookInfo.setBookAuthor(resultSet.getString("bookAuthor"));
				//bookInfo.setBookType(resultSet.getInt("bookType"));
				//bookInfo.setPublishId(resultSet.getInt("publisherId"));
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
	public int addBook(bookInfo bookinfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBook(int bookID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editBook(bookInfo bookinfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<bookInfo> getBookList() {
		//�����û�����
		List<bookInfo> infos =new ArrayList<bookInfo>();
		String sql = "SELECT book_Id,bookName,bookAuthor,bookType,typeName,publisherId,pub_name,pub_address,bookPrice,realPrice,bookContent,bookImage,book_score FROM bookinfo INNER JOIN booktype ON bookinfo.bookType=booktype.typeId INNER JOIN publisher ON bookinfo.publisherId=publisher.pub_Id";
		//������������
		Object[] params = null;
		//���ò�ѯ�ķ������ܽ����
		resultSet = super.excuteSelect(params, sql);
		//�������������װ���ݼ���
		try {
			while(resultSet.next()) {
				bookInfo bookInfo=new bookInfo();
				bookInfo.setBookId(resultSet.getInt("book_Id"));
				bookInfo.setBookName(resultSet.getString("bookName"));
				bookInfo.setBookAuthor(resultSet.getString("bookAuthor"));
				
				bookType booktype = new bookType();
				booktype.setTypeId(resultSet.getInt("bookType"));
				booktype.setTypeName(resultSet.getString("typeName"));
				bookInfo.setBookType(booktype);
				
				publisher pub = new publisher();
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
	public bookType getBooktype(int typeId) {
		//�����û�����
				bookType booktype = null;
				//��дSQL����
				String sql="SELECT typeId,typeName FROM booktype WHERE typeId=?";
				//��װ��ѯ����
				Object[] params = {typeId};
				//���ø���Ĳ�ѯ������ý����
				resultSet = super.excuteSelect(params, sql);
				//�ڽ��������ͬ�·�װ���ݶ���
				try {
					if(resultSet.next()) {
						//�����û����ݶ���
						booktype=new bookType();
						booktype.setTypeId(resultSet.getInt("typeId"));
						booktype.setTypeName(resultSet.getString("typeName"));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					this.closeAll();
				}
				return booktype;
	}
	@Override
	public publisher getBookPublisher(int pubId) {
		//�����û�����
		publisher pub = null;
		//��дSQL����
		String sql="SELECT pub_Id,pub_name,pub_address FROM publisher WHERE pub_Id=?";
		//��װ��ѯ����
		Object[] params = {pubId};
		//���ø���Ĳ�ѯ������ý����
		resultSet = super.excuteSelect(params, sql);
		//�ڽ��������ͬ�·�װ���ݶ���
		try {
			if(resultSet.next()) {
				//�����û����ݶ���
				pub=new publisher();
				pub.setPubId(resultSet.getInt("pub_Id"));
				pub.setPubName(resultSet.getString("pub_name"));
				pub.setPubAddress(resultSet.getString("pub_address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.closeAll();
		}
		return pub;
	}
	@Override
	public List<bookInfo> getBookListByType(int typeId) {
		//�����û�����
		List<bookInfo> infos =new ArrayList<bookInfo>();
		String sql = "SELECT book_Id,bookName,bookAuthor,bookType,typeName,publisherId,pub_name,pub_address,bookPrice,realPrice,bookContent,bookImage,book_score FROM bookinfo INNER JOIN booktype ON bookinfo.bookType=booktype.typeId INNER JOIN publisher ON bookinfo.publisherId=publisher.pub_Id WHERE typeId=?";
		//������������
		/**
		 * ���ﵽʱ���� ���� ����
		 */
		Object[] params = {typeId};
		//���ò�ѯ�ķ������ܽ����
		resultSet = super.excuteSelect(params, sql);
		//�������������װ���ݼ���
		try {
			while(resultSet.next()) {
				bookInfo bookInfo=new bookInfo();
				bookInfo.setBookId(resultSet.getInt("book_Id"));
				bookInfo.setBookName(resultSet.getString("bookName"));
				bookInfo.setBookAuthor(resultSet.getString("bookAuthor"));
				
				bookType booktype = new bookType();
				booktype.setTypeId(resultSet.getInt("bookType"));
				booktype.setTypeName(resultSet.getString("typeName"));
				bookInfo.setBookType(booktype);
				
				publisher pub = new publisher();
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
	public List<bookInfo> getBookListByPage(int pageNo,int pageSize) {
		//�����û�����
		List<bookInfo> infos =new ArrayList<bookInfo>();
		String sql = "SELECT * FROM (SELECT book_Id,bookName,bookAuthor,bookType,typeName,publisherId,pub_name,pub_address,bookPrice,realPrice,bookContent,bookImage,book_score FROM bookinfo INNER JOIN booktype ON bookinfo.bookType=booktype.typeId INNER JOIN publisher ON bookinfo.publisherId=publisher.pub_Id) as t LIMIT ?,?";
		//������������
		int pageNoTmp = (pageNo-1)*pageSize;
		Object[] params = {pageNoTmp,pageSize};
		//���ò�ѯ�ķ������ܽ����
		resultSet = super.excuteSelect(params, sql);
		//�������������װ���ݼ���
		try {
			while(resultSet.next()) {
				bookInfo bookInfo=new bookInfo();
				bookInfo.setBookId(resultSet.getInt("book_Id"));
				bookInfo.setBookName(resultSet.getString("bookName"));
				bookInfo.setBookAuthor(resultSet.getString("bookAuthor"));
				
				bookType booktype = new bookType();
				booktype.setTypeId(resultSet.getInt("bookType"));
				booktype.setTypeName(resultSet.getString("typeName"));
				bookInfo.setBookType(booktype);
				
				publisher pub = new publisher();
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
