package net.jc.beeerp.module;

import static org.junit.Assert.*;

import org.jooq.Table;
import org.jooq.UpdatableRecord;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import net.jc.beeerp.it.module.testdata.TestEntity;

@RunWith(MockitoJUnitRunner.class)
public class EntityDefinitionTest<R extends UpdatableRecord<R>> {

	@Mock
	Table<R> tableMock;
	EntityDefinition<?, ?> entityDefinition;

	@Before
	public void setUp() throws Exception {
		entityDefinition = new EntityDefinition<>(tableMock, TestEntity.class);
	}

	@Test
	public void getTable_returnConstructedTable() {
		assertSame(tableMock, entityDefinition.getTable());
	}

	@Test
	public void getEntity_returnEntityClass() {
		assertSame(TestEntity.class, entityDefinition.getEntity());
	}

	@Test
	public void getEmptyEntity_returnEmptyEntity() {
		Entity emptyEntity = entityDefinition.getEmptyEntity();
		assertNotNull(emptyEntity);
		assertTrue(emptyEntity instanceof TestEntity);
	}
}
