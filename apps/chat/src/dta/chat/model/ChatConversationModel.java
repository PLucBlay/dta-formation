package dta.chat.model;

import dta.chat.model.observer.ChatObservable;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	private String login;

	public void setLogin(String login) {
		this.login = login;
		notifyObservers(new ChatMessage(login, "Welcome"));
	}

	public void sendMessage(String msg) {
		notifyObservers(new ChatMessage(login, msg));
	}
}
