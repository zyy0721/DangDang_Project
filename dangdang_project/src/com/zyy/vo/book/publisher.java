package com.zyy.vo.book;
/**
 * ��������
 * @author zyy79
 *
 */
public class publisher {
	private int pubId;//������Id
	private String pubName;//����������
	private String pubAddress;//�������ַ
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
