package dta.chat.view.console;

import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;

public class ChatConsoleConversationView extends ViewComposite {
	private static final String HEADER = "== Conversations ==";

	public ChatConsoleConversationView() {
	}

	@Override
	public void print() {
		System.out.println(HEADER);
		System.out.println("Welcome : " + user);
	}

	public void printUpdate(ChatMessage cm) {
		if (cm.getLogin() == null) {
			System.out.println(user + " " + cm.getMsg());
		} else {
			System.out.println(cm.getLogin() + " " + cm.getMsg());
		}
	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage cm) {
		printUpdate(cm);
	}

}
