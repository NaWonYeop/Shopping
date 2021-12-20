<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/login.jsp</title>
</head>
<body>
	<form action="../login.do" method="post">
		<input type="text" name="id" id="id" placeholder="ID"><br>
		<input type="password" name="passwd" id="passwd" placeholder="PASSWORD"><br>
		<input type="submit" value="Login"><br>
		<button><a href="join.jsp">Join</a></button>
	</form>
</body>
</html>