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
<c:forEach items ="${users}" var="u">
<tr>

	<td> ${u.uid}</td>
	<td> ${u.first_name}</td>
	<td> ${u.last_name}</td>
	<td> ${u.role}</td>
</tr>
</c:forEach>
</table>


</div>
</body>
</html>