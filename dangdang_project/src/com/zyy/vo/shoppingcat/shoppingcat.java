package com.zyy.vo.shoppingcat;
/**
 * ���ﳵ��
 * @author zyy79
 *
 */
public class shoppingcat {
	private int userId;//�û�Id
	private int bookId;//�鼮Id
	private int isBuy;//�Ƿ�֧����0δ֧����1֧��
	public shoppingcat() {
		super();
	}
	public shoppingcat(int userId, int bookId, int isBuy) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.isBuy = isBuy;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getIsBuy() {
		return isBuy;
	}
	public void setIsBuy(int isBuy) {
		this.isBuy = isBuy;
	}
	
}
