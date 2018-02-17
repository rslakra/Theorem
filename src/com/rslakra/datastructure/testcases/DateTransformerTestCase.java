/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 * 
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *      
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.datastructure.testcases;

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
