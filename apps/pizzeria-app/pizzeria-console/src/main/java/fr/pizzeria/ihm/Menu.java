package fr.pizzeria.ihm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.pizzeria.dao.IDao;

/**
 * @author PLucBlay
 *
 */
public class Menu {
	private Map<Integer, Option> listeOptions;
	private IDao dao;

	/**
	 * @param dao
	 */
	public Menu(IDao dao) {
		listeOptions = new LinkedHashMap<>();// maintain order
		listeOptions.put(1, new OptionLister());
		listeOptions.put(2, new OptionListerParCategorie());
		listeOptions.put(3, new OptionPlusCher());
		listeOptions.put(4, new OptionAjouter());
		listeOptions.put(5, new OptionMAJ());
		listeOptions.put(6, new OptionSuppr());
		// listeOptions.put(10, new OptionStockerVersFichier());
		// listeOptions.put(11, new OptionNettoyerFichiers());
		listeOptions.put(99, new OptionExit());
		this.dao = dao;
	}

	/**
	 * @return list containing options
	 */
	public Map<Integer, Option> getListe() {
		return listeOptions;
	}

	/**
	 * Set the options
	 * 
	 * @param Map<int,Option>
	 */
	public void setListe(Map<Integer, Option> liste) {
		this.listeOptions = liste;
	}

	/**
	 * print the menu
	 */
	public void showMenu() {
		System.out.println();
		System.out.println("***** Pizzeria Administration *****");
		for (Map.Entry<Integer, Option> entry : listeOptions.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue().getContenuOption());
		}
		System.out.println();
	}

	/**
	 * start asking the user to choose an option
	 */
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
