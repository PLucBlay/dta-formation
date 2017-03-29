package fr.pizzeria.spring;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import fr.pizzeria.dao.IDao;
import fr.pizzeria.dao.PizzaDaoMemory;
import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
@Configuration
@ComponentScan("fr.pizzeria.ihm")
public class PizzeriaAdminConsoleAppConfig {
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	@Bean
	public IDao<Pizza, String> daoImplemented() {
		return new PizzaDaoMemory();
	}
}
