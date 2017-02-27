package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleAppObjet {

	public static void main(String[] args) {
		List<Pizza> listePizzas = new ArrayList<Pizza>();
		listePizzas.add(new Pizza("PEP", "La Pépéroni", 12.5, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("MAR", "La Margherita", 14.00, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		listePizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listePizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.POISSON));
		listePizzas.add(new Pizza("IND", "L'indienne", 14.00, CategoriePizza.SANS_VIANDE));
		List<Client> listeClients = new ArrayList<Client>();
		listeClients.add(new Client(12, "Jules", "Robert", 200.0));
		listeClients.add(new Client(15, "Hugues", "Robert", 2.0));
		Scanner scan = new Scanner(System.in);
		PizzaDao dao = new PizzaDao(listePizzas, scan);
		Menu menu = new Menu(dao);
		menu.execute();
		scan.close();
	}

}
