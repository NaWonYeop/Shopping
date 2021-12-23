<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/custom.css">
<title>게시글 작성</title>
<style>
* {
	text-align: center;
}

input[type="text"] {
	margin-top: 5%;
	margin-left: 5%;
	width: 80%;
	text-align: left;
	height: 50px;
	font-size: 100%;
}

textarea {
	margin-top: 5%;
	margin-left: 5%;
	width: 80%;
	resize: none;
	text-align: left;
	height: 500px;
	font-size: 20px;
}

input[type="submit"] {
	margin-top: 5%;
	margin-left: 3%;
	width: 150px;
}

input[type="reset"] {
	margin-top: 5%;
	margin-left: 3%;
	width: 150px;
}
</style>
</head>
<body>
	<%
	String userID = null;
	if (session.getAttribute("loginUser") != null) {
		userID = (String) session.getAttribute("user_id");
	}
	%>
	<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="main.jsp">JSP 게시판 웹 사이트</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs=example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="../main.jsp">메인</a></li>
				<li><a href="../ItemList.do">상품게시판</a></li>
				<li><a href="../BoardList.do">게시판</a></li>
			</ul>
			<%
			if (userID == null) {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="member/login.jsp">로그인</a>
						<li><a href="member/join.jsp">회원가입</a>
					</ul></li>
			</ul>
			<%
			} else {
			%>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">회원관리<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="member/logoutAction.jsp">로그아웃</a>
					</ul></li>
			</ul>
			<%
			}
			%>
		</div>
	</nav>
	<form action="../insertBoard.do" method="post">
		<h1>게시판등록</h1>
		<input type="text" name="board_title" placeholder="제목"><br>
		<textarea name="board_content" id="board_content" placeholder="내용"></textarea>
		<br> <input type="submit" value="저장"> <input type="reset"
			value="취소">


	</form>
</body>
</html>