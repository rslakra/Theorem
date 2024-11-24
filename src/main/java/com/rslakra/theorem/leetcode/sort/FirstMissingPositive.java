/**
 *
 */
package com.rslakra.theorem.leetcode.sort;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 18, 2019 8:43:52 PM
 */
public class FirstMissingPositive {

    /**
     * Returns the first missing positive number. Brute Force and easy solution.
     *
     * @param data
     * @return
     */
    public static int findFirstMissingPositive(int[] data) {
        int num = 1;
        if (data != null) {
            Arrays.sort(data);
            for (int i = 0; i < data.length; i++) {
                if (data[i] == num) {
                    num++;
                }
            }
        }

        return num;
    }

    /**
     * @param data
     * @param source
     * @param target
     */
    public static void swap(int[] data, int source, int target) {
        int temp = data[source];
        data[source] = data[target];
        data[target] = temp;
    }

    /**
     * @param data
     */
    public static void arrangeDigits(int[] data) {
        if (data != null) {
            int i = 0;
            int len = data.length;
            while (i < len) {
                int index = data[i] - 1;
                if (data[i] > 0 && data[i] < len && data[i] != data[index]) {
                    swap(data, i, index);
                } else {
                    i++;
                }
            }
        }
    }

    /**
     * Optimized Solution
     *
     * <pre>
     * if(nums == null || nums.length == 0) return 1;
     *
     * key here is to see that the missing positive number can only be between 1 ->
     * nums.length inclusive. Because the ideal case is [1,2,3,4,...] and the answer
     * is len + 1 so once you have a duplicate, or negative number then a number
     * from the ideal case is missing. that could be the missing number to return
     * </pre>
     *
     * <code>[1,2,0]</cod>
     *
     * @param data
     * @return
     */
    public static int findFirstMissingOptimized(int[] data) {
        if (data == null || data.length == 0) {
            return 1;
        }

        // arrange digits
        int i = 0;
        int len = data.length;
        while (i < len) {
            int index = data[i] - 1;
            if (data[i] > 0 && data[i] < len && data[i] != data[index]) {
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;
            } else {
                i++;
            }
        }

        for (int j = 0; j < data.length; j++) {
            if (data[j] - 1 != j) {
                return j + 1;
            }
        }

        return data.length + 1;
    }

    /**
     * @param A
     * @return
     */
    public static int findFirstMissing(int[] A) {
        if (A == null || A.length == 0) {
            return 1;
        }

        int[] temp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int index = A[i] - 1;
            if (index >= 0 && index < A.length) {
                temp[index] = A[i];
            }
        }

        int digit = 1;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == digit) {
                digit++;
            }
        }

        return digit;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] data = {3, 1, 1, 6};

        // System.out.println(findFirstMissingPositive(data));
        System.out.println(findFirstMissingOptimized(data));
        System.out.println(findFirstMissing(data));
        System.out.println();

        data = new int[]{3, 4, -1, 1};
        System.out.println(findFirstMissingOptimized(data));
        System.out.println(findFirstMissing(data));
        System.out.println();

        data = new int[]{1, 2, 3};
        System.out.println(findFirstMissingOptimized(data));
        System.out.println(findFirstMissing(data));
        System.out.println();

        data = new int[]{3, 1, 6};
        System.out.println(findFirstMissingOptimized(data));
        System.out.println(findFirstMissing(data));
        System.out.println();

        data = new int[]{1, 2, 0};
        System.out.println(findFirstMissingOptimized(data));
        System.out.println(findFirstMissing(data));
        System.out.println();

        // System.out.println(0x2222 & 0x000F);

    }

}
