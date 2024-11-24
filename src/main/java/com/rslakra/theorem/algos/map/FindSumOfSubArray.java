package com.rslakra.theorem.algos.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 11/30/23 11:18 AM
 */
public class FindSumOfSubArray {

    /**
     * Subarray sum equal to k (return number of such sub-arrays which sum is equal to k)
     *
     * <pre>
     *  Example 1:
     *      input[] = {1, 2, 3}
     *      k = 3
     *      output[] = 2 => {{1, 2,} {3}}
     *
     *  Example 2:
     *      input[] = {10, 2, -2, -20, 10}
     *      k = -10
     *      output[] = 3 => {{10, 2, -2} {2, -2, -20, 10}, {-20, 10}}
     * </pre>
     */
    public List<List<Integer>> sumOfSubArray(Integer[] input, int k) {
        return null;
    }

    /**
     * Subarray sum equal to k (return number of such sub-arrays which sum is equal to k)
     *
     * <pre>
     *  Example 1:
     *      input[] = {1, 2, 3}
     *      k = 3
     *      output[] = 2 => {{1, 2,} {3}}
     *
     *  Example 2:
     *      input[] = {10, 2, -2, -20, 10}
     *      k = -10
     *      output[] = 3 => {{10, 2, -2} {2, -2, -20, 10}, {-20, 10}}
     * </pre>
     */
    public List<List<Integer>> sumOfSubArrayWithPrefix(Integer[] input, int k) {
        return null;
    }

    /**
     * Subarray sum equal to k (return number of such sub-arrays which sum is equal to k)
     *
     * <pre>
     *  Example 1:
     *      input[] = {1, 2, 3}
     *      k = 3
     *      output[] = 2 => {{1, 2,} {3}}
     *
     *  Example 2:
     *      input[] = {10, 2, -2, -20, 10}
     *      k = -10
     *      output[] = 3 => {{10, 2, -2} {2, -2, -20, 10}, {-20, 10}}
     * </pre>
     */
    public List<List<Integer>> sumOfSubArrayBruteForce(Integer[] input, int k) {
        return null;
    }

    /**
     * @param input
     * @param k
     * @return
     */
    public int sumOfSubArrayCount(Integer[] input, int k) {
        // (k = sum, v = frequency)
        Map<Integer, Integer> sub = new HashMap<>();
        // empty array (always have sum of 0, which count/frequency = 1
        sub.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (sub.containsKey(sum - k)) {
                // increase the ans frequency
                ans += sub.get(sum - k);
            }

            // sum already exists, increase frequency
            if (sub.containsKey(sum)) {
                sub.put(sum, sub.get(sum) + 1);
            } else {
                //  not exists, add frequency as 1
                sub.put(sum, 1);
            }
        }

        return ans;
    }

}
