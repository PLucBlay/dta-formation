package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoDB;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Client;

public class PizzeriaAdminConsoleAppObjet {

	private PizzeriaAdminConsoleAppObjet() {
	}

	public static void main(String[] args) {

		List<Client> listeClients = new ArrayList<>();
		listeClients.add(new Client(12, "Jules", "Robert", 200.0));
		listeClients.add(new Client(15, "Hugues", "Robert", 2.0));
		Scanner scan = new Scanner(System.in);
		// PizzaDaoMemory dao = new PizzaDaoMemory(scan);
		PizzaDaoDB dao = new PizzaDaoDB(scan);
		Menu menu = new Menu(dao);
		menu.execute();
		scan.close();
		dao.closeDBConnection();
	}

}
