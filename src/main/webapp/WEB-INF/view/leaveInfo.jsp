<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %><!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8"> 
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width = device-width, initial-scale = 1">
<title>Leave Management System</title>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>

<body>
    <div class="jumbotron">
        <h1>Leave Management System</h1>  
    </div>
    
      <button type="button" class="btn btn-danger" style="float: right">Logout</button>
      <button type="button" class="btn btn-success" style="float: right"></button>
      <button type="button" class="btn btn-primary" style="float: right">User Management</button>
<table class="table table-bordered ">
    <thead>
        <th  colspan="6">Leave Information</th>
    </thead>
  <thead class="thead-dark">
    <tr>
      <th scope="col">S.no</th>
      <th scope="col">Employee id</th>
      <th scope="col">From</th>
      <th scope="col">To</th>
      <th scope="col">Message</th>
      <th scope="col"> </th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>2</td>
      <td>18-01-2018</td>
      <td>23-01-2018</td>
      <td>brother's marriage</td>
      <td>
        <div class="container"> 
        <button type="button" class="btn btn-primary">Approve</button>
  <button type="button" class="btn btn-md btn-danger " data-toggle="modal" data-target="#myModal" >Decline</button>
 <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <form action=#>
            <div class="form-group">
                <label for="decline reason"><h4>Decline Reason:</h4></label>
            <textarea class="form-control" rows="5" id="comment" name="text"></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Submit</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </form>
      </div>
    </div>
  </div>
</div>
      </td>
    </tr>
  </tbody>
</table>
</body>