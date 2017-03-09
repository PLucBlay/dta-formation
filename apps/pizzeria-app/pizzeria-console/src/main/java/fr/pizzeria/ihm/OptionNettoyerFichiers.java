package fr.pizzeria.ihm;

import fr.pizzeria.dao.IDao;

public class OptionNettoyerFichiers extends Option {

	/**
	 * 
	 */
	public OptionNettoyerFichiers() {
		super();
		this.contenuOption = "Nettoyer les fichiers génerés dans le dossier data";
	}

	@Override
	public void execute(IDao dao) {
		dao.clearFiles();
	}

}
