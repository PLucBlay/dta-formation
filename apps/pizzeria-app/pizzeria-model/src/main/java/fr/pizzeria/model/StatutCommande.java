/**
 * 
 */
package fr.pizzeria.model;

/**
 * @author PLucBlay
 *
 */
public enum StatutCommande {
	EN_ATTENTE("En attente"), EN_PREPARATION("En preparation"), EN_LIVRAISON("En cours de livraison"), LIVREE("Livree");

	private String status = "";

	/**
	 * @param status
	 */
	StatutCommande(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return status;
	}
}
