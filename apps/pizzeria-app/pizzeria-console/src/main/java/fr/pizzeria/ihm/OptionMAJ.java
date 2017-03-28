package fr.pizzeria.ihm;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
@Controller
public class OptionMAJ extends Option {

	/**
	 * 
	 */
	public OptionMAJ() {
		super();
		this.contenuOption = "Mettre à jour une pizza";
	}

	@Override
	public void execute(IDao dao, Scanner scan) {

		// check si 99 > sortie ou si code pizza existe
		String codeModif;
		do {
			System.out.println("Veuillez saisir le code de la pizza � modifier (99 pour sortir) : ");
			codeModif = scan.next();
		} while (!"99".equals(codeModif) && !(dao.exist(codeModif)));

		// si !99 on continue sinon fin d'execute
		if (!"99".equals(codeModif)) {
			System.out.println("Veuillez saisir le nouveau code de la pizza : ");
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
					System.out.println("Entr�e non-valide.");
				}
			} while (!isCategorie);

			try {
				dao.update(codeModif, new Pizza(codePizza, nomPizza, prixPizza, categoriePizza));
			} catch (StockageException e) {
				System.out.println(e);
			}
		}

	}

}
