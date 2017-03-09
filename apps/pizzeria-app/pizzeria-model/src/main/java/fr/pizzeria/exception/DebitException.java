package fr.pizzeria.exception;

/**
 * @author PLucBlay
 *
 */
public class DebitException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public DebitException() {
		super("Debit Exception");
	}

	/**
	 * @param message
	 */
	public DebitException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public DebitException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DebitException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public DebitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
