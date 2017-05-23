package net.jc.beeerp.module;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.jc.beeerp.module.field.Fields;

@RunWith(MockitoJUnitRunner.class)
public class EntityTest {

	private static final String TO_STRING_RETURN_VALUE = "thisData";

	private Entity entity;

	@Mock
	private Fields fields;

	@Before
	public void setUp() throws Exception {
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

	@Test(expected = UnsupportedOperationException.class)
	public void getIdNotImplementedByDefaut() throws Exception {
		entity.getId();
	}
}
