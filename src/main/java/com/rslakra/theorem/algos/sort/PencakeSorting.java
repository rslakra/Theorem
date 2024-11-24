/**
 *
 */
package com.rslakra.theorem.algos.sort;

import java.util.Arrays;

/**
 * <code>https://en.wikipedia.org/wiki/Pancake_sorting</code>
 *
 * @author Rohtash Lakra
 */
public class PencakeSorting {

    public static int[] flip(int[] arr, int index) {
        for (int i = 0, j = index; i < j; i++, j--) {
            swap(arr, i, j);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] pencackeSorting(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }

            // first move the largest number at beginning
            // no need to swap, if the first index is the maximum element
            if (i != maxIndex) {
                swap(arr, 0, maxIndex);
            }
            // arr = flip(arr, maxIndex);

            // now reverse an array to move that number at the end
            arr = flip(arr, i);
        }

        return arr;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {23, 10, 20, 11, 12, 6, 7};
        arr = pencackeSorting(arr);
        System.out.println(Arrays.toString(arr));
    }

}
