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

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

/**
 * <pre>
 * Task
 * The height of a binary search tree is the number of edges between the tree's root and its furthest leaf.
 * You are given a pointer, pointer, pointing to the root of a binary search tree.
 * Complete the getHeight function provided in your editor so that it returns the height of the binary search tree.
 *
 * Input Format
 * The locked stub code in your editor reads the following inputs and assembles them into a binary search tree:
 * The first line contains an integer, n , denoting the number of nodes in the tree.
 * Each of n the subsequent lines contains an integer, data, denoting the value of an element that must be added to the BST.
 *
 * Output Format
 * The locked stub code in your editor will print the integer returned by your getHeight function denoting the height of the BST.
 *
 * Sample Input
 * 7
 * 3
 * 5
 * 2
 * 1
 * 4
 * 6
 * 7
 *
 * Sample Output
 * 3
 *
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-18 06:35:01 PM
 * @since 1.0.0
 */
public class BSTExample {

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
     * Inserts the node at the right position.
     *
     * @param root
     * @param data
     * @return
     */
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node newNode = null;
            if (data <= root.data) {
                newNode = insert(root.left, data);
                root.left = newNode;
            } else {
                newNode = insert(root.right, data);
                root.right = newNode;
            }

            return root;
        }
    }

    /**
     * @param root
     * @param treeBuilder
     */
    public static void preOrder(Node root, final StringBuilder treeBuilder) {
        if (root != null) {
            treeBuilder.append(root.data);
            if (root.left != null) {
                treeBuilder.append(" ");
                preOrder(root.left, treeBuilder);
            }
            if (root.right != null) {
                treeBuilder.append(" ");
                preOrder(root.right, treeBuilder);
            }
        }
    }

    /**
     * ROOT - LEFT - RIGHT
     *
     * @param root
     */
    public static void preOrder(Node root) {
        final StringBuilder treeBuilder = new StringBuilder();
        preOrder(root, treeBuilder);
        System.out.println(treeBuilder.toString());
    }

    /**
     * ROOT - LEFT - RIGHT Note: - In pre-order iterative traversal, queue data structure does not work. Use stack for
     * the correct results.
     *
     * @param node
     */
    public static void preOrderIterative(Node node) {
        final StringBuilder treeBuilder = new StringBuilder();
        if (node != null) {
            Stack<Node> nodes = new Stack<>();
            nodes.push(node);
            while (!nodes.isEmpty()) {
                node = nodes.pop();
                // root
                treeBuilder.append(node.data).append(" ");

                // Right child is pushed first, so that left can be processed
                // first.
                // right
                if (node.right != null) {
                    nodes.push(node.right);
                }

                // left
                if (node.left != null) {
                    nodes.push(node.left);
                }
            }
        }
        System.out.println(treeBuilder.toString());
    }

    /**
     * @param root
     * @param treeBuilder
     */
    public static void postOrder(Node root, final StringBuilder treeBuilder) {
        if (root != null) {
            // left
            if (root.left != null) {
                postOrder(root.left, treeBuilder);
                treeBuilder.append(" ");
            }
            // right
            if (root.right != null) {
                postOrder(root.right, treeBuilder);
                treeBuilder.append(" ");
            }
            // root
            treeBuilder.append(root.data);
        }
    }

    /**
     * LEFT - RIGHT - ROOT
     *
     * @param root
     */
    public static void postOrder(Node root) {
        final StringBuilder treeBuilder = new StringBuilder();
        postOrder(root, treeBuilder);
        System.out.println(treeBuilder.toString());
    }

    /**
     * LEFT - RIGHT - ROOT
     *
     * @param root
     */
    public static void postOrderIterative(Node node) {
        final StringBuilder treeBuilder = new StringBuilder();
        if (node != null) {
            Stack<Node> nodes = new Stack<>();
            Node lastVisited = null;
            while (!nodes.isEmpty() || node != null) {
                if (node != null) {
                    nodes.push(node);
                    node = node.left;
                } else {
                    Node peekNode = nodes.peek();
                    if (peekNode.right != null && peekNode.right != lastVisited) {
                        node = peekNode.right;
                    } else {
                        treeBuilder.append(peekNode.data).append(" ");
                        lastVisited = nodes.pop();
                    }
                }
            }
        }
        System.out.println(treeBuilder.toString());
    }

    /**
     * @param root
     * @param treeBuilder
     */
    public static void inOrder(Node root, final StringBuilder treeBuilder) {
        if (root != null) {
            // left
            if (root.left != null) {
                inOrder(root.left, treeBuilder);
                treeBuilder.append(" ");
            }

            // root
            treeBuilder.append(root.data);

            // right
            if (root.right != null) {
                treeBuilder.append(" ");
                inOrder(root.right, treeBuilder);
            }
        }
    }

    /**
     * LEFT - ROOT - RIGHT
     *
     * @param root
     */
    public static void inOrder(Node root) {
        final StringBuilder treeBuilder = new StringBuilder();
        inOrder(root, treeBuilder);
        System.out.println(treeBuilder.toString());
    }

    /**
     * LEFT - ROOT - RIGHT
     *
     * @param node
     */
    public static void inOrderIterative(Node node) {
        final StringBuilder treeBuilder = new StringBuilder();
        if (node != null) {
            Stack<Node> nodes = new Stack<>();
            while (!nodes.isEmpty() || node != null) {
                if (node != null) {
                    nodes.push(node);
                    node = node.left;
                } else {
                    node = nodes.pop();
                    // root
                    treeBuilder.append(node.data).append(" ");
                    node = node.right;
                }
            }
        }
        System.out.println(treeBuilder.toString());
    }

    /**
     * Returns the height of the binary search tree, which is the number of edges of the tree's root and it's furthest
     * leaf.
     *
     * @param root
     * @return
     */
    public static int height(Node root) {
        if (root == null) {
            return -1;
        }

        return (1 + Math.max(height(root.left), height(root.right)));
    }

    /**
     * Top view means when you look the tree from the top the nodes you will see will be called the top view of the
     * tree. See the example below.
     * <p>
     * <p>
     * You are given a pointer to the root of a binary tree. Print the top view of the binary tree. Top view means when
     * you look the tree from the top the nodes, what you will see will be called the top view of the tree. See the
     * example below. You only have to complete the function. For example :
     *
     * <pre>
     *  1
     *   \
     *    2
     *     \
     *      5
     *     /  \
     *    3    6
     *     \
     *      4
     * </pre>
     * <p>
     * Top View : 1 -> 2 -> 5 -> 6
     *
     * <pre>
     *        1
     *      /   \
     *     /     \
     *    2       3
     *   /  \    / \
     *  4    5  6   7
     * </pre>
     * <p>
     * Top view of the above binary tree is:4 2 1 3 7
     *
     * <pre>
     *     1
     *   /   \
     * 2       3
     *  \
     *   4
     *    \
     *     5
     *      \
     *       6
     * </pre>
     * <p>
     * Top view of the above binary tree is:2 1 3 6
     *
     * @param node
     * @param level
     */
    public static void printTreeTopView(Node node) {
        final StringBuilder treeBuilder = new StringBuilder();
        if (node != null) {
            Map<Integer, Integer> visited = new TreeMap<>();
            Queue<QueueNode> nodes = new LinkedList<>();
            nodes.offer(new QueueNode(node, 0));
            while (!nodes.isEmpty()) {
                QueueNode queueNode = nodes.poll();
                int level = queueNode.level;
                if (!visited.containsKey(level)) {
                    // print it, as it's the first element of the level.
                    treeBuilder.append(queueNode.node.data).append(" ");
                    visited.put(level, queueNode.node.data);
                }

                if (queueNode.node.left != null) {
                    // decrease level
                    nodes.offer(new QueueNode(queueNode.node.left, level - 1));
                }

                if (queueNode.node.right != null) {
                    // increase level
                    nodes.offer(new QueueNode(queueNode.node.right, level + 1));
                }
            }

            System.out.println("printTreeTopView");
            visited.forEach((k, v) -> {
                System.out.print(k + "-" + v + ", ");
            });
            System.out.println();
        }

        System.out.println("TreeTopView:");
        System.out.println(treeBuilder.toString());
    }

    static class QueueNode {

        Node node;
        int level;

        QueueNode(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /**
     * Input: 6 1 2 5 3 6 4
     *
     * @param root
     */
    public static void levelOrder(Node root) {
        final StringBuilder treeBuilder = new StringBuilder();

        if (root != null) {
            Queue<Node> nodes = new LinkedList<>();
            nodes.offer(root);
            while (!nodes.isEmpty()) {
                Node node = nodes.poll();
                treeBuilder.append(node.data).append(" ");
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
        }

        System.out.println(treeBuilder.toString());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // Make Binary Search Tree
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        Node root = null;
        while (t-- > 0) {
            in.skip("\n\r|[\r\n\u2027\u2028]?");
            int data = in.nextInt();
            root = insert(root, data);
        }
        in.close();

        // Height
        int height = getHeight(root);
        System.out.println("Height:" + height);

        // PreOrder
        System.out.println("\nPreOrder Traversal");
        preOrder(root);
        System.out.println("\nPreOrder Iterative Traversal");
        preOrderIterative(root);

        // PostOrder
        System.out.println("\nPostOrder Traversal");
        postOrder(root);
        System.out.println("\nPostOrder Iterative Traversal");
        postOrderIterative(root);

        // InOrder
        System.out.println("\nInOrder Traversal");
        inOrder(root);
        System.out.println("\nInOrder Iterative Traversal");
        inOrderIterative(root);

        // height
        System.out.println("Height:" + height(root));

        // TopView
        System.out.println("\nTree - Top View");
        printTreeTopView(root);

        // Level Order Traversal
        System.out.println("\nTree - Level Order Traversal");
        levelOrder(root);
    }

}
