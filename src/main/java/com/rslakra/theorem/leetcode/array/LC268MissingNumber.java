/**
 *
 */
package com.rslakra.theorem.leetcode.array;

import java.util.Arrays;

/**
 * 268. Missing Number
 * <p>
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the
 * array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1] Output: 2 Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1] Output: 8 Note: Your algorithm should run in linear runtime complexity. Could you
 * implement it using only constant extra space complexity?
 *
 * @author Rohtash Lakra
 */
public class LC268MissingNumber {

    public static int missingNumberXor(int[] nums, boolean withZero) {
        int missing = (withZero ? nums.length : nums.length + 1);

        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }

        return (withZero ? missing : missing ^ nums.length);
    }

    public static int missingNumberOptimized(int[] nums) {
        int max = -1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }

            sum += nums[i];
        }

        max = max * (max + 1) / 2;
        return max - sum;
    }

    public static int missingNumber(int[] nums, boolean withZero) {
        int max = (withZero ? nums.length : nums.length + 1);
        max = max * (max + 1) / 2;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        return max - sum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 1};
        System.out.println("Missing in: " + Arrays.toString(nums));
        System.out.println(missingNumberXor(nums, true));
        System.out.println(missingNumberOptimized(nums));
        System.out.println(missingNumber(nums, true));
        System.out.println();

        nums = new int[]{3, 1, 4};
        System.out.println("Missing in: " + Arrays.toString(nums));
        System.out.println(missingNumberXor(nums, false));
        System.out.println(missingNumberOptimized(nums));
        System.out.println(missingNumber(nums, false));
        System.out.println();

        nums = new int[]{3, 1, 2, 5};
        System.out.println("Missing in: " + Arrays.toString(nums));
        System.out.println(missingNumberXor(nums, false));
        System.out.println(missingNumberOptimized(nums));
        System.out.println(missingNumber(nums, false));
    }

}
