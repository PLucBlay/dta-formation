package dta.chat;

import java.util.Scanner;

import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			ChatConversationModel model = new ChatConversationModel();
			ChatConsoleView c = new ChatConsoleView(scan);
			c.setAuthController((login) -> c.setLogin(login));
			model.addObserver(c);
			c.print();
			model.sendMessage("Bonjour");
			model.sendMessage("C'est moi !");
		}
	}
}
