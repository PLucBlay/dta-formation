package fr.pizzeria.exception;

/**
 * @author PLucBlay
 *
 */
public class UpdateException extends StockageException {

	private static final long serialVersionUID = 1L;

	public UpdateException() {
		super("Update Exception");
	}

	public UpdateException(String s) {
		super(s + "Update Exception");
	}

	public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdateException(Throwable cause) {
		super(cause);
	}
}
