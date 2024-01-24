package com.devamatre.theorem.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Nov 07, 2020 17:26:29
 * @since 1.0.0
 */
public class LC496NextGreaterElementI {

    /**
     * Time Complexity: O(N ^ 2) Space Complexity: O(N)
     *
     * @param subset
     * @param input
     * @return
     */
    public int[] findNextGreaterElementBruteForce(int[] subset, int[] input) {
        int[] result = new int[subset.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < subset.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] > subset[i]) {
                    result[i] = input[j];
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Time Complexity: O(N) Space Complexity: O(N)
     * <p>
     * int[] subset = {4, 1, 2}; int[] input = {1, 3, 4, 2};
     *
     * @param subset
     * @param input
     * @return
     */
    public int[] findNextGreaterElementOptimized(int[] subset, int[] input) {
        int[] result = new int[subset.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && stack.peek() < input[i]) {
                map.put(stack.pop(), input[i]);
            }

            stack.push(input[i]);
        }
        System.out.println(map);

        for (int i = 0; i < subset.length; i++) {
            result[i] = map.getOrDefault(subset[i], -1);
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC496NextGreaterElementI nextGreaterElement = new LC496NextGreaterElementI();
        // case 1
        int[] subset = {4, 1, 2};
        int[] input = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement.findNextGreaterElementBruteForce(subset, input)));
        System.out.println(Arrays.toString(nextGreaterElement.findNextGreaterElementOptimized(subset, input)));

    }
}
