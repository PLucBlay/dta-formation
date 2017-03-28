package fr.pizzeria.ihm;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
public class OptionAjouter extends Option {

	/**
	 * 
	 */
	public OptionAjouter() {
		super();
		this.contenuOption = "Ajouter une nouvelle pizza";
	}

	@Override
	public void execute(IDao dao, Scanner scan) {
		System.out.println("Veuillez saisir le code : ");
		String codePizza = scan.next();
		System.out.println("Veuillez saisir le nom (sans espace) : ");
		String nomPizza = scan.next();
		System.out.println("Veuillez saisir le prix : ");
		boolean scanError = false;
		double prixPizza = -1.0;
		while (!scanError) {
			try {
				prixPizza = scan.nextDouble();
				scanError = true;
			} catch (Exception e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
				System.out.println("Erreur : veuillez entrer un nombre :");
				scan.next();
			}
		}

		// force categorie input
		CategoriePizza categoriePizza = null;
		String stringCategorie;
		boolean isCategorie = false;
		do {
			System.out.println("Veuillez saisir le type (Viande,Sans_Viande,Poisson) : ");
			stringCategorie = scan.next();
			try {
				categoriePizza = CategoriePizza.valueOf(stringCategorie.toUpperCase());
				isCategorie = true;
			} catch (IllegalArgumentException e) {
				Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
				System.out.println("Entrée non-valide.");
			}
		} while (!isCategorie);

		try {
			dao.saveNew(new Pizza(codePizza, nomPizza, prixPizza, categoriePizza));
			System.out.println("Mise à jour réussie !");
		} catch (StockageException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "execute exception", e);
		}
	}

}
