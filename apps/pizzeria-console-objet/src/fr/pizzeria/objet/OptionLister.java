package fr.pizzeria.objet;

public class OptionLister extends Option {

	public OptionLister() {
		super();
		this.numChoix = 1;
		this.contenuOption = "Lister les pizzas";
	}

	@Override
	public void execute() {
		System.out.println("Execute Lister!");
	}

}
