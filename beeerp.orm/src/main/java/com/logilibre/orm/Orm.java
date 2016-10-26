package com.logilibre.orm;

import static org.jooq.impl.DSL.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.Table;
import org.jooq.UpdatableRecord;
import org.jooq.conf.Settings;

import net.jc.beeerp.module.Entity;

public class Orm {

	public <E extends Entity> E get(Table<? extends UpdatableRecord<?>> table, Class<E> type, Integer id) {
		try (Connection conn = getConnection()) {
			DSLContext sql = getSqlContext(conn);
			Field<Integer> fieldId = getFieldId(table);
			return sql.selectFrom(table).where(fieldId.equal(id)).fetchAnyInto(type);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Integer add(Table<? extends UpdatableRecord<?>> table, Entity entity) {
		try (Connection conn = getConnection()) {
			DSLContext sql = getSqlContext(conn);

			UpdatableRecord<?> newRecord = sql.newRecord(table, entity);
			newRecord.store();

			Field<Integer> fieldId = getFieldId(table);
			return newRecord.getValue(fieldId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Table<? extends UpdatableRecord<?>> table, Entity entity) {
		try (Connection conn = getConnection()) {
			DSLContext sql = getSqlContext(conn);

			UpdatableRecord<?> record = sql.newRecord(table, entity);
			record.update();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(Table<? extends UpdatableRecord<?>> table, Integer id) {
		try (Connection conn = getConnection()) {
			DSLContext sql = getSqlContext(conn);
			Field<Integer> fieldId = getFieldId(table);
			sql.delete(table).where(fieldId.equal(id)).execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Field<Integer> getFieldId(Table<?> table) {
		Field<?> field = table.field("id");
		if (field.getType().isAssignableFrom(Integer.class)) {
			@SuppressWarnings("unchecked")
			Field<Integer> fieldId = (Field<Integer>) field;
			return fieldId;
		}
		throw new RuntimeException("no 'id' field on this entity");
	}

	private Connection getConnection() {
		String userName = "postgres";
		String password = "";
		String url = "jdbc:postgresql:beeerp";
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		Connection conn;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return conn;
	}

	private DSLContext getSqlContext(Connection conn) {
		return using(conn, SQLDialect.POSTGRES,
				new Settings().withRenderFormatted(Boolean.TRUE));
	}
}