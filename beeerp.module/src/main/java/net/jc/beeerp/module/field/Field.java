package net.jc.beeerp.module.field;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.jc.beeerp.module.Entity;
import net.jc.beeerp.module.InputError;
import net.jc.beeerp.module.PropertiesAccessibleEntity;
import net.jc.beeerp.module.exception.InvalidDataValueException;

public abstract class Field<T> {
	private static final Logger log = LoggerFactory.getLogger(Field.class);

	public static class Safety { private Safety() {} }
	private static Safety safety = new Safety();

	private String name;
	private PropertiesAccessibleEntity originalEntity;

	private InputError error = null;

	public Field(String name, Entity originalEntity) {
		this.name = name;
		this.originalEntity = (PropertiesAccessibleEntity) originalEntity;
	}

	public String getName() {
		return name;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return getTypeArgument().cast(originalEntity.getData(name, safety));
	}

	/**
	 * Set the data to the specified field
	 * @param data the data to set
	 */
	public String getDataString() {
		T data = getData();
		if (data == null) {
			return "";
		}
		return data.toString();
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		setDataType(getTypeArgument().cast(data));
	}

	/**
	 * Sets the data in the good type.
	 * 
	 * @param data the new data type
	 */
	protected void setDataType(T data) {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();

		Set<?> errors = validator.validateValue(originalEntity.getClass(), name, data);
		if (!errors.isEmpty()) {
			@SuppressWarnings("unchecked")
			ConstraintViolation<Entity> violation = (ConstraintViolation<Entity>) errors.iterator().next();
			error = new InputError(violation);
			log.debug("validation err:{}", error);
		}

		originalEntity.setData(name, data, safety);
	}

	/**
	 * Set the data to the specified field from it's string format
	 * 
	 * @param data the data to set from it's string format
	 */
	public void setDataString(String data) {
		try {
			setDataStringInner(data);
		} catch (InvalidDataValueException e) {
			log.debug("Data value exception {}", e);
			log.trace("", e);
			error = new InputError(e.getMessage(), data);
		}
	}

	public boolean isValid() {
		return error == null;
	}

	public InputError getError() {
		return error;
	}
	/**
	 * Set the data to the specified field from it's string format
	 * 
	 * @param data the data to set from it's string format
	 */
	protected abstract void setDataStringInner(String data);

	/**
	 * Gets the type argument.
	 * 
	 * @return the type argument
	 */
	protected abstract Class<T> getTypeArgument();

}
