package com.logilibre.beeerp.module;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class EntityTest {

	private Entity entity;

	@Mock
	private Fields fields;
	
	@Before
	public void setUp() throws Exception {
		entity = new Entity(fields);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testEntity() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetFields() {
		fail("Not yet implemented");
	}

	@Test
	public final void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public final void testGetData() {
		fail("Not yet implemented");
	}

	@Test
	public final void testSetData() {
		fail("Not yet implemented");
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
	public final void equalsReturnTrueWhenSecondIsSimilareButNotSameInstance() {
		Entity secondEntity = new Entity(fields);
		assertTrue(entity.equals(secondEntity));
	}

}
