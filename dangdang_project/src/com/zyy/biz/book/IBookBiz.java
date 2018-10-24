package com.zyy.biz.book;

import java.util.List;
import com.zyy.vo.book.*;
public interface IBookBiz {
	
	/**
	 * �鼮�б�
	 * @return
	 */
	public List<bookInfo> bookInfoDetails();
	/**
	 * �鼮�б�by ����
	 */
	public List<bookInfo> bookInfoDetailsByTypeId(int typeId);
	/**
	 * �鼮�б��ҳ
	 * @return
	 */
	public List<bookInfo> bookInfoDetailsByPage(int pageNo,int pageSize);
	/**
	 * ���鼮����
	 * @return
	 */
	public int searchBookCount();
}
