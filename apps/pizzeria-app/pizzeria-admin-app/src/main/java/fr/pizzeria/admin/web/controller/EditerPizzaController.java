package fr.pizzeria.admin.web.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
@WebServlet("/pizzas/edit")
public class EditerPizzaController extends PizzaServletWebApi implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("pizza", dao.get(request.getParameter("code").toString()));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code").toString();
		String newCode = request.getParameter("newcode").toString();
		String nom = request.getParameter("nom").toString();
		Double prix = Double.valueOf(request.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(request.getParameter("categorie").toUpperCase());
		try {
			dao.update(code, new Pizza(newCode, nom, prix, categorie));
		} catch (UpdateException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
		response.setStatus(201);
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}

}
