package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;

public class OptionNettoyerFichiers extends Option {

	public OptionNettoyerFichiers() {
		super();
		this.contenuOption = "Nettoyer les fichiers g�ner�s dans le dossier data";
	}

	@Override
	public void execute(PizzaDao dao) {
		dao.clearFiles();
	}

}
