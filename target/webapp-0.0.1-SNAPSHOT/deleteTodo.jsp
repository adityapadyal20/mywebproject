<%@page import="model.Todo"%>
<%@page import="java.util.List"%>
<%@page import="serviceimpl.TodoServiceImpl"%>
<%@page import="service.TodoService"%>
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
<link rel="stylesheet" type="text/css" href="css/style.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container align-page">
	<h2 style="color:blue"><u>Delete Todo</u></h2>
	<form action="deleteTodo" method="post">
	<%
		int id = Integer.parseInt(request.getParameter("id"));
		TodoService todoService = new TodoServiceImpl();
		List<Todo> TodoList = todoService.getselectedTodo(id);
		for(Todo todo:TodoList){
	%>
	<input type="hidden" name="id" value="<%=id %>">
	<label class ="form-label">Title :</label><input type ="text" class="form-control width-control" name="title"  placeholder ="Enter title" value = "<%=todo.getTitle()%>" required="required" readonly><br>
	<label class ="form-label">Description :</label><textarea class="form-control width-control" name="description" placeholder ="Enter description" value = "<%=todo.getDescription() %>" required="required" readonly></textarea><br>
	<label class ="form-label">Username :</label><input type ="text" class="form-control width-control" name="username"  placeholder ="Enter username" value = "<%=todo.getUsername() %>" required="required" readonly><br>
	<label class ="form-label">target_date :</label><input type ="text" class="form-control width-control" name="targetDate" placeholder ="Enter date" value = "<%=todo.getTargetDate()%>" required="required" readonly><br>
	<%
		}
	%>
	<input class ="btn btn-danger btn-width" type="submit" value="Delete" >&nbsp&nbsp&nbsp&nbsp
	<input class ="btn btn-secondary btn-width" onclick='goBack()' type="button" value="Back">
	</form>
	</div>
</body>
</html>