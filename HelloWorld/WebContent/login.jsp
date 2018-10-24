<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=UTF-8">
<title>登录</title>
</head>
<body>
	<div>
		<form action="user.do" method="post">
			<p>姓名：<input type="text" name="uname" id="uname"/></p>
			<p>密码：<input type="password" name="upwd" id="upwd"/></p>
			<p><input type="submit" value="提交"/></p>
			<p><input type="reset" value="重置"/></p>
		</form>
	</div>
</body>
</html>