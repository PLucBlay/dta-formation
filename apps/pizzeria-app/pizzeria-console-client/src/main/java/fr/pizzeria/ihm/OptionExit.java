package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;

/**
 * @author PLucBlay
 *
 */
public class OptionExit extends Option {

	/**
	 * 
	 */
	public OptionExit() {
		super();
		this.contenuOption = "Sortir";
	}

	@Override
	public void execute(IDao dao, Scanner scan) {
		System.out.println("A Bientot");
	}

}
