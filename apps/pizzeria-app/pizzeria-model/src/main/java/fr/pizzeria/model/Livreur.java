package fr.pizzeria.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author PLucBlay
 *
 */
@Entity
public class Livreur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@OneToMany(mappedBy = "livreur")
	private Set<Commande> commandes;

	@Column(name = "nom", length = 100, nullable = false)
	private String nom;

	@Column(name = "prenom", length = 100, nullable = false)
	private String prenom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
