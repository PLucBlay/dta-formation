package fr.pizzeria.model;

import java.lang.reflect.Field;

public class Pizza {
	@ToString
	private String code;
	@ToString
	private String nom;
	@ToString
	private double prix;
	@ToString
	private CategoriePizza categorie;
	private static int nbPizzas = 0;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public CategoriePizza getCategorie() {
		return categorie;
	}

	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		nbPizzas++;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();

		try {
			for (Field champ : this.getClass().getDeclaredFields()) {
				ToString annotationTrouve = champ.getAnnotation(ToString.class);
				if (annotationTrouve != null) {
					str.append(champ.get(this).toString() + " ");
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return str.toString();
	}
}
