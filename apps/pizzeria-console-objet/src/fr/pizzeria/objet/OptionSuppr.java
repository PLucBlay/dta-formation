package fr.pizzeria.objet;

public class OptionSuppr extends Option {

	public OptionSuppr() {
		super();
		this.numChoix = 4;
		this.contenuOption = "Supprimer une pizza";
	}

	@Override
	public void execute() {
		System.out.println("Execute Suppr!");

	}

}
