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

<% DBManager.getConnection(); %>
<jsp:include page="check"></jsp:include> 



</body>
<jsp:include page="footer"></jsp:include>
</html> 