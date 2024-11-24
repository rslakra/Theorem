package com.rslakra.theorem.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any
 * order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [1], k = 1
 * Output: [1]
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 9/19/23 3:43 PM
 */
public class LC347TopKFrequentElements {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC347TopKFrequentElements.class);

    /**
     * <pre>
     *  Time Complexity: O(N ^ 2)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        SortedSet<Map.Entry<Integer, Integer>> sortedSet = new TreeSet<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                // values might be same and can override the key
                int result = o2.getValue() - o1.getValue();
                if (result == 0) {
                    result = o1.getKey() - o2.getKey();
                }
                return result;
            }
        });
        sortedSet.addAll(map.entrySet());

        int index = 0;
        int[] topKElements = new int[k];
        for (Iterator<Map.Entry<Integer, Integer>> itr = sortedSet.iterator(); itr.hasNext() && k > 0; k--) {
            topKElements[index++] = itr.next().getKey();
        }

        return topKElements;
    }

    /**
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        // min heap of number and frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Comparator<Map.Entry<Integer, Integer>> entryComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int result = o1.getValue() - o2.getValue();
                if (result == 0) {
                    result = o1.getKey() - o2.getKey();
                }
                return result;
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k, entryComparator);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int index = 0;
        int[] ans = new int[k];
        while (!pq.isEmpty()) {
            ans[index++] = pq.remove().getKey();
        }

        return ans;
    }

    /**
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(N)
     * </pre>
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent3(int[] nums, int k) {
        // min heap of number and frequency
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // store frequency as index and list of keys on that index
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (buckets[entry.getValue()] == null) {
                buckets[entry.getValue()] = new ArrayList<>();
            }
            buckets[entry.getValue()].add(entry.getKey());
        }

        LOGGER.debug("buckets:{}", Arrays.toString(buckets));
        int index = 0;
        int[] ans = new int[k];
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = 0; buckets[i] != null && j < buckets[i].size() && index < k; j++) {
                ans[index++] = buckets[i].get(j);
            }
        }

        LOGGER.debug("ans:{}", ans);
        return ans;
    }
}
