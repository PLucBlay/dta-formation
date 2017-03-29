package fr.pizzeria.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fr.pizzeria.model.Pizza;

/**
 * @author PLucBlay
 *
 */
// @Configuration
// @ComponentScan("fr.pizzeria.dao")
public class PizzaDaoConfig {

	@Bean
	public IDao<Pizza, String> daoImplemented() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeria?useSSL=false");
		dataSource.setUsername("user1");
		dataSource.setPassword("");
		return new PizzaDaoDB(dataSource);
	}
}
