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

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int id = Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html");
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setUsername(username);
		user.setPassword(password);
		user.setId(id);

		UserService userService = new UserServiceImpl();
		
		if (userService.updateUser(user)) {
			String message = "Update Successfull";
			request.setAttribute("message",message);
			//response.getWriter().print("Update Succesfully.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("allUsers.jsp");
			dispatcher.forward(request, response);
		} else {
			response.getWriter().print("<h4 style='color:red'>Update Failed. Please retry<h4>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("updateUser.jsp");
			dispatcher.include(request, response);

		}
	}

}
