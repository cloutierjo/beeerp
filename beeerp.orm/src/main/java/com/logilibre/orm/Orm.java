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

public class Orm {

	// public String get(Integer id) {
	//
	// Connection conn = getConnection();
	// DSLContext sql = getSqlContext(conn);
	// WeeklyTime weeklyTime = sql.select().from(WEEKLY_TIME).where(WEEKLY_TIME.ID.equal(id))
	// .fetchOneInto(WeeklyTime.class);
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// throw new RuntimeException(e);
	// }
	// }

	// public String add(org.jooq.Table<?> table, Entity entity) {
	// try (Connection conn = getConnection()) {
	// DSLContext sql = getSqlContext(conn);
	//
	// sql.newRecord(table, entity).store();
	// } catch (SQLException e) {
	// throw new RuntimeException(e);
	// }
	// }

	// public String update(Integer id, ModelMap model, Map<String, String> param) {
	// Connection conn = getConnection();
	// DSLContext sql = getSqlContext(conn);
	// WeeklyTime weeklyTime = sql.select().from(WEEKLY_TIME).where(WEEKLY_TIME.ID.equal(id))
	// .fetchOneInto(WeeklyTime.class);
	//
	// weeklyTime.setDataString("date", param.get("date"));
	// weeklyTime.setDataString("time", param.get("time"));
	//
	// sql.newRecord(WEEKLY_TIME, weeklyTime).update();
	// try {
	// conn.close();
	// } catch (SQLException e) {
	// throw new RuntimeException(e);
	// }
	// }

	public void delete(TableImpl<?> table, Integer id) {

		try (Connection conn = getConnection()) {
			DSLContext sql = getSqlContext(conn);
			Field<?> field = table.field("id");
			if (field.getType().isAssignableFrom(Integer.class)) {
				@SuppressWarnings("unchecked")
				Field<Integer> fieldId = (Field<Integer>) field;
				sql.delete(table).where(fieldId.equal(id)).execute();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
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