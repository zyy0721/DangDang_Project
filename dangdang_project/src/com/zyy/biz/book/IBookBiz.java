package com.zyy.biz.book;

import java.util.List;
import com.zyy.vo.book.*;
public interface IBookBiz {
	
	/**
	 * 书籍列表
	 * @return
	 */
	public List<bookInfo> bookInfoDetails();
	/**
	 * 书籍列表by 类型
	 */
	public List<bookInfo> bookInfoDetailsByTypeId(int typeId);
	/**
	 * 书籍列表分页
	 * @return
	 */
	public List<bookInfo> bookInfoDetailsByPage(int pageNo,int pageSize);
	/**
	 * 找书籍总数
	 * @return
	 */
	public int searchBookCount();
}
