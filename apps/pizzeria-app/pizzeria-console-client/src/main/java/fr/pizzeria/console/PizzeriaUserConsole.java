package fr.pizzeria.console;

import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.ConfigurationException;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoJPA;
import fr.pizzeria.dao.PizzaDaoMemory;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
public class PizzeriaUserConsole {

	/**
	 * prevent use of this class as non-static
	 */
	private PizzeriaUserConsole() {
	}

	/**
	 * Main method launching ConsoleAppObjet
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ResourceBundle appBundle = ResourceBundle.getBundle("application");
		String typeDao = appBundle.getString("dao.type");
		IDao<Pizza, String> dao;

		try {
			switch (typeDao) {
			case "DB":
				ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
				// dao = new PizzaDaoDB(scan, bundle);
				break;
			/*
			 * model DAO set for default non-recognized configuration to have a
			 * valid DAO for launch
			 */
			case "MODEL":
				dao = new PizzaDaoMemory();
				break;
			case "JPA":
				java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
				dao = new PizzaDaoJPA();
				break;
			default:
				throw new ConfigurationException(
						"Dao type Error : set dao.type in application.properties to a valid DAO (MODEL,DB)");
			}
			// Menu menu = new Menu(dao);
			// menu.execute();
			// launch stopping methods for DAOs
			if (typeDao.equals("JPA")) {
				// dao.stopDao();
			}
		} catch (ConfigurationException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "Config exception :", e);
		} finally {
			scan.close();
		}
	}

}
