<%@page import="user.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="user.controller.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check User</title>
</head>
<body>

	<%
	UserDAO userDao = UserDAO.getInstance();
	ArrayList<User> list = userDao.getUserAll();
	%>

	<section>
		<h2>회원목록 check</h2>
		<table border="1">
			<thead>
				<tr>
					<th>회원이름</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>가입일자</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (User user : list) {
				%>
				<tr>
					<td><%=user.getName()%></td>
					<td><%=user.getUser_id()%></td>
					<td><%=user.getPassword()%></td>
					<td><%=user.getPhone()%></td>
					<td><%=user.getEmail()%></td>
					<td><%=user.getSign_date()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</section>

</body>
<jsp:include page="footer"></jsp:include>
</html>