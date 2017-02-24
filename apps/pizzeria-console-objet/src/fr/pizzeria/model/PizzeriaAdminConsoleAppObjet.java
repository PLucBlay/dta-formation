package fr.pizzeria.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleAppObjet {

	public static void main(String[] args) {
		List<Pizza> listePizzas = new ArrayList<Pizza>();
		listePizzas.add(new Pizza("PEP", "La Pépéroni", 12.5));
		listePizzas.add(new Pizza("MAR", "La Margherita", 14.00));
		listePizzas.add(new Pizza("REI", "La Reine", 11.50));
		listePizzas.add(new Pizza("FRO", "La 4 fromages", 12.00));
		listePizzas.add(new Pizza("CAN", "La cannibale", 12.50));
		listePizzas.add(new Pizza("SAV", "La savoyarde", 13.00));
		listePizzas.add(new Pizza("ORI", "L'orientale", 13.50));
		listePizzas.add(new Pizza("IND", "L'indienne", 14.00));
		Scanner scan = new Scanner(System.in);
		PizzaDao dao = new PizzaDao(listePizzas, scan);
		Menu menu = new Menu(dao);
		menu.execute();
		scan.close();
	}

}
