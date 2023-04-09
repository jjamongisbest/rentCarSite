<%@page import="board.Board"%>
<%@page import="board.controller.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resource/boardView.css">
</head>
<jsp:include page="header"></jsp:include>
<body>

	<%
	int code = Integer.parseInt(request.getParameter("code"));

	BoardDAO dao = BoardDAO.getInstance();
	Board board = dao.getBoardByCode(code);
	%>

	<div class="container">
		<div class="row">
			<table class="table table-striped"
				style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th>문의사항 글 보기</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">글 제목</td>
						<td colspan="2"><%=board.getTitle()%></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2"><%=board.getWriter()%></td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2"><%=board.getRegisterDate()%></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="height: 200px; text-align: left;"><%=board.getMain()%></td>
					</tr>
				</tbody>
			</table>
			<div>
				<input type="button" value="목록" onclick="location.href='boardlist'">

				<%
				if (session.getAttribute("log") != null && board.getWriter().equals(session.getAttribute("log"))) {
				%>
				<input type="button" value="수정" onclick="location.href='modify'">
				<input type="button" value="삭제" onclick="location.href='../service?command=deleteboard'">
				<%
				}
				%>
			</div>
		</div>
	</div>

</body>
<jsp:include page="footer"></jsp:include>
</html>