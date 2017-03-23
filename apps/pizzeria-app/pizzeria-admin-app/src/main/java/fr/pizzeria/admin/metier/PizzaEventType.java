package fr.pizzeria.admin.metier;

public enum PizzaEventType {
	CREATE("Create"), UPDATE("Update"), DELETE("Delete");

	private String name = "";

	/**
	 * @param name
	 */
	PizzaEventType(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
