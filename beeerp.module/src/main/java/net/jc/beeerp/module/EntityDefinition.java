package net.jc.beeerp.module;

import org.jooq.Table;
import org.jooq.UpdatableRecord;

public class EntityDefinition<R extends UpdatableRecord<R>, E extends Entity> {

	private Table<R> table;
	private Class<E> entity;

	public EntityDefinition(Table<R> table, Class<E> entity) {
		this.table = table;
		this.entity = entity;
	}

	public Table<R> getTable() {
		return table;
	}

	public Class<E> getEntity() {
		return entity;
	}

	public E getEmptyEntity() {
		try {
			return entity.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);	// should never happen
		}
	}

	public Entity getDefaultEntity() {
		E newEntity = getEmptyEntity();
		newEntity.setDefaultValue();
		return newEntity;
	}
}
