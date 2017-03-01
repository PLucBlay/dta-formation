package dta.chat;

import java.util.Scanner;

import dta.chat.view.console.ChatConsoleView;

public class ChatClientApp {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			ChatConsoleView c = new ChatConsoleView(scan);
			c.setAuthController((login) -> c.setLogin(login));
			c.print();
		}
	}
}
