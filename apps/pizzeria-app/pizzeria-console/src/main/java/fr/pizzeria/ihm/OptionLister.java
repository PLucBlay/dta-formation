package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
@Controller
public class OptionLister extends Option {

	/**
	 * 
	 */
	public OptionLister() {
		super();
		this.contenuOption = "Lister les pizzas";
	}

	@Override
	public void execute(IDao dao, Scanner scan) {
		List<Pizza> list = dao.findAll();
		for (Pizza piz : list) {
			System.out.println(piz);
		}
	}

}
