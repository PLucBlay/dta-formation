package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;

public abstract class Option {
	protected String contenuOption;

	public Option() {
	}

	public String getContenuOption() {
		return contenuOption;
	}

	public void setContenuOption(String contenuOption) {
		this.contenuOption = contenuOption;
	}

	public abstract void execute(PizzaDao dao);
}
