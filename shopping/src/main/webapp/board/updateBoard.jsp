<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>게시판 수정</title>
<style>
* {
	text-align: center;
}

input[type="text"] {
	margin-top: 5%;
	margin-left: 5%;
	width: 80%;
	text-align: left;
	height: 50px;
	font-size: 100%;
}

textarea {
	margin-top: 5%;
	margin-left: 5%;
	width: 80%;
	resize: none;
	text-align: left;
	height: 500px;
	font-size: 20px;
}

input[type="submit"] {
	margin-top: 5%;
	margin-left: 3%;
	width: 150px;
}

input[type="reset"] {
	margin-top: 5%;
	margin-left: 3%;
	width: 150px;
}
</style>
</head>
<body>
	<%@ include file="../head.jsp"%>
	<form action="updateBoard.do" method="post">
		<h1>게시판수정</h1>
		<input type="hidden" name="bId"
			value="${requestScope.SingleBoard.boardId}"> <input
			type="text" name="bTitle"
			value="${requestScope.SingleBoard.boardTitle }"><br>
		<textarea name="bContent" id="bContent">${requestScope.SingleBoard.boardContent }</textarea>
		<br> <input type="submit" value="저장"> <input type="reset"
			value="취소">


	</form>
</body>
</html>