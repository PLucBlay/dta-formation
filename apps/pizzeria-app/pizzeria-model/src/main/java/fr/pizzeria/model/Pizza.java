package fr.pizzeria.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author PLucBlay
 *
 */

/**
 * @author PLucBlay
 *
 */
@Entity
@NamedQueries({ @NamedQuery(name = "pizza.findAll", query = "select p from Pizza p"),
		@NamedQuery(name = "pizza.get", query = "select p from Pizza p where p.code=:codeSearched") })
public class Pizza implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@ToString
	@Column(name = "code", length = 10, nullable = false, unique = true)
	private String code;

	@ToString
	@Column(name = "nom", length = 255, nullable = false)
	private String nom;

	@ToString
	@Column(name = "prix", nullable = false)
	private double prix;

	@ToString
	@Enumerated(EnumType.STRING)
	@Column(name = "categorie", nullable = false)
	private CategoriePizza categorie;

	@ToString
	@Column(name = "url_pizza", length = 255, nullable = false)
	private String urlPizza;

	/**
	 * Constructor without argument mainly for JPA use
	 */
	public Pizza() {
		// Empty constructor for JPA use and eventual future adds
	}

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
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		this.urlPizza = nom + ".png";
	}

	/**
	 * Constructor with no internal management of the id - DO NOT USE with the
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
		this.urlPizza = nom + ".png";
	}

	/**
	 * @param id
	 *            of pizza
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return id of pizza
	 */
	public Integer getId() {
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

	/**
	 * @return url of pizza
	 */
	public String getUrlPizza() {
		return urlPizza;
	}

	/**
	 * @param urlPizza
	 */
	public void setUrlPizza(String urlPizza) {
		this.urlPizza = urlPizza;
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
