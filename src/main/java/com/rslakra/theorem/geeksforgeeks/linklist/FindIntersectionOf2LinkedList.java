/**
 *
 */
package com.rslakra.theorem.geeksforgeeks.linklist;

import java.util.LinkedList;

/**
 * @author Rohtash Lakra
 */
public class FindIntersectionOf2LinkedList {

    private static LinkedList findIntersectionOfLists(LinkedList<Integer> left, LinkedList<Integer> right) {
        if (left != null && right != null) {
            left.retainAll(right);
            return left;
            // left.stream().distinct().filter(x -> right.stream().anyMatch(y -> y == x)).;
        } else if (left != null && right == null) {
            return left;
        } else if (left == null && right != null) {
            return right;
        }

        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> left = new LinkedList<>();
        left.add(1);
        left.add(3);
        left.add(4);

        LinkedList<Integer> right = new LinkedList<>();
        right.add(2);
        right.add(4);
        right.add(5);

        System.out.println(findIntersectionOfLists(left, right));
    }

}
