package dta.chat.model;

import java.io.Serializable;

public class ChatMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private String login;
	private String msg;

	public ChatMessage() {
	}

	public ChatMessage(String login, String msg) {
		this.login = login;
		this.msg = msg;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
