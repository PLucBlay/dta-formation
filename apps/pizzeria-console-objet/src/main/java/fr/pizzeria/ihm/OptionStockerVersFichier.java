package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;

public class OptionStockerVersFichier extends Option {

	public OptionStockerVersFichier() {
		super();
		this.contenuOption = "G�nerer les fichiers correspondants � la liste actuelle";
	}

	@Override
	public void execute(PizzaDao dao) {
		dao.createFiles();
	}

}
