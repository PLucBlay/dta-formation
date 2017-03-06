package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class OptionMAJ extends Option {

	public OptionMAJ() {
		super();
		this.contenuOption = "Mettre à jour une pizza";
	}

	@Override
	public void execute(PizzaDao dao) {

		// check si 99 > sortie ou si code pizza existe
		String codeModif = "";
		do {
			System.out.println("Veuillez saisir le code de la pizza à modifier (99 pour sortir) : ");
			codeModif = dao.getScanner().next();
		} while ((!codeModif.equals("99")) && !(dao.exist(codeModif)));

		// si !99 on continue sinon fin d'execute
		if (!codeModif.equals("99")) {
			System.out.println("Veuillez saisir le nouveau code de la pizza : ");
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
					System.out.println("Entrée non-valide.");
				}
			} while (!isCategorie);

			// post gestion exception :
			try {
				dao.update(codeModif, new Pizza(codePizza, nomPizza, prixPizza, categoriePizza));
			} catch (StockageException e) {
				System.out.println(e);
			}
			/*
			 * pré gestion d'exception
			 * 
			 * if (dao.updatePizza(codeModif, new Pizza(codePizza, nomPizza,
			 * prixPizza))) { System.out.println("Mise à jour réussie !"); }
			 * else { System.out.println("Mise à jour echouée ! (TRY AGAIN !)");
			 * }
			 */
		}

	}

}
