<%@page import="model.Todo"%>
<%@page import="java.util.List"%>
<%@page import="serviceimpl.TodoServiceImpl"%>
<%@page import="service.TodoService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script type="text/javascript" src="javascript/source.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToDO List</title>
</head>
<body>
	<p class="float-right" style="margin-right:30px; font-size:20px;">User<br><a href="logoutUser.jsp">Logout</a></p>
	<h2 style="color:blue" class="text-center"><u>Todo List</u></h2>
	<div class="panel-body">
	<form action="status" method="post">
	<table class="table table-responsive table-bordered center" cellspadding="0">
	<tr>
		<th>Title</th>
		<th>Description</th>
		<th>Username</th>
		<th>Target-Date</th>
		<th>Update</th>
		<th>Delete</th>
		<th>Is Done</th>
	</tr>
	
	<%
		TodoService service = new TodoServiceImpl();
		List <Todo> todoList = service.getAllTodos();
		for(Todo todos: todoList){
			int id = todos.getId();
	%>
		<tr> 	
		<td><%=todos.getTitle() %></td>
		<td><%=todos.getDescription() %></td>
		<td><%=todos.getUsername() %></td>
		<td><%=todos.getTargetDate() %></td>
		<td><a href="updateTodo.jsp?id=<%=id%>">Update</a></td> 
		<td><a href="deleteTodo.jsp?id=<%=id%>">Delete</a></td>
	<% 	if(id>=0){ %>
		<td><input type="checkbox" name="isDone" value="true" checked="checked">Status</td>
	<%	}else{ %>
		<td><input type="checkbox" name="isDone" value="false">Status</td>
	<%  } %>
		</tr>
	<%
		}
	%>
	</table><br>
	<%
		TodoService todoService = new TodoServiceImpl();
		List <Todo> list = service.getAllTodos();
		for(Todo todos: list){
			int id = todos.getId();
	%>
		<input type="hidden" name="id" value="<%=id %>">
	<%
		}
	%>
	<input class="btn btn-primary" type="submit" value="Update Todo Status" style="width: 170px; margin-left: 207px">&nbsp
	<button class="btn btn-primary" id ="creatTodoButton" onclick="window.location.href='createTodo.jsp';"  type="button"style="width: 170px; margin-left:30px">Create New Todo</button>
	</form><br>
	<P style="font-size:20px; color:green; margin-left:207px">${message}</p>
	</div>
	<%
			
	%>
</body>
</html>