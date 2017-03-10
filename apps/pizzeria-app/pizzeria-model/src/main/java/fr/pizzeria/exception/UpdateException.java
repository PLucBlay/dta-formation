package fr.pizzeria.exception;

/**
 * @author PLucBlay
 *
 */
public class UpdateException extends StockageException {

	private static final long serialVersionUID = 1L;

	/**
	 * Create basic UpdateException containing "Update Exception"
	 */
	public UpdateException() {
		super("Update Exception");
	}

	/**
	 * @param s
	 */
	public UpdateException(String s) {
		super(s + "Update Exception");
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UpdateException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public UpdateException(Throwable cause) {
		super(cause);
	}
}
