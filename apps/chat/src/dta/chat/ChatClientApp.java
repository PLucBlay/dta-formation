package dta.chat;

import java.util.Scanner;

import dta.chat.model.ChatConversationModel;
import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static final String IP = "localhost";// "192.168.99.31";
	public static final int PORT = 1800;

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			ChatConversationModel model = new ChatConversationModel(IP, PORT);
			ChatConsoleView c = new ChatConsoleView(scan);
			c.setAuthController((login) -> {
				c.setLogin(login);
				model.setLogin(login);
			});
			model.addObserver(c);
			c.print();
			model.printHistory();
			model.startWriting(scan);
		}
	}
}
