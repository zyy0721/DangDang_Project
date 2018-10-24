<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>图书管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>图书管理系统</h1>

    <div class="publicHeaderR">
        <p><span id="hours"></span><span style="color: #fff21b"> <c:out value="${sessionScope.adminName }"></c:out></span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li id="active"><a href="bookList.do?type=2">图书管理</a></li>
                <li><a href="user.do?type=2">用户管理</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>图书管理页面 >> 信息查看</span>
        </div>
        <div class="providerView">
            <p><strong>图书编码：</strong><span>${requestScope.book.bookId }</span></p>
            <p><strong>图书名称：</strong><span>${requestScope.book.bookName }</span></p>
            <p><strong>图书类型：</strong><span>${requestScope.book.bookType.typeName }</span></p>
            <p><strong>图书作者：</strong><span>${requestScope.book.bookAuthor }</span></p>
            <p><strong>图书出版社：</strong><span>${requestScope.book.publisher.pubName }</span></p>
            <p><strong>图书定价：</strong><span>${requestScope.book.bookPrice }</span></p>
            <p><strong>图书销售价：</strong><span>${requestScope.book.realPrice }</span></p>
			<p><strong>图书简介：</strong><span>${requestScope.book.bookContent }</span></p>
			<p><strong>图书图片地址：</strong><span>${requestScope.book.bookImage }</span></p>
			
            <a href="bookList.do?type=1">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>