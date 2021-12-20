<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/join.jsp</title>
</head>
<body>
    <form action="../joinMember.do" method="post">
        <input type="text" name="id" id="id"><br>
        <input type="password" name="passwd" id="passwd"><br>
        <input type="text" name="name" id="name"><br>
        <input type="submit" value="Join"><br>
    </form>
</body>
</html>