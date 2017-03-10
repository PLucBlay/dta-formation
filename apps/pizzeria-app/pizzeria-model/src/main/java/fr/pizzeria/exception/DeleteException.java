package fr.pizzeria.exception;

/**
 * @author PLucBlay
 *
 */
public class DeleteException extends StockageException {

	private static final long serialVersionUID = 1L;

	/**
	 * Create basic DeleteException containing "Delete Exception"
	 */
	public DeleteException() {
		super("Delete Exception");
	}

	/**
	 * @param s
	 */
	public DeleteException(String s) {
		super(s + "Delete Exception");
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DeleteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DeleteException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public DeleteException(Throwable cause) {
		super(cause);
	}
}
