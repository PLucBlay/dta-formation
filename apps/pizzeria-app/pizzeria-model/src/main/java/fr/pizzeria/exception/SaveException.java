package fr.pizzeria.exception;

/**
 * @author PLucBlay
 *
 */
public class SaveException extends StockageException {

	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public SaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SaveException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public SaveException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public SaveException(Throwable cause) {
		super(cause);
	}

	/**
	 * Create basic SaveException containing "Save Exception"
	 */
	public SaveException() {
		super("Save Exception");
	}
}
