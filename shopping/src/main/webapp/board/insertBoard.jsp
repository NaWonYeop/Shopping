<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<form action="../insertItem.do"  enctype="multipart/form-data"  method="post">
		
		제목: <input type="text" name="iTitle"><br>
		내용:<textarea name="iContent" id="iContent"></textarea><br> 
		<input type="submit" value="저장"> <input type="reset" value="취소">


	</form>
</body>
</html>