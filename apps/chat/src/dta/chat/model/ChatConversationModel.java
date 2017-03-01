package dta.chat.model;

import dta.chat.model.observer.ChatObservable;
import dta.chat.model.observer.ChatObserver;

public class ChatConversationModel extends ChatObservable<ChatMessage> {

	private ChatMessage cm = new ChatMessage();

	public void setLogin(String login) {
		cm.setLogin(login);
		notifyObservers(cm);
	}

	public void sendMessage(String msg) {
		cm.setMsg(msg);
		notifyObservers(cm);
	}

	@Override
	public void notifyObservers(ChatMessage cm) {
		for (ChatObserver<ChatMessage> chatObserver : observers) {
			this.cm = cm;
			chatObserver.update(this, cm);
		}
	}

}
