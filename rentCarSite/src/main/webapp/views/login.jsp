<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resource/login.css">
<title>Insert title here</title>
</head>
<jsp:include page="header"></jsp:include>
<body>

	<form action="../service" method="POST">
		<input type="hidden" name="command" value="login">
		<h2>로그인</h2>
		<label for="id">아이디:</label> <input type="text" id="id" name="id">
		<label for="password">비밀번호:</label> <input type="text" id="password"
			name="password"> <input type="submit" value="로그인"
			onclick="checkValues(form)">
		<%
		if (request.getAttribute("message") != null) {
		%>
		<p>${message}</p>
		<%
		}
		%>
	</form>

	<script src="../resource/loginOk.js"></script>
</body>
</html>