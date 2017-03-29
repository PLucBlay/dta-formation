package fr.pizzeria.spring;

import java.util.logging.Level;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.ihm.Menu;

/**
 * @author PLucBlay
 *
 */
public class PizzeriaAdminConsoleAppObjetAnnotations {

	/**
	 * prevent use of this class as non-static
	 */
	private PizzeriaAdminConsoleAppObjetAnnotations() {
	}

	/**
	 * Main method launching ConsoleAppObjetAnnotations
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.logging.Logger.getLogger("org").setLevel(Level.SEVERE);
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzeriaAdminConsoleAppConfig.class)) {
			Menu menu = context.getBean(Menu.class);
			menu.execute();
		}
	}
}
