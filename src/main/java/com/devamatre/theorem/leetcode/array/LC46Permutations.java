package com.devamatre.theorem.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/31/24 3:14 PM
 */
public class LC46Permutations {

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList(curr));
            return;
        }

        // iterate each element of nums
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            curr.add(nums[i]);
            visited[i] = true;
            permute(nums, result, curr, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

    /**
     * <url>https://leetcode.com/problems/permutations</url>
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permute(nums, result, new ArrayList<>(), visited);
        return result;
    }

    /**
     * @param nums
     * @param result
     * @param curr
     */
    private void permute(int[] nums, List<List<Integer>> result, List<Integer> curr) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) {
                continue;
            }

            curr.add(nums[i]);
            permute(nums, result, curr);
            curr.remove(curr.size() - 1);
        }
    }

    /**
     * <url>https://leetcode.com/problems/permutations</url>
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>());
        return result;
    }

}
