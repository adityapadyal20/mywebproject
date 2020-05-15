<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="serviceimpl.UserServiceImpl"%>
<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script type="text/javascript" src="javascript/source.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Update User</title>
</head>
<body>
<div class="container">
	<h2 style="color:blue"><u>Update User</u></h2>	
	<div class="row">
		<div class="col-lg-12">
		<form action="update" method="post">
		<%
			int id = Integer.parseInt(request.getParameter("id"));
			UserService userService = new UserServiceImpl();
			List<User> users = userService.selectUser(id);
			for (User user:users){
		%>
			<input type="hidden" name="id" value="<%=id %>">
			<label class ="form-label">First Name :</label><input type ="text" class="form-control width-control" name="firstname"  placeholder ="Enter firstname" value = "<%=user.getFirstName() %>" required="required"><br>
			<label class ="form-label">Last Name :</label><input type ="text" class="form-control width-control" name="lastname" placeholder ="Enter lastname" value = "<%=user.getLastName() %>" required="required"><br>
			<label class ="form-label">Username :</label><input type ="text" class="form-control width-control" name="username"  placeholder ="Enter username" value = "<%=user.getUsername() %>" required="required"><br>
			<label class ="form-label">Password :</label><input type ="password" class="form-control width-control" name="password" placeholder ="Enter password" value = "<%=user.getPassword()%>" required="required"><br>
		<%
			}
		%>
		<input class="btn btn-primary btn-width" type="submit" value="Update">&nbsp&nbsp&nbsp&nbsp
		<input class ="btn btn-secondary btn-width" onclick='goBack()' type="button" value="Back">
		</form>
		</div>
	</div>
</div>
</body>
</html>