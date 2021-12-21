<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<form action="../insertBoard.do" method="post">
		
		제목: <input type="text" name="board_title"><br>
		내용:<textarea name="board_content" id="board_content"></textarea><br> 
		<input type="submit" value="저장"> <input type="reset" value="취소">


	</form>
</body>
</html>