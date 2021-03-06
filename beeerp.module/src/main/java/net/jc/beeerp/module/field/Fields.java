package net.jc.beeerp.module.field;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import net.jc.beeerp.module.InputError;

public class Fields {

	private Map<String, Field<?>> fieldsDataMap;

	public Fields() {
		fieldsDataMap = new LinkedHashMap<>();
	}

	/**
	 * Get a field from it's field name
	 * 
	 * @param fieldName Name of the field to get
	 * @return the field
	 */
	public Field<?> getField(String fieldName) {
		return fieldsDataMap.get(fieldName);
	}

	/**
	 * Get a field from it's field name
	 * 
	 * @param fieldName Name of the field to get
	 * @return the field
	 */
	public Field<?> addField(Field<?> field) {
		return fieldsDataMap.put(field.getName(), field);
	}

	/**
	 * Get the data from a specified field
	 * 
	 * @param fieldName The field name
	 * @return The data from the specified field
	 */
	public Object getData(String fieldName) {
		return getField(fieldName).getData();
	}

	/**
	 * Get the data from a specified field in it's string format
	 * 
	 * @param fieldName The field name
	 * @return The data from the specified field in it's string format
	 */
	public String getDataString(String fieldName) {
		return getField(fieldName).getDataString();
	}

	/**
	 * Set the data to the specified field
	 * 
	 * @param fieldName The field name
	 * @param data the data to set
	 */
	public void setData(String fieldName, Object data) {
		getField(fieldName).setData(data);
	}

	/**
	 * Set the data to the specified field from it's string format
	 * 
	 * @param fieldName The field name
	 * @param data the data to set from it's string format
	 */
	public void setDataString(String fieldName, String data) {
		getField(fieldName).setDataString(data);
	}

	public boolean isValid() {
		for (Field<?> field : fieldsDataMap.values()) {
			if (!field.isValid()) {
				return false;
			}
		}
		return true;
	}

	public Map<String, InputError> getErrors() {
		Map<String, InputError> errors = new HashMap<>();
		for (Field<?> field : fieldsDataMap.values()) {
			InputError error = field.getError();
			errors.put(field.getName(), error);
		}
		return errors;
	}
}
