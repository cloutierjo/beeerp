package net.jc.beeerp.it.module.testdata;

import java.sql.Date;

import net.jc.beeerp.module.Entity;

public class TestEntity extends Entity {
	private Integer id; 
	private Date fieldDate;
	private Double fieldDouble;
	private Integer fieldInteger;
	private Boolean fieldBool;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isFieldBool() {
		return fieldBool;
	}

	public void setFieldBool(boolean fieldBool) {
		this.fieldBool = fieldBool;
	} 

	public Double getFieldDouble() {
		return fieldDouble;
	}

	public void setFieldDouble(Double fieldDouble) {
		this.fieldDouble = fieldDouble;
	}

	public Integer getFieldInteger() {
		return fieldInteger;
	}

	public void setFieldInteger(Integer fieldInteger) {
		this.fieldInteger = fieldInteger;
	}

	public Date getFieldDate() {
		return fieldDate;
	}

	public void setFieldDate(Date fieldDate) {
		this.fieldDate = fieldDate;
	}



//	/**
//	 * Set the data to the specified field
//	 * 
//	 * @param fieldName The field name
//	 * @param data the data to set
//	 * @see net.jc.beeerp.module.field.Fields#setData(java.lang.String, java.lang.Object)
//	 */
//	@Override
//	public void setData(String fieldName, Object data, Field.Safety safety) {
//		if(safety==null){
//			throw new IllegalAccessError("cannot setData from outside a Field");
//		}
//		try {
//			getClass().getDeclaredField(fieldName).set(this, data);
//		} catch (IllegalArgumentException | IllegalAccessException
//				| NoSuchFieldException | SecurityException e) {			throw new RuntimeException(
//						"couldn't get value from '" + fieldName + "' field on '" + getClass().getCanonicalName() + "' entity", e);
//		}
//	}
//
//	/**
//	 * Get the data from a specified field
//	 * 
//	 * @param fieldName The field name
//	 * @return The data from the specified field
//	 * @see net.jc.beeerp.module.field.Fields#getData(java.lang.String)
//	 */
//	@Override
//	public Object getData(String fieldName, Field.Safety safety) {
//		if(safety==null){
//			throw new IllegalAccessError("cannot setData from outside a Field");
//		}
//		try {
//			return getClass().getDeclaredField(fieldName).get(this);
//		} catch (IllegalArgumentException | IllegalAccessException
//				| NoSuchFieldException | SecurityException e) {			throw new RuntimeException(
//						"couldn't get value from '" + fieldName + "' field on '" + getClass().getCanonicalName() + "' entity", e);
//		}
//	}
}
