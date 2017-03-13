package fr.pizzeria.ihm;

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
	public void execute(IDao dao) {
		System.out.println("A Bientot");
	}

}
