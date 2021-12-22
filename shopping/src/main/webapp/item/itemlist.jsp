
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 리스트</title>
<style>* {
	text-align: center;
}
div#list{

display: inline-block;
margin: 20px 0px 10px 30px;
}
div#list>button{
width: 25%;
}
div#insert>button{
width: 80px;
}
div#insert
{
position: absolute;
top: 90%;
left: 90%;
}</style>
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
	p.action="../shopping/updateItemForm.do";
	p.method="post";
	p.submit();
}
function deletefnc(iId)
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
	<h1>상품 리스트</h1>


	<c:forEach var="item" items="${requestScope.itemList }">
	<div id="list">
		<a href="javascript:move_page(${item.itemId});"><img
			alt="상품 이미지" src="image/${item.itemImg }" width="250px"
			height="250px"></a><br>
					
						${item.itemTitle }<br>
						${item.itemPrice }원<br>
						
		<c:if test="${sessionScope.loginUser.id eq 'admin'}">
			<button onclick="update(${item.itemId})">수정</button>
			<button onclick="deletefnc(${item.itemId})">삭제</button>
		</c:if>
	</div>
	</c:forEach>
	

	<c:if test="${sessionScope.loginUser.id eq 'admin'}">
	<div id="insert">
		<button onclick="location.href='item/insertItem.jsp'">등록</button>
	</div>
	</c:if>
	<!--이미지 이동시 사용 -->
	<form name="paging">
		<input type="hidden" name="iId">
	</form>
</body>
</html>