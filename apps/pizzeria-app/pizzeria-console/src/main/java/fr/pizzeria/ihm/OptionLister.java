package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class OptionLister extends Option {

	public OptionLister() {
		super();
		this.contenuOption = "Lister les pizzas";
	}

	@Override
	public void execute(PizzaDao dao) {
		List<Pizza> list = dao.findAll();
		for (Pizza piz : list) {
			System.out.println(piz);
		}
	}

}
