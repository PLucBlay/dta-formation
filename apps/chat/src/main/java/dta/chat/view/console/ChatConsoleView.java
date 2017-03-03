package dta.chat.view.console;

import java.util.List;
import java.util.Scanner;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatConsoleView extends ViewComposite {
	private Scanner scan;

	public ChatConsoleView(Scanner sc) {
		add(new ChatConsoleTitleView());
		add(new ChatConsoleLoginView(sc));
		add(new ChatConsoleConversationView());
	}

	public ChatConsoleView(List<ViewComposite> listeVC) {

	}

	public Scanner getScanner() {
		return scan;
	}

	public void setScanner(Scanner scan) {
		this.scan = scan;
	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		getChildren().forEach(view -> view.update(observable, obj));

	}
}
