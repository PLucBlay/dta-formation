package fr.pizzeria.console;

public class OptionAjouter extends Option {

	public OptionAjouter() {
		super();
		this.numChoix = 2;
		this.contenuOption = "Ajouter une nouvelle pizza";
	}

	@Override
	public void execute() {
		System.out.println("Execute Lister!");

	}

}
