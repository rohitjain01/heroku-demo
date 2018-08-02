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
<link rel="stylesheet" type="text/css" href="css/UserManagement.css">
</head>
    
<body>
<div class="jumbotron">
  <h1 style="align-content: center">Leave Management System</h1>  
</div>
    
<div class="container"> 
  <button type="button" class="btn btn-info btn-lg float-right" data-toggle="modal" data-target="#myModal" >Add Employee</button>
 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
            <h4 class="modal-title">Employee Details</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
            <form>
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
            </div>
            <div class="form-group">
                <label for="contact no">Contact no:</label>
                <input type="text" class="form-control" id="contactno" placeholder="Enter Contact no." name="contact no">
            </div>
    
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" class="form-control" id="address" placeholder="Enter Address" name="address">
            </div>
    
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
            </div>
            <div class="form-group">
                <label for="pwd">Password:</label>
                <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
            </div>    
            <div class="form-group">
                <label for="pwd">Confirm Password:</label>
                <input type="password" class="form-control" id="confirmpwd" placeholder="Enter password" name="confirm pwd">
            </div>    
        
            <div class="form-group">
                <label for="active">Active:</label>
                <input type="text" class="form-control" id="active" placeholder="Enter Status of employee" name="active">
            </div>    
            </form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-default">Submit</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
     </div>
      
    </div>
  </div>
</div>

</html>
    
    <div id="employee-table">
    <table class="table table-bordered" >
        <thead>
            <th  colspan="7">User Management System</th>
        </thead>
      <thead class="thead-dark">
          <tr class="table-primary">
                <th scope="col" width=5%><center>S.no</center></th>
                <th scope="col" width=18%><center>Name </center></th>
                <th scope="col"><center>Email</center></th> 
                <th scope="col" width=14%><center>Contact No.</center></th>
                <th scope="col"><center>Address</center></th>
                <th scope="col" width=8%><center>Active</center></th>
                <th scope="col" width=8%><center>  </center></th>
          </tr>
     </thead>
    <tbody>
            <tr class="table-secondary">
            <th scope="row">1</td>
            <td>Suresh</td>
            <td>s@g.c</td>
            <td>894584430598</td>
            <td>adfehaf</td>
            <td>Yes</td>
            <td><button type="button" class="btn btn-primary">Edit</button></td>    
          </tr>
            <tr class="table-success">
            <th scope="row">1</td>
            <td>Suresh</td>
            <td>s@g.c</td>
            <td>894584430598</td>
            <td>adfehaf</td>
             <td>Yes</td>
            <td><button type="button" class="btn btn-primary">Edit</button></td>
            </tr>
    </tbody>     
        </table>
    </div>
</body> 