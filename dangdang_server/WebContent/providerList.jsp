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
            <span>图书管理页面</span>
        </div>
        <div class="search">
            <span>图书名称：</span>
            <input type="text" placeholder="请输入图书的编码"/>
            <input type="button" value="查询"/>
            <a href="providerAdd.jsp">添加图书</a>
        </div>
            <div>

                    <dd> 总共${requestScope.maxPage}页 当前到第 ${requestScope.pageNo}页</dd>
                    <dd>
                    <c:if test="${requestScope.pageNo>1}">
						<a href="bookList.do?type=1&&pageNo=${requestScope.pageNo-1 }">上一页</a>
					</c:if>
					<c:if test="${requestScope.pageNo<maxPage}">
						<a href="bookList.do?type=1&&pageNo=${requestScope.pageNo+1 }">下一页</a>
					</c:if>
                    </dd>
    </div>
        <!--图书操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">图书编码</th>
                <th width="20%">图书名称</th>
                <th width="10%">图书作者</th>
                <th width="10%">图书出版社</th>
                <th width="10%">图书定价</th>
                <th width="10%">图书销售价</th>
                <th width="30%">操作</th>
            </tr>
            <c:forEach items="${requestScope.pageBooks}" var="book">
					<tr>
						<td>${book.bookId}</td>
						<td>${book.bookName}</td>
						<td>${book.bookAuthor}</td>
						<td>${book.publisher.pubName}</td>
						<td>${book.bookPrice}</td>
						<td>${book.realPrice}</td>
						<td>
                        <a href="bookList.do?type=5&&bookId=${book.bookId }&&flag=1"><img src="img/read.png" alt="查看" title="查看"/></a>
                        <a href="bookList.do?type=5&&bookId=${book.bookId }&&flag=2"><img src="img/xiugai.png" alt="修改" title="修改"/></a>
                        <a href="bookList.do?type=4&&bookId=${book.bookId }" ><img src="img/schu.png" alt="删除" title="删除"/></a>
                        </td>
					</tr>
			</c:forEach>
        </table>

    </div>

    
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
   <div class="removerChid">
       <h2>提示</h2>
       <div class="removeMain" >
           <p>你确定要删除该图书吗？</p>
           <a href="#" id="yes">确定</a>
           <a href="#" id="no">取消</a>
       </div>
   </div>
</div>


<footer class="footer">
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>

</body>
</html>