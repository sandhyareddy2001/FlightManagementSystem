<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1> Register!!</h1>
<div style="width:40%; height:340px; border:medium solid;">
<h2>Passenger Registration!</h2>
<form action="passengerReg">
  	   	<label for="uid">Passenger ID:</label><br>
  		<input type="number" id="pid" name="pid"><br>
  	   	<label for="fname">First name:</label><br>
  		<input type="text" id="fname" name="fname"><br>
  		<label for="lname">Last name :</label><br>
  		<input type="text" id="lname" name="lname"><br>
  		
  		<label for="lname">Address :</label><br>
  		<input type="text" id="addr" name="addr"><br>
  		<label for="lname">Mobile number :</label><br>
  		<input type="text" id="mobnum" name="mobnum"><br>
  		
  		<label for="emailID">Email ID :</label><br>
  		<input type="text" id="emailID" name="emailID"><br>
  		<button>Submit</button>
  		</form>
 </div>
 <br><br><br>
 
<div style="width:40%; height:300px; border:medium solid;">
<h2> Admin Registrations!</h2>
       <form action="adminReg">
  	   	<label for="uid">Admin ID:</label><br>
  		<input type="number" id="uid" name="uid"><br>
  	   	<label for="fname">First name:</label><br>
  		<input type="text" id="fname" name="fname"><br>
  		<label for="lname">Last name :</label><br>
  		<input type="text" id="lname" name="lname"><br>
  		<button>Submit</button>
  		</form>
 </div>

</div>
</body>
</html>