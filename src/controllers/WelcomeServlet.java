package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter printWriter = response.getWriter();
		response.setContentType("text/html");
		String htmlRespone = "<html>";
		htmlRespone += "<h2>Welcome: "+request.getParameter("username") + "</h2>";
		htmlRespone += "</html>";
		printWriter.print(htmlRespone);
		//printWriter.print("Welcome "+request.getParameter("username"));

	}
}
