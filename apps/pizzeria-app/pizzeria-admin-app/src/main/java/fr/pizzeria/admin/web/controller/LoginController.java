package fr.pizzeria.admin.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((request.getParameter("log") != null) && ("out".equals(request.getParameter("log")))) {
			request.getSession().invalidate();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login").toString();
		String pass = request.getParameter("pass").toString();
		response.setStatus(201);
		if ("admin@pizzeria.fr".equals(login) && "admin".equals(pass)) {
			request.getSession().setAttribute("isConnected", true);
			response.sendRedirect(request.getContextPath() + "/pizzas/list");
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
