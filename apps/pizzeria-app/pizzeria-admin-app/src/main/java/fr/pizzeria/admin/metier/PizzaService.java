package fr.pizzeria.admin.metier;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import fr.pizzeria.admin.web.tools.PizzaServiceEJB;
import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaService {

	@Inject
	private Event<PizzaEvent> event;

	// @Inject
	// private IDao<Pizza, String> pizzaDao;

	@EJB
	private PizzaServiceEJB pizzaEJB;

	@Schedule(second = "10", minute = "*", hour = "*")
	public void insererPizza() {
		String code = "P" + RandomStringUtils.random(3, true, false).toUpperCase();
		String nom = RandomStringUtils.random(12, true, false);
		double prix = Math.round((RandomUtils.nextDouble(1, 25)) * 100.0) / 100.0;
		CategoriePizza categorie = CategoriePizza.values()[RandomUtils.nextInt(0, 3)];
		saveNew(new Pizza(code, nom, prix, categorie));
	}

	public List<Pizza> findAll() {
		// code metier
		return pizzaEJB.findAll();
	}

	public Pizza get(String s) {
		// code
		return pizzaEJB.get(s);
	}

	public void update(String s, Pizza p) {
		// code
		try {
			pizzaEJB.update(s, p);
			event.fire(new PizzaEvent(p, PizzaEventType.UPDATE));
		} catch (UpdateException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}

	public void saveNew(Pizza p) {
		// code
		try {
			pizzaEJB.saveNew(p);
			event.fire(new PizzaEvent(p, PizzaEventType.CREATE));
		} catch (SaveException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}

	public boolean exist(String s) {
		// code
		return pizzaEJB.exist(s);
	}

	public void delete(String s) {
		// code
		try {
			Pizza temp = pizzaEJB.get(s);
			pizzaEJB.delete(s);
			event.fire(new PizzaEvent(temp, PizzaEventType.DELETE));
		} catch (DeleteException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}

}
