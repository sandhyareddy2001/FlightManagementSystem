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
<form action="delPass">    
<label for="key">Delete Passenger By : </label><br>
    <input type="text" id="key" name="key"><br>
  	  <select name ="Keyword">
  	  
      	<option value = "pid" selected>Passenger ID</option>
        <option value = "first_name">First Name</option>
        <option value = "last_name">Last Name</option>
        
        <option value = "address">Address</option>
        <option value = "mobile_number">Mobile Number</option>
        <option value = "email_id">Email ID</option>
       </select>
            
       <button>Delete</button>
         </form>

</div>


</body>
</html>