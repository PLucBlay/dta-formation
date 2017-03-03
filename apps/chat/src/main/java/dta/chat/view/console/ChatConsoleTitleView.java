package dta.chat.view.console;

public class ChatConsoleTitleView extends ViewComposite {
	private static final String HEADER = "== CHAT APP ==";

	public ChatConsoleTitleView() {
	}

	@Override
	public void print() {
		System.out.println(HEADER);
	}

}
