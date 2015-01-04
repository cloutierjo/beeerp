package net.jc.beeerp.module.field.type;

import static org.junit.Assert.*;
import net.jc.beeerp.it.module.testdata.TestEntity;
import net.jc.beeerp.module.field.exception.InvalidDataValueException;

import org.junit.Before;
import org.junit.Test;

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

	@Test(expected = InvalidDataValueException.class)
	public final void setDataStringToWrongValue() {
		fieldInteger.setDataString("asdasd");
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
