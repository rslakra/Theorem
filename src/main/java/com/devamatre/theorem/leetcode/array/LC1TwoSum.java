package com.devamatre.theorem.leetcode.array;

import com.devamatre.theorem.adts.map.HashMap;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 4:12 PM
 */
public class LC1TwoSum {

    /**
     * <url>https://leetcode.com/problems/two-sum</url>
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

}
