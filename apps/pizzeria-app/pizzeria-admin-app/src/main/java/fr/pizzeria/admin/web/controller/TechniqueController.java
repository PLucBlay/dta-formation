package fr.pizzeria.admin.web.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaEvent;

/**
 * Servlet implementation class TechniqueController
 */
@WebServlet("/technique")
public class TechniqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final static String SESSION_COUNT = "sessionCount";

	@Inject
	private List<PizzaEvent> listEvents;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TechniqueController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("compteurSession", request.getSession().getServletContext().getAttribute(SESSION_COUNT));
		request.setAttribute("listEvents", listEvents);
		System.out.println();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/technique.jsp");
		dispatcher.forward(request, response);
	}
}
