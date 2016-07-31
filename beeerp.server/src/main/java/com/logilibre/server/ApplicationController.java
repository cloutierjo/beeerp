package com.logilibre.server;

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

	@RequestMapping(value = "/{module}/{entity}/add", method = RequestMethod.GET)
	public String getadd(@PathVariable String module, @PathVariable String entity, ModelMap model) {
		log.debug("getadd '{}/{}' entity", module, entity);

		ModuleDefinition moduleDefinition = new ModuleRegistry().get(module);
		EntityDefinition<?, ?> entityDef = moduleDefinition.getEntity(entity);
		Entity entityValue = entityDef.getDefaultEntity();
		model.addAttribute("value", entityValue);

		return "index";
	}

	@RequestMapping(value = "/{module}/{entity}/add", method = RequestMethod.POST)
	public String postadd(@PathVariable String module, @PathVariable String entity, ModelMap model, @RequestParam Map<String, String> param) {
		log.debug("postadd '{}/{}' entity", module, entity);

		ModuleDefinition moduleDefinition = new ModuleRegistry().get(module);
		EntityDefinition<?, ?> entityDef = moduleDefinition.getEntity(entity);
		Entity entityValue = entityDef.getEmptyEntity();
		updateEntity(param, entityValue);

		Integer newId = orm.add(entityDef.getTable(), entityValue);

		model.addAttribute("value", entityValue);
		log.debug("postadd data: {}", param);
		return String.format("redirect:/%s/%s/get/%s", module, entity, newId);
	}

	@RequestMapping(value = "/{module}/{entity}/update/{id}", method = RequestMethod.GET)
	public String getupdate(@PathVariable String module, @PathVariable String entity, @PathVariable Integer id, ModelMap model) {
		log.debug("getupdate '{}/{}/{}' entity", module, entity, id);
		return get(module, entity, id, model);
	}

	@RequestMapping(value = "/{module}/{entity}/update/{id}", method = RequestMethod.POST)
	public String postupdate(@PathVariable String module, @PathVariable String entity, @PathVariable Integer id, ModelMap model,
			@RequestParam Map<String, String> param) {
		log.debug("postupdate '{}' entity", id);

		ModuleDefinition moduleDefinition = new ModuleRegistry().get(module);
		EntityDefinition<?, ?> entityDef = moduleDefinition.getEntity(entity);
		Entity entityValue = orm.get(entityDef.getTable(), entityDef.getEntity(), id);

		updateEntity(param, entityValue);

		orm.update(entityDef.getTable(), entityValue);

		model.addAttribute("value", entityValue);
		log.debug("postupdate data: {}", param);
		return "index";
	}

	@RequestMapping(value = "/{module}/{entity}/delete/{id}", method = RequestMethod.GET)
	public String getdelete(@PathVariable String module, @PathVariable String entity, @PathVariable Integer id, ModelMap model) {
		log.debug("getdelete '{}/{}/{}' entity", module, entity, id);
		return get(module, entity, id, model);
	}

	@RequestMapping(value = "/{module}/{entity}/delete/{id}", method = RequestMethod.POST)
	public String postdelete(@PathVariable String module, @PathVariable String entity, @PathVariable Integer id,
			HttpServletResponse httpServletResponse) {
		log.debug("postdelete '{}/{}/{}' entity", module, entity, id);

		ModuleDefinition moduleDefinition = new ModuleRegistry().get(module);
		EntityDefinition<?, ?> entityDef = moduleDefinition.getEntity(entity);
		orm.delete(entityDef.getTable(), id);

		return String.format("redirect:/%s/%s/get/1", module, entity);
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