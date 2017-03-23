package fr.pizzeria.model;

import org.apache.commons.lang3.text.WordUtils;

/**
 * @author PLucBlay
 *
 */
public enum CategoriePizza {
	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

	private String name = "";

	/**
	 * @param name
	 */
	CategoriePizza(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	/**
	 * @return a good looking name
	 */
	public String getFriendlyName() {
		return WordUtils.capitalize(name().toLowerCase().replace("_", " "));
	}
}
