package fr.pizzeria.model;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

/**
 * @author PLucBlay
 *
 */
public class Client {
	private Integer id;
	private String nom;
	private String prenom;
	private Double solde;

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

}
