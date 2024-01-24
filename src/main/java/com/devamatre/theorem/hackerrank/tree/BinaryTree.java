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
package com.devamatre.theorem.hackerrank.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-18 09:29:47 PM
 * @since 1.0.0
 */
public class BinaryTree {

    static class Node {

        int data;
        Node left, right;

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
            return -1;
        } else {
            return (1 + (int) Math.max(getHeight(root.left), getHeight(root.right)));
        }
    }

    /**
     * Breadth First Search (BFS) or Level Order Traversal.
     *
     * @param root
     */
    public static void levelOrder(Node root) {
        // Write your code here
        if (root != null) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

    /**
     * Prints the tree in level order traversal or Breadth First Search.
     *
     * @param root
     */
    public static void levelOrderTree(Node root) {
        // Write your code here
        if (root != null) {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int level = queue.size();
                while (level > 0) {
                    Node node = queue.poll();
                    System.out.print(node.data + " ");
                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    if (node.right != null) {
                        queue.add(node.right);
                    }

                    level--;
                }
                System.out.println();
            }
        }
    }

    /**
     * @param root
     * @param level
     */
    public static void printLevelOrder(Node root, int level) {
        if (root != null) {
            if (level == 0) {
                System.out.print(root.data + " ");
            } else if (level > 0) {
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
            for (int i = 0; i <= height; i++) {
                printLevelOrder(root, i);
                System.out.println();
            }
        }
    }

    /**
     * Left -> Root -> Right (Traveral in Ascending Order)
     *
     * @param root
     */
    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    /**
     * Left -> Right -> Root
     *
     * @param root
     */
    public static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    /**
     * Root -> Left -> Right (Depth First Search)
     *
     * @param root
     */
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * Inserts the nodes to the binary tree.
     *
     * @param root
     * @param data
     * @return
     */
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            if (data <= root.data) {
                root.left = insert(root.left, data);
            } else {
                root.right = insert(root.right, data);
            }
            return root;
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

    /**
     * @param in
     * @return
     */
    private static Node createBinarySearchTree(final Scanner in) {
        Node root = null;
        int n = in.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }
        Arrays.sort(values);
        root = createBinarySearchTreeWithSortedArray(values, 0, values.length - 1);
        return root;
    }

    /**
     * @param in
     * @param withUserInput
     * @return
     */
    private static Node createBinaryTree(final Scanner in, boolean withUserInput) {
        Node root = null;
        if (withUserInput) {
            int n = in.nextInt();
            while (n-- > 0) {
                int data = in.nextInt();
                root = insert(root, data);
            }
        } else {
            root = new Node(1);
            // left
            root.left = new Node(2);
            root.left.left = new Node(4);
            root.left.right = new Node(5);

            // right
            root.right = new Node(3);
            root.right.left = new Node(6);
            root.right.right = new Node(7);
        }

        return root;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Node root = null;
        /* 1. - create binary tree. */
        // root = createBinaryTree(in, false);

        /* 2. - create binary tree. */
        // root = createBinaryTree(in, true);

        /* 3. - create binary tree. */
        root = createBinarySearchTree(in);

        in.close();

        System.out.println("Height/Depth:");
        int height = getHeight(root);
        System.out.println(height);

        System.out.println("In Order Traversal (Ascending): ");
        inOrder(root);
        System.out.println();

        System.out.println("Post Order Traversal: ");
        postOrder(root);
        System.out.println();

        System.out.println("Pre Order Traversal (Depth First Search): ");
        preOrder(root);
        System.out.println();

        System.out.println("Level Order Traversal (Breadth First Search): ");
        levelOrder(root);
        System.out.println();

        System.out.println("Level Order Traversal Tree (Breadth First Search): ");
        levelOrderTree(root);
        System.out.println();

        System.out.println("Print Level Order Traversal (Breadth First Search) as Tree: ");
        printLevelOrder(root);
    }

}
