package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
public class OptionLister extends Option {

	/**
	 * 
	 */
	public OptionLister() {
		super();
		this.contenuOption = "Lister les pizzas";
	}

	@Override
	public void execute(IDao dao) {
		List<Pizza> list = dao.findAll();
		for (Pizza piz : list) {
			System.out.println(piz);
		}
	}

}
