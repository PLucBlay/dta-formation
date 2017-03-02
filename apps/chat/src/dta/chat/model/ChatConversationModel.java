package dta.chat.model;

import java.util.List;
import java.util.Scanner;

import dta.chat.exception.ChatClientException;
import dta.chat.history.History;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.socket.ChatSocketImpl;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	private ChatSocketImpl socket;
	private String login;
	private History history;

	public ChatConversationModel(String ip, int port) {
		// socket = new ChatSocketImpl("localhost", 1800);
		history = new History();
		socket = new ChatSocketImpl(ip, port);
		Thread read = new Thread() {
			public void run() {
				while (true) {
					try {
						readMessage(socket.readMessage());
					} catch (ChatClientException e) {
						e.printStackTrace();
					}
				}
			}
		};
		read.setDaemon(true);
		read.start();
	}

	public void sendMessage(String msg) {
		ChatMessage cm = new ChatMessage(login, msg);
		notifyObservers(cm);
		socket.sendMessage(cm);
		history.saveMessage(cm);
	}

	public void readMessage(ChatMessage cm) {
		notifyObservers(cm);
		history.saveMessage(cm);
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void closeSocket() {
		socket.close();
	}

	public void startWriting(Scanner scan) {
		Boolean writing = true;
		String write = "";
		do {
			write = scan.nextLine();
			if (write.equals("exit") || write.equals("quit") || write.equals("q")) {
				writing = false;
			} else {
				sendMessage(write);
			}
		} while (writing);
	}

	public void printHistory() {
		List<ChatMessage> listH = history.findLastMessages();
		for (ChatMessage elem : listH) {
			System.out.println(elem);
		}
	}
}
