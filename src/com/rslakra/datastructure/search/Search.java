package com.rslakra.datastructure.search;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 02/18/2017 01:36:46 PM
 *
 */
public class Search {

	/**
	 * 
	 * @param values
	 * @param what
	 * @return
	 */
	public static int binarySearch(int[] values, int lowIndex, int highIndex, int what) {
		if (highIndex > lowIndex) {
			int midIndex = lowIndex + (highIndex - lowIndex) / 2;
			if (what > values[midIndex]) {
				return binarySearch(values, midIndex + 1, highIndex, what);
			} else if (what < values[midIndex]) {
				return binarySearch(values, lowIndex, midIndex, what);
			} else {
				return midIndex;
			}
		}

		return (what == values[highIndex] ? highIndex : -1);
	}

	public static void main(String[] args) {
		int[] values = { 2, 4, 6, 9, 11, 38 };
		System.out.println(binarySearch(values, 0, values.length - 1, 11));

	}

}
