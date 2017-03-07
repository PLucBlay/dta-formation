package fr.pizzeria.exception;

public class UpdateException extends StockageException {

	private static final long serialVersionUID = 1L;

	public UpdateException() {
		super("Update Exception");
	}

	public UpdateException(String s) {
		super(s + "Update Exception");
	}
}
