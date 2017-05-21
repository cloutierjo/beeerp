package net.jc.beeerp.module;

import javax.validation.ConstraintViolation;

public class InputError {

	private String message;
	private String invalidValue;

	public InputError() {
		message = "";
		invalidValue = "";
	}

	public InputError(ConstraintViolation<Entity> error) {
		message = error.getMessage();
		invalidValue = error.getInvalidValue().toString();
	}

	public InputError(String message, String invalidValue) {
		super();
		this.message = message;
		this.invalidValue = invalidValue;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInvalidValue() {
		return invalidValue;
	}

	public void setInvalidValue(String invalidValue) {
		this.invalidValue = invalidValue;
	}
}
