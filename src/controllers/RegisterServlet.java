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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String userRole = request.getParameter("userRole");
		
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(userRole);

		UserService service = new UserServiceImpl();
		
		if(service.createUser(user)) {
			String message = "Register successfull!!! Please proceed with login";
			request.setAttribute("message", message);
			//response.getWriter().print("Registration sucessfull! Please proceeds with login");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginUser.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			response.getWriter().print("Registration not sucessfull! Please retry again");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("registerUser.jsp");
			requestDispatcher.include(request, response);
		}
	}

}
