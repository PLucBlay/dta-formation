package fr.pizzeria.exception;

public class SaveException extends StockageException {
	public SaveException() {
		super("Saved Exception");
	}

	public SaveException(String s) {
		super(s + "Saved Exception");
	}
}
