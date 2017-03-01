package dta.chat.view.console;

import java.util.ArrayList;
import java.util.List;

public abstract class ViewComposite {

	private List<ViewComposite> children = new ArrayList<>();

	public ViewComposite() {
		// TODO Auto-generated constructor stub
	}

	public void add(ViewComposite vc) {
		children.add(vc);
	}

	public void print() {
		for (ViewComposite child : children) {
			child.print();
		}
	}
}
