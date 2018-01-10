package com.rslakra.datastructure.sort;

import java.util.Arrays;

/**
 * 
 * @author rsingh
 *
 */
public class Sorting {

	/**
	 * Sorts the values of the given array in ascending order.
	 * 
	 * @param values
	 */
	public static void selectionSortAscending(int[] values) {
		int temp;
		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length; j++) {
				if (values[i] > values[j]) {
					temp = values[j];
					values[j] = values[i];
					values[i] = temp;
				}
			}
		}
	}

	/**
	 * Sorts the values of the given array in descending order.
	 * 
	 * @param values
	 */
	public static void selectionSortDescending(int[] values) {
		int temp;
		for (int i = 0; i < values.length; i++) {
			for (int j = i + 1; j < values.length; j++) {
				if (values[i] < values[j]) {
					temp = values[j];
					values[j] = values[i];
					values[i] = temp;
				}
			}
		}
	}

	/**
	 * Sorts the values of the given array in ascending order.
	 * 
	 * @param values
	 */
	public static void insertionSortAscending(int[] values) {
		int j, temp;
		for (int i = 1; i < values.length; i++) {
			temp = values[i];
			for (j = i; j > 0 && temp < values[j - 1]; j--) {
				values[j] = values[j - 1];
			}
			values[j] = temp;
		}
	}

	/**
	 * Sorts the values of the given array in descending order.
	 * 
	 * @param values
	 */
	public static void insertionSortDescending(int[] values) {
		int j, temp;
		for (int i = 1; i < values.length; i++) {
			temp = values[i];
			for (j = i; j > 0 && temp > values[j - 1]; j--) {
				values[j] = values[j - 1];
			}
			values[j] = temp;
		}
	}

	/**
	 * Sorts the values of the given array in ascending order.
	 * 
	 * @param values
	 */
	public static void bubbleSortAscending(int[] values) {
		int temp;
		for (int i = 0; i < values.length - 1; i++) {
			for (int j = 0; j < values.length - 1 - i; j++) {
				if (values[j] > values[j + 1]) {
					temp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * Sorts the values of the given array in descending order.
	 * 
	 * f(n) = O(n2)
	 * 
	 * @param values
	 */
	public static void bubbleSortDescending(int[] values) {
		int temp;
		for (int i = 0; i < values.length - 1; i++) {
			for (int j = 0; j < values.length - 1 - i; j++) {
				if (values[j] < values[j + 1]) {
					temp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = temp;
				}
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] values = new int[] { 5, 2, 6, 1, 9, 4, 7 };
		System.out.println(Arrays.toString(values));

		// selectionSortAscending(values);
		// selectionSortDescending(values);

		// insertionSortAscending(values);
		// insertionSortDescending(values);

		// bubbleSortAscending(values);
		// bubbleSortDescending(values);
		System.out.println(Arrays.toString(values));
	}

}
