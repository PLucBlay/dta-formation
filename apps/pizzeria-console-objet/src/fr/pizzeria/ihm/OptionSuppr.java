package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;

public class OptionSuppr extends Option {

	public OptionSuppr() {
		super();
		this.numChoix = 4;
		this.contenuOption = "Supprimer une pizza";
	}

	@Override
	public void execute(PizzaDao dao) {
		System.out.println("Veuillez saisir le code de la pizza à supprimer : ");
		// post gestion exceptions
		try {
			dao.deletePizza(PizzaDao.getScanner().next());
		} catch (StockageException e) {
			System.out.println(e);
		}
		/*
		 * pré gestion exceptions
		 * 
		 * if (dao.deletePizza(PizzaDao.getScanner().next())) {
		 * System.out.println("Suppression réussie !"); } else {
		 * System.out.println("Suppression echouée ! (TRY AGAIN !)"); }
		 */

	}

}
