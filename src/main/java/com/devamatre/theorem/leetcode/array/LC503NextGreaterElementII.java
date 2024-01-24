package com.devamatre.theorem.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-ii/
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Nov 07, 2020 17:29:41
 * @since 1.0.0
 */
public class LC503NextGreaterElementII {


    /**
     * Time Complexity: O(N ^ 2) Space Complexity: O(N)
     * <p>
     * int[] input = {1, 2, 1};
     *
     * @param input
     * @return
     */
    public int[] findNextGreaterElementBruteForce(int[] input) {
        int[] result = new int[input.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < input.length; i++) {
            int j = (i == input.length - 1 ? 0 : i + 1);
            while (j != i) {
                if (input[j] > input[i]) {
                    result[i] = input[j];
                    break;
                }
                j = (j == input.length - 1 ? 0 : j + 1);
            }
        }

        return result;
    }

    /**
     * Time Complexity: O(N ^ 2) Space Complexity: O(N)
     * <p>
     * int[] input = {1, 3, 4, 2};
     *
     * @param input
     * @return
     */
    public int[] findNextGreaterElementOptimized(int[] input) {
        int[] result = new int[input.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = i + 1;
        while (i < input.length && i != j) {
            while (!stack.isEmpty() && input[stack.peek()] < input[i] && result[j] == -1) {
                result[stack.pop()] = input[i];
            }

            stack.push(i);
            j = (j == input.length - 1 ? 0 : j + 1);
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC503NextGreaterElementII nextGreaterElement = new LC503NextGreaterElementII();
        // case 1
// int[] input = {1, 3, 4, 2};
// System.out.println(Arrays.toString(nextGreaterElement.findNextGreaterElementBruteForce(input)));
// System.out.println(Arrays.toString(nextGreaterElement.findNextGreaterElementOptimized(input)));

    }
}
