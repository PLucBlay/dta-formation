package fr.pizzeria.ihm;

import fr.pizzeria.dao.IDao;

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

	public abstract void execute(IDao dao);
}
