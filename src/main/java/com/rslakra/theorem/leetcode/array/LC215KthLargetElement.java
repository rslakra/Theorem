package com.rslakra.theorem.leetcode.array;

import java.util.Arrays;

/**
 * Author: Rohtash Lakra
 * Created: 8/29/20 9:39 AM Version: 1.0.0
 */
public class LC215KthLargetElement {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k - 1];
    }


    public int findKthLargestOptimized(int[] nums, int k) {
        return -1;
    }

    public static void main(String[] args) {
        LC215KthLargetElement object = new LC215KthLargetElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(object.findKthLargest(nums, k));
    }
}
