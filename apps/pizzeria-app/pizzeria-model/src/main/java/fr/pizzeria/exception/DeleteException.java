package fr.pizzeria.exception;

public class DeleteException extends StockageException {

	private static final long serialVersionUID = 1L;

	public DeleteException() {
		super("Delete Exception");
	}

	public DeleteException(String s) {
		super(s + "Delete Exception");
	}

	public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DeleteException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeleteException(Throwable cause) {
		super(cause);
	}
}
