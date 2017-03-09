package fr.pizzeria.model;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author PLucBlay
 *
 */
public class Pizza {
	private int id;
	@ToString
	private String code;
	@ToString
	private String nom;
	@ToString
	private double prix;
	@ToString
	private CategoriePizza categorie;
	private static int nbPizzas = 0;

	/**
	 * Constructor automatically managing the id - DO NOT USE with the other
	 * constructor
	 * 
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categorie
	 */
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		super();
		this.id = nbPizzas;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		nbPizzas++;
	}

	/**
	 * Constructor with no internal managament of the id - DO NOT USE with the
	 * other constructor
	 * 
	 * @param id
	 * @param code
	 * @param nom
	 * @param prix
	 * @param categorie
	 */
	public Pizza(int id, String code, String nom, double prix, CategoriePizza categorie) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		nbPizzas++;
	}

	/**
	 * @return id of pizza
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return code(referentiel) of pizza
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code(referentiel)
	 *            of pizza
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return nom of pizza
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            of pizza
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return prix of pizza
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            of pizza
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return number of created pizzas
	 */
	public static int getNbPizzas() {
		return nbPizzas;
	}

	/**
	 * @return categorie of pizza
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            of pizza
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
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
			Logger.getAnonymousLogger().log(Level.SEVERE, "an exception was thrown", e);
		}
		return str.toString();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(code).append(prix).toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Pizza rhs = (Pizza) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(code, rhs.code).append(prix, rhs.prix)
				.isEquals();
	}

}
