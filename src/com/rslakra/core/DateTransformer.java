package com.rslakra.core;

public class DateTransformer extends Date {
	private DateType dateType;
	
	/**
	 * 
	 * @param dateType
	 * @param year
	 * @param month
	 * @param day
	 */
	public DateTransformer(DateType dateType, int year, int month, int day) {
		super(year, month, day);
		this.dateType = dateType;
	}
	
	/**
	 * Increments the date to tomorrows date.
	 * @return
	 */
	public Date increment() {
		if(isLastMonthOfYear() && isLastDayOfMonth()){
			setYear(getYear() + 1);
			setMonth(1);
			setDay(1);
		}else if(isLastDayOfMonth()){
			setMonth(getMonth() + 1);
			setDay(1);
		}else {
			setDay(getDay() + 1);
		}
		
		return new Date(getYear(), getMonth(), getDay());
	}
	
	public Date decrement() {
		return null;
	}
	
}
