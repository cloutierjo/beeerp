package com.logilibre.server;

import static com.logilibre.module.timesheet.jooq.Tables.*;
import static org.jooq.impl.DSL.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.logilibre.module.timesheet.entities.WeeklyTime;

@Controller
@RequestMapping("/")
public class ApplicationController {

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

	@RequestMapping(value = "/timesheet/weekly_time/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Integer id, ModelMap model) {

		Connection conn = getConnection();
		DSLContext sql = using(conn, SQLDialect.POSTGRES,
				new Settings().withRenderFormatted(true));
		WeeklyTime weeklyTime = sql.select().from(WEEKLY_TIME).where(WEEKLY_TIME.ID.equal(id))
				.fetchOneInto(WeeklyTime.class);
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("value", weeklyTime);

		return "index";
	}

	@RequestMapping(value = "/timesheet/weekly_time/add", method = RequestMethod.GET)
	public String getadd(ModelMap model) {
		WeeklyTime weeklyTime = new WeeklyTime();
		weeklyTime.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
		weeklyTime.setTime(1.);
		model.addAttribute("value", weeklyTime);

		return "index";
	}

	@RequestMapping(value = "/timesheet/weekly_time/add", method = RequestMethod.POST)
	public String postadd(ModelMap model, @RequestParam Map<String, String> param) {
		WeeklyTime weeklyTime = new WeeklyTime();
		weeklyTime.setDataString("date", param.get("date"));
		weeklyTime.setDataString("time", param.get("time"));

		Connection conn = getConnection();
		DSLContext sql = using(conn, SQLDialect.POSTGRES,
				new Settings().withRenderFormatted(true));

		sql.newRecord(WEEKLY_TIME, weeklyTime).store();
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("value", weeklyTime);
		System.out.println(param);
		return "index";
	}

	@RequestMapping(value = "/timesheet/weekly_time/update/{id}", method = RequestMethod.GET)
	public String getupdate(@PathVariable Integer id, ModelMap model) {

		Connection conn = getConnection();
		DSLContext sql = using(conn, SQLDialect.POSTGRES,
				new Settings().withRenderFormatted(true));
		WeeklyTime weeklyTime = sql.select().from(WEEKLY_TIME).where(WEEKLY_TIME.ID.equal(id))
				.fetchOneInto(WeeklyTime.class);
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("value", weeklyTime);

		return "index";
	}

	@RequestMapping(value = "/timesheet/weekly_time/update/{id}", method = RequestMethod.POST)
	public String postupdate(@PathVariable Integer id, ModelMap model, @RequestParam Map<String, String> param) {
		Connection conn = getConnection();
		DSLContext sql = using(conn, SQLDialect.POSTGRES,
				new Settings().withRenderFormatted(true));
		WeeklyTime weeklyTime = sql.select().from(WEEKLY_TIME).where(WEEKLY_TIME.ID.equal(id))
				.fetchOneInto(WeeklyTime.class);

		weeklyTime.setDataString("date", param.get("date"));
		weeklyTime.setDataString("time", param.get("time"));

		sql.newRecord(WEEKLY_TIME, weeklyTime).update();
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("value", weeklyTime);
		System.out.println(param);
		return "index";
	}

	@RequestMapping(value = "/timesheet/weekly_time/delete/{id}", method = RequestMethod.GET)
	public String getdelete(@PathVariable Integer id, ModelMap model) {

		Connection conn = getConnection();
		DSLContext sql = using(conn, SQLDialect.POSTGRES,
				new Settings().withRenderFormatted(true));
		WeeklyTime weeklyTime = sql.select().from(WEEKLY_TIME).where(WEEKLY_TIME.ID.equal(id))
				.fetchOneInto(WeeklyTime.class);
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		model.addAttribute("value", weeklyTime);

		return "index";
	}

	@RequestMapping(value = "/timesheet/weekly_time/delete/{id}", method = RequestMethod.POST)
	public String postdelete(@PathVariable Integer id, HttpServletResponse httpServletResponse) {

		Connection conn = getConnection();
		DSLContext sql = using(conn, SQLDialect.POSTGRES,
				new Settings().withRenderFormatted(true));
		sql.delete(WEEKLY_TIME).where(WEEKLY_TIME.ID.equal(id)).execute();
		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return "redirect:/timesheet/weekly_time/get/1";
	}
}