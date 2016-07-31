package com.logilibre.server;

import static com.logilibre.module.timesheet.jooq.Tables.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;

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

import net.jc.beeerp.module.Entity;
import net.jc.beeerp.module.EntityDefinition;
import net.jc.beeerp.module.ModuleDefinition;
import net.jc.beeerp.module.field.Field;
import net.jc.beeerp.module.field.Fields;

@Controller
@RequestMapping("/")
public class ApplicationController {
	final Logger log = LoggerFactory.getLogger(ApplicationController.class);
	private Orm orm = new Orm();

	@RequestMapping(value = "/{module}/{entity}/get/{id}", method = RequestMethod.GET)
	public String get(@PathVariable String module, @PathVariable String entity, @PathVariable Integer id, ModelMap model) {
		log.debug("get '{}/{}/{}' entity", module,entity, id);

		ModuleDefinition moduleDefinition = new ModuleRegistry().get(module);
		EntityDefinition<?, ?> entityDef = moduleDefinition.getEntity(entity);
		Entity entityValue = orm.get(entityDef.getTable(), entityDef.getEntity(), id);

		model.addAttribute("value", entityValue);

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
		Entity entity = new WeeklyTime();
		updateEntity(param, entity);

		Integer newId = orm.add(WEEKLY_TIME, entity);

		model.addAttribute("value", entity);
		log.debug("postadd data: {}", param);
		return "redirect:/timesheet/weekly_time/get/" + newId;
	}

	@RequestMapping(value = "/timesheet/weekly_time/update/{id}", method = RequestMethod.GET)
	public String getupdate(@PathVariable Integer id, ModelMap model) {
		log.debug("getupdate '{}' entity", id);
		return get("timesheet", "weekly_time", id, model);
	}

	@RequestMapping(value = "/timesheet/weekly_time/update/{id}", method = RequestMethod.POST)
	public String postupdate(@PathVariable Integer id, ModelMap model, @RequestParam Map<String, String> param) {
		log.debug("postupdate '{}' entity", id);
		Entity entity = orm.get(WEEKLY_TIME, WeeklyTime.class, id);

		updateEntity(param, entity);

		orm.update(WEEKLY_TIME, entity);

		model.addAttribute("value", entity);
		log.debug("postupdate data: {}", param);
		return "index";
	}

	@RequestMapping(value = "/timesheet/weekly_time/delete/{id}", method = RequestMethod.GET)
	public String getdelete(@PathVariable Integer id, ModelMap model) {
		log.debug("getdelete '{}' entity", id);
		return get("timesheet", "weekly_time", id, model);
	}

	@RequestMapping(value = "/timesheet/weekly_time/delete/{id}", method = RequestMethod.POST)
	public String postdelete(@PathVariable Integer id, HttpServletResponse httpServletResponse) {
		log.debug("postdelete '{}' entity", id);
		orm.delete(WEEKLY_TIME, id);

		return "redirect:/timesheet/weekly_time/get/1";
	}

	private void updateEntity(Map<String, String> param, Entity entity) {
		Fields fields = entity.getFields();
		for(Entry<String, String> paramEntry:param.entrySet()){
			String paramName = paramEntry.getKey();
			String paramValue = paramEntry.getValue();
			Field<?> field = fields.getField(paramName);
			if(field != null){
				field.setDataString(paramValue);
			}
		}
	}
}