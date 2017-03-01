package dta.chat.view.console;

import java.util.List;
import java.util.Scanner;

public class ChatConsoleView extends ViewComposite {
	private Scanner scan;

	public ChatConsoleView(Scanner sc) {
		add(new ChatConsoleTitleView());
		add(new ChatConsoleLoginView(sc));
		add(new ChatConsoleConversationView());
	}

	public ChatConsoleView(List<ViewComposite> listeVC) {

	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}
}
