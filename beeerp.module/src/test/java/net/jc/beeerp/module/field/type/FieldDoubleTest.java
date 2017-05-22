package net.jc.beeerp.module.field.type;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import net.jc.beeerp.module.testdata.TestEntity;

public class FieldDoubleTest {

	private static final Double ZERO = 0.;
	private static final Double TEST_VALUE = 123.321;
	private static final String FIELD_NAME = "fieldDouble";
	FieldDouble fieldDouble;

	@Before
	public void setUp() throws Exception {
		fieldDouble = new FieldDouble(FIELD_NAME, new TestEntity());
	}

	@Test
	public final void constructorWork() {
		assertNotNull(fieldDouble);
	}

	@Test
	public final void getDataStringReturnValue() {
		fieldDouble.setData(TEST_VALUE);
		assertEquals("" + TEST_VALUE, fieldDouble.getDataString());
	}

	@Test
	public final void getDataStringReturnZeroWhenNull() {
		assertEquals("", fieldDouble.getDataString());
	}

	@Test
	public final void setDataStringToValue() {
		fieldDouble.setDataString("" + TEST_VALUE);
		assertEquals(TEST_VALUE, fieldDouble.getData());
	}

	@Test
	public final void setDataStringToWrongValue() {
		fieldDouble.setDataString("wrong");
		assertFalse(fieldDouble.isValid());
	}

	@Test
	public final void setDataStringToEmptySetToZero() {
		fieldDouble.setDataString("");
		assertEquals(ZERO, fieldDouble.getData());
	}

	@Test
	public final void setDataStringToNullStringSetToZero() {
		fieldDouble.setDataString("null");
		assertEquals(ZERO, fieldDouble.getData());
	}

	@Test
	public final void setDataStringNullTotrue() {
		fieldDouble.setDataString(null);
		assertEquals(ZERO, fieldDouble.getData());
	}
}
