<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Job Done</h1>

<table border=1>
<c:forEach items ="${flightDetails}" var="u">
<tr>
	<td> ${u.flight_id}</td>
	<td> ${u.airline_id}</td>
	<td> ${u.airline_name}</td>
	<td> ${u.from_location}</td>
	<td> ${u.to_location}</td>
	<td> ${u.departure_time}</td>
	<td> ${u.arrival_time}</td>
	<td> ${u.duration}</td>
	<td> ${u.total_seats}</td>
</tr>
</c:forEach>
</table>


</div>


</body>
</html>