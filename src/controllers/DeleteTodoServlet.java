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

@WebServlet("/deleteTodo")
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html");
		
		Todo todo = new  Todo();
		todo.setId(id);
		
		TodoService todoService = new TodoServiceImpl();
		while(todoService.deleteTodo(id)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("allTodos.jsp");
			dispatcher.forward(request, response);
			response.getWriter().print("Deleted Succesfully.");
		}
	}
}
