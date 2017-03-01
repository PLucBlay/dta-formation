package dta.chat.view.console;

public class ChatConsoleConversationView extends ViewComposite {
	private static final String HEADER = "== Conversations ==";

	public ChatConsoleConversationView() {
	}

	@Override
	public void print() {
		System.out.println(HEADER);
		System.out.println("Welcome : " + user);
	}

}
