package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;

public class OptionSuppr extends Option {

	public OptionSuppr() {
		super();
		this.numChoix = 4;
		this.contenuOption = "Supprimer une pizza";
	}

	@Override
	public void execute(PizzaDao dao) {
		System.out.println("Veuillez saisir le code de la pizza à supprimer : ");
		if (dao.deletePizza(PizzaDao.getScanner().next())) {
			System.out.println("Suppression réussie !");
		} else {
			System.out.println("Suppression echouée ! (TRY AGAIN !)");
		}

	}

}
