package fr.pizzeria.ihm;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
@Controller
public class OptionListerParCategorie extends Option {

	/**
	 * 
	 */
	public OptionListerParCategorie() {
		super();
		this.contenuOption = "Lister les pizzas par catégorie";
	}

	@Override
	public void execute(IDao dao, Scanner scan) {
		((Iterable) dao.findAll().stream().sorted(Comparator.comparing(Pizza::getCategorie))
				.collect(Collectors.toList())).forEach(pizza -> System.out.println(pizza));
	}

}
