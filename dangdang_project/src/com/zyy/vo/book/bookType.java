package com.zyy.vo.book;
/**
 * 书籍类型类
 * @author zyy79
 *
 */
public class bookType {
	private int typeId;//类型Id
	private String typeName;//类型名称
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
