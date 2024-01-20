package com.devamatre.theorem.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 6:39 PM
 */
public class LC217ContainsDuplicate {

    /**
     * <url>https://leetcode.com/problems/contains-duplicate</url>
     *
     * <pre>
     *  Time Complexity: O(N log N)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }

    /**
     * <pre>
     *  Time Complexity: O(log N)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) > 1) {
                return true;
            }
        }

        return false;
    }


    /**
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i != j) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }

            if (map.get(nums[i]) > 1 || map.get(nums[j]) > 1) {
                return true;
            }
        }

        return false;
    }
}
