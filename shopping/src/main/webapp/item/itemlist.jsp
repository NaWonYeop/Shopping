<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
</head>
<body>
	<table border='1'>
				<thead>
					<tr>
						<th>상품명</th>
						<th>상품설명</th>
						<th>가격</th>
						<th>이미지</th>
					</tr>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${requestScope.itemList }">
						<tr>
							<td>${item.itemId }</td>
							<td>${item.itemTitle }</td>
							<td>${item.itemPrice }</td>
							<td><img alt="" src="image/${item.itemImg }" width="200px" height="200px"> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
</body>
</html>