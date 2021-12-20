<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="shopping/updateBoard.do" method="post">
		<input type="hidden" name="bId" value="${requestScope.Singleboard.boardId">
		제목: <input type="text" name="bTitle" value="${requestScope.Singleboard.boardTitle "><br>
		내용:<textarea name="iContent" id="bContent">${requestScope.Singleboard.boardContent </textarea><br> 
		<input type="submit" value="저장"> <input type="reset" value="취소">


	</form>
</body>
</html>