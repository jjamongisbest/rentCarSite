<%@page import="vehicle.Vehicle"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vehicle.controller.VehicleDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resource/carList.css">
</head>
<jsp:include page="header"></jsp:include>
<body>

	<%
	VehicleDAO vehicleDao = VehicleDAO.getInstance();
	ArrayList<Vehicle> list = vehicleDao.getCarAll();
	%>

	<section>
		<h2>렌탈 자동차 목록</h2>
		<table border="1">
			<thead>
				<tr>
					<th>이름</th>
					<th>시간 당 가격</th>
					<th>승차 가능 인원</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Vehicle vehicle : list) {
				%>
				<tr>
					<td><a href="carview?carcode=<%=vehicle.getCarCode()%>"><%=vehicle.getCarName()%></a></td>
					<td><%=vehicle.getHourPrice()%></td>
					<td><%=vehicle.getSeat()%></td>
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