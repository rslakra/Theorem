/**
 *
 */
package com.rslakra.theorem.leetcode.array;

import java.util.HashSet;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1] Output: 1 Example 2:
 * <p>
 * Input: [4,1,2,1,2] Output: 4
 *
 * @author Rohtash Lakra
 */
public class SingleNumber {

    /**
     * O(n)
     *
     * @param nums
     * @return
     */
    public static int singleNumberUsingSet(int[] nums) {
        if (nums != null) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < nums.length; j++) {
                if (set.contains(nums[j])) {
                    set.remove(nums[j]);
                } else {
                    set.add(nums[j]);
                }
            }

            return set.iterator().next().intValue();
        }

        return -1;
    }

    public static int singleNumber(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            i ^= nums[j];
        }

        return i;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        System.out.println(singleNumberUsingSet(nums));
        System.out.println(singleNumber(nums));
        System.out.println();

        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumberUsingSet(nums));
        System.out.println(singleNumber(nums));
        System.out.println();
    }

}
