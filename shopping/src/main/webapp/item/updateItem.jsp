<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
</script>
</head>
<body>
	<form action="../shopping/updateItem.do" method="post">
		<input type="hidden" name="iId" value="${requestScope.SingleItem.itemId }">
		상품명: <input type="text" name="iTitle" value="${requestScope.SingleItem.itemTitle}"><br>
		상품설명:<textarea name="iContent" id="iContent">${requestScope.SingleItem.itemContent}</textarea><br> 
		상품가격: <input type="number" name="iPrice" value="${requestScope.SingleItem.itemPrice}"><br> 
		<input type="submit" value="저장"> <input type="reset" value="취소">


	</form>
</body>
</html>