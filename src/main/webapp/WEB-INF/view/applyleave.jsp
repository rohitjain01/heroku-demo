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
<link rel="stylesheet" type="text/css" href="css/applyleave.css">
</head>

<body>
    <div class="jumbotron">
        <h1>Leave Management System</h1>  
    </div>
      <button type="button" class="btn btn-danger" style="float: right">Logout</button>
      <button type="button" class="btn btn-success" style="float: right">LeaveInfo</button>
      <button type="button" class="btn btn-primary" style="float: right">Apply Leave</button>
    <div class="container">
    <h2>Apply Leave:</h2>
    <hr>
      <form class="form-signin" action="btsendtoor" method="post" enctype="multipart/form-data">
            <div class="form-group">
            Leave Type<sup>*</sup>
	           <select class="form-control" name="project" id="projectName"  required >
							<option value="0">Select Leave Type</option>
							<option value="Sick Leave">Sick Leave</option>
							<option value="Casual Leave">Casual Leave</option>
							<option value="Earned Leave/PL">Earned Leave/PL </option>
							<option value="Maternity Leave">Maternity Leave</option>
                            <option value="Paternity Leave">Paternity Leave</option>
                            <option value="Transfer Leave">Transfer Leave</option>
                            <option value="Other">Other</option>
               </select> 
            </div>
            <div class="form-group">
                <label for="address">Message:</label>
                <input type="text" class="form-control" id="message" placeholder="Enter Message" name="message">
            </div>
            <div class="form-group">
                <label for="from">From:</label>
                <input type="date" class="form-control" id="from" placeholder="Enter Starting date" name="fdate">
            </div>
            <div class="form-group">
                <label for="tdate">To:</label>
                <input type="date" class="form-control" id="to" placeholder="Enter ending date" name="tdate">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
        </form>    
    </div>    
</body>