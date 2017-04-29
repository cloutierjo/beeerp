package net.jc.beeerp.module.exception;

public class InvalidDataValueException extends RuntimeException {

	private static final long serialVersionUID = 3447723538372093797L;

	public InvalidDataValueException() {
		super();
	}

	public InvalidDataValueException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidDataValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidDataValueException(String message) {
		super(message);
	}

	public InvalidDataValueException(Throwable cause) {
		super(cause);
	}
}
