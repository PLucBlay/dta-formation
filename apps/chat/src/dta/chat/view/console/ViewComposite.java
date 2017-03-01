package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

import dta.chat.controller.ChatAuthController;
import dta.chat.model.ChatMessage;
import dta.chat.model.observer.ChatObservable;
import dta.chat.model.observer.ChatObserver;

public abstract class ViewComposite implements ChatObserver<ChatMessage> {

	private List<ViewComposite> children = new ArrayList<>();
	protected String user;
	protected ChatAuthController authController;

	public ViewComposite() {
		// TODO Auto-generated constructor stub
	}

	public void add(ViewComposite vc) {
		children.add(vc);
	}

	public List<ViewComposite> getChildren() {
		return children;
	}

	public void print() {
		for (ViewComposite child : children) {
			child.print();
		}
	}

	public void setLogin(String login) {
		this.user = login;
		children.forEach(view -> view.setLogin(login));
	}

	public void setAuthController(ChatAuthController authController) {
		this.authController = authController;
		children.forEach(view -> view.setAuthController(authController));
	}

	@Override
	public void update(ChatObservable<ChatMessage> observable, ChatMessage obj) {
		children.forEach(view -> view.update(observable, obj));

	}
}
