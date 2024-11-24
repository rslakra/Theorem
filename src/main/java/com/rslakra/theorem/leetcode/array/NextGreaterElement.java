package com.rslakra.theorem.leetcode.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 */
public class NextGreaterElement {


    /**
     * @param input
     * @return
     */
    public int[] findNextGreaterElementBruteForce(int[] input) {
        int[] result = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            boolean findGreater = false;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] > input[i]) {
                    findGreater = true;
                    result[i] = input[j];
                    break;
                }
            }

            if (!findGreater) {
                result[i] = -1;
            }
        }

        return result;
    }

    /**
     * {1, 3, 4, 2}
     *
     * @param input
     * @return
     */
    public int[] findNextGreaterElementOptimized(int[] input) {
        int[] result = new int[input.length];
        int limit = 1;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < input.length; i++) {
            if (queue.isEmpty()) {
                queue.add(input[i]);
            } else {
                if (queue.element() < input[i]) {

                }
            }
            boolean findGreater = false;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] > input[i]) {
                    findGreater = true;
                    result[i] = input[j];
                    break;
                }
            }

            if (!findGreater) {
                result[i] = -1;
            }
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        LC496NextGreaterElementI nextGreaterElementI = new LC496NextGreaterElementI();
        // case 1
        int[] subset = {4, 1, 2};
        int[] input = {1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement.findNextGreaterElementBruteForce(subset)));
        System.out.println(Arrays.toString(nextGreaterElement.findNextGreaterElementBruteForce(input)));
        System.out.println(Arrays.toString(nextGreaterElementI.findNextGreaterElementBruteForce(subset, input)));

        // case 2
        subset = new int[]{2, 4};
        input = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(nextGreaterElement.findNextGreaterElementBruteForce(subset)));
        System.out.println(Arrays.toString(nextGreaterElement.findNextGreaterElementBruteForce(input)));
        System.out.println(Arrays.toString(nextGreaterElementI.findNextGreaterElementBruteForce(subset, input)));

    }
}
