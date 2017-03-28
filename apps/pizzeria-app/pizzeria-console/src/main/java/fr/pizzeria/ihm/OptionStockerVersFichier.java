package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;

/**
 * @author PLucBlay
 *
 */
public class OptionStockerVersFichier extends Option {

	/**
	 * 
	 */
	public OptionStockerVersFichier() {
		super();
		this.contenuOption = "Génerer les fichiers correspondants à la liste actuelle";
	}

	@Override
	public void execute(IDao dao, Scanner scan) {
		dao.createFiles();
	}

}
