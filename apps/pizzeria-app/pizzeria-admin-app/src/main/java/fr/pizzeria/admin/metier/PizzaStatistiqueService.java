package fr.pizzeria.admin.metier;

import java.util.List;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class PizzaStatistiqueService {

	@Inject
	private List<PizzaEvent> listEvents;

	public void ecouteMonEvent(@Observes PizzaEvent event) {
		listEvents.add(event);
	}
}
