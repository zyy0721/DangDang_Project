package com.zyy.vo.book;
/**
 * �鼮������
 * @author zyy79
 *
 */
public class bookType {
	private int typeId;//����Id
	private String typeName;//��������
	public bookType() {
		super();
	}
	public bookType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
