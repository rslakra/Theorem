package com.rslakra.datastructure.testcases;

public class DateTransformer extends Date {
//	private DateType dateType;
	
	/**
	 * 
	 * @param dateType
	 * @param year
	 * @param month
	 * @param day
	 */
	public DateTransformer(int year, int month, int day) {
		this(null, year, month, day);
	}
	
	/**
	 * 
	 * @param dateType
	 * @param year
	 * @param month
	 * @param day
	 */
	public DateTransformer(DateType dateType, int year, int month, int day) {
		super(year, month, day);
//		this.dateType = dateType;
	}
	
	
	/**
	 * Increments the date to tomorrow's date.
	 * 
	 * @return
	 */
	public Date increment() {
		if(isLastMonthOfYear() && isLastDayOfMonth()) {
			setYear(getYear() + 1);
			setMonth(1);
			setDay(1);
		} else if(isLastDayOfMonth()) {
			setMonth(getMonth() + 1);
			setDay(1);
		} else {
			setDay(getDay() + 1);
		}
		
		return new Date(getYear(), getMonth(), getDay());
	}
	
	/**
	 * Decrements the date to yesterday's date.
	 * 
	 * @return
	 */
	public Date decrement() {
		if(isFirstMonthOfYear() && isFirstDayOfMonth()) {
			setYear(getYear() - 1);
			setMonth(12);
			setDay(31);
		} else if(isFirstDayOfMonth()) {
			setMonth(getMonth() - 1);
			if(isExtendedMonth()) {
				setDay(31);
			} else if(isStandardMonth()) {
				setDay(30);
			} else if(isLeapMonth()) {
				setDay(29);
			} else {
				setDay(28);
			}
		} else {
			setDay(getDay() - 1);
		}
		
		return new Date(getYear(), getMonth(), getDay());
	}
	
}
