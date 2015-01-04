package net.jc.beeerp.module.field.type;

import static org.junit.Assert.*;
import net.jc.beeerp.it.module.testdata.TestEntity;

import org.junit.Before;
import org.junit.Test;

public class FieldBoolTest {

	private static final String FIELD_NAME = "fieldBool";
	FieldBool fieldBool;

	@Before
	public void setUp() throws Exception {
		 fieldBool = new FieldBool(FIELD_NAME, new TestEntity());
	}

	@Test
	public final void constructorWork() {
		assertNotNull(fieldBool);
	}

	@Test
	public final void getDataStringReturnFalse() {
		fieldBool.setData(false);
		assertEquals("False", fieldBool.getDataString());
	}

	@Test
	public final void getDataStringReturnTrue() {
		fieldBool.setData(true);
		assertEquals("True", fieldBool.getDataString());
	}

	@Test
	public final void getDataStringReturnFalseWhenNull() {
		assertEquals("", fieldBool.getDataString());
	}

	@Test
	public final void setDataStringToFalse() {
		fieldBool.setDataString("False");
		assertFalse(fieldBool.getData());
	}

	@Test
	public final void setDataStringToWrongValue() {
		fieldBool.setDataString("asdasd");
		assertFalse(fieldBool.getData());
	}

	@Test
	public final void setDataStringToTrue() {
		fieldBool.setDataString("True");
		assertTrue(fieldBool.getData());
	}

	@Test
	public final void setDataStringTotrue() {
		fieldBool.setDataString("true");
		assertTrue(fieldBool.getData());
	}

	@Test
	public final void setDataStringToOn() {
		fieldBool.setDataString("On");
		assertTrue(fieldBool.getData());
	}

	@Test
	public final void setDataStringToon() {
		fieldBool.setDataString("on");
		assertTrue(fieldBool.getData());
	}

	@Test
	public final void setDataStringToYes() {
		fieldBool.setDataString("Yes");
		assertTrue(fieldBool.getData());
	}

	@Test
	public final void setDataStringToyes() {
		fieldBool.setDataString("yes");
		assertTrue(fieldBool.getData());
	}
}
