package fr.pizzeria.exception;

/**
 * @author PLucBlay
 *
 */
public class StockageException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public StockageException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public StockageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public StockageException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public StockageException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public StockageException(Throwable cause) {
		super(cause);
	}
}
