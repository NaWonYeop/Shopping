<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main.jsp</title>
</head>
<body>
	<div id="content">
	
	</div>


	
	<script>
	var content = document.getElementById('content');
	getAjax();

	function getAjax() {
		var xhtp = new XMLHttpRequest();
		xhtp.open("get", "getComment.do");
		xhtp.send();
		xhtp.onload = function(){
			console.log(xhtp.responseText);
			var data = JSON.parse(xhtp.responseText);
			data.forEach(item => {
				console.log(item);
				var li = document.createElement('li');
				
				li.textContent = item.content;
				content.append(li);
			});
		}
	}
	</script>
</body>
</html>