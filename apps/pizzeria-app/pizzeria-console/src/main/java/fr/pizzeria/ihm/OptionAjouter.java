package fr.pizzeria.ihm;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
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
				Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
				System.out.println("Erreur : veuillez entrer un nombre :");
				dao.getScanner().next();
			}
		}

		// force categorie input
		CategoriePizza categoriePizza = null;
		String stringCategorie;
		boolean isCategorie = false;
		do {
			System.out.println("Veuillez saisir le type (Viande,Sans_Viande,Poisson) : ");
			stringCategorie = dao.getScanner().next();
			try {
				categoriePizza = CategoriePizza.valueOf(stringCategorie.toUpperCase());
				isCategorie = true;
			} catch (IllegalArgumentException e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
				System.out.println("Entr�e non-valide.");
			}
		} while (!isCategorie);

		// post exception
		try {
			dao.saveNew(new Pizza(codePizza, nomPizza, prixPizza, categoriePizza));
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
