package fr.pizzeria.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.Pizza;

@Path("/pizzas")
public class APIPizza extends Application {

	@Inject
	protected PizzaService pizzaService;

	@Consumes(MediaType.APPLICATION_JSON)
	@POST
	public void create(Pizza pizza) {
		pizzaService.saveNew(pizza);
	}

	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public List<Pizza> read() {
		return pizzaService.findAll();
	}

	@Path("/{code}")
	@Consumes(MediaType.APPLICATION_JSON)
	@PUT
	public void update(@PathParam("code") String code, Pizza pizza) {
		pizzaService.update(code, pizza);
	}

	@Path("/{code}")
	@DELETE
	public void delete(@PathParam("code") String code) {
		pizzaService.delete(code);
	}

}
