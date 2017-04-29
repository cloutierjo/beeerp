package com.logilibre.orm;

public class OrmException extends RuntimeException {

	private static final long serialVersionUID = 864854153707945234L;

	public OrmException() {
		super();
	}

	public OrmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public OrmException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrmException(String message) {
		super(message);
	}

	public OrmException(Throwable cause) {
		super(cause);
	}

}
