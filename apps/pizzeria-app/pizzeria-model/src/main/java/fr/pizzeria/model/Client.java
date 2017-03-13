package fr.pizzeria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

/**
 * @author PLucBlay
 *
 */
@Entity
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Integer id;

	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes;

	@Column(name = "nom", length = 100, nullable = false)
	private String nom;

	@Column(name = "prenom", length = 100, nullable = false)
	private String prenom;

	@Column(name = "email", length = 255, nullable = false)
	private String email;

	@Column(name = "mdp", length = 20, nullable = false)
	private String motDePasse;

	private Double solde;

	/**
	 * empty constructor
	 */
	public Client() {
		super();
		commandes = new HashSet<>();
	}

	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param solde
	 */
	public Client(int id, String nom, String prenom, Double solde) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
	}

	/**
	 * @return id of client
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            of client
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return nom of client
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            of client
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return prenom of client
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            of client
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return solde of client
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            of client
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	/**
	 * @param montant
	 *            of transaction
	 * @throws CreditException
	 */
	public void crediterCompte(double montant) throws CreditException {
		if ((montant >= 0) && (solde + montant > 5000)) {
			throw new CreditException();
		} else {
			solde += montant;
		}
	}

	/**
	 * @param montant
	 *            of transaction
	 * @throws DebitException
	 */
	public void debiterCompte(double montant) throws DebitException {
		if ((montant >= 0) && (solde - montant < 0)) {
			throw new DebitException();
		} else {
			solde -= montant;
		}
	}

	@Override
	public String toString() {
		return id + " ->" + nom + " " + prenom + " (" + solde + ")";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

}
