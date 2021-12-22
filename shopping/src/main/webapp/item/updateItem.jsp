<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	text-align: center;
}
table{
width: 100%;
height: 500px;
}
table>tr{
height: 50px;
}
textarea{
width: 100%;
    height: 100%;
	font-size: 25px;
    resize: none;
}
input{
height: 30%;
width: 200px;
}
input[type="text"],input[type="number"]{
font-size:100%;}
div#insert{
margin-top:30px;
}
</style>
</head>
<body>
	<form action="../shopping/updateItem.do" method="post">
		<input type="hidden" name="iId" value="${requestScope.SingleItem.itemId }">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="iTitle" value="${requestScope.SingleItem.itemTitle }"></td>
			</tr>

			<tr>
				<td>상품가격</td>
				<td><input type="number" name="iPrice"  value="${requestScope.SingleItem.itemPrice }"></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><textarea name="iContent" id="iContent">${requestScope.SingleItem.itemContent }</textarea></td>
			</tr>
			</table>
			
	<div id="insert">
		<input type="submit" value="저장"> <input type="reset"
			value="취소">
	</div>
	</form>
</body>
</html>