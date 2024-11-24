package com.rslakra.theorem.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @created 1/17/24 12:34 PM
 */
public class LC219ContainsDuplicate2 {

    /**
     * <url>https://leetcode.com/problems/contains-duplicate-ii</url>
     *
     * <pre>
     *  Time Complexity: O(N ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * <url>https://leetcode.com/problems/contains-duplicate-ii</url>
     *
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }

        return false;
    }


    /**
     * <url>https://leetcode.com/problems/contains-duplicate-ii</url>
     *
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        if (nums == null) {
            return false;
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }

            if (!set.add(nums[i])) {
                return true;
            }
        }

        return false;
    }

}
