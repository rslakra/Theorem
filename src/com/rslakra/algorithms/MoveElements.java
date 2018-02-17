package com.rslakra.algorithms;

import java.util.Arrays;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 03/26/2017 05:34:02 PM
 */
public class MoveElements {
	
	/**
	 * Moves all zero elements at the end and count non-zero elements.
	 * 
	 * @param values
	 * @return
	 */
	public static int moveZerosAtEndAndCountNonZeroElements(int[] values) {
		int nonZeroElements = 0;
		if(values != null) {
			int lastIndex = values.length - 1;
			for(int i = 0; i < values.length; i++) {
				if(values[i] == 0) {
					for(int j = lastIndex; j > i; j--) {
						if(values[j] != 0) {
							int temp = values[i];
							values[i] = values[j];
							values[j] = temp;
							nonZeroElements++;
							lastIndex = j;
							break;
						}
					}
				} else {
					nonZeroElements++;
				}
			}
		}
		
		return nonZeroElements;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] values = { 0, 2, 6, 0, 3, -1, 8, -2, 0, 0 };
		// int[] values = { 0, 0, 3, -1, 8, -2};
		int[] values = { 2, 6, 3, -1, 8, -2, 0, 0 };
		System.out.println(Arrays.toString(values));
		System.out.println(moveZerosAtEndAndCountNonZeroElements(values));
		System.out.println(Arrays.toString(values));
	}
	
}
