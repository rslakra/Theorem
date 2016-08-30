package com.rslakra.core;

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
		this.year = year;
		this.month = month;
		this.day = day;
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
		this.year = year;
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
		this.month = month;
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
		this.day = day;
	}
	
	/**
	 * Returns true if the year is divisible by 4 or 400 otherwise false.
	 * 
	 * @return
	 */
	public boolean isLeapYear() {
		return ((getYear() % 400 == 0) || (getYear() % 4 == 0));
	}
	
	/**
	 * Returns true if the day is valid.
	 * 
	 * @param day
	 * @return
	 */
	private boolean isValidMonth(int month) {
		if(getMonth() > 0 && getMonth() <= month) {
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
		if(getDay() > 0 && getDay() <= day) {
			return true;
		} else {
			throw new IllegalArgumentException("Invalid day:" + getDay() + " of month:" + getMonth());
		}
	}
	
	/**
	 * Returns true if the day is the last day of the month otherwise false.
	 * 
	 * @return
	 */
	public boolean isLastDayOfMonth() {
		switch(getMonth()) {
			case 2:
				return (isLeapYear() ? (isValidDay(29) && getDay() == 29) : (isValidDay(28) && getDay() == 28));
			case 4:
			case 6:
			case 9:
			case 11:
				return (isValidDay(30) && getDay() == 30);
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return (isValidDay(31) && getDay() == 31);
			
			default:
				throw new IllegalArgumentException("Invalid day:" + getDay() + " of month:" + getMonth());
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
