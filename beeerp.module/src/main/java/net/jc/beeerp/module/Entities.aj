package net.jc.beeerp.module;

import net.jc.beeerp.module.field.Field;

/**
* Aspect that add the generic getter and setter in each {@link Entity} subclass
*/
privileged aspect Entities {
	declare parents: Entity+ && !Entity implements PropertiesAccessibleEntity;
	

	void around(): execution(void PropertiesAccessibleEntity.setData(String, Object, Field.Safety)){
		String fieldName =(String)thisJoinPoint.getArgs()[0];
		Object data =thisJoinPoint.getArgs()[1];
		Field.Safety safety =(Field.Safety)thisJoinPoint.getArgs()[2];
		
		if(safety==null){
			throw new IllegalAccessError("cannot setData from outside a Field");
		}
		try {
			java.lang.reflect.Field field = thisJoinPoint.getTarget().getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			field.set(thisJoinPoint.getTarget(), data);
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e) {			throw new RuntimeException(
						"couldn't get value from '" + fieldName + "' field on '" + getClass().getCanonicalName() + "' entity", e);
		}
	}

	Object around(PropertiesAccessibleEntity obj): execution(Object PropertiesAccessibleEntity.getData(String, Field.Safety)) && target(obj){
		String fieldName =(String)thisJoinPoint.getArgs()[0];
		Field.Safety safety =(Field.Safety)thisJoinPoint.getArgs()[1];
		
		if(safety==null){
			throw new IllegalAccessError("cannot getData from outside a Field");
		}
		try {
			java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(thisJoinPoint.getTarget());
		} catch (IllegalArgumentException | IllegalAccessException
				| NoSuchFieldException | SecurityException e) {			throw new RuntimeException(
						"couldn't get value from '" + fieldName + "' field on '" + getClass().getCanonicalName() + "' entity", e);
		}
	}
	/**
	 * Set the data to the specified field
	 * 
	 * @param fieldName The field name
	 * @param data the data to set
	 * @see net.jc.beeerp.module.field.Fields#setData(java.lang.String, java.lang.Object)
	 */
	public void PropertiesAccessibleEntity.setData(String fieldName, Object data, Field.Safety safety) {
	}

	/**
	 * Get the data from a specified field
	 * 
	 * @param fieldName The field name
	 * @return The data from the specified field
	 * @see net.jc.beeerp.module.field.Fields#getData(java.lang.String)
	 */
	public Object PropertiesAccessibleEntity.getData(String fieldName, Field.Safety safety) {
		return 1;
	}

//	public Integer WageStates.getId() {
//		return id;
//	}
//
//	public Integer WageStates.getWeeklyWage() {
//		return weeklyWage;
//	}
//
//	public Double WageStates.getHollidayRate() {
//		return hollidayRate;
//	}
//
//	public Double WageStates.getNormalWeekTime() {
//		return normalWeekTime;
//	}
//
//	public void WageStates.setId(Integer id) {
//		this.id = id;
//	}
//
//	public void WageStates.setWeeklyWage(Integer weeklyWage) {
//		this.weeklyWage = weeklyWage;
//	}
//
//	public void WageStates.setHollidayRate(Double hollidayRate) {
//		this.hollidayRate = hollidayRate;
//	}
//
//	public void WageStates.setNormalWeekTime(Double normalWeekTime) {
//		this.normalWeekTime = normalWeekTime;
//	}

}
