package net.jc.beeerp.module;

public class InputError {

	private String message;
	private String invalidValue;

	public InputError(String message, String invalidValue) {
		super();
		this.message = message;
		this.invalidValue = invalidValue;
	}

	public String getMessage() {
		return message;
	}

	public String getInvalidValue() {
		return invalidValue;
	}
}
