package com.logilibre.module.timesheet.entities;

import com.logilibre.module.timesheet.jooq.tables.interfaces.IWageStates;

import net.jc.beeerp.module.Entity;
import net.jcs.jboildown.annotation.Getter;
import net.jcs.jboildown.annotation.Setter;

@Getter @Setter
public class WageStates extends Entity implements com.logilibre.module.timesheet.jooq.tables.interfaces.IWageStates {

	private static final long serialVersionUID = 427105034;

	private java.lang.Integer id;
	private java.lang.Integer weeklyWage;
	private java.lang.Double  hollidayRate;
	private java.lang.Double  normalWeekTime;

	@Override
	public void from(IWageStates from) {
		setId(from.getId());
		setWeeklyWage(from.getWeeklyWage());
		setHollidayRate(from.getHollidayRate());
		setNormalWeekTime(from.getNormalWeekTime());
	}
	@Override
	public <E extends IWageStates> E into(E into) {
		into.from(this);
		return into;
	}
}
