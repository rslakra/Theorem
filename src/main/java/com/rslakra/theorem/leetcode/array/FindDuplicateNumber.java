/**
 *
 */
package com.rslakra.theorem.leetcode.array;

import java.util.HashSet;

/**
 * @author Rohtash Lakra
 */
public class FindDuplicateNumber {

    public static int findDuplicateWithSet(int[] nums) {
        if (nums != null) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (set.contains(nums[i])) {
                    return nums[i];
                } else {
                    set.add(nums[i]);
                }
            }
        }

        return -1;
    }

    public static int findDuplicate(int[] nums) {
        if (nums != null) {
            int slowIndex = nums[0];
            int fastIndex = nums[0];
            do {
                slowIndex = nums[nums[slowIndex]];
                fastIndex = nums[fastIndex];
            } while (slowIndex != fastIndex);

            int value = nums[0];
            while (value != slowIndex) {
                value = nums[value];
                slowIndex = nums[slowIndex];
            }

            return value;

        }

        return -1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicateWithSet(nums));
        System.out.println(findDuplicate(nums));
        System.out.println();

        nums = new int[]{3, 1, 3, 4, 2};
        System.out.println(findDuplicateWithSet(nums));
        System.out.println(findDuplicate(nums));
    }

}
