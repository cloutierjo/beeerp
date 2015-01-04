package com.logilibre.module.timesheet.entities;

import com.logilibre.module.timesheet.jooq.tables.interfaces.IWageStates;

import net.jcs.jboildown.annotation.Getter;
import net.jcs.jboildown.annotation.Setter;

@Getter @Setter
public class WageStates implements com.logilibre.module.timesheet.jooq.tables.interfaces.IWageStates {
 
	private static final long serialVersionUID = 427105034;

	private java.lang.Integer id;
	private java.lang.Integer weeklyWage;
	private java.lang.Double  hollidayRate;
	private java.lang.Double  normalWeekTime;

	@Override
	public void from(IWageStates from) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <E extends IWageStates> E into(E into) {
		// TODO Auto-generated method stub
		return null;
	}
}
