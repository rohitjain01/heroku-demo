<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8"> 
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Leave Management System</title>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/forgotpassword.css">
</head>
<body>
    <div class="jumbotron">
  <h1>Leave Management System</h1>  
</div>
    
    <div class="container">
	<form action="/action_page.php">
    	<h3>Forgot Password?</h3><br>
    	<p>Enter registered email address,we will send you a mail with password resetting instructions.</p>
  		<div class="form-group">
    	<label for="email">Email address:</label>
   		<input type="email" class="form-control" id="email">
  	</div>
  	<button type="submit" class="btn btn-primary">Submit</button>
    <button type="submit" class="btn btn-secondary float="right">Cancel</button>
</form>
    </div>    
</body>