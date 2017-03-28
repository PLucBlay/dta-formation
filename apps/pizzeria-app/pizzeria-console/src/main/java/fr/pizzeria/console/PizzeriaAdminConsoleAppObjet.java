package fr.pizzeria.console;

import java.util.logging.Level;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.ihm.Menu;

/**
 * @author PLucBlay
 *
 */
public class PizzeriaAdminConsoleAppObjet {

	/**
	 * prevent use of this class as non-static
	 */
	private PizzeriaAdminConsoleAppObjet() {
	}

	/**
	 * Main method launching ConsoleAppObjet
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
		try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml",
				"dao-memoire-config.xml")) {
			Menu menu = (Menu) context.getBean("menu");
			menu.execute();
		}

		/*
		 * List<Client> listeClients = new ArrayList<>(); listeClients.add(new
		 * Client(12, "Jules", "Robert", 200.0)); listeClients.add(new
		 * Client(15, "Hugues", "Robert", 2.0)); Scanner scan = new
		 * Scanner(System.in); ResourceBundle appBundle =
		 * ResourceBundle.getBundle("application"); String typeDao =
		 * appBundle.getString("dao.type"); IDao<Pizza, String> dao;
		 * 
		 * try { switch (typeDao) { case "DB": ResourceBundle bundle =
		 * ResourceBundle.getBundle("jdbc"); dao = new PizzaDaoDB(scan, bundle);
		 * break;
		 * 
		 * // model DAO set for default non-recognized configuration to have a
		 * // valid DAO for launch
		 * 
		 * case "MEMORY": dao = new PizzaDaoMemory(scan); break; case "JPA":
		 * java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.
		 * SEVERE); dao = new PizzaDaoJPA(scan); break; default: throw new
		 * ConfigurationException(
		 * "Dao type Error : set dao.type in application.properties to a valid DAO (MODEL,DB)"
		 * ); } Menu menu = new Menu(dao); menu.execute(); // launch stopping
		 * methods for DAOs if ("JPA".equals(typeDao)) { dao.stopDao(); } }
		 * catch (ConfigurationException e) {
		 * Logger.getAnonymousLogger().log(Level.SEVERE, "Config exception :",
		 * e); } finally { scan.close(); }
		 */}

}
