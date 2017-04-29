package net.jc.beeerp.module.field.type;

import static org.junit.Assert.*;

import java.sql.Date;

import net.jc.beeerp.it.module.testdata.TestEntity;
import net.jc.beeerp.module.exception.InvalidDataValueException;

import org.junit.Before;
import org.junit.Test;

public class FieldDateTest {

	private static final String FIELD_VALUE_STRING = "2010-03-24";
	private static final Date TEST_VALUE = Date.valueOf(FIELD_VALUE_STRING);
	private static final String FIELD_NAME = "fieldDate";
	FieldDate fieldDate;

	@Before
	public void setUp() throws Exception {
		 fieldDate = new FieldDate(FIELD_NAME, new TestEntity());
	}

	@Test
	public final void constructorWork() {
		assertNotNull(fieldDate);
	}

	@Test
	public final void getDataStringReturnValue() {
		fieldDate.setData(TEST_VALUE);
		assertEquals(FIELD_VALUE_STRING, fieldDate.getDataString());
	}

	@Test
	public final void getDataStringReturnZeroWhenNull() {
		assertEquals("", fieldDate.getDataString());
	}

	@Test
	public final void setDataStringToValue() {
		fieldDate.setDataString(FIELD_VALUE_STRING);
		assertEquals(TEST_VALUE, fieldDate.getData());
	}

	@Test(expected = InvalidDataValueException.class)
	public final void setDataStringToWrongValue() {
		fieldDate.setDataString("asdasd");
	}

	@Test
	public final void setDataStringToEmptySetToZero() {
		fieldDate.setDataString("");
		assertNull(fieldDate.getData());
	}

	@Test
	public final void setDataStringToNullStringSetToZero() {
		fieldDate.setDataString("null");
		assertNull(fieldDate.getData());
	}

	@Test
	public final void setDataStringNullTotrue() {
		fieldDate.setDataString(null);
		assertNull(fieldDate.getData());
	}
}
