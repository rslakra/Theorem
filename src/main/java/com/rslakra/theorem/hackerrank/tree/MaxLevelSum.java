/**
 *
 */
package com.rslakra.theorem.hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Rohtash Lakra
 */
public final class MaxLevelSum {

    static class Node {

        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }

        void addLeft(int value) {
            left = new Node(value);
        }

        void addRight(int value) {
            right = new Node(value);
        }
    }

    /**
     * @param root
     * @return
     */
    static int maxLevelSum(Node root) {
        int maxLevelSum = 0;
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int sum = 0;
                int count = queue.size();
                while (count-- > 0) {
                    root = queue.poll();
                    sum += root.data;

                    if (root.left != null) {
                        queue.offer(root.left);
                    }
                    if (root.right != null) {
                        queue.offer(root.right);
                    }
                }

                if (sum > maxLevelSum) {
                    maxLevelSum = sum;
                }
            }
        }

        return maxLevelSum;
    }

    static Node makeTree() {
        Node root = new Node(1);
        root.addLeft(2);
        root.addRight(3);

        root.left.addLeft(4);
        root.left.addRight(5);

        root.right.addLeft(6);
        root.right.addRight(7);

        return root;
    }

    static Node makeNextTree() {
        Node root = new Node(1);
        root.addLeft(2);
        root.addRight(3);

        root.left.addLeft(4);
        root.left.addRight(5);

        root.right.addRight(8);

        root.right.right.addLeft(6);
        root.right.right.addRight(7);

        return root;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Node root = makeTree();
        System.out.println(maxLevelSum(root));
        System.out.println();

        root = makeNextTree();
        System.out.println(maxLevelSum(root));

    }

}
