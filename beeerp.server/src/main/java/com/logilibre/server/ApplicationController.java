package com.logilibre.server;

import static com.logilibre.module.timesheet.jooq.Tables.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.logilibre.module.timesheet.entities.WeeklyTime;
import com.logilibre.orm.Orm;

@Controller
@RequestMapping("/")
public class ApplicationController {
	final Logger log = LoggerFactory.getLogger(ApplicationController.class);

	@RequestMapping(value = "/timesheet/weekly_time/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable Integer id, ModelMap model) {
		log.debug("get '{}' entity", id);
		Orm orm = new Orm();
		WeeklyTime weeklyTime = orm.get(WEEKLY_TIME, WeeklyTime.class, id);

		model.addAttribute("value", weeklyTime);

		return "index";
	}

	@RequestMapping(value = "/timesheet/weekly_time/add", method = RequestMethod.GET)
	public String getadd(ModelMap model) {
		log.debug("getadd default entity");
		WeeklyTime weeklyTime = new WeeklyTime();
		weeklyTime.setDate(new Date(Calendar.getInstance().getTimeInMillis()));
		weeklyTime.setTime(1.);
		model.addAttribute("value", weeklyTime);

		return "index";
	}

	@RequestMapping(value = "/timesheet/weekly_time/add", method = RequestMethod.POST)
	public String postadd(ModelMap model, @RequestParam Map<String, String> param) {
		log.debug("postadd new entity");
		WeeklyTime weeklyTime = new WeeklyTime();
		weeklyTime.getFields().setDataString("date", param.get("date"));
		weeklyTime.getFields().setDataString("time", param.get("time"));

		Orm orm = new Orm();
		Integer newId = orm.add(WEEKLY_TIME, weeklyTime);

		model.addAttribute("value", weeklyTime);
		System.out.println(param);
		return "redirect:/timesheet/weekly_time/get/" + newId;
	}

	@RequestMapping(value = "/timesheet/weekly_time/update/{id}", method = RequestMethod.GET)
	public String getupdate(@PathVariable Integer id, ModelMap model) {
		log.debug("getupdate '{}' entity", id);
		return get(id, model);
	}

	@RequestMapping(value = "/timesheet/weekly_time/update/{id}", method = RequestMethod.POST)
	public String postupdate(@PathVariable Integer id, ModelMap model, @RequestParam Map<String, String> param) {
		log.debug("postupdate '{}' entity", id);
		Orm orm = new Orm();
		WeeklyTime weeklyTime = orm.get(WEEKLY_TIME, WeeklyTime.class, id);

		weeklyTime.getFields().setDataString("date", param.get("date"));
		weeklyTime.getFields().setDataString("time", param.get("time"));

		orm.update(WEEKLY_TIME, weeklyTime);

		model.addAttribute("value", weeklyTime);
		log.debug("postupdate data: {}", param);
		return "index";
	}

	@RequestMapping(value = "/timesheet/weekly_time/delete/{id}", method = RequestMethod.GET)
	public String getdelete(@PathVariable Integer id, ModelMap model) {
		log.debug("getdelete '{}' entity", id);
		return get(id, model);
	}

	@RequestMapping(value = "/timesheet/weekly_time/delete/{id}", method = RequestMethod.POST)
	public String postdelete(@PathVariable Integer id, HttpServletResponse httpServletResponse) {
		log.debug("postdelete '{}' entity", id);
		Orm orm = new Orm();
		orm.delete(WEEKLY_TIME, id);

		return "redirect:/timesheet/weekly_time/get/1";
	}
}