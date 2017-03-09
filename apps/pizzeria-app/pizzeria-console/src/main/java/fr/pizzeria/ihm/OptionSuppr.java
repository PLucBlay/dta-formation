package fr.pizzeria.ihm;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;

public class OptionSuppr extends Option {

	/**
	 * 
	 */
	public OptionSuppr() {
		super();
		this.contenuOption = "Supprimer une pizza";
	}

	@Override
	public void execute(IDao dao) {
		System.out.println("Veuillez saisir le code de la pizza à supprimer : ");
		try {
			dao.delete(dao.getScanner().next());
		} catch (StockageException e) {
			System.out.println(e);
		}
	}
}
