package com.logilibre.module.timesheet.entities;

import java.sql.Date;
import java.util.Calendar;

import net.jc.beeerp.module.Entity;
import net.jcs.jboildown.annotation.Getter;
import net.jcs.jboildown.annotation.Setter;

@Getter @Setter
public class WeeklyTime extends Entity implements
com.logilibre.module.timesheet.jooq.tables.interfaces.IWeeklyTime {

	private static final long serialVersionUID = -1959475316;

	private Integer id;
	private Date date;
	private Double time;
	private Double hollidayTimeUse;
	private Double lostOvertime;
	private Double sickTime;

	@Override
	public void setDefaultValue() {
		setId(null);
		setDate(new Date(Calendar.getInstance().getTimeInMillis()));
		setTime(1.);
	}

	// -------------------------------------------------------------------------
	// FROM and INTO
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void from(com.logilibre.module.timesheet.jooq.tables.interfaces.IWeeklyTime from) {
		setId(from.getId());
		setDate(from.getDate());
		setTime(from.getTime());
		setHollidayTimeUse(from.getHollidayTimeUse());
		setLostOvertime(from.getLostOvertime());
		setSickTime(from.getSickTime());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <E extends com.logilibre.module.timesheet.jooq.tables.interfaces.IWeeklyTime> E into(E into) {
		into.from(this);
		return into;
	}
}
