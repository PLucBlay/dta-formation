package dta.chat.model;

public class ChatMessage {

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
