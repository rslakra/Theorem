/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 * 
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 * 
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 * 
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.rslakra.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2018-08-28 09:44:52 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class SumPair {
	
	/**
	 * Given an array of unique integers, return a pair of integers that sum up
	 * to a target sum.
	 * 
	 * @param numbers
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		if (numbers != null) {
			final Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < numbers.length; i++) {
				if (map.containsKey(target - numbers[i])) {
					result[1] = i + 1;
					result[0] = map.get(target - numbers[i]);
					return result;
				}
				map.put(numbers[i], i + 1);
			}
		}
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] values = { 2, 1, 3, 4, 8, 0, 9 };
		final int[] pairs = twoSum(values, 6);
		System.out.println(Arrays.toString(pairs));
	}
	
}
