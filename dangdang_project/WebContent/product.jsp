<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>当当网商品展示页面</title>
    <link href="css/global.css" rel="stylesheet" type="text/css" />
    <link href="css/layout.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/product.js"></script>
</head>
<body>
<div id="header"><iframe src="header.jsp" height="155px" width="960px" frameborder="0"></iframe></div>
<!--中间部分开始-->
<div id="main">
    <div class="dd_index_top_adver"><img src="images/dd_index_top_adver.jpg" alt="通栏广告图片" /></div>
    <div class="current_place">您现在的位置：<a href="index.jsp">当当图书</a> &gt;&gt; 小说 &gt;&gt; 财经</div>
    <!--左侧菜单开始-->
    <div id="product_left">
        <div id="product_catList">
            <div class="product_catList_top">浏览同级分类</div>
            <div id="product_catList_class"><!--使用javaScript显示图书分类--></div>
        </div>
        <div class="product_catList_end">
            <img src="images/product_01.gif" alt="shopping"/>
            <img src="images/product_02.gif" alt="shopping"/>
        </div>
    </div>
    <!--右侧内容开始-->
    <div id="product_storyList">
        <div id="product_storyList_top">
            <ul>
                <li>排序方式</li>
                <li><img src="images/dd_arrow_right.gif" alt="arrow"/></li>
                <li>
                    <select id="compositor">
                    <option>按销量 降序</option>
                    <option>按价格 升序</option>
                    <option>按价格 降序</option>
                    <option>按折扣 升序</option>
                    <option>按折扣 降序</option>
                    <option>按出版时间 升序</option>
                    <option>按出版时间 降序</option>
                    <option>按上架时间 升序</option>
                    <option>按上架时间 降序</option>
                    </select>
                </li>
                <li><img src="images/product_icon_01.gif" alt="icon"/></li>
                <li><img src="images/product_icon_02.gif" alt="icon"/></li>
                <li><img src="images/product_icon_03.gif" alt="icon"/></li>
                <li><img src="images/product_icon_04.gif" alt="icon"/></li>
                <li>每页显示的数量</li>
                <li><img src="images/dd_arrow_right.gif" alt="arrow"/></li>
                <li><img src="images/product_icon_20.gif" alt="icon"/></li>
                <li><img src="images/product_icon_40.gif" alt="icon"/></li>
                <li style="float:right; padding-right:10px;"><img src="images/product_page_down.gif" alt="icon"/></li>
                <li style="float:right;">第1页</li>
                <li style="float:right;"><img src="images/product_page_up.gif" alt="icon"/></li>
            </ul>
        </div>
        <div id="product_array">
            <a class="click" name="array"  href="javascript:void(0)">列表</a>
            <a name="bigImg" href="javascript:void(0)">大图</a>
        </div>
        <!--图书排列开始-->
        <div id="product_storyList_content" class="product_storyList_content">
            <c:forEach items="${requestScope.pageBooks}" var="books">
            <!--列表开始-->
            <div class="product_storyList_content_left"><img src=${books.bookImage } } alt="图书列表"/></div>
            <div class="product_storyList_content_right">
                <ul>
                    <li class="product_storyList_content_dash"><a href="#" class="blue_14">${books.bookName}</a></li>
                    <li>顾客评分：<img src="images/star_red.gif" alt="star"/><img src="images/star_red.gif" alt="star"/><img src="images/star_red.gif" alt="star"/><img src="images/star_red.gif" alt="star"/><img src="images/star_gray.gif" alt="star"/></li>
                    <li>作　者：<a href="#" class="blue_14">${books.bookAuthor}</li>
                    <li>出版社：<a href="#" class="blue_14">${books.publisher.pubName}</a></li>
                    <li>${books.bookContent}</li>
                    <li>
                        <dl class="product_content_dd">
                            <dd><img src="images/product_buy_02.gif" alt="shopping"/></dd>
                            <dd><img src="images/product_buy_01.gif" alt="shopping"/></dd>
                            <dd class="footer_dull_red"><span>￥${books.realPrice}</span></dd>
                            <dd class="product_content_delete"><span>￥${books.bookPrice}</span></dd>
                        </dl>
                    </li>
                </ul>
            </div>
            <div class="product_storyList_content_bottom"></div>
            </c:forEach>
            <div>
                <dl class="product_content_dd">
                	总共${requestScope.maxPage}页
                    <dd><img src="images/OK.gif" alt="ok"/></dd>
                    <dd>页</dd>
                    <dd><input name="page" type="text" value=${requestScope.pageNo} style="width:20px;"/></dd>
                    <dd>当前到第</dd>
                    <dd>
					<c:if test="${requestScope.pageNo>1}">
						<a href="book.do?type=2&&pageNo=${requestScope.pageNo-1 }">上一页</a>
					</c:if>
					<c:if test="${requestScope.pageNo<maxPage}">
						<a href="book.do?type=2&&pageNo=${requestScope.pageNo+1 }">下一页</a>
					</c:if>
                    </dd>
                    <dd><img src="images/product_page_up.gif" alt="ok"/></dd>
                </dl>
            </div>
        </div>
    </div>
    <!--右侧内容结束-->
</div>
<!--网站版权部分开始-->
<div id="footer">
<div class="footer_top"><a href="#" target="_parent" class="footer_dull_red">公司简介</a> | <a href="#" target="_parent" class="footer_dull_red">诚证英才</a> | <a href="#" target="_parent" class="footer_dull_red">网站联盟</a> | <a href="#" target="_parent" class="footer_dull_red">百货招商</a> | <a href="#" target="_parent" class="footer_dull_red">交易条款</a></div>
<iframe src="footer.jsp" height="50px" width="900px" frameborder="0"></iframe></div>
</body>
</html>
