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
