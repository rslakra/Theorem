package com.devamatre.theorem.leetcode.peak;

/**
 * @author Rohtash Lakra
 * @created 1/3/24 11:13 AM
 */
public class LC162FindPeakElement {

    /**
     * <url>https://leetcode.com/problems/find-peak-element</url>
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        if (nums == null) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) { // mean the large number should on left side of an array
                end = mid;
            } else {
                // the larger number should be on the right side of an array
                start = mid + 1;
            }
        }

        // now the both start and end pointer should be on the same index
        return start; // or end
    }
}
