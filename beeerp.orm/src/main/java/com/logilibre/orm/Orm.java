package com.logilibre.orm;

import static org.jooq.impl.DSL.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.TableImpl;
import org.jooq.impl.UpdatableRecordImpl;

import net.jc.beeerp.module.Entity;

public class Orm {

	public <E extends Entity> E get(TableImpl<? extends UpdatableRecordImpl<?>> table, Class<E> type, Integer id) {
		try (Connection conn = getConnection()) {
			DSLContext sql = getSqlContext(conn);
			Field<Integer> fieldId = getFieldId(table);
			return sql.selectFrom(table).where(fieldId.equal(id)).fetchAnyInto(type);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Integer add(TableImpl<? extends UpdatableRecordImpl<?>> table, Entity entity) {
		try (Connection conn = getConnection()) {
			DSLContext sql = getSqlContext(conn);

			UpdatableRecordImpl<?> newRecord = sql.newRecord(table, entity);
			newRecord.store();

			Field<Integer> fieldId = getFieldId(table);
			return newRecord.getValue(fieldId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(TableImpl<? extends UpdatableRecordImpl<?>> table, Entity entity) {
		try (Connection conn = getConnection()) {
			DSLContext sql = getSqlContext(conn);

			UpdatableRecordImpl<?> record = sql.newRecord(table, entity);
			record.update();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(TableImpl<? extends UpdatableRecordImpl<?>> table, Integer id) {
		try (Connection conn = getConnection()) {
			DSLContext sql = getSqlContext(conn);
			Field<Integer> fieldId = getFieldId(table);
			sql.delete(table).where(fieldId.equal(id)).execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Field<Integer> getFieldId(TableImpl<?> table) {
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
				new Settings().withRenderFormatted(true));
	}
}