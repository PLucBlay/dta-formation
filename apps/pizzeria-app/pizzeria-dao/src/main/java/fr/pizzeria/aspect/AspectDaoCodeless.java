package fr.pizzeria.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Pizza;

@Component
@Aspect
public class AspectDaoCodeless {

	@Before("execution(* fr.pizzeria.dao.PizzaDaoJPA.saveNew(..))")
	private void codelessCreation(JoinPoint jp) {
		Pizza pizza = (Pizza) jp.getArgs()[0];
		if (pizza.getCode().isEmpty()) {
			pizza.setCode(pizza.getNom().substring(0, 3));
		}
	}
}
