package pizzeria.pizzeria_model;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

public class Client {
	private Integer id;
	private String nom;
	private String prenom;
	private Double solde;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Double getSolde() {
		return solde;
	}

	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Client(int id, String nom, String prenom, Double solde) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
	}

	public void crediterCompte(double montant) throws CreditException {
		if (solde + montant > 5000) {
			throw new CreditException();
		} else {
			solde += montant;
		}
	}

	public void debiterCompte(double montant) throws DebitException {
		if (solde - montant < 0) {
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
