package fr.pizzeria.objet;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<Option> liste;

	public List<Option> getListe() {
		return liste;
	}

	public void setListe(List<Option> liste) {
		this.liste = liste;
	}

	public Menu() {
		liste = new ArrayList<Option>();
		liste.add(new OptionLister());
		liste.add(new OptionAjouter());
		liste.add(new OptionMAJ());
		liste.add(new OptionSuppr());
	}

	public void showMenu() {
		System.out.println("***** Pizzeria Administration *****");
		for (Option opt : liste) {
			opt.print();
		}
		System.out.println("99 -> Sortir");
	}
}
