package net.jc.beeerp.module.exception;

public class ModuleException extends RuntimeException {

	private static final long serialVersionUID = -4981935413611886166L;

	public ModuleException() {
		super();
	}

	public ModuleException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ModuleException(String message, Throwable cause) {
		super(message, cause);
	}

	public ModuleException(String message) {
		super(message);
	}

	public ModuleException(Throwable cause) {
		super(cause);
	}
}
