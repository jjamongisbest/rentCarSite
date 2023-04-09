<%@page import="board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.controller.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resource/boardList.css">
</head>
<jsp:include page="header"></jsp:include>
<body>
	<%
	BoardDAO dao = BoardDAO.getInstance();
	ArrayList<Board> list = dao.getBoardAll();
	%>

	<section>
		<h2>게시판</h2>
		<table border="1">
			<thead>
				<tr>
					<th>게시글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Board board : list) {
				%>
				<tr>
					<td><%=board.getCode()%></td>
					<td><a href="boardview?code=<%=board.getCode()%>"><%=board.getTitle()%></a></td>
					<td><%=board.getWriter()%></td>
					<td><%=board.getRegisterDate()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		if (session.getAttribute("log") != null) {
		%>
		<div>
		<input type="button" value="글쓰기" onclick="location.href='boardwrite'">
		</div>
		<%
		}
		%>


	</section>

</body>
<jsp:include page="footer"></jsp:include>
</html>