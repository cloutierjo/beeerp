package com.logilibre.orm.it;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.logilibre.module.timesheet.entities.WeeklyTime;
import com.logilibre.orm.Orm;

public class OrmIT {
	Orm ormTest;

	@Before
	public void setup() {
		ormTest = new Orm();
	}

	@Test
	public void addRecordTest() throws Exception {
		WeeklyTime weeklyTime = new WeeklyTime();
		weeklyTime.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
		weeklyTime.setTime(1.);
		// ormTest.add(WEEKLY_TIME, weeklyTime);
	}
}