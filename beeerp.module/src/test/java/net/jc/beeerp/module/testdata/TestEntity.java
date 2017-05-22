package net.jc.beeerp.module.testdata;

import java.sql.Date;

import net.jc.beeerp.module.Entity;

public class TestEntity extends Entity {
	private Integer id;
	private Date fieldDate;
	private Double fieldDouble;
	private Integer fieldInteger;
	private Boolean fieldBool;
	private final int _final = 1;
	private static int _static;
	private transient int _transiant;
	private volatile int _volatil;

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

	public static int get_static() {
		return _static;
	}

	public static void set_static(int _static) {
		TestEntity._static = _static;
	}

	public int get_transiant() {
		return _transiant;
	}

	public void set_transiant(int _transiant) {
		this._transiant = _transiant;
	}

	public int get_volatil() {
		return _volatil;
	}

	public void set_volatil(int _volatil) {
		this._volatil = _volatil;
	}

	public int get_final() {
		return _final;
	}

	@Override
	public void setDefaultValue() {
		setId(25);
		setFieldBool(true);
	}

}
