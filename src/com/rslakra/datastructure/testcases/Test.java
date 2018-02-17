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

public class Test {
	
	/**
	 * 
	 * @param str
	 * @return
	 */
	public static boolean findDuplicateChars(String str) {
		int checker = 0;
		for(int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			int leftShift = (1 << val);
			int result = (checker & leftShift);
			System.out.println("checker: " + checker + ", val: " + val + ", leftShift: " + leftShift + ", result: " + result);
			if(result > 0)
				return false;
			checker |= leftShift;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(findDuplicateChars("abc"));
		System.out.println(findDuplicateChars("bcdb"));
	}
	
}
