package com.logilibre.orm.it;

import static com.logilibre.module.timesheet.jooq.Tables.*;
import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.Before;
import org.junit.Test;

import com.logilibre.module.timesheet.entities.WeeklyTime;
import com.logilibre.orm.Orm;

public class OrmIT {
	private static final double INITIAL_TIME = 1.;
	private static final Date INITIAL_DATE = new Date(LocalDate.of(2003, 5, 16).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
	private static final double UPDATED_TIME = 5.;
	private static final Date UPDATED_DATE = new Date(LocalDate.of(2008, 9, 27).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
	Orm ormTest;

	@Before
	public void setup() {
		ormTest = new Orm();
	}

	@Test
	public void addRecordTest() throws Exception {
		Integer id = null;
		try {
			WeeklyTime weeklyTime = getWeeklyTimeTestValue();
			id = ormTest.add(WEEKLY_TIME, weeklyTime);
			assertNotNull(id);
			assertNotSame(0, id);
		} finally {
			ormTest.delete(WEEKLY_TIME, id);
		}
	}

	@Test
	public void selectRecordTest() throws Exception {
		Integer id = null;
		try {
			WeeklyTime weeklyTime = getWeeklyTimeTestValue();
			id = ormTest.add(WEEKLY_TIME, weeklyTime);

			WeeklyTime weeklyTimeTest = ormTest.get(WEEKLY_TIME, WeeklyTime.class, id);
			assertEquals(INITIAL_DATE, weeklyTimeTest.getDate());
			assertEquals(INITIAL_TIME, weeklyTimeTest.getTime(), .01);
		} finally {
			ormTest.delete(WEEKLY_TIME, id);
		}
	}

	@Test
	public void updateRecordTest() throws Exception {
		Integer id = null;
		try {
			WeeklyTime weeklyTime = getWeeklyTimeTestValue();
			id = ormTest.add(WEEKLY_TIME, weeklyTime);

			WeeklyTime weeklyTimeToUpdate = ormTest.get(WEEKLY_TIME, WeeklyTime.class, id);

			weeklyTimeToUpdate.setDate(UPDATED_DATE);
			weeklyTimeToUpdate.setTime(UPDATED_TIME);

			ormTest.update(WEEKLY_TIME, weeklyTimeToUpdate);

			WeeklyTime weeklyTimeTest = ormTest.get(WEEKLY_TIME, WeeklyTime.class, id);
			assertEquals(UPDATED_DATE, weeklyTimeTest.getDate());
			assertEquals(UPDATED_TIME, weeklyTimeTest.getTime(), .01);
		} finally {
			ormTest.delete(WEEKLY_TIME, id);
		}
	}

	@Test
	public void deleteRecordTest() throws Exception {
		Integer id = null;
		try {
			WeeklyTime weeklyTime = getWeeklyTimeTestValue();
			id = ormTest.add(WEEKLY_TIME, weeklyTime);

			ormTest.delete(WEEKLY_TIME, id);

			WeeklyTime weeklyTimeTest = ormTest.get(WEEKLY_TIME, WeeklyTime.class, id);
			assertNull(weeklyTimeTest);
		} finally {
			ormTest.delete(WEEKLY_TIME, id);
		}
	}

	private WeeklyTime getWeeklyTimeTestValue() {
		WeeklyTime weeklyTime = new WeeklyTime();

		weeklyTime.setDate(INITIAL_DATE);
		weeklyTime.setTime(INITIAL_TIME);
		return weeklyTime;
	}
}