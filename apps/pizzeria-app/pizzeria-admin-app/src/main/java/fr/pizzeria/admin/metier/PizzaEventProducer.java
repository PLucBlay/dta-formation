package fr.pizzeria.admin.metier;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

public class PizzaEventProducer {
	@Produces
	@ApplicationScoped
	public List<PizzaEvent> getPizzaEvent() {
		return new ArrayList<>();
	}
}
