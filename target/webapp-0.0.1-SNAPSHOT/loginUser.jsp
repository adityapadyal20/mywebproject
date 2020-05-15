<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Login page</title>
</head>
<body>
<div class="container align-center">
<h2 style="color:blue"><u>User Login Page</u></h2>
	<form action="login" method="post">
	<label class ="form-label">Username :</label><input type ="text" name="username"  class ="form-control width-control" placeholder ="Enter username" required="required" style="width:50%"><br><br>
	<label class ="form-label">Password :</label><input type ="password" name="password" class ="form-control width-control" placeholder ="Enter password" required="required" style="width:50%"><br><br>
	<input type="submit" class="btn btn-primary btn-width" value="Login">&nbsp&nbsp&nbsp&nbsp
	<input type="reset" class="btn btn-secondary btn-width" value="Cancle">
	</form>
	<br>
	<p style="font-size:20px">
	If you don,t register please <u><a href="registerUser.jsp">Register here</a></u></p>
	<P style="font-size:20px; color:green; margin-left:207px">${message}</p>
</div>
</body>
</html>