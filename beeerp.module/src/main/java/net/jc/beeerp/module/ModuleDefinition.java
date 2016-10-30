package net.jc.beeerp.module;

import java.util.HashMap;
import java.util.Map;

public abstract class ModuleDefinition {

	private Map<String, EntityDefinition<?, ?>> tables;

	public ModuleDefinition() {
		tables = new HashMap<>();
	}

	public abstract String getName();

	public EntityDefinition<?, ?> getEntity(String tableName) {
		return tables.get(tableName);
	}

	protected void addTable(String tableName, EntityDefinition<?, ?> entityDefinition) {
		tables.put(tableName, entityDefinition);
	}
}
