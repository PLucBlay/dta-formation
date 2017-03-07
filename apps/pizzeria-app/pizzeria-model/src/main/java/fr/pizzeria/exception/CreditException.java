package fr.pizzeria.exception;

public class CreditException extends Exception {

	private static final long serialVersionUID = 1L;

	public CreditException() {
		super("Credit Exception");
	}

	public CreditException(String message) {
		super(message);
	}

	public CreditException(Throwable cause) {
		super(cause);
	}

	public CreditException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreditException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
