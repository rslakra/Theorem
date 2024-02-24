package com.devamatre.theorem.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/31/24 3:24 PM
 */
public class LC949LargestTimeForGivenDigits {

    public void findAllTimes(int[] arr, List<List<Integer>> result, List<Integer> curr, boolean[] visited) {
        if (curr.size() == arr.length) {
            result.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            curr.add(arr[i]);
            visited[i] = true;
            findAllTimes(arr, result, curr, visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }

    public List<List<Integer>> findAllTimes(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[arr.length];
        findAllTimes(arr, result, new ArrayList<>(), visited);
        return result;
    }


    public boolean areValidDigits(List<Integer> input) {
        if (input.get(0) > 2) {
            return false;
        } else if (input.get(0) == 2 && input.get(1) > 3) {
            return false;
        } else if (input.get(2) > 5) {
            return false;
        }

        return true;
    }

    /**
     * <url>https://leetcode.com/problems/largest-time-for-given-digits</url>
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param arr
     * @return
     */
    public String largestTimeFromDigits(int[] arr) {
        // find all permutations
        List<List<Integer>> allTimes = findAllTimes(arr);
        // exclude invalid times
        List<String> validTimes = new ArrayList<>();
        for (int i = 0; i < allTimes.size(); i++) {
            if (areValidDigits(allTimes.get(i))) {
                validTimes.add(allTimes.get(i).toString());
            }
        }
        Collections.sort(validTimes);
        // from valid times, return max time
        if (validTimes.size() > 0) {
            String validTime = validTimes.get(validTimes.size() - 1);
            validTime = validTime.replace(", ", "");
            validTime = validTime.substring(1, 3) + ":" + validTime.substring(3, validTime.length() - 1);
            return validTime;
        }

        return "";
    }

}
