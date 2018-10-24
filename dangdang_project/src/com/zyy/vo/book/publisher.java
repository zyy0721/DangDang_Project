package com.zyy.vo.book;
/**
 * 出版社类
 * @author zyy79
 *
 */
public class publisher {
	private int pubId;//出版社Id
	private String pubName;//出版社名称
	private String pubAddress;//出版社地址
	public publisher() {
		super();
	}
	public publisher(int pubId, String pubName, String pubAddress) {
		super();
		this.pubId = pubId;
		this.pubName = pubName;
		this.pubAddress = pubAddress;
	}
	public int getPubId() {
		return pubId;
	}
	public void setPubId(int pubId) {
		this.pubId = pubId;
	}
	public String getPubName() {
		return pubName;
	}
	public void setPubName(String pubName) {
		this.pubName = pubName;
	}
	public String getPubAddress() {
		return pubAddress;
	}
	public void setPubAddress(String pubAddress) {
		this.pubAddress = pubAddress;
	}
	
}
