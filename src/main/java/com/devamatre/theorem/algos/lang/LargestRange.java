/**
 *
 */
package com.devamatre.theorem.algos.lang;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 23, 2019 1:18:17 PM
 */
public class LargestRange {

    /**
     * Write a function that takes in an array of integers and returns an array of length 2 representing the largest
     * range of numbers contained in that array. The first number in the output array should be the first number in the
     * range while the second number should be the last number in the range. A range of numbers is defined as a set of
     * numbers that come right after each other in the set of real integers. For instance, the output array [2, 6]
     * represents the range {2, 3, 4, 5, 6}, which is a range of length 5. Note that numbers do not need to be ordered
     * or adjacent in the array in order to form a range. Assume that there will only be one largest range.
     * <p>
     * Sample input: [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
     * <p>
     * Sample output: [0, 7]
     * <p>
     * Time Complexity: O(N)
     * <p>
     * Space Complexity: O(N)
     *
     * @param arr
     * @return
     */
    public int[] largestRange(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], true));
        }

        int[] bestRange = new int[2];
        int longestRangeCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i])) {
                map.put(arr[i], false);
                int currentRangeCount = 1;
                int left = arr[i] - 1;
                int right = arr[i] + 1;
                // find minimum number
                while (map.containsKey(left) && map.get(left)) {
                    map.put(left, false);
                    currentRangeCount++;
                    left--;
                }

                // find maximum number
                while (map.containsKey(right) && map.get(right)) {
                    map.put(right, false);
                    currentRangeCount++;
                    right++;
                }

                if (currentRangeCount > longestRangeCount) {
                    longestRangeCount = currentRangeCount;
                    bestRange[0] = left + 1;
                    bestRange[1] = right - 1;
                }
            }
        }

        return bestRange;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LargestRange obj = new LargestRange();
        int[] arr = {2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(obj.largestRange(arr)));
        System.out.println();

        arr = new int[]{1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        System.out.println(Arrays.toString(obj.largestRange(arr)));
        System.out.println();
    }

}
