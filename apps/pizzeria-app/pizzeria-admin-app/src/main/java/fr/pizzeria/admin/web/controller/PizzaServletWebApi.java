package fr.pizzeria.admin.web.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.PizzaDaoMemory;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import tools.DaoStaticModel;

/**
 * Servlet implementation class PizzaServletWebApi
 */
@WebServlet("/pizzas")
public class PizzaServletWebApi extends HttpServlet {
	protected final transient PizzaDaoMemory dao;

	/**
	 * Default constructor.
	 */
	public PizzaServletWebApi() {
		dao = (PizzaDaoMemory) DaoStaticModel.DAO;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write(dao.findAll().toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		Double prix = Double.valueOf(request.getParameter("prix"));
		CategoriePizza categorie = CategoriePizza.valueOf(request.getParameter("categorie").toUpperCase());
		try {
			dao.saveNew(new Pizza(code, nom, prix, categorie));
		} catch (SaveException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
		response.setStatus(201);
	}

}
