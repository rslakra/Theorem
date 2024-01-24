/**
 *
 */
package com.devamatre.theorem.leetcode.array;

import java.util.Arrays;

/**
 * Given two sorted integer array nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * <p>
 * The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough
 * space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * <p>
 * Example:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6],       n = 3
 * <p>
 * Output: [1,2,2,3,5,6]
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 20, 2019 9:49:03 PM
 */
public class LC88MergeSortedArray {

    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = nums1.length - 1;
        int i = m - 1;
        int j = n - 1;

        if (n < 1) {
            return;
        }

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                if (i > 0) {
                    nums1[i] = nums1[i - 1];
                }
                index--;
                i--;
            } else {
                nums1[index] = nums2[j];
                index--;
                j--;
            }
        }

        while (j >= 0 && index >= 0) {
            nums1[index] = nums2[j];
            index--;
            j--;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC88MergeSortedArray mArray = new LC88MergeSortedArray();
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] num2 = {2, 5, 6};
        int n = 3;
        mArray.merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));

        num1 = new int[]{-1, -1, 0, 0, 0, 0};
        m = 4;
        num2 = new int[]{-1, 0};
        n = 2;
        // expected : [-1,-1,-1,0,0,0]
        mArray.merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));

        num1 = new int[]{1};
        m = 1;
        num2 = new int[]{};
        n = 0;
        // expected : [-1,-1,-1,0,0,0]
        mArray.merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));

        num1 = new int[]{0};
        m = 0;
        num2 = new int[]{1};
        n = 1;
        // expected : [-1,-1,-1,0,0,0]
        mArray.merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));

        num1 = new int[]{4, 0, 0, 0, 0, 0};
        m = 1;
        num2 = new int[]{1, 2, 3, 5, 6};
        n = 5;
        // expected : [-1,-1,-1,0,0,0]
        mArray.merge(num1, m, num2, n);
        System.out.println(Arrays.toString(num1));
    }

}
