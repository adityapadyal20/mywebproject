<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Registration page</title>
</head>
<body>
<div class="container align-page">
<h2 style="color:blue"><u>User Registration Page</u></h2>	
	<form action="register" method="post">
	<label class ="form-label">First Name :</label><input type ="text" class="form-control width-control" name="firstname"  placeholder ="Enter firstname" required="required" ><br>
	<label class ="form-label">Last Name:</label><input type ="text" class="form-control width-control" name="lastname" placeholder ="Enter lastname" required="required"><br>
	<label class ="form-label">User Name:</label><input type ="text" class="form-control width-control" name="username"  placeholder ="Enter username" required="required"><br>
	<label class ="form-label">Password:</label><input type ="password" class="form-control width-control" name="password" placeholder ="Enter password" required="required"><br>
	<input type="hidden" name="userRole" value="Student">
	<input type="submit" class="btn btn-primary btn-width" value="Register">&nbsp&nbsp&nbsp&nbsp
	<input type="reset" class="btn btn-secondary btn-width" value="Cancle">
	</form>
	<br>
	<p style="font-size:20px">
	If you already login register please <u><a href="loginUser.jsp">Login here</a></u></p>
</div>
</body>
</html>