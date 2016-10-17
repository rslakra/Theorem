package com.rslakra.testcases;

import com.rslakra.core.Date;

public class DateTestCase {
	
	public static void main(String[] args) {
		
		Date myDate = new Date(1905, 2, 13);
		Date yourDate = new Date(1983, 6, 01);
		Date ourDate = new Date(2000, 10, 29);
		System.out.println("myDate:" + myDate + ", Leap Year:" + myDate.isLeapYear());
		System.out.println("yourDate:" + yourDate+ ", Leap Year:" + yourDate.isLeapYear());
		System.out.println("ourDate:" + ourDate+ ", Leap Year:" + ourDate.isLeapYear());
		
		Date today = new Date(1905, 12, 31);
		System.out.println("today:" + today+ ", Leap Year:" + today.isLeapYear());
		System.out.println("LastDayOfMonth:" + today.isLastDayOfMonth());
		System.out.println("LastMonthOfYear:" + today.isLastMonthOfYear());
		
		Date date = new Date(2020, 10, 29);
		System.out.println("myDate:" + date + ", Leap Year:" + date.isLeapYear());

	}
	
}
