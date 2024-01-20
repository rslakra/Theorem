package com.devamatre.theorem.leetcode.array;

import com.devamatre.theorem.adts.map.HashMap;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 4:00 PM
 */
public class LC167TwoSumIIInputArrayIsSorted {

    /**
     * <url>https://leetcode.com/problems/two-sum-ii-input-array-is-sorted</url>
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[]{map.get(target - numbers[i]) + 1, i + 1};
            }

            map.put(numbers[i], i);
        }

        return result;
    }
}
