package fr.pizzeria.ihm;

import java.util.Scanner;

import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IDao;

/**
 * @author PLucBlay
 *
 */
@Controller
public class OptionExit extends Option {

	/**
	 * 
	 */
	public OptionExit() {
		super();
		this.contenuOption = "Sortir";
	}

	@Override
	public void execute(IDao dao, Scanner scan) {
		System.out.println("A Bientot");
	}

}
