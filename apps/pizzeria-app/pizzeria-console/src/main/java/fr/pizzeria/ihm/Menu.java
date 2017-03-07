package fr.pizzeria.ihm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.PizzaDao;

public class Menu {
	private Map<Integer, Option> listeOptions;
	private PizzaDao dao;

	public Menu(PizzaDao dao) {
		listeOptions = new LinkedHashMap<>();// maintain order
		listeOptions.put(1, new OptionLister());
		listeOptions.put(2, new OptionListerParCategorie());
		listeOptions.put(3, new OptionPlusCher());
		listeOptions.put(4, new OptionAjouter());
		listeOptions.put(5, new OptionMAJ());
		listeOptions.put(6, new OptionSuppr());
		listeOptions.put(10, new OptionStockerVersFichier());
		listeOptions.put(11, new OptionNettoyerFichiers());
		listeOptions.put(99, new OptionExit());
		this.dao = dao;
	}

	public Map<Integer, Option> getListe() {
		return listeOptions;
	}

	public void setListe(Map<Integer, Option> liste) {
		this.listeOptions = liste;
	}

	public void showMenu() {
		System.out.println();
		System.out.println("***** Pizzeria Administration *****");
		for (Map.Entry<Integer, Option> entry : listeOptions.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue().getContenuOption());
		}
		System.out.println();
	}

	public void execute() {
		dao.getScanner();
		int reponseUser = 0;
		boolean scanError;

		while (!(listeOptions.get(reponseUser) instanceof OptionExit)) {
			if (listeOptions.containsKey(reponseUser)) {
				listeOptions.get(reponseUser).execute(dao);
			}
			showMenu();

			// get input
			scanError = false;
			while (!scanError) {
				try {
					reponseUser = dao.getScanner().nextInt();
					scanError = true;
				} catch (Exception e) {
					Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
					System.out.println("Erreur : veuillez entrer un entier :");
					dao.getScanner().next();
				}
			}
		}
	}
}
