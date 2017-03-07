package fr.pizzeria.exception;

public class SaveException extends StockageException {

	private static final long serialVersionUID = 1L;

	public SaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SaveException(String message, Throwable cause) {
		super(message, cause);
	}

	public SaveException(String message) {
		super(message);
	}

	public SaveException(Throwable cause) {
		super(cause);
	}
}
