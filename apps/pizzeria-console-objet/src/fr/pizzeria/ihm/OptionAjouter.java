package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Pizza;

public class OptionAjouter extends Option {

	public OptionAjouter() {
		super();
		this.contenuOption = "Ajouter une nouvelle pizza";
	}

	@Override
	public void execute(PizzaDao dao) {
		System.out.println("Veuillez saisir le code : ");
		String codePizza = dao.getScanner().next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String nomPizza = dao.getScanner().next();
		System.out.println("Veuillez saisir le prix : ");
		boolean scanError = false;
		double prixPizza = -1.0;
		while (!scanError) {
			try {
				prixPizza = dao.getScanner().nextDouble();
				scanError = true;
			} catch (Exception e) {
				System.out.println("Erreur : veuillez entrer un nombre :");
				dao.getScanner().next();
			}
		}
		// post exception
		try {
			dao.saveNew(new Pizza(codePizza, nomPizza, prixPizza));
			System.out.println("Mise à jour réussie !");
		} catch (StockageException e) {
			System.out.println(e);
		}
		/*
		 * pré gestion exception
		 * 
		 * if (dao.saveNewPizza(new Pizza(codePizza, nomPizza, prixPizza))) {
		 * System.out.println("Mise à jour réussie !"); } else { System.out.
		 * println("Mise à jour echouée !(C'est possible de raté ça finalement..."
		 * ); }
		 */
	}

}
