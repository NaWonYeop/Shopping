<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품명: ${requestScope.SingleItem.itemTitle}</h2>
	<h1>상품 설명:${requestScope.SingleItem.itemContent} </h1>
	<h1>상품 가격:${requestScope.SingleItem.itemPrice} </h1>
	<img alt="상품 이미지" src="image/${requestScope.SingleItem.itemImg }" width="200px" height="200px">
	
</body>
</html>