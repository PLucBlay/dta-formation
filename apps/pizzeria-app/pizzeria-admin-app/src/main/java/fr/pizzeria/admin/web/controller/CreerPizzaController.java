package fr.pizzeria.admin.web.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class CreerPizzaController
 */
@WebServlet("/pizzas/new")
public class CreerPizzaController extends PizzaServletWebApi {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pizzas/creerPizza.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code").toString();
		String nom = request.getParameter("nom").toString();
		Double prix = Double.valueOf(request.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(request.getParameter("categorie").toUpperCase());
		try {
			dao.saveNew(new Pizza(code, nom, prix, categorie));
		} catch (SaveException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
			response.setStatus(400);
		}
		response.setStatus(201);
		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}
}
