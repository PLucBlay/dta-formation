package fr.pizzeria.console;

public class OptionMAJ extends Option {

	public OptionMAJ() {
		super();
		this.numChoix = 3;
		this.contenuOption = "Mettre � jour une pizza";
	}

	@Override
	public void execute() {
		System.out.println("Execute MAJ!");

	}

}
