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
<style type="text/css">
<!--
-->
</style>
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
                <li ><a href="bookList.do?type=1">图书管理</a></li>
                <li id="active"><a href="user.do?type=2">用户管理</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
<section class="publicInfo">
    <span id="info">提示信息一</span>
</section>
        
        
        
        <div class="providerAdd">
            <form action="user.do",method = "post">
                <!--div的class 为error是验证错误，ok是验证成功-->
                <input type="hidden" name="type" value="6">
                <input type="hidden" name="userId" id="userId" value="${requestScope.user.userId}"  />
                <div>
                    <label for="userName">用户ID：</label>
                    <input type="text" name="userId" id="userId" value="${requestScope.user.userId}" disabled="disabled"  />
                    <span >*</span>
                </div>
                
                <div>
                    <label for="userName">用户名称：</label>
                    <input type="text" name="userName" id="userName" value="${requestScope.user.userName}"/>
                    <span >*</span>
                </div>

 
                <div>
                    <label for="data">用户密码：</label>
                    <input type="text" name="userPwd" id="userPwd" value="${requestScope.user.userPwd}"/>
                    <span >*</span>
                </div>

                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.jsp">返回</a>-->
                    <input type="submit" value="保存" onClick="history.back(-1)"/>
                    <input type="button" value="返回" onClick="history.back(-1)"/>
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