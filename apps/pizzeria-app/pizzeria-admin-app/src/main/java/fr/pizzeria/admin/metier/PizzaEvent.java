package fr.pizzeria.admin.metier;

import java.time.ZonedDateTime;

import fr.pizzeria.model.Pizza;

public class PizzaEvent {
	private Pizza pizza;
	private ZonedDateTime date;
	private PizzaEventType type;

	public PizzaEvent(Pizza pizza, PizzaEventType type) {
		this.pizza = pizza;
		this.date = ZonedDateTime.now();
		this.type = type;
	}

	public PizzaEventType getType() {
		return type;
	}

	public void setType(PizzaEventType type) {
		this.type = type;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public ZonedDateTime getDate() {
		return date;
	}

	public void setDate(ZonedDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return pizza + " " + date + " " + type.toString();
	}
}
