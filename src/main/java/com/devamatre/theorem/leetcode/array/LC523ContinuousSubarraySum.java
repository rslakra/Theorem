package com.devamatre.theorem.leetcode.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 1:45 PM
 */
public class LC523ContinuousSubarraySum {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC523ContinuousSubarraySum.class);

    /**
     * <url>https://leetcode.com/problems/continuous-subarray-sum</url>
     * <p>
     * Time Complexity: O(N ^ 2)
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < nums.length - i; j++) {
                sum += nums[j];
                if (sum == target && Math.abs(i - j) >= 0) {
                    LOGGER.debug("Subarray Indices:{}, {}", i, j);
                    return true;
                }
            }
        }

        return false;
    }


    /**
     * <url>https://leetcode.com/problems/continuous-subarray-sum</url>
     * <p>
     * Time Complexity: O(N ^ 2)
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean checkSubarraySum2(int[] nums, int target) {
        if (nums == null) {
            return false;
        } else if (nums.length == 1) {
            return (nums[0] == target);
        }

        int left = 0;
        int right = 0;
        int sum = 0;
        while (left <= right && right < nums.length) {
            if (sum > target) {
                sum -= nums[left];
                left++;
            } else if (sum < target) {
                sum += nums[right];
                right++;
            } else if (sum == target) {
                LOGGER.debug("Subarray Indices:{}, {}", left, right);
                return true;
            }
        }

        return false;
    }
}
