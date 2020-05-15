<%@page import="model.User"%>
<%@page import="java.util.List"%>
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
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of All Users</title>
</head>
<body>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p class="float-right" style="margin-right:30px; font-size:20px;">User<br><a href="logoutUser.jsp">Logout</a></p>
	<h2 style="color:blue" class="text-center"><u>Users List</u></h2>	
	<div class="panel-body">
	<table class="table table-responsive table-bordered center" style="width:100%">
	<colgroup>
     <col span="10" style="width:10%">
  	</colgroup>
	<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Username</th>
		<th>Password</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
	
	<%
		UserService userService = new UserServiceImpl();
		List <User> userList = userService.getAllUsers();
		for(User users: userList){
		int id = users.getId();
	%>
		<tr> 	
		<td><%=users.getFirstName() %></td>
		<td><%=users.getLastName() %></td>
		<td><%=users.getUsername() %></td>
		<td><%=users.getPassword() %></td>
		<td><a href="updateUser.jsp?id=<%=id%>">Update</a></td>  
		<td><a href="deleteUser.jsp">Delete</a></td>
		</tr>
	<%
		}
	%>
	</table><br>
	<P style="font-size:20px; color:green; margin-left:207px">${message}</p>
	</div>	
</body>
</html>	