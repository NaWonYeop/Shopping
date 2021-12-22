<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<script>
	function update() {
		var p = document.paging;
		p.action = "../shopping/updateBoardForm.do";
		p.method = "post";
		p.submit();
	}
	function deletefnc() {
		var p = document.paging;
		p.action = "../shopping/deleteBoard.do";
		p.method = "post";
		p.submit();

	}
</script>
<style>
* {
	text-align: center;
}

table {
	width: 80%;
	height: 200px;
	margin-left: 7%;
	border-collapse : collapse;
}
tr#title,tr#user{
	border-bottom: 1px solid black;
}
td#con {
	text-align: left;
	font-size: 25px;
}

button {
	width: 100px;
	margin-left: 50px;
}

div#home {
	position: absolute;
	left: 90%;
	top: 90%
}
</style>

</head>
<body>
	<div id="body">
		<h1>게시판</h1>
		<table>
			<thead>
				<tr id="title">
					<td>제목</td>
					<td>${requestScope.Singleboard.boardTitle}</td>
				</tr>
				<tr id="user">
					<td>작성자</td>
					<td>${requestScope.Singleboard.userId}</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="2" id="con">${requestScope.Singleboard.boardContent}</td>
				</tr>
			</tbody>

		</table>

		<c:if test="${loginUser.id == requestScope.Singleboard.userId}">

			<button onclick="update()">수정</button>
			<button onclick="deletefnc()">삭제</button>

		</c:if>

		<form name="paging">
			<input type="hidden" name="bId"
				value="${requestScope.Singleboard.boardId}">
		</form>
	</div>


	<div id="com">
		<!-- 댓글창 필요 -->
	</div>
	<div id="home">
		<form action="../shopping/BoardList.do" method="post">
			<input type="submit" value="목록으로">
		</form>
	</div>
</body>
</html>