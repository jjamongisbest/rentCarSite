<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resource/regist.css">
</head>
<jsp:include page="header"></jsp:include>
<body>

	<!-- user_id, name, phone, password, sign_date, email -->
	<%
	String userid = request.getParameter("user_id");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String password = request.getParameter("password");
	String signdate = request.getParameter("sign_date");
	String email = request.getParameter("email");
	%>

	<section>
		<h2>회원가입</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="regist">
			<table border="1">
				<tr>
					<th>성명</th>
					<td><input type="text" id="name" name="name"
						value="<%=name != null ? name : ""%>"
						<%=name == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" id="userid" name="user_id"
						value="<%=userid != null ? userid : ""%>"
						<%=userid == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" id="password" name="password"
						value="<%=password != null ? password : ""%>"
						<%=password == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>휴대전화</th>
					<td><input type="text" id="phone" name="phone"
						value="<%=phone != null ? phone : ""%>"
						<%=phone == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" id="email" name="email"
						value="<%=email != null ? email : ""%>"
						<%=email == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="date" id="signdate" name="sign_date"
						value="<%=signdate != null ? signdate : new Timestamp(System.currentTimeMillis()).toString().split(" ")[0]%>"
						<%=signdate == null ? "autofocus" : ""%>></td>
				</tr>
			</table>
			<div>
				<input type="button" value="회원가입" onclick="checkValues(form)">
			</div>
		</form>
	</section>
	<script src="../resource/validation.js"></script>
</body>
<jsp:include page="footer"></jsp:include>
</html>