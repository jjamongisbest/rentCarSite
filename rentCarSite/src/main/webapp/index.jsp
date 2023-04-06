<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<link rel="stylesheet" href="../resource/grid.css">
<jsp:include page="header"></jsp:include>
<body>

	<%
	DBManager.getConnection();
	%>

	<div class="imgContainer">
		<img src="..\resource\images\moru1.jpg" width="450" height="450"
			border="0">
		<img src="..\resource\images\moru2.jpg" width="450"
			height="450" border="0">
	</div>




</body>
<jsp:include page="footer"></jsp:include>
</html>
