package net.jc.beeerp.module.field;

import net.jc.beeerp.module.Entity;
import net.jc.beeerp.module.PropertiesAccessibleEntity;

public abstract class Field<T> {
	public static class Safety { private Safety() {} }
	private static Safety safety = new Safety();

	private String name;
	private PropertiesAccessibleEntity originalEntity;

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
		originalEntity.setData(name, data, safety);
	}

	/**
	 * Set the data to the specified field from it's string format
	 * 
	 * @param data the data to set from it's string format
	 */
	public abstract void setDataString(String data);

	/**
	 * Gets the type argument.
	 * 
	 * @return the type argument
	 */
	protected abstract Class<T> getTypeArgument();

}
