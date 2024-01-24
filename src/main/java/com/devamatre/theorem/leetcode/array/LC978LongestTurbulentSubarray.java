/**
 *
 */
package com.devamatre.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 */
public class LC978LongestTurbulentSubarray {

    /**
     * Problem #978
     * <p>
     * A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:
     * <p>
     * For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even; OR, for i <= k < j, A[k] > A[k+1]
     * when k is even, and A[k] < A[k+1] when k is odd.
     * <p>
     * That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the
     * subarray.
     * <p>
     * Return the length of a maximum size turbulent subarray of A.
     *
     * @param A
     * @return
     */
    public int maxTurbulenceSize(int[] A) {
        if (A.length <= 1) {
            return A.length;
        }

        int maxSize = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (i % 2 == 0) { // even
                if (A[i] > A[i + 1]) {
                    maxSize++;
                }
            } else {
                if (A[i] < A[i + 1]) {
                    maxSize++;
                }
            }
        }

        return maxSize;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC978LongestTurbulentSubarray instance = new LC978LongestTurbulentSubarray();
        int[] arr = new int[]{9, 4, 2, 10, 7, 8, 8, 1, 9};
        System.out.println(instance.maxTurbulenceSize(arr));
        arr = new int[]{4, 8, 12, 16};
        System.out.println(instance.maxTurbulenceSize(arr));
        arr = new int[]{100};
        System.out.println(instance.maxTurbulenceSize(arr));
    }

}
