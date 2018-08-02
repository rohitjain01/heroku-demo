<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jstl/xml" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<head>
	<title>Leave Management</title>
	<link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<link rel="stylesheet" type="text/css" href="css/signin.css">
</head>
<body>
	<div class="container">
		<form class="form-signin" action="signed" method="post">
			<h2 class="form-signin-heading">Please login</h2>
			<input type="text" class="form-control" name="username"
				placeholder="USERNAME" required="" autofocus="" /> 
			<input type="password" class="form-control" name="password"
				placeholder="PASSWORD" required="" />
			<div class="form-group">
				<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
			</div>
			<div class="form-group">
				<a href="#">Forgot password?</a>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="<c:url value='/js/signin.js'/>"></script>
