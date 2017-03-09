package fr.pizzeria.ihm;

import fr.pizzeria.dao.IDao;

public class OptionStockerVersFichier extends Option {

	public OptionStockerVersFichier() {
		super();
		this.contenuOption = "Génerer les fichiers correspondants à la liste actuelle";
	}

	@Override
	public void execute(IDao dao) {
		dao.createFiles();
	}

}
