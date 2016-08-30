package com.rslakra.testcases;

import com.rslakra.core.Date;
import com.rslakra.core.DateTransformer;
import com.rslakra.core.DateType;

public class DateTransformerTestCase {
	
	public static void main(String[] args) {
		DateTransformer myDate = new DateTransformer(DateType.INCREMENT, 1905, 2, 13);
		System.out.println("myDate:" + myDate);
		Date tomorrow = myDate.increment();
		System.out.println("tomorrow:" + tomorrow);
		System.out.println();
		
		//Last Month of Year
		DateTransformer lastMonthOfYear = new DateTransformer(DateType.INCREMENT, 1905, 12, 31);
		System.out.println("lastMonthOfYear:" + lastMonthOfYear);
		Date nextDayOfLastMonthOfYear = lastMonthOfYear.increment();
		System.out.println("nextDayOfLastMonthOfYear:" + nextDayOfLastMonthOfYear);
		System.out.println();
		
		//Last day of Month
		DateTransformer lastDayOfMonth = new DateTransformer(DateType.INCREMENT, 1905, 11, 30);
		System.out.println("lastDayOfMonth:" + lastDayOfMonth);
		Date nextDayOfLastDayOfMonth = lastDayOfMonth.increment();
		System.out.println("nextDayOfLastDayOfMonth:" + nextDayOfLastDayOfMonth);
		
	}
	
}
