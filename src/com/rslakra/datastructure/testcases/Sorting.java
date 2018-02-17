package com.rslakra.datastructure.testcases;

import java.util.Arrays;
import java.util.Random;

/**
 * Sorting Algorithms.
 * 
 * @author Rohtash Singh Lakra
 * @date 01/18/2017 12:39:03 PM
 *
 */
public class Sorting {
	
	/**
	 * Fills the specified array with random numbers of the specified length.
	 * 
	 * @param values
	 * @param length
	 */
	public static void fillRandoms(int[] values, int length) {
		if(values != null) {
			Random random = new Random();
			for(int i = 0; i < values.length; i++) {
				values[i] = random.nextInt(100);
			}
		}
	}
	
	
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
	public static void insertSortAscending(int[] values) {
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
	public static void insertSortDescending(int[] values) {
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
	 * Sorts the values using the merge sort, which is most efficient algorithm
	 * of sorting large data sets.
	 * 
	 * @param values
	 */
	public static void mergeSort(int[] sortArray, int[] tempArray, int lowIndex, int highIndex) {
		// stop recursion at some point
		if(highIndex > lowIndex) {
			int midIndex = (highIndex + lowIndex) / 2;
			mergeSort(sortArray, tempArray, lowIndex, midIndex);
			mergeSort(sortArray, tempArray, midIndex + 1, highIndex);
			merge(sortArray, tempArray, lowIndex, midIndex, highIndex);
		}
	}
	
	/**
	 * Merges the values of sub-sets into one.
	 * 
	 * @param sortArray
	 * @param tempArray
	 * @param lowIndex
	 * @param midIndex
	 * @param highIndex
	 */
	private static void merge(int[] sortArray, int[] tempArray, int lowIndex, int midIndex, int highIndex) {
		int lowIndex1 = lowIndex;
		int lowIndex2 = midIndex + 1;
		int ctr = lowIndex;
		
		// make the copy of the sortArray into tempArray
		System.arraycopy(sortArray, 0, tempArray, 0, sortArray.length);
		
		// now start merging the sub-sets and updating the sortArray.
		while(lowIndex1 <= midIndex && lowIndex2 <= highIndex) {
			if(tempArray[lowIndex1] <= tempArray[lowIndex2]) {
				sortArray[ctr] = tempArray[lowIndex1];
				lowIndex1++;
			} else {
				sortArray[ctr] = tempArray[lowIndex2];
				lowIndex2++;
			}
			ctr++;
		}
		
		// merge the left half remaining array
		while(lowIndex1 <= midIndex) {
			sortArray[ctr] = tempArray[lowIndex1];
			ctr++;
			lowIndex1++;
		}
		
		// merge the right half remaining array
		while(lowIndex2 <= highIndex) {
			sortArray[ctr] = tempArray[lowIndex2];
			ctr++;
			lowIndex2++;
		}
	}
	
	/**
	 * Starting Point.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// int[] values = new int[] { 8, 5, 2, 6, 4 };
		int SIZE = 1000000;
		int[] values = new int[SIZE];
		Sorting.fillRandoms(values, SIZE);
		System.out.println(Arrays.toString(values));
		
		long sTime = System.currentTimeMillis();
		// sort
		
		// selectionSortAscending(values);
		// selectionSortDescending(values);

		// insertSortAscending(values);
		// insertSortDescending(values);

		// bubbleSortAscending(values);
		// bubbleSortDescending(values);
		
		// int[] temp = new int[values.length];
		// Sorting.mergeSort(values, temp, 0, values.length - 1);
		long timeTaken = (System.currentTimeMillis() - sTime);
		System.out.println("Took :" + timeTaken + " millis");
		System.out.println(Arrays.toString(values));
	}
	
}
