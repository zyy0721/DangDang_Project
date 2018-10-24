package com.zyy.vo.book;
/**
 * �鼮��
 * @author zyy79
 *
 */
public class bookInfo {
	private int bookId;//�鼮ID
	private String bookName;//�鼮����
	private bookType bookType;//�鼮����
	private publisher publisher;//�鼮������
	private float bookPrice;//�鼮����
	private float realPrice;//�鼮���ۼ�
	private String bookContent;//�鼮���
	private String bookImage;//�鼮ͼƬurl��ַ
	private int bookScore;//�鼮����
	private String bookAuthor;//�鼮����
	public bookInfo() {
		super();
	}
	public bookInfo(int bookId, String bookName, com.zyy.vo.book.bookType bookType, com.zyy.vo.book.publisher publisher,
			float bookPrice, float realPrice, String bookContent, String bookImage, int bookScore, String bookAuthor) {
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
	public bookType getBookType() {
		return bookType;
	}
	public void setBookType(bookType bookType) {
		this.bookType = bookType;
	}
	public publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(publisher publisher) {
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
