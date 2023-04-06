<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<header>
		<h1>이건어떨 CAR?</h1>
	</header>
	<nav>
		<ul>
			<li><a href="regist">회원가입</a></li>
			<%
			if (session.getAttribute("log") != null) {
			%>
			<li><a href='../service?command=logout'>logout</a></li>
			<%
			} else {
			%>
			<li><a href="login">로그인</a></li>
			<%
			}
			%>
			<li><a href="list">렌트 차량 목록 확인</a></li>
			<li><a href="book">예약시스템</a></li>
			<li><a href="/">홈으로</a></li>
			<%if (session.getAttribute("log") != null) { %>
			<li class="logId"><a href="mypage"> <%=session.getAttribute("log") %></a> </li>
			<%} %>
		</ul>
	</nav>

</body>
</html>