package com.zyy.vo.shoppingcat;
/**
 * 购物车类
 * @author zyy79
 *
 */
public class shoppingcat {
	private int userId;//用户Id
	private int bookId;//书籍Id
	private int isBuy;//是否支付，0未支付，1支付
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
