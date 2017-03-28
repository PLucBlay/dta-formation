package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;

/**
 * @author PLucBlay
 *
 */
public class OptionNettoyerFichiers extends Option {

	/**
	 * 
	 */
	public OptionNettoyerFichiers() {
		super();
		this.contenuOption = "Nettoyer les fichiers génerés dans le dossier data";
	}

	@Override
	public void execute(IDao dao, Scanner scan) {
		dao.clearFiles();
	}

}
