package fr.pizzeria.ihm;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.model.Pizza;

public class OptionMAJ extends Option {

	public OptionMAJ() {
		super();
		this.numChoix = 3;
		this.contenuOption = "Mettre � jour une pizza";
	}

	@Override
	public void execute(PizzaDao dao) {

		// check si 99 > sortie ou si code pizza existe
		String codeModif = "";
		do {
			System.out.println("Veuillez saisir le code de la pizza � modifier (99 pour sortir) : ");
			codeModif = PizzaDao.getScanner().next();
		} while ((!codeModif.equals("99")) && !(dao.existPizza(codeModif)));

		// si !99 on continue sinon fin d'execute
		if (!codeModif.equals("99")) {
			System.out.println("Veuillez saisir le nouveau code de la pizza : ");
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
			if (dao.updatePizza(codeModif, new Pizza(codePizza, nomPizza, prixPizza))) {
				System.out.println("Mise � jour r�ussie !");
			} else {
				System.out.println("Mise � jour echou�e ! (TRY AGAIN !)");
			}
		}
	}

}