package com.devamatre.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 * @created 1/3/24 5:34 PM
 */
public class LC410SplitArrayLargestSum {

    /**
     * <url>https://leetcode.com/problems/split-array-largest-sum</url>
     *
     * @param nums
     * @param k
     * @return
     */
    public int splitArray(int[] nums, int k) {
        // max sum of all elements.
        int start = 0;
        // max sum of min pieces
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]);
            end += nums[i];
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                // check if the num can be added to sum or not
                if (sum + num > mid) {
                    // if can't be added, means the new piece
                    pieces++;
                    sum = 0;
                }
                sum += num;
            }

            // check the pieces are euqal to k or not
            if (pieces <= k) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start; // or end
    }
}
