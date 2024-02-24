package com.devamatre.theorem.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 1/31/24 3:38 PM
 */
public class LC128LongestConsecutiveSequence {


    /**
     * <url>https://leetcode.com/problems/longest-consecutive-sequence</url>
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longestSteak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int nextNumber = num;
                while (set.contains(nextNumber + 1)) {
                    nextNumber++;
                }

                longestSteak = Math.max(longestSteak, (nextNumber - num) + 1);
            }
        }

        return longestSteak;
    }


    /**
     * <url>https://leetcode.com/problems/longest-consecutive-sequence</url>
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            // ignore duplicate numbers
            if (nums[i - 1] == nums[i]) {
                continue;
            } else if (nums[i - 1] + 1 == nums[i]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }

        max = Math.max(max, count);
        return max;
    }

    /**
     * <url>https://leetcode.com/problems/longest-consecutive-sequence</url>
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public int longestConsecutive3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - 1)) {
                map.put(nums[i], false);
            }
        }
        // System.out.println(map);
        int max = 0;
        for (int num : map.keySet()) {
            if (map.get(num)) {// value == true
                int count = 0;
                while (map.containsKey(num)) {
                    count++;
                    num++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }

    /**
     * @param num
     * @param map
     * @return
     */
    private int findCount(int num, Map<Integer, Boolean> map) {
        int count = 0;
        while (map.containsKey(num)) {
            count++;
            num++;
        }

        return count;
    }

    /**
     * <url>https://leetcode.com/problems/longest-consecutive-sequence</url>
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public int longestConsecutive4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - 1)) {
                map.put(nums[i], false);
            }
        }
        // System.out.println(map);
        int max = 0;
        for (int num : map.keySet()) {
            if (map.get(num)) {// value == true
                int count = findCount(num, map);
                max = Math.max(max, count);
            }
        }

        return max;
    }

}
