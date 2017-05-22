package net.jc.beeerp.it.module;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import net.jc.beeerp.module.field.Field;
import net.jc.beeerp.module.testdata.TestEntity;
import net.jc.beeerp.module.testdata.TestEntityInvalid;

@SuppressWarnings("deprecation")
// TODO: remove when decision is taken
public class EntityFieldsIt {

	private static final Integer ID_TEST_VALUE = 345;
	private static final String ID_TEST_VALUE_STRING = "" + ID_TEST_VALUE;
	private TestEntity entity;

	@Before
	public void setUp() throws Exception {
		entity = new TestEntity();
	}

	@Test
	public final void constructorWork() {
		assertNotNull(entity);
	}

	@Test
	public final void containFieldId() {
		Field<?> field = entity.getFields().getField("id");
		assertNotNull(field);
		assertEquals("id", field.getName());
	}

	@Test
	public final void containFieldDate() {
		Field<?> field = entity.getFields().getField("fieldDate");
		assertNotNull(field);
		assertEquals("fieldDate", field.getName());
	}

	@Test
	public final void containFieldSickTime() {
		Field<?> field = entity.getFields().getField("fieldDouble");
		assertNotNull(field);
		assertEquals("fieldDouble", field.getName());
	}

	@Test
	public final void setValueFromEntityIsRetrivable() {
		entity.setData("id", ID_TEST_VALUE);
		Field<?> field = entity.getFields().getField("id");
		assertEquals(ID_TEST_VALUE, field.getData());
		assertEquals(ID_TEST_VALUE, entity.getFields().getData("id"));
		assertEquals(ID_TEST_VALUE, entity.getData("id"));
	}

	@Test
	public final void setValueFromFieldsIsRetrivable() {
		entity.getFields().setData("id", ID_TEST_VALUE);
		Field<?> field = entity.getFields().getField("id");
		assertEquals(ID_TEST_VALUE, field.getData());
		assertEquals(ID_TEST_VALUE, entity.getFields().getData("id"));
		assertEquals(ID_TEST_VALUE, entity.getData("id"));
	}

	@Test
	public final void setValueFromFieldIsRetrivable() {
		Field<?> field = entity.getFields().getField("id");
		field.setData(ID_TEST_VALUE);
		assertEquals(ID_TEST_VALUE, field.getData());
		assertEquals(ID_TEST_VALUE, entity.getFields().getData("id"));
		assertEquals(ID_TEST_VALUE, entity.getData("id"));
	}

	@Test
	public final void setValueStringFromEntityIsRetrivable() {
		entity.setDataString("id", ID_TEST_VALUE_STRING);
		Field<?> field = entity.getFields().getField("id");
		assertEquals(ID_TEST_VALUE, field.getData());
		assertEquals(ID_TEST_VALUE, entity.getFields().getData("id"));
		assertEquals(ID_TEST_VALUE, entity.getData("id"));
	}

	@Test
	public final void setValueStringFromFieldsIsRetrivable() {
		entity.getFields().setDataString("id", ID_TEST_VALUE_STRING);
		Field<?> field = entity.getFields().getField("id");
		assertEquals(ID_TEST_VALUE, field.getData());
		assertEquals(ID_TEST_VALUE, entity.getFields().getData("id"));
		assertEquals(ID_TEST_VALUE, entity.getData("id"));
	}

	@Test
	public final void setValueStringFromFieldIsRetrivable() {
		Field<?> field = entity.getFields().getField("id");
		field.setDataString(ID_TEST_VALUE_STRING);
		assertEquals(ID_TEST_VALUE, field.getData());
		assertEquals(ID_TEST_VALUE, entity.getFields().getData("id"));
		assertEquals(ID_TEST_VALUE, entity.getData("id"));
	}

	@Test
	public final void setValueFromFieldsIsRetrivableFromEntity() {
		entity.getFields().setData("id", ID_TEST_VALUE);
		assertEquals(ID_TEST_VALUE, entity.getId());
	}

	@Test
	public final void setValueFromEntityIsRetrivableFromField() {
		entity.setId(ID_TEST_VALUE);
		assertEquals(ID_TEST_VALUE, entity.getFields().getData("id"));
	}

	@Test
	public final void setDefaultValueFromEntityDoSetDefaultValue() {
		entity.setDefaultValue();
		assertEquals(25, entity.getFields().getData("id"));
		assertTrue((Boolean) entity.getFields().getData("fieldBool"));
	}

	@Test(expected = UnsupportedOperationException.class)
	public void entityWithInvalidDataThrowException() throws Exception {
		new TestEntityInvalid();
	}
}
