package fr.pizzeria.model;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author PLucBlay
 *
 */
@Entity
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column(name = "num_commande", length = 10, nullable = false, unique = true)
	private Integer numCommande;

	@ToString
	@Enumerated(EnumType.STRING)
	@Column(name = "statut", nullable = false)
	private StatutCommande statut;

	@Column(name = "date_commande", length = 10, nullable = false)
	private Date dateCommande;

	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreur;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToMany
	@JoinTable(name = "commande_pizza", joinColumns = @JoinColumn(name = "commande_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private Set<Pizza> pizzas;

	/**
	 * @return id of commande
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return number of commande
	 */
	public Integer getNumCommande() {
		return numCommande;
	}

	/**
	 * @param numCommande
	 */
	public void setNumCommande(Integer numCommande) {
		this.numCommande = numCommande;
	}

	/**
	 * @return statut of commande
	 */
	public StatutCommande getStatut() {
		return statut;
	}

	/**
	 * @param statut
	 */
	public void setStatut(StatutCommande statut) {
		this.statut = statut;
	}

	/**
	 * @return date of commande
	 */
	public Date getDateCommande() {
		return dateCommande;
	}

	/**
	 * @param dateCommande
	 */
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
}
