package fr.pizzeria.ihm;

import java.util.Comparator;
import java.util.List;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class OptionPlusCher extends Option {

	public OptionPlusCher() {
		super();
		this.contenuOption = "Pizza au tarif le plus �lev�";
	}

	@Override
	public void execute(PizzaDao dao) {
		List<Pizza> list = dao.findAll();
		list.stream().max(Comparator.comparing(Pizza::getPrix)).ifPresent(p -> System.out.println(p));
	}
}
