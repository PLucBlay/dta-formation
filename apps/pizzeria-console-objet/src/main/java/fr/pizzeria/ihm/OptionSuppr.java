package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;

public class OptionSuppr extends Option {

	public OptionSuppr() {
		super();
		this.contenuOption = "Supprimer une pizza";
	}

	@Override
	public void execute(PizzaDao dao) {
		System.out.println("Veuillez saisir le code de la pizza � supprimer : ");
		// post gestion exceptions
		try {
			dao.delete(dao.getScanner().next());
		} catch (StockageException e) {
			System.out.println(e);
		}
		/*
		 * pr� gestion exceptions
		 * 
		 * if (dao.deletePizza(PizzaDao.getScanner().next())) {
		 * System.out.println("Suppression r�ussie !"); } else {
		 * System.out.println("Suppression echou�e ! (TRY AGAIN !)"); }
		 */

	}

}
