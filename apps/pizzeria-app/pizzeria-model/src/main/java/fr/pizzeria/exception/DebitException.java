package fr.pizzeria.exception;

/**
 * @author PLucBlay
 *
 */
public class DebitException extends Exception {

	private static final long serialVersionUID = 1L;

	public DebitException() {
		super("Debit Exception");
	}

	public DebitException(String message) {
		super(message);
	}

	public DebitException(Throwable cause) {
		super(cause);
	}

	public DebitException(String message, Throwable cause) {
		super(message, cause);
	}

	public DebitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
