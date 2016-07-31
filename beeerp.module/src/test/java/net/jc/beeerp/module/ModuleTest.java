package net.jc.beeerp.module;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ModuleTest {

	private ModuleDefinition module;
	@Mock
	private static EntityDefinition<?, ?> entityDefinitionMock;

	private static final String MODULE_NAME = "modulename";
	private static final String TABLE_MOCK = "tableMock";

	@Before
	public void setup() {
		module = new ModuleMock();
	}

	@Test
	public void getName_returnName() {
		assertEquals(MODULE_NAME, module.getName());
	}

	@Test
	public void getEntity_returnEntityDefinition() {
		assertEquals(entityDefinitionMock, module.getEntity(TABLE_MOCK));
	}


	private static class ModuleMock extends ModuleDefinition{

		public ModuleMock() {
			addTable(TABLE_MOCK, entityDefinitionMock);
		}

		@Override
		public String getName() {
			return MODULE_NAME;
		}

	}
}
