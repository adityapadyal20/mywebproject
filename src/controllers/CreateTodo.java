package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Todo;
import service.TodoService;
import serviceimpl.TodoServiceImpl;
@WebServlet("/createTodo")
public class CreateTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String targetDate =request.getParameter("target_date");
		String username = request.getParameter("username");
		
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setDescription(description);
		todo.setTargetDate(targetDate);
		todo.setUsername(username);
		
		TodoService service = new TodoServiceImpl();
		
		if(service.createTodo(todo)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("allTodos.jsp");
			requestDispatcher.forward(request, response);
			response.getWriter().print("Added sucessfull!");
		}
		else {
			response.getWriter().print("Not added sucessfully! Please retry again");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("createTodo.jsp");
			requestDispatcher.include(request, response);
		}
	}

}
