package fr.pizzeria.admin.web.tools;

import java.util.Scanner;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoMemory;
import fr.pizzeria.model.Pizza;

public class DaoProducer {

	@Produces
	@ApplicationScoped
	public IDao<Pizza, String> getDao() {
		return new PizzaDaoMemory(new Scanner(System.in));
	}

}
