/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.theorem.hackerrank.tree;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-23 04:40:59 PM
 * @since 1.0.0
 */
public class CheckBinarySearchTree {

    static class Node {

        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    /**
     * Returns the height of the given root tree.
     *
     * @param root
     * @return
     */
    public static int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            return (1 + (int) Math.max(getHeight(root.left), getHeight(root.right)));
        }
    }

    /**
     * @param root
     * @param level
     */
    public static void printLevelOrder(Node root, int level) {
        if (root != null) {
            if (level == 1) {
                System.out.print(root.data + " ");
            } else if (level > 1) {
                printLevelOrder(root.left, level - 1);
                printLevelOrder(root.right, level - 1);
            }
        }
    }

    /**
     * Prints Breadth First Search (BFS) or Level Order Traversal.
     *
     * @param root
     */
    public static void printLevelOrder(Node root) {
        // Write your code here
        if (root != null) {
            int height = getHeight(root);
            System.out.println("height:" + height);
            for (int i = 1; i <= height; i++) {
                printLevelOrder(root, i);
                System.out.println();
            }
        }
    }

    /**
     * Inserts the nodes to the binary tree.
     *
     * @param values
     * @param sIndex
     * @param eIndex
     * @return
     */
    public static Node createBinarySearchTreeWithSortedArray(int[] values, int sIndex, int eIndex) {
        if (sIndex > eIndex) {
            return null;
        }

        int midIndex = (sIndex + eIndex) / 2;
        Node node = null;
        node = new Node(values[midIndex]);
        node.left = createBinarySearchTreeWithSortedArray(values, sIndex, midIndex - 1);
        node.right = createBinarySearchTreeWithSortedArray(values, midIndex + 1, eIndex);

        return node;
    }

    class Item {

        Node node;
        int rootData;

        Item(Node node, int rootData) {

        }
    }

    public static boolean isBinarySearchTree(Node node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.data < min || node.data > max) {
            return false;
        }

        return (isBinarySearchTree(node.left, min, node.data - 1)
                && isBinarySearchTree(node.right, node.data + 1, max));
    }

    /**
     * Using In-Order Traversal (Ascending).
     *
     * @param node
     * @param prev
     * @return
     */
    public static boolean isBST(Node node, Node prev) {
        if (node != null) {
            if (!isBST(node.left, prev)) {
                return false;
            }

            if (prev != null && node.data <= prev.data) {
                return false;
            }

            prev = node;
            if (!isBST(node.right, prev)) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int T = in.nextInt();
        // int[] values = new int[T];
        // for (int i = 0; i < T; i++) {
        // values[i] = in.nextInt();
        // }
        // in.close();
        //
        // Arrays.sort(values);
        // Node root = createBinarySearchTreeWithSortedArray(values, 0,
        // values.length - 1);

        Node root = new Node(4);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        printLevelOrder(root);
        System.out.println();
        boolean isBST = isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(isBST ? "Yes" : "No");
        System.out.println();
        System.out.println(isBST(root, root) ? "Yes" : "No");

    }

}
