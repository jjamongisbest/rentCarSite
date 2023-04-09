<%@page import="vehicle.Vehicle"%>
<%@page import="vehicle.controller.VehicleDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car View</title>
<link rel="stylesheet" href="../resource/carView.css">
</head>
<jsp:include page="header"></jsp:include>
<body>
	<%
	// URL 매개변수로 전달된 carcode 값을 가져옴
	int carCode = Integer.parseInt(request.getParameter("carcode"));

	// VehicleDAO를 사용하여 차량 정보를 조회
	VehicleDAO vehicleDao = VehicleDAO.getInstance();
	Vehicle vehicle = vehicleDao.getCarByCode(carCode);
	%>

	<section>
		<h2><%=vehicle.getCarName()%></h2>
		<div class="car-info">
			<div class="image">
				<img src="../resource/<%=vehicle.getImage()%>">
			</div>
			<div class="details">
				<p>
					시간 당 가격:
					<%=vehicle.getHourPrice()%>원
				</p>
				<p>
					승차 가능 인원:
					<%=vehicle.getSeat()%>명
				</p>
			</div>
		</div>
		<div>
			<input type="button" value="뒤로가기" onclick="location.href='carlist'">
			<%
			if (session.getAttribute("log") != null) {
			%>
			<input type="button" value="예약하기"
				onclick="location.href='selectcarbook'">
			<%
			} else {
			%>
			<input type="button" value="로그인 후 예약하기"
				onclick="location.href='login'">
			<%
			}
			%>
		</div>



	</section>


</body>
<jsp:include page="footer"></jsp:include>
</html>
