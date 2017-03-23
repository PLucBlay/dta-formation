package fr.pizzeria.admin.metier;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.event.Event;
import javax.inject.Inject;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.DeleteException;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.exception.UpdateException;
import fr.pizzeria.model.Pizza;

public class PizzaService {

	@Inject
	private Event<PizzaEvent> event;

	@Inject
	private IDao<Pizza, String> pizzaDao;

	public List<Pizza> findAll() {
		// code metier
		return pizzaDao.findAll();
	}

	public Pizza get(String s) {
		// code
		return pizzaDao.get(s);
	}

	public void update(String s, Pizza p) {
		// code
		try {
			pizzaDao.update(s, p);
			event.fire(new PizzaEvent(p, PizzaEventType.UPDATE));
		} catch (UpdateException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}

	public void saveNew(Pizza p) {
		// code
		try {
			pizzaDao.saveNew(p);
			event.fire(new PizzaEvent(p, PizzaEventType.CREATE));
		} catch (SaveException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}

	public boolean exist(String s) {
		// code
		return pizzaDao.exist(s);
	}

	public void delete(String s) {
		// code
		try {
			Pizza temp = pizzaDao.get(s);
			pizzaDao.delete(s);
			event.fire(new PizzaEvent(temp, PizzaEventType.DELETE));
		} catch (DeleteException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
	}

}
