<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
</head>
<body>
	<form action="../insertItem.do"  enctype="multipart/form-data"  method="post">
		
		상품명: <input type="text" name="iTitle"><br>
		상품설명:<textarea name="iContent" id="iContent"></textarea><br> 
		상품가격: <input type="number" name="iPrice"><br> 
		이미지: <input type="file" name="iImg"><br> 
		<input type="submit" value="저장"> <input type="reset" value="취소">


	</form>
</body>
</html>