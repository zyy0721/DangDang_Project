package com.zyy.vo.book;
/**
 * 书籍类
 * @author zyy79
 *
 */
public class BookInfo {
	private int bookId;//书籍ID
	private String bookName;//书籍名称
	private BookType bookType;//书籍类型
	private Publisher publisher;//书籍出版社
	private float bookPrice;//书籍定价
	private float realPrice;//书籍销售价
	private String bookContent;//书籍简介
	private String bookImage;//书籍图片url地址
	private int bookScore;//书籍积分
	private String bookAuthor;//书籍作者
	public BookInfo() {
		super();
	}
	public BookInfo(int bookId, String bookName, BookType bookType, Publisher publisher, float bookPrice,
			float realPrice, String bookContent, String bookImage, int bookScore, String bookAuthor) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookType = bookType;
		this.publisher = publisher;
		this.bookPrice = bookPrice;
		this.realPrice = realPrice;
		this.bookContent = bookContent;
		this.bookImage = bookImage;
		this.bookScore = bookScore;
		this.bookAuthor = bookAuthor;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public BookType getBookType() {
		return bookType;
	}
	public void setBookType(BookType bookType) {
		this.bookType = bookType;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public float getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(float realPrice) {
		this.realPrice = realPrice;
	}
	public String getBookContent() {
		return bookContent;
	}
	public void setBookContent(String bookContent) {
		this.bookContent = bookContent;
	}
	public String getBookImage() {
		return bookImage;
	}
	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	public int getBookScore() {
		return bookScore;
	}
	public void setBookScore(int bookScore) {
		this.bookScore = bookScore;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	
}
