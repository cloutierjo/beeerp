package net.jc.beeerp.it.module.testdata;

import java.sql.Date;

import net.jc.beeerp.module.Entity;

public class TestEntity extends Entity {
	private Integer id;
	private Date fieldDate;
	private Double fieldDouble;
	private Integer fieldInteger;
	private Boolean fieldBool;

	@Override
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

	@Override
	public void setDefaultValue() {
		setId(25);
		setFieldBool(true);
	}

}
