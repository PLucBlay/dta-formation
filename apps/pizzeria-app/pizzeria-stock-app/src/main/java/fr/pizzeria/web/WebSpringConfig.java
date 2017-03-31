package fr.pizzeria.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import fr.pizzeria.data.ConfigDataJpa;

@Configuration
@EnableWebMvc
@ComponentScan({ "fr.pizzeria.web.controller", "fr.pizzeria.web.controllerREST" })
@Import(ConfigDataJpa.class)
public class WebSpringConfig {

	@Bean
	ViewResolver getViewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;

	}
}
