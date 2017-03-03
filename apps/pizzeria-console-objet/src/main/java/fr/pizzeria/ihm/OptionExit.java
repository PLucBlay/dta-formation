package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;

public class OptionExit extends Option {

	public OptionExit() {
		super();
		this.contenuOption = "Sortir";
	}

	@Override
	public void execute(PizzaDao dao) {
		System.out.println("A Bientôt");
	}

}
