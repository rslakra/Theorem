package com.devamatre.theorem.leetcode.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * <url>https://leetcode.com/problems/continuous-subarray-sum</url>
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean checkSubarraySum3(int[] nums, int target) {
        // maintain a hash map to store <sum % k, index>
        Map<Integer, Integer> map = new HashMap<>();
        // this is for example (-10,10,5,4,... )
        // -10,10 add up to zero is a multiple of k.
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % target;
            if (map.containsKey(rem)) {
                if ((i - map.get(rem)) > 1) {
                    return true;
                } else {
                    continue;
                }
            }

            map.put(rem, i);
        }

        return false;
    }


    /**
     * <url>https://leetcode.com/problems/continuous-subarray-sum</url>
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean checkSubarraySum4(int[] nums, int target) {
        if (nums == null) {
            return false;
        }

        // prefix sum
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, nums[0]);
        for (int i = 1; i < nums.length; i++) {
            prefixSum.put(i, prefixSum.get(i - 1) + nums[i]);
        }

        // maintain a hash map to store <sum % k, index>
        Map<Integer, Integer> map = new HashMap<>();
        // this is for example (-10,10,5,4,... )
        // -10,10 add up to zero is a multiple of k.
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = sum % target;
            if (map.containsKey(sum)) {
                int startIndex = map.get(sum);
                if (i - startIndex > 1 && prefixSum.containsKey(prefixSum)
                    && prefixSum.get(i) - prefixSum.get(startIndex) == target) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }

        return false;
    }
}
