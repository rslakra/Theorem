package com.rslakra.testcases;

import com.rslakra.core.Date;
import com.rslakra.core.DateTransformer;

public class DateTransformerTestCase {
	
	public static void main(String[] args) {
		DateTransformer myDate = new DateTransformer(1905, 2, 13);
		System.out.println("myDate:" + myDate);
		
		/*
		 * Increment Test-cases.
		 */
		Date tomorrow = myDate.increment();
		System.out.println("tomorrow:" + tomorrow);
		System.out.println();
		
		// Last Month of Year
		DateTransformer lastMonthOfYear = new DateTransformer(1905, 12, 31);
		System.out.println("lastMonthOfYear:" + lastMonthOfYear);
		Date nextDayOfLastMonthOfYear = lastMonthOfYear.increment();
		System.out.println("nextDayOfLastMonthOfYear:" + nextDayOfLastMonthOfYear);
		System.out.println();
		
		// Last day of Month
		DateTransformer lastDayOfMonth = new DateTransformer(1905, 11, 30);
		System.out.println("lastDayOfMonth:" + lastDayOfMonth);
		Date nextDayOfLastDayOfMonth = lastDayOfMonth.increment();
		System.out.println("nextDayOfLastDayOfMonth:" + nextDayOfLastDayOfMonth);
		System.out.println();
		System.out.println();
		/*
		 * Decrement Test-cases.
		 */
		DateTransformer todayDate = new DateTransformer(2016, 9, 2);
		System.out.println("todayDate:" + todayDate);
		
		Date yesterday = todayDate.decrement();
		System.out.println("yesterday:" + yesterday);
		System.out.println();
		
		// Last Month of Year
		DateTransformer firstMonthOfYear = new DateTransformer(2016, 1, 1);
		System.out.println("firstMonthOfYear:" + firstMonthOfYear);
		Date previousDayOfFirstMonthOfYear = firstMonthOfYear.decrement();
		System.out.println("previousDayOfFirstMonthOfYear:" + previousDayOfFirstMonthOfYear);
		System.out.println();
		
		// Last day of Month
		DateTransformer firstDayOfMonth = new DateTransformer(1905, 11, 1);
		System.out.println("firstDayOfMonth:" + firstDayOfMonth);
		Date previousDayOfFirstDayOfMonth = firstDayOfMonth.decrement();
		System.out.println("previousDayOfFirstDayOfMonth:" + previousDayOfFirstDayOfMonth);
		
	}
	
}
