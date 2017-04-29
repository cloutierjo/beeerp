package net.jc.beeerp.module;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.jc.beeerp.module.field.Field;
import net.jc.beeerp.module.field.Fields;

@RunWith(MockitoJUnitRunner.class)
public class EntityTest {

	private static final int DATA_VALUE = 42;
	private static final String TO_STRING_RETURN_VALUE = "thisData";

	private Entity entity;

	@Mock
	private Fields fields;
	@SuppressWarnings("rawtypes")
	@Mock
	private Field field;

	@Before
	public void setUp() throws Exception {
		when(fields.getField(anyString())).thenReturn(field);
		entity = new Entity(fields);
	}

	@Test
	public final void constructorWork() {
		assertNotNull(entity);
	}

	@Test
	public final void getFieldsReturnTheOriginalFields() {
		assertEquals(fields, entity.getFields());
	}

	@Test
	public final void testToString() {
		when(fields.toString()).thenReturn(TO_STRING_RETURN_VALUE);
		assertEquals(TO_STRING_RETURN_VALUE, entity.toString());
	}

	@Test
	public final void testGetData() {
		when(fields.getData(anyString())).thenReturn(DATA_VALUE);
		assertEquals(DATA_VALUE, entity.getData(anyString()));
	}

	@Test
	public final void testSetData() {
		entity.setData("", DATA_VALUE);
		verify(fields).setData(anyString(), eq(DATA_VALUE));
	}

	@Test
	public final void hashCodeReturnAPositiveValue() {
		assertTrue(entity.hashCode()>0);
	}

	@Test
	public final void equalsReturnFalseWhenSecondIsNull() {
		assertFalse(entity.equals(null));
	}

	@Test
	public final void equalsReturnTrueWhenSecondIsSameInstance() {
		assertTrue(entity.equals(entity));
	}

	@Test
	public final void defaultEntitySetDefaultValueDoesNothing() {
		entity.setDefaultValue();
		assertNotNull(entity);
	}

}
