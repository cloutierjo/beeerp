package beeerp.module.timesheet;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class DbTest {

	private Connection conn;

	@Before
	public void setUp() throws Exception {
		String userName = "postgres";
		String password = "";
		String url = "jdbc:postgresql:beeerp";

		conn = DriverManager.getConnection(url, userName, password);
	}

	@After
	public void tearDown() throws Exception {
		conn.close();
	}

	@Test
	@Ignore
	public final void selectSomeData() {
		// DSLContext sql = using(conn, SQLDialect.POSTGRES,
		// new Settings().withRenderFormatted(true));
		// List<WeeklyTime> into = sql.select().from(WEEKLY_TIME)
		// .fetchInto(WeeklyTime.class);
		//
		// for (WeeklyTime weeklyTime : into) {
		// System.out.println(weeklyTime.getTime());
		// }

	}

}
