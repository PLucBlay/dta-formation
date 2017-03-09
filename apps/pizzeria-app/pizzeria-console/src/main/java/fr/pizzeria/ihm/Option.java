package fr.pizzeria.ihm;

import fr.pizzeria.dao.IDao;

/**
 * @author PL
 *
 */
public abstract class Option {
	protected String contenuOption;

	public Option() {
	}

	/**
	 * @return a String describing the option effect
	 */
	public String getContenuOption() {
		return contenuOption;
	}

	/**
	 * change the description of the option effect
	 * 
	 * @param contenuOption
	 */
	public void setContenuOption(String contenuOption) {
		this.contenuOption = contenuOption;
	}

	/**
	 * execute the option code
	 * 
	 * @param dao
	 */
	public abstract void execute(IDao dao);
}
