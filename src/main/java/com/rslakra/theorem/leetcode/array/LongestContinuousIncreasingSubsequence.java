/**
 *
 */
package com.rslakra.theorem.leetcode.array;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 */
public class LongestContinuousIncreasingSubsequence {

    public static int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int sIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i - 1] >= nums[i]) {
                sIndex = i;
            }
            max = Math.max(max, i - sIndex + 1);
        }

        return max;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(Arrays.toString(nums));
        System.out.println(findLengthOfLCIS(nums));

        System.out.println();
        nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(Arrays.toString(nums));
        System.out.println(findLengthOfLCIS(nums));

        System.out.println();
        nums = new int[]{2, 2, 2, 2, 2};
        System.out.println(Arrays.toString(nums));
        System.out.println(findLengthOfLCIS(nums));

        System.out.println();
        nums = new int[]{7, 8, 9, 1, 2, 3};
        System.out.println(Arrays.toString(nums));
        System.out.println(findLengthOfLCIS(nums));

        System.out.println();
        nums = new int[]{1, 3, 5, 4, 2, 3, 4};
        System.out.println(Arrays.toString(nums));
        System.out.println(findLengthOfLCIS(nums));

        System.out.println();
        nums = new int[]{1, 1, 2};
        System.out.println(Arrays.toString(nums));
        System.out.println(findLengthOfLCIS(nums));

    }

}
