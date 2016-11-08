package com.rslakra.testcases;

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
