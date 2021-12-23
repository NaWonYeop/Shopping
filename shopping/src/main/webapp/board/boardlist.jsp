<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<meta name="viewport" content="width=device-width" , inital-scale="1">

<title>JSP 게시판 웹 사이트</title>
<script>
	function move_page(bId) {

		var p = document.paging;
		p.bId.value = bId;
		p.action = "../shopping/viewBoard.do";
		p.method = "post";
		p.submit();
	}
</script>
<style>


table {
	width: 100%;
	height: 80%;
	border: 1px solid black;
	border-collapse: collapse;
}

th {
	border-bottom: 1px solid black;
	border-collapse: collapse;
	background-color: gray;
}

td {
	border-bottom: 1px solid black;
}

a {
	color: black;
	text-decoration: none;
}

div#insert {
	position: absolute;
	top: 90%;
	left: 90%;
}
</style>
</head>
<body>
	<%@ include file="../head.jsp" %>


	<!-- 추가 -->
							<h1>자유 게시판</h1>

	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>

			</tr>

		</thead>
		<tbody>
			<c:forEach var="item" items="${requestScope.BoardList }">
				<tr>
					<td>${item.boardId }</td>
					<td><a href="javascript:move_page(${item.boardId});">${item.boardTitle }</a></td>
					<td>${item.userId }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div id="insert">
		<button onclick="location.href='board/insertBoard.jsp'">등록</button>
	</div>
	<!--이미지 이동시 사용 -->
	<form name="paging">
		<input type="hidden" name="bId">
	</form>


	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>

						</body>
</html>



