package com.rslakra.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 * @created 1/24/24 5:27 PM
 */
public class LC27RemoveElement {

    /**
     * <url>https://leetcode.com/problems/remove-element</url>
     * <url>https://leetcode.com/problems/remove-element/solutions/4622279/java-easy-beats-100-00-of-users-with-java</url>
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 1 && nums[0] == val) {
            return 0;
        }

        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            while (j >= 0 && nums[j] == val) {
                j--;
            }

            if (nums[i] == val && j >= 0 && j > i) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }

        return j + 1;
    }

    /**
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }

}
