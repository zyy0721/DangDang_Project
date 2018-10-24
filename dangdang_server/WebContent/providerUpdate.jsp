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
            <span>图书管理页面 >>图书修改页</span>
        </div>
        <div class="providerAdd">
            <form action="bookList.do",method="post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input type="hidden" name="type" value="6">
                <input type="hidden" name="bookId" id="bookId" value="${requestScope.book.bookId}"  />
                <div class="">
                    <label for="providerId">图示编码：</label>
                    <input type="text" name="bookId" id="bookId" value="${requestScope.book.bookId}" disabled="disabled"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="providerName">书籍名称：</label>
                    <input type="text" name="bookName" id="bookName" value="${requestScope.book.bookName}"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="people">书籍作者：</label>
                    <input type="text" name="bookAuthor" id="bookAuthor" value="${requestScope.book.bookAuthor}"/>
                    <span>*</span>

                </div>
                <div>
                    <label >图书类型：</label>
                    <select name="bookType" >
                        <option value="0">--请选择相应的类型--</option>
                        <option value="1" ${requestScope.book.bookType.typeId==1?'selected':"" }>历史</option>
                        <option value="2" ${requestScope.book.bookType.typeId==2?'selected':"" }>青春</option>
                        <option value="3" ${requestScope.book.bookType.typeId==3?'selected':"" }>小说</option>
                        <option value="4" ${requestScope.book.bookType.typeId==4?'selected':"" }>经济</option>
                    </select>
                    <span>*</span>
                </div>
                <div>
                    <label >图书出版社：</label>
                    <select name="publisherId" >
                        <option value="0">--请选择相应的出版社--</option>
                        <option value="1" ${requestScope.book.publisher.pubId==1?'selected':"" }>中信出版社</option>
                        <option value="2" ${requestScope.book.publisher.pubId==2?'selected':"" }>三联书店</option>
                        <option value="3" ${requestScope.book.publisher.pubId==3?'selected':"" }>中国海关出版社</option>
                        <option value="4" ${requestScope.book.publisher.pubId==4?'selected':"" }>上海译文出版社</option>
                        <option value="5" ${requestScope.book.publisher.pubId==5?'selected':"" }>译林出版社</option>
                        <option value="6" ${requestScope.book.publisher.pubId==6?'selected':"" }>湖南文艺出版社</option>
                        <option value="7" ${requestScope.book.publisher.pubId==7?'selected':"" }>长江文艺出版社</option>
                        <option value="8" ${requestScope.book.publisher.pubId==8?'selected':"" }>南海出版公司</option>
                        <option value="9" ${requestScope.book.publisher.pubId==9?'selected':"" }>人民文学出版社</option>
                        <option value="10" ${requestScope.book.publisher.pubId==10?'selected':"" }>人民出版社</option>
                    </select>
                    <span>*</span>
                </div>
                <div>
                    <label for="fax">图书定价：</label>
                    <input type="text" name="bookPrice" id="bookPrice" value="${requestScope.book.bookPrice}"/>
                    <span>*</span>

                </div>
                <div>
                    <label for="describe">图书销售价：</label>
                    <input type="text" name="realPrice" id="realPrice" value="${requestScope.book.realPrice}"/>
                    <span></span>

                </div>
                <div>
                    <label for="fax">图书简介：</label>
                    <input type="text" name="bookContent" id="bookContent" value="${requestScope.book.bookContent}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="fax">图书图片地址：</label>
                    <input type="text" name="bookImage" id="bookImage" value="${requestScope.book.bookImage}"/>
                    <span>*</span>
                </div>
                <div>
                    <label for="fax">图书积分：：</label>
                    <input type="text" name="bookScore" id="bookScore" value="${requestScope.book.bookScore}"/>
                    <span>*</span>
                </div>
                
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="providerList.jsp">返回</a>-->
                    <input type="submit" value="保存" onclick="history.back(-1)"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>
<script src="js/time.js"></script>

</body>
</html>