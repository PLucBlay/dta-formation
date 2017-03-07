package fr.pizzeria.exception;

public class DeleteException extends StockageException {

	private static final long serialVersionUID = 1L;

	public DeleteException() {
		super("Delete Exception");
	}

	public DeleteException(String s) {
		super(s + "Delete Exception");
	}
}
