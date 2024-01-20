package com.devamatre.theorem.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 5:11 PM
 */
public class LC1207UniqueNumberOfOccurrences {

    /**
     * <url>https://leetcode.com/problems/unique-number-of-occurrences</url>
     *
     * @param arr
     * @return
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> unique = new HashSet<>(map.values());
        return map.size() == unique.size();
    }

}
