package dta.chat.view.console;

import java.util.Scanner;

public class ChatConsoleLoginView extends ViewComposite {
	private static final String HEADER = "== Authentification ==";
	private Scanner sc;

	public ChatConsoleLoginView(Scanner sc) {
		this.sc = sc;
	}

	@Override
	public void print() {
		System.out.println(HEADER);
		System.out.println("Veuillez saisir votre login : ");
		sc.nextLine();
	}

}
