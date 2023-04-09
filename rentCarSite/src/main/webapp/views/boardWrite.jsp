<%@page import="board.controller.BoardDAO"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resource/boardWrite.css">
<jsp:include page="header"></jsp:include>
</head>
<body>

	<%
	BoardDAO dao = BoardDAO.getInstance();
	int code = dao.getMaxCode() + 1;
	String title = request.getParameter("title");
	String main = request.getParameter("main");
	String modifiedDate = request.getParameter("register_date");
	String registerDate = request.getParameter("register_date");
	String writer = request.getParameter("writer");
	%>

	<div class="container">
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="writeboard"> <input
				type="hidden" name="code" value="<%=code%>"> <input
				type="hidden" name="modified_date" value="<%=modifiedDate%>">

			<div class="row">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th>게시글 작성</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td style="width: 20%;">글 제목</td>
							<td colspan="2"><input type="text" id="title" name="title"
								value="<%=title != null ? title : ""%>"
								<%=title == null ? "autofocus" : ""%>></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td colspan="2"><input type="text" id="writer" name="writer"
								value="<%=session.getAttribute("log")%>" readonly></td>
						</tr>
						<tr>
							<td>작성일자</td>
							<td colspan="2"><input type="date" id="registerdate"
								name="register_date"
								value="<%=registerDate != null ? registerDate : new Timestamp(System.currentTimeMillis()).toString().split(" ")[0]%>"
								<%=registerDate == null ? "autofocus" : ""%>></td>
						</tr>
						<tr>
							<td>본문</td>
							<td colspan="2" style="height: 200px; text-align: left;"><textarea
									id="main" name="main" value="<%=main != null ? main : ""%>"
									<%=main == null ? "autofocus" : ""%>></textarea></td>
						</tr>
					</tbody>
				</table>
				<div>
					<input type="button" value="작성" onclick="checkValues(form)">
				</div>
			</div>
		</form>
	</div>
	<script src="../resource/boardWrite.js"></script>
</body>
<jsp:include page="footer"></jsp:include>
</html>