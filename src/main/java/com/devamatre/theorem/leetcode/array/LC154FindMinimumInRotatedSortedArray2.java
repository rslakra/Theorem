package com.devamatre.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Nov 7, 2020 18:25:30 PM
 */
public class LC154FindMinimumInRotatedSortedArray2 {

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
     * <url>https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii</url>
     *
     * <pre>
     *  Time Complexity: <code>O(log N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int pivot = findPivotInDuplicateRotatedArray(nums);
        return nums[pivot];
    }

}
