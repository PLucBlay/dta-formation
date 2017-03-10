package fr.pizzeria.exception;

/**
 * @author PLucBlay
 *
 */
public class CreditException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Create basic CreditException containing "Credit Exception"
	 */
	public CreditException() {
		super("Credit Exception");
	}

	/**
	 * @param message
	 */
	public CreditException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CreditException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CreditException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CreditException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
