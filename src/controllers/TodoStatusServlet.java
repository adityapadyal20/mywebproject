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


@WebServlet("/status")
public class TodoStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String[] isDoneId = request.getParameterValues("isDone");
		
		response.setContentType("text/html");
		
		TodoService todoService = new TodoServiceImpl();
				
		if(todoService.updateTodoStatus(isDoneId)) {
			response.getWriter().print("<h4 style='color:green;'>update status Succesfully.</h4>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("allTodos.jsp");
			dispatcher.include(request, response);
		}else {
			response.getWriter().print("update unsuccessfull");
			RequestDispatcher dispatcher = request.getRequestDispatcher("allTodos.jsp");
			dispatcher.include(request, response);
		}*/
	}
}
