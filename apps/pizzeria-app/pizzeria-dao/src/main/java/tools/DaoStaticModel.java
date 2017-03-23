package tools;

import java.util.Scanner;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoMemory;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
public interface DaoStaticModel {
	IDao<Pizza, String> DAO = new PizzaDaoMemory(new Scanner(System.in));
}
