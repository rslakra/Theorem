package com.rslakra.algorithms;

import java.util.Arrays;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 02/16/2017 01:07:32 PM
 *
 */
public class ArrayAlgos {
	
	/**
	 * 
	 * Given two sorted integer arrays A and B, merge B into A as one sorted
	 * array.
	 * 
	 * Note:
	 * You may assume that A has enough space to hold additional elements from
	 * B. The number of elements initialized in A and B are m and n
	 * respectively.
	 * 
	 * Analysis
	 * 
	 * The key to solve this problem is moving element of A and B backwards. If
	 * B has some elements left after A is done, also need to handle that case.
	 * 
	 * The takeaway message from this problem is that the loop condition. This
	 * kind of condition is also used for merging two sorted linked list.
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static int[] mergeSortedArrays(int[] first, int[] second) {
		int[] target = new int[first.length + second.length];
		int i = first.length - 1;
		int j = second.length - 1;
		int index = target.length - 1;
		
		while(i >= 0 && j >= 0) {
			if(first[i] < second[j]) {
				target[index] = second[j];
				j--;
			} else {
				target[index] = first[i];
				i--;
			}
			index--;
		}
		
		while(i >= 0) {
			target[index] = first[i];
			i--;
			index--;
		}
		
		while(j >= 0) {
			target[index] = second[j];
			j--;
			index--;
		}
		
		return target;
	}
	
	/**
	 * Given a sorted array and a target value, return the index if the target
	 * is found. If not, return the index where it would be if it were inserted
	 * in order. You may assume no duplicates in the array.
	 * 
	 * Here are few examples.
	 * 
	 * [1,3,5,6], 5 -> 2
	 * [1,3,5,6], 2 -> 1
	 * [1,3,5,6], 7 -> 4
	 * [1,3,5,6], 0 -> 0
	 * 
	 * @param array
	 * @param find
	 * @return
	 */
	public static int searchIndex(int[] array, int find) {
		int i = 0;
		int j = array.length;
		while(i < j) {
			int mid = (i + j) / 2;
			if(find > array[mid]) {
				i = mid + 1;
			} else {
				j = mid;
			}
		}
		
		return j;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] first = { 2, 4, 6, 7 };
		int[] second = { 3, 5, 8, 90, 994 };
		System.out.println(Arrays.toString(mergeSortedArrays(first, second)));
		
		int[] array = { 1, 3, 5, 6 };
		System.out.println("searchIndex(" + Arrays.toString(array) + ", 5):" + searchIndex(array, 5));
		System.out.println("searchIndex(" + Arrays.toString(array) + ", 2):" + searchIndex(array, 2));
		System.out.println("searchIndex(" + Arrays.toString(array) + ", 7):" + searchIndex(array, 7));
		System.out.println("searchIndex(" + Arrays.toString(array) + ", 0):" + searchIndex(array, 0));
		
	}
	
}
