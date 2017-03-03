package fr.pizzeria.exception;

public class DeleteException extends StockageException {
	public DeleteException() {
		super("Delete Exception");
	}

	public DeleteException(String s) {
		super(s + "Delete Exception");
	}
}
