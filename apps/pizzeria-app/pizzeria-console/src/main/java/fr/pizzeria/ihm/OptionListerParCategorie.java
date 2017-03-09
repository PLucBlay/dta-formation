package fr.pizzeria.ihm;

import java.util.Comparator;
import java.util.stream.Collectors;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

public class OptionListerParCategorie extends Option {

	public OptionListerParCategorie() {
		super();
		this.contenuOption = "Lister les pizzas par catégorie";
	}

	@Override
	public void execute(IDao dao) {
		((Iterable) dao.findAll().stream().sorted(Comparator.comparing(Pizza::getCategorie))
				.collect(Collectors.toList())).forEach(pizza -> System.out.println(pizza));
	}

}
