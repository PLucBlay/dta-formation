package dta.chat.view.console;

import java.util.List;
import java.util.Scanner;

public class ChatConsoleView extends ViewComposite {
	private Scanner scan;

	public ChatConsoleView() {
		add(new ChatConsoleTitleView());
		add(new ChatConsoleLoginView());
		add(new ChatConsoleConversationView());
	}

	public ChatConsoleView(List<ViewComposite> listeVC) {

	}
}
