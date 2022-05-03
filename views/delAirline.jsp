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
<h1>Modify Airlines</h1>
<form action="delStuff">    
<label for="key">Delete By : </label><br>
    <input type="text" id="key" name="key"><br>
  	  <select name ="Keyword">
  	  
      	<option value = "flight_id" selected>Flight ID</option>
        <option value = "airline_id">Airline ID</option>
        <option value = "airline_name">Airline Name</option>
        
        <option value = "from_location">From Location</option>
        <option value = "to_location">To Location</option>
        <option value = "departure_time">Departure Time</option>
        <option value = "arrival_time">Arrival Time</option>
        <option value = "duration">Duration</option>
        <option value = "total_seats">Total Seats</option>
        
       </select>
            
       <button>Delete</button>
         </form>

</div>

</body>
</html>