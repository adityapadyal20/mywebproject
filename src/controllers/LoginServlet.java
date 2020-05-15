package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Login;
import service.LoginService;
import serviceimpl.LoginServiceImpl;


//@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
			
		Login login = new Login();
		login.setUsername(username);
		login.setPassword(password);
		
		LoginService loginService = new LoginServiceImpl();
		String role = loginService.getUserRole(username);
		HttpSession session = request.getSession();
		String message =role+" login successfull ";
		RequestDispatcher dispatcher;
		
		if (loginService.validateUser(login) && role.equalsIgnoreCase("Admin")) {
			session.setAttribute("username", username);
			request.setAttribute("message",message);
			dispatcher = request.getRequestDispatcher("allUsers.jsp");
			dispatcher.forward(request, response);
		} else if(loginService.validateUser(login)){
			if(role.equalsIgnoreCase("student")) {
				session.setAttribute("username", username);
				dispatcher = request.getRequestDispatcher("studentTodos.jsp");
				dispatcher.forward(request, response);
				request.setAttribute("message",message);
			}else if(role.equalsIgnoreCase("teacher")) {
				session.setAttribute("username", username);
				dispatcher = request.getRequestDispatcher("allTodos.jsp");
				dispatcher.forward(request, response);
				request.setAttribute("message",message);
			}
		}else {
			response.getWriter().print("<h4 style='color:red'>Invalid Credentials</h4>");
			dispatcher = request.getRequestDispatcher("loginUser.jsp");
			dispatcher.include(request, response);
		}
	}

}
