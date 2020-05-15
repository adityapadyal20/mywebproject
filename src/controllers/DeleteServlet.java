package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;
import serviceimpl.UserServiceImpl;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username = request.getParameter("username");

		User user = new User();
		user.setUsername(username);

		UserService userService = new UserServiceImpl();
		
		if (userService.deleteUser(user)) {
			String message = "Delete Successfull";
			request.setAttribute("message",message);
			//response.getWriter().print("delete sucessfull");
			RequestDispatcher dispatcher = request.getRequestDispatcher("allUsers.jsp");
			dispatcher.forward(request, response);
		} else {
			response.getWriter().print("<h4 style='color:red'>Deletion failed. Please retry<h4>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("deleteUser.jsp");
			dispatcher.include(request, response);
		}

	}

}
