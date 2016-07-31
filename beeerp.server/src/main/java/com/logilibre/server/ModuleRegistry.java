package com.logilibre.server;

import java.util.HashMap;
import java.util.Map;

import com.logilibre.module.timesheet.Module;

import net.jc.beeerp.module.ModuleDefinition;

public class ModuleRegistry {

	Map<String, ModuleDefinition> modules;

	public ModuleRegistry() {
		modules = new HashMap<>();
		add(new Module());

	}

	public void add(ModuleDefinition module) {
		modules.put(module.getName(), module);
	}

	public ModuleDefinition get(String moduleName) {
		return modules.get(moduleName);
	}

}
