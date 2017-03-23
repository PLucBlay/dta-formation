package fr.pizzeria.admin.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pizzas/list")
public class ListerPizzaController extends PizzaServletWebApi {

	private static final long serialVersionUID = 1L;
	private static final String DELPARAMNAME = "delete";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if ((request.getParameter(DELPARAMNAME) != null) && (pizzaService.exist(request.getParameter(DELPARAMNAME)))) {
			pizzaService.delete(request.getParameter(DELPARAMNAME));

		}
		request.setAttribute("listPizzas", pizzaService.findAll());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String code = req.getParameter("code").toString();
		pizzaService.delete(code);
		resp.setStatus(200);

	}

}
