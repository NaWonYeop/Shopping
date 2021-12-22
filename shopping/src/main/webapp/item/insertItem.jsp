<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
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

    resize: none;
}
input{
height: 30%;
width: 200px;
}
div#insert{
margin-top:30px;
}
</style>
</head>
<body>
	<h1>상품 등록</h1>
	<form action="../insertItem.do" enctype="multipart/form-data"
		method="post">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="iTitle"></td>
			</tr>

			<tr>
				<td>상품가격</td>
				<td><input type="number" name="iPrice"></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td><textarea name="iContent" id="iContent"></textarea></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="iImg"></td>
			</tr>
		</table>


	<div id="insert">
		<input type="submit" value="저장"> <input type="reset"
			value="취소">
	</div>

	</form>
</body>
</html>