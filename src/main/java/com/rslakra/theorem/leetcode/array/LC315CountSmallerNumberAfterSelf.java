package com.rslakra.theorem.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property
 * where counts[i] is the number of smaller elements to the right of nums[i].
 * <p>
 * Example:
 * <p>
 * Input: [5,2,6,1] Output: [2,1,1,0] Explanation: To the right of 5 there are 2 smaller elements (2 and 1). To the
 * right of 2 there is only 1 smaller element (1). To the right of 6 there is 1 smaller element (1). To the right of 1
 * there is 0 smaller element.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Dec 07, 2019 11:19:03 PM
 */
public class LC315CountSmallerNumberAfterSelf {

    private class Node {

        int value;
        int count;
        int repeat;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            count = 0;
            repeat = 0;
            left = null;
            right = null;
        }
    }

    private Node root;

    /**
     * @param numbers
     * @return
     */
    public List<Integer> countSmallers(int[] numbers) {
        if (numbers == null) {
            return null;
        }
        if (numbers.length < 1) {
            return new ArrayList<>();
        } else if (numbers.length == 1) {
            return Arrays.stream(new int[]{0}).boxed().collect(Collectors.toList());
        }

        //check already sorted
        int[] counts = new int[numbers.length];
        root = new Node(numbers[numbers.length - 1]);
        for (int i = numbers.length - 2; i >= 0; i--) {
            counts[i] = countSmaller(numbers[i]);
        }

        return Arrays.stream(counts).boxed().collect(Collectors.toList());
    }

    /**
     * @param value
     * @return
     */
    private int countSmaller(int value) {
        Node itr = root;
        int count = 0;
        while (itr != null) {
            if (itr.value > value) { //left node
                itr.count += 1;
                if (itr.left == null) {
                    itr.left = new Node(value);
                    return count;
                } else {
                    itr = itr.left;
                }
            } else if (itr.value < value) { //right side
                count += itr.count + itr.repeat + 1;
                if (itr.right == null) {
                    itr.right = new Node(value);
                    return count;
                } else {
                    itr = itr.right;
                }
            } else { // repeats
                itr.repeat += 1;
                return (count + itr.count);
            }
        }

        return count;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC315CountSmallerNumberAfterSelf countSmaller = new LC315CountSmallerNumberAfterSelf();
        int[] numbers = null;
        List<Integer> listCounts = countSmaller.countSmallers(numbers);
        System.out.println("Input: " + Arrays.toString(numbers));
        System.out.println("Results: " + listCounts);
        System.out.println();
        numbers = new int[]{5};
        listCounts = countSmaller.countSmallers(numbers);
        System.out.println("Input: " + Arrays.toString(numbers));
        System.out.println("Results: " + listCounts);
        System.out.println();
        numbers = new int[]{1, 2, 3};
        listCounts = countSmaller.countSmallers(numbers);
        System.out.println("Input: " + Arrays.toString(numbers));
        System.out.println("Results: " + listCounts);
        System.out.println();
        numbers = new int[]{3, 2, 1};
        listCounts = countSmaller.countSmallers(numbers);
        System.out.println("Input: " + Arrays.toString(numbers));
        System.out.println("Results: " + listCounts);
        System.out.println();
        numbers = new int[]{5, 9, 7, 3, 2, 5};
        listCounts = countSmaller.countSmallers(numbers);
        System.out.println("Input: " + Arrays.toString(numbers));
        System.out.println("Results: " + listCounts);
        numbers = new int[]{5, 9, 8, 7, 3, 2, 5};
        listCounts = countSmaller.countSmallers(numbers);
        System.out.println("Input: " + Arrays.toString(numbers));
        System.out.println("Results: " + listCounts);
        numbers = new int[]{5, 2, 6, 1};
        listCounts = countSmaller.countSmallers(numbers);
        System.out.println("Input: " + Arrays.toString(numbers));
        System.out.println("Results: " + listCounts);
        numbers = new int[]{-1};
        listCounts = countSmaller.countSmallers(numbers);
        System.out.println("Input: " + Arrays.toString(numbers));
        System.out.println("Results: " + listCounts);
    }
}
