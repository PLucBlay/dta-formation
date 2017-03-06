package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Client;

public class PizzeriaAdminConsoleAppObjet {

	public static void main(String[] args) {

		/*
		 * ResourceBundle bundle = ResourceBundle.getBundle("conf/application");
		 * String daoImpl = bundle.getString("dao.impl");
		 * System.out.println(daoImpl); IDao<Pizza, String> dao = (IDao<Pizza,
		 * String>) Class.forName(daoImpl).newInstance(scan);
		 */
		List<Client> listeClients = new ArrayList<Client>();
		listeClients.add(new Client(12, "Jules", "Robert", 200.0));
		listeClients.add(new Client(15, "Hugues", "Robert", 2.0));
		Scanner scan = new Scanner(System.in);
		PizzaDao dao = new PizzaDao(scan);
		Menu menu = new Menu(dao);
		menu.execute();
		scan.close();
	}

}
