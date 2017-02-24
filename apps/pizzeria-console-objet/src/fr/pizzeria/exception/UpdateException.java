package fr.pizzeria.exception;

public class UpdateException extends StockageException {
	public UpdateException() {
		super("Update Exception");
	}

	public UpdateException(String s) {
		super(s + "Update Exception");
	}
}
