package fr.pizzeria.exception;

/**
 * @author PLucBlay
 *
 */
public class StockageException extends Exception {

	private static final long serialVersionUID = 1L;

	public StockageException() {
		super();
	}

	public StockageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public StockageException(String message, Throwable cause) {
		super(message, cause);
	}

	public StockageException(String message) {
		super(message);
	}

	public StockageException(Throwable cause) {
		super(cause);
	}
}
