<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页面</title>
</head>
<body>
	<c:out value="欢迎${sessionScope.uname }登录"></c:out>
	<div>
		<table>
			<tr>
				<td>用户编号</td>
				<td>用户姓名</td>
				<td>用户密码</td>
				<td>用户性别</td>
				<td>用户年龄</td>
				<td>用户地址</td>
			</tr>
			<c:forEach items="${requestScope.infos }" var="user">
			<tr>
				<td>${user.userId}</td>
				<td>${user.userName }</td>
				<td>${user.userPwd }</td>
				<td>${user.userGender }</td>
				<td>${user.userAge }</td>
				<td>${user.address }</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>