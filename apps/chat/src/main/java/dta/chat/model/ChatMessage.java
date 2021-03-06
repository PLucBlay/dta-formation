package dta.chat.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {

	private static final long serialVersionUID = 12L;
	private String login;
	private String text;

	public ChatMessage() {
	}

	public ChatMessage(String login, String text) {
		this.login = login;
		this.text = text;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMsg() {
		return text;
	}

	public void setMsg(String text) {
		this.text = text;
	}

	public static ChatMessage decode(String[] data) {
		if (data.length == 2) {
			return new ChatMessage(data[0], data[1]);
		} else {
			return null;
		}
	}

	public String encode() {
		return login + "|||" + text;
	}

	@Override
	public String toString() {
		return login + " " + text;
	}

}
