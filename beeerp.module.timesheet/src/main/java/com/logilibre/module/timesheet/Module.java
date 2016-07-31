package com.logilibre.module.timesheet;

import com.logilibre.module.timesheet.entities.WageStates;
import com.logilibre.module.timesheet.entities.WeeklyTime;
import com.logilibre.module.timesheet.jooq.Tables;

import net.jc.beeerp.module.EntityDefinition;
import net.jc.beeerp.module.ModuleDefinition;

public class Module extends ModuleDefinition {


	public Module() {
		addTable("weekly_time", new EntityDefinition<>(Tables.WEEKLY_TIME, WeeklyTime.class));
		addTable("wage_states", new EntityDefinition<>(Tables.WAGE_STATES, WageStates.class));
	}

	@Override
	public String getName() {
		return "timesheet";
	}
}
