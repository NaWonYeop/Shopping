<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
</script>
<title>자유 게시판</title>
</head>
<body>
		<table border='1'>
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
		
			<button onclick="location.href='board/insertBoard.jsp'">등록</button>

			<!--이미지 이동시 사용 -->
			<form name="paging">
			<input type="hidden" name="bId">
			</form>
</body>
</html>