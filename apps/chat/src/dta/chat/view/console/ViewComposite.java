package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

import dta.chat.controller.ChatAuthController;

public abstract class ViewComposite {

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
}
