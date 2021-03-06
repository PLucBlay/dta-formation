package fr.pizzeria.console;

import java.util.Scanner;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int reponse = 0;
		boolean scanError;
		String codePizza, nomPizza, prixPizza = "";
		String tabPizza[][] = { { "PEP", "P�p�roni", "12.50" }, { "MAR", "Margherita", "14.00" },
				{ "REI", "La Reine", "11.50" }, { "FRO", "La 4 fromages", "12.00" }, { "CAN", "La cannibale", "12.50" },
				{ "SAV", "La savoyarde", "13.00" }, { "ORI", "L'orientale", "13.50" }, { "IND", "L'indienne", "14.00" },
				{ "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" }, { "", "", "" } };
		while (reponse != 99) {
			switch (reponse) {
			case 1:
				for (int i = 0; i < tabPizza.length; i++) {
					if (!tabPizza[i][0].equals("")) {
						System.out.println(tabPizza[i][0] + " - " + tabPizza[i][1] + " (" + tabPizza[i][2] + ")");
					}
				}
				break;
			case 2:
				int idPizzaVide = tabPizza.length;
				for (int i = 0; (idPizzaVide == tabPizza.length) && (i < tabPizza.length); i++) {
					if (tabPizza[i][0].equals("")) {
						idPizzaVide = i;
					}
				}
				if (idPizzaVide == tabPizza.length) {
					System.out.println("Erreur il y trop de pizzas : " + idPizzaVide);
				} else {
					System.out.println("Veuillez saisir le code : ");
					codePizza = scan.next();
					System.out.println("Veuillez saisir le nom (sans espace) : ");
					nomPizza = scan.next();
					System.out.println("Veuillez saisir le prix : ");
					prixPizza = scan.next();
					tabPizza[idPizzaVide][0] = codePizza;
					tabPizza[idPizzaVide][1] = nomPizza;
					tabPizza[idPizzaVide][2] = prixPizza;
				}
				break;
			case 3:
				int idPizzaModif = tabPizza.length;
				String codePizzaModif = "";
				System.out.println("Veuillez saisir le code : ");
				codePizzaModif = scan.next();
				for (int i = 0; (idPizzaModif == tabPizza.length) && (i < tabPizza.length); i++) {
					if (tabPizza[i][0].equals(codePizzaModif)) {
						idPizzaModif = i;
					}
				}
				if (idPizzaModif == tabPizza.length) {
					System.out.println("Erreur il n'y a pas de pizza : " + codePizzaModif);
				} else {
					System.out.println("Veuillez saisir le code : ");
					codePizza = scan.next();
					System.out.println("Veuillez saisir le nom (sans espace) : ");
					nomPizza = scan.next();
					System.out.println("Veuillez saisir le prix : ");
					prixPizza = scan.next();
					tabPizza[idPizzaModif][0] = codePizza;
					tabPizza[idPizzaModif][1] = nomPizza;
					tabPizza[idPizzaModif][2] = prixPizza;
				}
				break;
			case 4:
				int idPizzaSuppr = tabPizza.length;
				String codePizzaSuppr = "";
				System.out.println("Veuillez saisir le code : ");
				codePizzaSuppr = scan.next();
				for (int i = 0; (idPizzaSuppr == tabPizza.length) && (i < tabPizza.length); i++) {
					if (tabPizza[i][0].equals(codePizzaSuppr)) {
						idPizzaSuppr = i;
					}
				}
				if (idPizzaSuppr == tabPizza.length) {
					System.out.println("Erreur il n'y a pas de pizza : " + codePizzaSuppr);
				} else {
					// TODO : verif pizza inserable
					tabPizza[idPizzaSuppr][0] = "";
					tabPizza[idPizzaSuppr][1] = "";
					tabPizza[idPizzaSuppr][2] = "";
				}
				break;
			default:
				break;
			}
			System.out.println("***** Pizzeria Administration *****");
			System.out.println("1. Lister les pizzas");
			System.out.println("2. Ajouter une nouvelle pizza");
			System.out.println("3. Mettre � jour une pizza");
			System.out.println("4. Supprimer une pizza");
			System.out.println("99. Sortir");
			scanError = false;
			while (!scanError) {
				try {
					reponse = scan.nextInt();
					scanError = true;
				} catch (Exception e) {
					System.out.println("Erreur : veuillez entrer un entier :");
					scan.next();
				}
			}
		}
		System.out.println("***** A Bient�t *****");
	}
}