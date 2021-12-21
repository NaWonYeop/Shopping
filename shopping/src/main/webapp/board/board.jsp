<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function update()
{
	var p=document.paging;
	p.action="../shopping/updateBoardForm.do";
	p.method="post";
	p.submit();
}
function deletefnc()
{
	var p=document.paging;
	p.action="../shopping/deleteBoard.do";
	p.method="post";
	p.submit();	
	
}
var lu="${loginUser.id}";
var uI="${requestScope.Singleboard.userId}";

</script>
</head>
<body>
	<h1>제목 ${requestScope.Singleboard.boardTitle}</h1>
	<h2>작성자 ${requestScope.Singleboard.userId}</h2>
	<h3>${requestScope.Singleboard.boardContent}</h3>
	<h3>현재로그인 ${sessionScope.loginUser.id}</h3>

	
	<c:if test="${loginUser.id == requestScope.Singleboard.userId}">
			
			<button onclick="update()">수정</button>
			<button onclick="deletefnc()">삭제</button>

	</c:if>
	
	<form name="paging">
		<input type="hidden" name="bId" value="${requestScope.Singleboard.boardId}">
	</form>
			
	<!-- 댓글창 필요 -->
	
	
</body>
</html>