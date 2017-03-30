package fr.pizzeria.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.dao.PizzaDaoJPA;

@Import(PizzaDaoJPA.class)
@Configuration
@EnableJpaRepositories("fr.pizzeria.repo")
public class PizzaDaoJPAConfig {

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		return txManager;
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		// emf.setPersistenceUnitName("pizzeria-console-jpa-spring");
		return emf;
	}
}
