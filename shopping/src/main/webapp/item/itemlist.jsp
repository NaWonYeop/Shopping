<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보</title>
<script>
function move_page(iId)
{
	
	var p=document.paging;
	p.iId.value=iId;
	p.action="../shopping/viewItem.do";
	p.method="post";
	p.submit();
}
function update(iId)
{
	var p=document.paging;
	p.iId.value=iId;
	p.action="../shopping/updateItem.do";
	p.method="post";
	p.submit();
}
function delete(iId)
{
	var p=document.paging;
	p.iId.value=iId;
	p.action="../shopping/deleteItem.do";
	p.method="post";
	p.submit();	
	
}
</script>
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
					
				</thead>
				<tbody>
					<c:forEach var="item" items="${requestScope.itemList }">
						<tr>
							<td>${item.itemId }</td>
							<td>${item.itemTitle }</td>
							<td>${item.itemPrice }</td>
							<td><a href="javascript:move_page(${item.itemId});"><img alt="상품 이미지" src="image/${item.itemImg }" width="200px" height="200px"></a> </td>
							<c:if test="${sessionScope.loginUser eq 'admin'}">
								<td>
									<button onclick="update(${item.itemId})">수정</button>
									<button onclick="delete(${item.itemId}))">삭제</button>
								</td>
							</c:if>				
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<form name="paging">
			<input type="hidden" name="iId">
			</form>
</body>
</html>