package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.exception.DeleteException;

@WebServlet("/pizzas/list")
public class ListerPizzaController extends PizzaServletWebApi {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((request.getParameter("delete") != null) && (dao.exist(request.getParameter("delete")))) {
			try {
				dao.delete(request.getParameter("delete"));
			} catch (DeleteException e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
			}
		}
		request.setAttribute("listPizzas", dao.findAll());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code").toString();
		try {
			dao.delete(code);
			resp.setStatus(200);
		} catch (DeleteException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}

}
