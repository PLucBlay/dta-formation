package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;

/**
 * @author PLucBlay
 *
 */
public class OptionInscription extends Option {

	/**
	 * 
	 */
	public OptionInscription() {
		super();
		this.contenuOption = "S'inscrire";
	}

	@Override
	public void execute(IDao dao, Scanner scan) {

	}

}
