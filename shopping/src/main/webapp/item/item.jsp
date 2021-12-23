<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>상품 정보</title>
<style>
*{
text-align: center;
}
div#img{

float: left;
margin: 20px 0px 10px 10%;
width: 40%;
height: 70%;

}
div#con{
float: left;
margin: 20px 0px 10px 30px;
width: 40%;
height: 70%;
}
table{
  width: 100%;
  height: 200px;
}
td#con{
text-align: left;
font-size: 20px;
}
div#home{
position: absolute;
left: 90%;
top: 90%
}

</style>
</head>
<body>
	<%@ include file="../head.jsp"%>
	<h1>상품 단건 페이지</h1>
	<div id="img">
		<img alt="상품 이미지" src="image/${requestScope.SingleItem.itemImg }" width="100%" height="100%">
	</div>
	
	<div id="con">
		<table>
		<tr>
			<td>상품명</td>
			<td>${requestScope.SingleItem.itemTitle}</td>	
		</tr>
		<tr>
			<td>상품 가격</td>
			<td>${requestScope.SingleItem.itemPrice} 원</td>
		</tr>
		<tr>
			<td colspan="2" id="con">${requestScope.SingleItem.itemContent}</td>
		</tr>
		</table>	
	</div>
	
	<div id="home">
	<form action="../shopping/ItemList.do" method="post">
	<input type="submit" value="목록으로">
	</form>
	</div>
</body>
</html>