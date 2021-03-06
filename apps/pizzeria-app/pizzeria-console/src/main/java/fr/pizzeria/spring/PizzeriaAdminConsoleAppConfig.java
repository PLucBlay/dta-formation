package fr.pizzeria.spring;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import fr.pizzeria.aspect.AspectDaoCodeless;
import fr.pizzeria.aspect.AspectDaoPerformance;
import fr.pizzeria.dao.PizzaDaoJPA;

/**
 * @author PLucBlay
 *
 */
@ComponentScan("fr.pizzeria.ihm")
@Import({ PizzaDaoJPA.class, AspectDaoCodeless.class, AspectDaoPerformance.class })
@Configuration
@EnableAspectJAutoProxy
@EnableJpaRepositories("fr.pizzeria.repo")
public class PizzeriaAdminConsoleAppConfig {
	@Bean
	public Scanner scanner() {
		return new Scanner(System.in);
	}

	/*
	 * @Bean public IDao<Pizza, String> daoImplemented() { return new
	 * PizzaDaoJPA(); }
	 */

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager txManager = new JpaTransactionManager();
		return txManager;
	}

	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
		return emf;
	}
}
