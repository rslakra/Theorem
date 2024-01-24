/**
 *
 */
package com.devamatre.theorem.leetcode.array;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 */
public class SortedArraySquares {

    public int[] sortedSquares(int[] A) {
        if (A.length == 0) {
            return A;
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }

        Arrays.sort(A);
        return A;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        SortedArraySquares instance = new SortedArraySquares();
        int[] arr = new int[]{-4, -1, 0, 3, 10};
        int[] result = instance.sortedSquares(arr);
        System.out.println(Arrays.toString(result));
        arr = new int[]{-7, -3, 2, 3, 11};
        result = instance.sortedSquares(arr);
        System.out.println(Arrays.toString(result));

    }

}
