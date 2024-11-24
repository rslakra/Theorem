package com.rslakra.theorem.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 1/19/24 3:41 PM
 */
public class LC220ContainsDuplicate3 {

    /**
     * <url>https://leetcode.com/problems/contains-duplicate-iii</url>
     *
     * <pre>
     *  Time Complexity: O(N ^ 2)
     * </pre>
     *
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(i - j) <= indexDiff && Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * <pre>
     *  Time Complexity: O(N ^ 2)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int indexDiff, int valueDiff) {
        int left = 0;
        int right = left + 1;
        // repeat until iterate all elements
        while (right < nums.length) {
            int currIndexDiff = Math.abs(left - right);
            int currValueDiff = Math.abs(nums[left] - nums[right]);
            if (currIndexDiff <= indexDiff && currValueDiff <= valueDiff) {
                return true;
            } else if (currIndexDiff == indexDiff || right == nums.length - 1) {
                right = ++left;
            }

            right++;
        }

        return false;
    }

    /**
     * @param map
     * @param bucket
     * @param value
     * @param valueDiff
     * @return
     */
    private boolean hasDuplicate(Map<Long, Long> map, long bucket, long value, int valueDiff) {
        if (map.containsKey(bucket)) {
            return true;
        } else if (map.containsKey(bucket - 1) && value - map.get(bucket - 1) <= valueDiff) {
            return true;
        } else if (map.containsKey(bucket + 1) && map.get(bucket + 1) - value <= valueDiff) {
            return true;
        }

        return false;
    }

    /**
     * @param value
     * @return
     */
    private long asLong(int value) {
        return (long) value - Integer.MIN_VALUE;
    }

    /**
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return
     */
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int indexDiff, int valueDiff) {
        if (indexDiff < 1 || valueDiff < 0) {
            return false;
        }

        Map<Long, Long> map = new HashMap<>();
        long bucketSize = (long) valueDiff + 1;
        for (int i = 0; i < nums.length; i++) {
            long value = asLong(nums[i]);
            long bucket = value / bucketSize;
            // bucket has the nearby almost duplicate
            if (hasDuplicate(map, bucket, value, valueDiff)) {
                return true;
            }

            // remove elements when the bucket size reaches the limit
            if (map.entrySet().size() >= indexDiff) {
                long lastBucket = asLong(nums[i - indexDiff]) / bucketSize;
                map.remove(lastBucket);
            }
            map.put(bucket, value);
        }

        return false;
    }

}
