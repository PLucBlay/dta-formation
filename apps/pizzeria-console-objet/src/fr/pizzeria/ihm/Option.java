package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;

public abstract class Option {
	protected int numChoix;
	protected String contenuOption;

	public int getnumChoix() {
		return numChoix;
	}

	public void setnumChoix(int numChoix) {
		this.numChoix = numChoix;
	}

	public String getContenuOption() {
		return contenuOption;
	}

	public void setContenuOption(String contenuOption) {
		this.contenuOption = contenuOption;
	}

	public Option() {
	}

	public abstract void execute(PizzaDao dao);

	public String toString() {
		return numChoix + " -> " + contenuOption;
	}

}
