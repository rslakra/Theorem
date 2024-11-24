package com.rslakra.theorem.leetcode.monotonic;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Nov 14, 2020 19:14:06
 * @since 1.0.0
 */
public class LC581ShortestUnsortedContinuousSubArray {

    /**
     * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubArray(int[] nums) {
        Deque<Integer> queue = new LinkedList<>();
        int leftIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.getLast()] >= nums[i]) {
                queue.removeLast();
                leftIndex = i;
            }

            queue.push(i);
        }

        int rightIndex = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i]) {
                queue.removeLast();
                rightIndex = i;
            }

            queue.push(i);
        }

        return (rightIndex - leftIndex > 0 ? (rightIndex - leftIndex) : 0);
    }


    public static void main(String[] args) {
        LC581ShortestUnsortedContinuousSubArray obj = new LC581ShortestUnsortedContinuousSubArray();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(obj.findUnsortedSubArray(nums));
    }
}
