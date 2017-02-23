package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class OptionAjouter extends Option {

	public OptionAjouter() {
		super();
		this.numChoix = 2;
		this.contenuOption = "Ajouter une nouvelle pizza";
	}

	@Override
	public void execute(PizzaDao dao) {
		System.out.println("Veuillez saisir le code : ");
		String codePizza = PizzaDao.getScanner().next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String nomPizza = PizzaDao.getScanner().next();
		System.out.println("Veuillez saisir le prix : ");
		boolean scanError = false;
		double prixPizza = -1.0;
		while (!scanError) {
			try {
				prixPizza = PizzaDao.getScanner().nextDouble();
				scanError = true;
			} catch (Exception e) {
				System.out.println("Erreur : veuillez entrer un nombre :");
				PizzaDao.getScanner().next();
			}
		}
		// post exception
		try {
			dao.saveNewPizza(new Pizza(codePizza, nomPizza, prixPizza));
			System.out.println("Mise � jour r�ussie !");
		} catch (StockageException e) {
			System.out.println(e);
		}
		/*
		 * pr� gestion exception
		 * 
		 * if (dao.saveNewPizza(new Pizza(codePizza, nomPizza, prixPizza))) {
		 * System.out.println("Mise � jour r�ussie !"); } else { System.out.
		 * println("Mise � jour echou�e !(C'est possible de rat� �a finalement..."
		 * ); }
		 */
	}

}
