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


@WebServlet("/updateTodo")
public class UpdateTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String username = request.getParameter("username");
		String targetDate = request.getParameter("targetDate");
		int id = Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html");
		
		String [] date = targetDate.split(" ");
		for(int i=0;i<date.length;i++) {
			if(date.length>0) {
				targetDate = date[0];
			}
		}
		
		Todo todo = new Todo();
		todo.setTitle(title);
		todo.setDescription(description);
		todo.setUsername(username);
		todo.setTargetDate(targetDate);
		todo.setId(id);

		TodoService todoService = new TodoServiceImpl();
		if (todoService.updateTodo(todo)) {
			response.getWriter().print("Update Succesfully.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("allTodos.jsp");
			dispatcher.forward(request, response);
		} else {
			response.getWriter().print("update failed. Please retry");
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateTodo.jsp");
			dispatcher.include(request, response);
		}
		
	}
}
