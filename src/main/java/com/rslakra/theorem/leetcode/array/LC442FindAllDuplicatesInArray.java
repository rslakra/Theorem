package com.rslakra.theorem.leetcode.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <url>https://leetcode.com/problems/find-all-duplicates-in-an-array</url>
 *
 * @author Rohtash Lakra
 * @created 1/31/24 4:20 PM
 */
public class LC442FindAllDuplicatesInArray {

    private static final Logger LOGGER = LoggerFactory.getLogger(LC442FindAllDuplicatesInArray.class);

    /**
     * @param nums
     * @param source
     * @param target
     */
    public void swap(int[] nums, int source, int target) {
        int temp = nums[source];
        nums[source] = nums[target];
        nums[target] = temp;
    }

    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     */
    public void cyclicSort(int[] nums) {
        LOGGER.debug("+cyclicSort({})", nums);
        int i = 0;
        while (i < nums.length) {
            LOGGER.debug("i:{}, nums[{}]:{}, nums[{}-1]:{}", i, i, nums[i], nums[i], nums[nums[i] - 1]);
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        LOGGER.debug("-cyclicSort(), nums:{}", nums);
    }

    /**
     * <url>https://leetcode.com/problems/find-all-duplicates-in-an-array</url>
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        cyclicSort(nums);
        // System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != (i + 1)) {
                duplicates.add(nums[i]);
            }
        }

        return duplicates;
    }

    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        // build frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : nums) {
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int key : nums) {
            if (map.get(key) > 1) {
                duplicates.add(key);
            }
        }

        return duplicates;
    }


    /**
     * <pre>
     *  Time Complexity: O(n)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates3(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 1) {
                duplicates.add(-nums[index]);
            }
            nums[index] = -nums[index];
        }

        return duplicates;
    }

}
