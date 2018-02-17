package com.rslakra.datastructure.testcases;

/**
 * A class that handles the date and it's manipulations.
 * 
 * @author Rohtash Singh Lakra
 */
public class Date {
	
	/* MIN_YEAR */
	protected static final int MIN_YEAR = 1601;
	/* year */
	private int year;
	/* month */
	private int month;
	/* day */
	private int day;
	
	/**
	 * Initialize the date with the parameterized values.
	 * 
	 * @param year
	 * @param month
	 * @param day
	 */
	public Date(int year, int month, int day) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	/**
	 * Returns true if the year is greater than MIN_YEAR otherwise false.
	 * 
	 * @param year
	 * @return
	 */
	private boolean isValidYear(int year) {
		if(year > MIN_YEAR) {
			return true;
		} else {
			throw new IllegalArgumentException("Invalid Month:" + getMonth());
		}
	}
	
	/**
	 * Returns true if the day is valid.
	 * 
	 * @param day
	 * @return
	 */
	private boolean isValidMonth(int month) {
		if(month > 0 && month <= 12) {
			return true;
		} else {
			throw new IllegalArgumentException("Invalid Month:" + getMonth());
		}
	}
	
	/**
	 * Returns true if the day is valid.
	 * 
	 * @param day
	 * @return
	 */
	private boolean isValidDay(int day) {
		if(day > 0 && (isExtendedMonth() ? day <= 31 : (isStandardMonth() ? day <= 30 : (isLeapMonth() ? day <= 29 : day <= 28)))) {
			return true;
		} else {
			throw new IllegalArgumentException("Invalid day:" + getDay() + " of month:" + getMonth());
		}
	}
	
	/**
	 * Returns the year.
	 * 
	 * @return
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * The year to be set.
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		if(isValidYear(year)) {
			this.year = year;
		}
	}
	
	/**
	 * Returns the month.
	 * 
	 * @return
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * The month to be set.
	 * 
	 * @param month
	 */
	public void setMonth(int month) {
		if(isValidMonth(month)) {
			this.month = month;
		}
	}
	
	/**
	 * Retutns the day.
	 * 
	 * @return
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * The day to be set.
	 * 
	 * @param day
	 */
	public void setDay(int day) {
		if(isValidDay(day)) {
			this.day = day;
		}
	}
	
	/**
	 * Returns true if the year is leap year otherwise false.
	 * Note:
	 * A year is a leap year if either (i) it is divisible by 4 but not by 100
	 * or (ii) it is divisible by 400.
	 * 
	 * @return
	 */
	public boolean isLeapYear() {
		return ((getYear() % 400 == 0) || (getYear() % 4 == 0 && getYear() % 100 != 0));
	}
	
	/**
	 * Returns true if the month is 30 days otherwise false.
	 * 
	 * @return
	 */
	protected boolean isStandardMonth() {
		switch(getMonth()) {
			case 4:
			case 6:
			case 9:
			case 11:
				return true;
			
			default:
				return false;
		}
	}
	
	/**
	 * Returns true if the month is 31 days otherwise false.
	 * 
	 * @return
	 */
	protected boolean isExtendedMonth() {
		switch(getMonth()) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return true;
			
			default:
				return false;
		}
	}
	
	/**
	 * Returns true if the month is 29 days otherwise false.
	 * 
	 * @return
	 */
	protected boolean isLeapMonth() {
		return (getMonth() == 2 && isLeapYear());
	}
	
	/**
	 * Returns true if the day is the last day of the month otherwise false.
	 * 
	 * @return
	 */
	public boolean isLastDayOfMonth() {
		if(isExtendedMonth()) {
			return (isValidDay(31) && getDay() == 31);
		} else if(isStandardMonth()) {
			return (isValidDay(30) && getDay() == 30);
		} else if(isLeapMonth()) {
			return (isValidDay(29) && getDay() == 29);
		} else {
			return (isValidDay(28) && getDay() == 28);
		}
	}
	
	/**
	 * Returns true if the day is the first day of the month otherwise false.
	 * 
	 * @return
	 */
	public boolean isFirstDayOfMonth() {
		return (isValidDay(1) && getDay() == 1);
	}
	
	/**
	 * Returns true if the day is the last day of the month otherwise false.
	 * 
	 * @return
	 */
	public boolean isLastMonthOfYear() {
		return (isValidMonth(12) && getMonth() == 12);
	}
	
	/**
	 * Returns true if the day is the first day of the month otherwise false.
	 * 
	 * @return
	 */
	public boolean isFirstMonthOfYear() {
		return (isValidMonth(1) && getMonth() == 1);
	}
	
	/**
	 * Returns the string representation of this object.
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new StringBuilder().append(getMonth()).append("/").append(getDay()).append("/").append(getYear()).toString();
	}
	
}
