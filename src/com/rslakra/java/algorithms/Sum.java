package com.rslakra.java.algorithms;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * For example:
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=0, index2=1
 * 
 * ==============
 * Two Sum III – Data structure design
 * ==============
 * 
 * 
 * Design and implement a TwoSum class. It should support the following
 * operations: add and find.
 * 
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the
 * value.
 * 
 * For example,
 * 
 * add(1);
 * add(3);
 * add(5);
 * find(4) -> true
 * find(7) -> false
 * 
 * 
 * 
 * @author Rohtash Singh Lakra
 * @date 02/15/2017 10:44:29 AM
 *
 */
public class Sum {
	private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
	
	public Sum() {
		
	}
	
	/**
	 * Returns the indexs of two values which sum is equal to target.
	 * 
	 * @param values
	 * @param target
	 * @return
	 */
	public static int[] twoSumTypeI(int[] values, int target) {
		int[] result = new int[2];
		if(values != null && target > 0) {
			HashMap<Integer, Integer> indexes = new HashMap<Integer, Integer>();
			for(int i = 0; i < values.length; i++) {
				if(indexes.containsKey(values[i])) {
					result[0] = indexes.get(values[i]);
					result[1] = i;
					break;
				} else {
					indexes.put(target - values[i], i);
				}
			}
			System.out.println(indexes);
		}
		
		return result;
	}
	
	/**
	 * Returns the indexs of two values which sum is equal to target.
	 * 
	 * @param values
	 * @param target
	 * @return
	 */
	public static int[] twoSumTypeII(int[] values, int target) {
		int[] result = new int[2];
		if(values != null && target > 0) {
			Arrays.sort(values);
			int i = 0, j = values.length - 1;
			while(i < j) {
				int sum = values[i] + values[j];
				if(sum < target) {
					i++;
				} else if(sum > target) {
					j--;
				} else {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Add the number to an internal data structure.
	 * 
	 * @param value
	 */
	public void add(int value) {
		if(elements.containsKey(value)) {
			elements.put(value, elements.get(value) + 1);
		} else {
			elements.put(value, 1);
		}
	}
	
	/**
	 * Find if there exists any pair of numbers which sum is equal to the value.
	 * 
	 * @param value
	 * @return
	 */
	public boolean find(int value) {
		System.out.println(elements);
		
		for(Integer key : elements.keySet()) {
			int target = value - key;
			if(elements.containsKey(target)) {
				if(target == key && elements.get(target) < 2) {
					continue;
				} else {
					return true;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] numbers = { 2, 7, 11, 15 };
		int[] numbers = { 2, 5, 9, 7, 11, 15 };
		int target = 9;
		// int[] results = Sum.twoSumTypeI(numbers, target);
		// int[] results = Sum.twoSumTypeII(numbers, target);
		// System.out.println(Arrays.toString(results));
		
		Sum sum = new Sum();
		sum.add(1);
		sum.add(2);
		sum.add(3);
		sum.add(5);
		System.out.println(sum.find(2));
		System.out.println(sum.find(4));
		System.out.println(sum.find(7));
		System.out.println(sum.find(13));
	}
	
}
