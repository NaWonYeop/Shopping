<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/userUpdate.jsp</title>
</head>
<body>
	<form action="../updateMember.do" method="post">
		id:<input type="text" name="id" id="id" value="${loginUser.id}" ><br>
		pw:<input type="text" name="passwd" id="passwd" value="${loginUser.passwd}"><br>
		name:<input type="text" name="name" id="name" value="${loginUser.name}"><br>
		<input type="submit" value="Update"><br>
	</form>
</body>
</html>