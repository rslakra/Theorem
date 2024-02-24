package com.devamatre.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 * @created 1/24/24 5:01 PM
 */
public class LC26RemoveDuplicatesFromSortedArray {

    /**
     * <url>https://leetcode.com/problems/remove-duplicates-from-sorted-array</url>
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    /**
     * <url>https://leetcode.com/problems/remove-duplicates-from-sorted-array</url>
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

}
