package com.rslakra.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 * @created 1/22/24 5:05 PM
 */
public class LC153FindMinimumInRotatedSortedArray {

    private int findPivotInDuplicateRotatedArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[mid]) {
                start++;
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                if (nums[start] < nums[end]) {
                    break;
                } else {
                    end--;
                }
            }
        }

        return start;
    }

    /**
     * <url>https://leetcode.com/problems/find-minimum-in-rotated-sorted-array</url>
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int pivot = findPivotInDuplicateRotatedArray(nums);
        return nums[pivot];
    }
}
