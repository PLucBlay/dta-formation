package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.exception.StockageException;

/**
 * @author PLucBlay
 *
 */
@Controller
public class OptionSuppr extends Option {

	/**
	 * 
	 */
	public OptionSuppr() {
		super();
		this.contenuOption = "Supprimer une pizza";
	}

	@Override
	public void execute(IDao dao, Scanner scan) {
		System.out.println("Veuillez saisir le code de la pizza à supprimer : ");
		try {
			dao.delete(scan.next());
		} catch (StockageException e) {
			System.out.println(e);
		}
	}
}
