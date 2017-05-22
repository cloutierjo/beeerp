package net.jc.beeerp.module.field.type;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import net.jc.beeerp.module.testdata.TestEntity;

public class FieldIntegerTest {

	private static final Integer ZERO = 0;
	private static final Integer TEST_VALUE = 123;
	private static final String FIELD_NAME = "fieldInteger";
	FieldInteger fieldInteger;

	@Before
	public void setUp() throws Exception {
		fieldInteger = new FieldInteger(FIELD_NAME, new TestEntity());
	}

	@Test
	public final void constructorWork() {
		assertNotNull(fieldInteger);
	}

	@Test
	public final void getDataStringReturnValue() {
		fieldInteger.setData(TEST_VALUE);
		assertEquals("" + TEST_VALUE, fieldInteger.getDataString());
	}

	@Test
	public final void getDataStringReturnZeroWhenNull() {
		assertEquals("", fieldInteger.getDataString());
	}

	@Test
	public final void setDataStringToValue() {
		fieldInteger.setDataString("" + TEST_VALUE);
		assertEquals(TEST_VALUE, fieldInteger.getData());
	}

	@Test
	public final void setDataStringToWrongValue() {
		fieldInteger.setDataString("wrong");
		assertFalse(fieldInteger.isValid());
	}

	@Test
	public final void setDataStringToEmptySetToZero() {
		fieldInteger.setDataString("");
		assertEquals(ZERO, fieldInteger.getData());
	}

	@Test
	public final void setDataStringToNullStringSetToZero() {
		fieldInteger.setDataString("null");
		assertEquals(ZERO, fieldInteger.getData());
	}

	@Test
	public final void setDataStringNullTotrue() {
		fieldInteger.setDataString(null);
		assertEquals(ZERO, fieldInteger.getData());
	}
}
