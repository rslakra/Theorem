/**
 *
 */
package com.devamatre.theorem.leetcode.array;

import java.util.HashSet;

/**
 * @author Rohtash Lakra
 */
public class LongestConsecutiveSequence {

    /**
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longestSteak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int nextNumber = num;
                while (set.contains(nextNumber + 1)) {
                    nextNumber++;
                }

                longestSteak = Math.max(longestSteak, (nextNumber - num) + 1);
            }
        }

        return longestSteak;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));

        System.out.println();
        nums = new int[]{0, 0};
        System.out.println(longestConsecutive(nums));

        System.out.println();
        nums = new int[]{1, 1, 2};
        System.out.println(longestConsecutive(nums));
    }

}
