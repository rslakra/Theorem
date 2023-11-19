/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.devamatre.theorem.adts.tree;

import static com.devamatre.appsuite.core.BeanUtils.isNotNull;
import static com.devamatre.appsuite.core.BeanUtils.isNull;

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * The formulae for calculating the array indices of the various relatives of a node are as follows.
 * <p>
 * The total number of nodes in the tree is n.
 * <p>
 * The index of the node in question is r, which must fall in the range 0 to n−1.
 * <p>
 * Parent(r) =⌊(r−1)/2⌋ if r≠0.
 * <p>
 * Left child(r) =2r+1 if 2r+1<n.
 * <p>
 * Right child(r) =2r+2 if 2r+2<n.
 * <p>
 * Left sibling(r) =r−1 if r is even and r≠0.
 * <p>
 * Right sibling(r) =r+1 if r is odd and r+1<n.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 5/18/18 1:54 PM
 * @since 1.0.0
 */
public enum TreeUtils {
    INSTANCE;

    public static final String BACK_SLASH = "/";
    public static final String SLASH = "\\";
    public static final String NULL = "null";
    public static final String NEW_LINE = "\n";
    public static final String SPACE = " ";
    public static final String LEFT = "┌─";
    public static final String RIGHT = "─┐";
    public static final String DASH = "─";

    private static final Logger LOGGER = LoggerFactory.getLogger(TreeUtils.class);

    /**
     * Returns the parent index.
     * <p>
     * The <code>index</code> should be greater than or equal to 1.
     * <p>
     * * Parent(r) = ⌊(r−1)/2⌋ if r≠0.
     *
     * @param index
     * @return
     */
    public static int parentIndex(int index) {
        return (index != 0 ? ((index - 1) / 2) : 0);
    }

    /**
     * Returns the left index.
     * <p>
     * The <code>index</code> should be greater than or equal to 0.
     * <p>
     * Left child(r) = 2r+1 if 2r+1<n.
     *
     * @param index
     * @return
     */
    public static int leftNodeIndex(int index) {
        return (2 * index + 1);
    }

    /**
     * Returns the right index.
     * <p>
     * The <code>index</code> should be greater than or equal to 0.
     * <p>
     * Right child(r) = 2r+2 if 2r+2<n.
     *
     * @param index
     * @return
     */
    public static int rightNodeIndex(int index) {
        return (2 * index + 2);
    }

    /**
     * Left sibling(r) = r−1 if r is even and r≠0.
     *
     * @param index
     * @return
     */
    public static int leftSiblingIndex(int index) {
        return (index != 0 ? (index - 1) : -1);
    }

    /**
     * Right sibling(r) =r+1 if r is odd and r+1<n.
     *
     * @param index
     * @return
     */
    public static int rightSiblingIndex(int index) {
        return (index != 0 ? (index + 1) : -1);
    }

    /**
     * @param treeNode
     * @param <T>
     * @return
     */
    public static <T> boolean isLeaf(TreeNode treeNode) {
        return (treeNode != null && treeNode.getLeft() == null && treeNode.getRight() == null);
    }

    /**
     * Returns the middle index.
     *
     * @param start
     * @param end
     * @return
     */
    public static int getMidIndex(int start, int end) {
        return (start + (end - start) / 2);
    }

    /**
     * Returns the height of the tree based on the size of the input.
     *
     * @param size
     * @return
     */
    public static int getHeightByInputSize(int size) {
        // ceil returns the 1 when the value is >= .5
        // return (int) (size <= 0 ? 0 : Math.ceil(Math.log(size) / Math.log(2)));
        return (int) (size <= 0 ? 0 : Math.floor(Math.log(size) / Math.log(2)));
    }

    /**
     * Returns the size of how much memory should allocate to the tree based on the height of the tree.
     *
     * @param height
     * @return
     */
    public static int getMemoryAllotmentByTreeHeight(int height) {
        return (2 * (int) Math.pow(2, height) - 1); // Maximum size of tree
    }

    /**
     * @param size
     * @return
     */
    public static int getMemoryAllotmentByInputSize(int size) {
        return (2 * (int) Math.pow(2, getHeightByInputSize(size)) - 1); // Maximum size of tree
    }

    /**
     * This method is to construct a normal binary tree.
     * <p>
     * The input reads like this for [5, 3, 6, 2, 4, null, null, 1],
     *
     * <pre>
     *             5
     *           /   \
     *          3     6
     *         / \   / \
     *        2   4 #   #
     *       /
     *      1
     * </pre>
     *
     * @param treeValues
     * @return
     */
    public static <T> TreeNode<T> buildBinaryTree(List<T> treeValues) {
        TreeNode<T> treeNode = new TreeNode(treeValues.get(0));
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(treeNode);
        for (int i = 1; i < treeValues.size(); i++) {
            TreeNode<T> current = queue.poll();
            if (isNotNull(treeValues.get(i))) {
                current.setLeft(new TreeNode(treeValues.get(i)));
                queue.offer(current.getLeft());
            }
            if (++i < treeValues.size() && isNotNull(treeValues.get(i))) {
                current.setRight(new TreeNode(treeValues.get(i)));
                queue.offer(current.getRight());
            }
        }

        return treeNode;
    }

    /**
     * Builds the binary tree with the inputCommaSeparated string.
     *
     * @param inputCommaSeparated
     * @return
     */
    public static <T> TreeNode<T> buildBinaryTree(String inputCommaSeparated) {
        if (BeanUtils.isEmpty(inputCommaSeparated)) {
            return null;
        }

        String[] inputs = inputCommaSeparated.split(",");
        // consider first element as the root element
        String item = inputs[0].trim();
        TreeNode<T> rootNode = new TreeNode(item);
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.add(rootNode);

        int index = 1; // the next element of the input is the child of the root.
        while (!queue.isEmpty()) {
            // removes head of the queue
            TreeNode<T> treeNode = queue.remove();

            // check more elements exist
            if (index == inputs.length) {
                break;
            }

            item = inputs[index++].trim();
            if (!NULL.equals(item)) {
                treeNode.setLeft(new TreeNode(item));
                queue.add(treeNode.getLeft());
            }

            // check more elements exist
            if (index == inputs.length) {
                break;
            }

            item = inputs[index++].trim();
            if (!NULL.equals(item)) {
                treeNode.setRight(new TreeNode(item));
                queue.add(treeNode.getRight());
            }
        }

        return rootNode;
    }

    /**
     * Returns the max level (height) of the node.
     *
     * @param treeNode
     * @return
     */
    public static int getHeight(TreeNode treeNode) {
        return (Objects.isNull(treeNode) ? 0 : (Math.max(getHeight(treeNode.getLeft()), getHeight(treeNode.getRight()))
                                                + 1));
    }

    /**
     * <pre>
     *             1
     *           /   \
     *          /     \
     *         2       3
     *        / \     / \
     *       4  5    6   7
     * </pre>
     *
     * @param list
     * @param level
     * @param maxLevel
     */
    private static void printNodeInternal(List<TreeNode> list, int level, int maxLevel) {
        if (list.isEmpty() || AlgoUtils.isAllNull(list)) {
            return;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int gapBetweenNodes = (int) Math.pow(2, (floor + 1)) - 1;

        AlgoUtils.printWhiteSpaces(firstSpaces);

        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : list) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(SPACE);
            }

            AlgoUtils.printWhiteSpaces(gapBetweenNodes);
        }
        System.out.println("");

        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < list.size(); j++) {
                AlgoUtils.printWhiteSpaces(firstSpaces - i);
                if (list.get(j) == null) {
                    AlgoUtils.printWhiteSpaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (list.get(j).hasLeft()) {
                    System.out.print(BACK_SLASH);
                } else {
                    AlgoUtils.printWhiteSpaces(1);
                }

                AlgoUtils.printWhiteSpaces(i + i - 1);

                if (list.get(j).hasRight()) {
                    System.out.print(SLASH);
                } else {
                    AlgoUtils.printWhiteSpaces(1);
                }

                AlgoUtils.printWhiteSpaces(edgeLines + edgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    /**
     * @param treeNode
     */
    public static void printBinaryTree(TreeNode treeNode) {
        AlgoUtils.println("\nPrinting out the binary tree in a very visual manner as below:\n");
        int maxLevel = TreeUtils.getHeight(treeNode);
        printNodeInternal(Collections.singletonList(treeNode), 1, maxLevel);
    }

    /**
     * Prints the pretty tree.
     *
     * <pre>
     *  │       ┌── 7
     *  │   ┌── 3
     *  │   │   └── 6
     *  └── 1
     *      │   ┌── 5
     *      └── 2
     *          └── 4
     * </pre>
     *
     * @param node
     * @param prefix
     * @param isLeft
     */
    public static void printPrettyTreeVertically(TreeNode node, String prefix, boolean isLeft) {
        if (node == null) {
            System.out.println("Empty tree");
            return;
        }

        if (node.hasRight()) {
            printPrettyTreeVertically(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.getValue());

        if (node.hasLeft()) {
            printPrettyTreeVertically(node.getLeft(), prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    /**
     * Prints the pretty tree.
     *
     * @param node
     */
    public static void printPrettyTreeVertically(TreeNode node) {
        printPrettyTreeVertically(node, "", true);
    }

    /**
     * Counts the spaces required based on the height.
     *
     * @param height
     * @return
     */
    public static int countSpaces(int height) {
        return (int) (3 * Math.pow(2, height - 2) - 1);
    }

    /**
     * @param height
     * @return
     */
    public static int countSlashes(int height) {
        return ((height <= 3) ? (height - 1) : (int) (3 * Math.pow(2, height - 3) - 1));
    }

    /**
     * Returns the length of the path to its root.
     *
     * @param node
     * @return
     */
    public static <T> int maxDepth(Node<T> node) {
        return (node == null ? 0 : 1 + maxDepth(node.getParent()));
    }

    /**
     * Returns the length of the longest path to a leaf.
     *
     * @param node
     * @return
     */
    public static <T> int maxHeight(Node<T> node) {
        return (node == null ? 0 : 1 + (Math.max(maxHeight(node.getLeft()), maxHeight(node.getRight()))));
    }

    /**
     * Adds the <code>totalSpaces</code>.
     *
     * @param totalSpaces
     * @param treeBuilder
     */
    public static void addSpaces(int totalSpaces, StringBuilder treeBuilder) {
        for (int i = 0; i < totalSpaces; i++) {
            treeBuilder.append(SPACE);
        }
    }

    /**
     * Adds the <code>totalSpaces</code>.
     *
     * @param totalSpaces
     * @param treeBuilder
     */
    private static <T> void addNode(int totalSpaces, StringBuilder treeBuilder, Node<T> node) {
        // left side
        treeBuilder.append(LEFT);
        for (int i = 0; i < totalSpaces; i++) {
            treeBuilder.append(DASH);
        }
        treeBuilder.append(SPACE);
        treeBuilder.append(node.getValue());
        // right side
        treeBuilder.append(SPACE);
        for (int i = 0; i < totalSpaces; i++) {
            treeBuilder.append(DASH);
        }
        treeBuilder.append(RIGHT);
    }

    /**
     * Builds the spatial block for the node and spaces.
     *
     * @param node
     * @param spaces
     * @param <T>
     * @return
     */
    private static <T> String buildSpatialBlock(final Node<T> node, int spaces) {
        return (node == null
                ? String.format("%" + (2 * spaces + 1) + "s%n", "")
//                : String.format("%" + (spaces + 1) + "s%" + spaces + "s", node.getValue(), "")
                : String.format("%" + (spaces + 1) + "s%" + spaces + "s", LEFT + node.getValue() + RIGHT, "")
        );
    }

    /**
     * Prints the pretty tree.
     *
     * <pre>
     *      1
     *     / \
     *    /   \
     *   2     3
     * </pre>
     *
     * @param node
     * @param currentHeight
     * @param maxHeight
     * @return
     */
    public static <T> StringBuilder printPrettyTree(Node<T> node, int currentHeight, int maxHeight) {
        final StringBuilder treeBuilder = new StringBuilder();
        int spaces = countSpaces(maxHeight - currentHeight + 1);
        if (isNull(node)) {
            // create a 'spatial' block and return it
            String row = buildSpatialBlock(node, spaces);
            // now repeat this row space+1 times
            final String block = new String(new char[spaces + 1]).replace("\0", row);
            return new StringBuilder(block);
        }

        if (currentHeight == maxHeight) {
            return new StringBuilder(node.getValue().toString());
        }

        treeBuilder.append(buildSpatialBlock(node, spaces));
        treeBuilder.append(NEW_LINE);
        /* now print / and \ but make sure that left and right exists */
        String leftSlash = node.hasLeft() ? BACK_SLASH : SPACE;
        String rightSlash = node.hasRight() ? SLASH : SPACE;
        int spaceInBetween = 1;
        int slashes = countSlashes(maxHeight - currentHeight + 1);
        for (int i = 0, space = spaces - 1; i < slashes; i++, space--, spaceInBetween += 2) {
            addSpaces(space, treeBuilder);
            treeBuilder.append(leftSlash);
            addSpaces(spaceInBetween, treeBuilder);
            treeBuilder.append(rightSlash);
            addSpaces(space, treeBuilder);
            treeBuilder.append(NEW_LINE);
        }

        /* now get string representations of left and right subtrees */
        final StringBuilder leftTreeBuilder = printPrettyTree(node.getLeft(), currentHeight + 1, maxHeight);
        final StringBuilder rightTreeBuilder = printPrettyTree(node.getRight(), currentHeight + 1, maxHeight);
        /* now line by line print the trees side by side */
        final Scanner leftScanner = new Scanner(leftTreeBuilder.toString());
        final Scanner rightScanner = new Scanner(rightTreeBuilder.toString());
        // spaceInBetween+=1;
        while (leftScanner.hasNextLine()) {
            if (currentHeight == maxHeight - 1) {
                treeBuilder.append(String.format("%-2s %2s", leftScanner.nextLine(), rightScanner.nextLine()));
                treeBuilder.append(NEW_LINE);
                spaceInBetween -= 2;
            } else {
                treeBuilder.append(leftScanner.nextLine());
                treeBuilder.append(SPACE);
                treeBuilder.append(rightScanner.nextLine());
                treeBuilder.append(NEW_LINE);
            }
        }

        leftScanner.close();
        rightScanner.close();

        return treeBuilder;
    }

    /**
     * @param node
     * @param <T>
     * @return
     */
    public static <T> StringBuilder printPrettyTree(Node<T> node) {
        return printPrettyTree(node, 0, TreeUtils.maxHeight(node));
    }

    /**
     * <pre>
     *  │       ┌── 7
     *  │   ┌── 3
     *  │   │   └── 6
     *  └── 1
     *      │   ┌── 5
     *      └── 2
     *          └── 4
     * </pre>
     *
     * @param node
     * @param prefix
     * @param isLeft
     * @param <T>
     * @return
     */
    public static <T> StringBuilder prettyTreeHorizontally(Node<T> node, int level, int maxLevel) {
        StringBuilder treeBuilder = new StringBuilder();
        if (isNull(node)) {
            return treeBuilder;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int gapBetweenNodes = (int) Math.pow(2, (floor + 1)) - 1;

        addSpaces(firstSpaces, treeBuilder);
        treeBuilder.append(node.getValue());

//        List<TreeNode> newNodes = new ArrayList<>();
//        for (TreeNode node : list) {
//            if (node != null) {
//                System.out.print(node.getValue());
//                newNodes.add(node.getLeft());
//                newNodes.add(node.getRight());
//            } else {
//                newNodes.add(null);
//                newNodes.add(null);
//                System.out.print(SPACE);
//            }
//
//            AlgoUtils.printWhiteSpaces(gapBetweenNodes);
//        }
//        System.out.println("");

//        for (int i = 1; i <= edgeLines; i++) {
//            for (int j = 0; j < list.size(); j++) {
//                AlgoUtils.printWhiteSpaces(firstSpaces - i);
//                if (list.get(j) == null) {
//                    AlgoUtils.printWhiteSpaces(edgeLines + edgeLines + i + 1);
//                    continue;
//                }
//
//                if (list.get(j).hasLeft()) {
//                    System.out.print(BACK_SLASH);
//                } else {
//                    AlgoUtils.printWhiteSpaces(1);
//                }
//
//                AlgoUtils.printWhiteSpaces(i + i - 1);
//
//                if (list.get(j).hasRight()) {
//                    System.out.print(SLASH);
//                } else {
//                    AlgoUtils.printWhiteSpaces(1);
//                }
//
//                AlgoUtils.printWhiteSpaces(edgeLines + edgeLines - i);
//            }
//
//            System.out.println("");
//        }

        treeBuilder.append(prettyTreeHorizontally(node.getLeft(), level + 1, maxLevel));
        treeBuilder.append(prettyTreeHorizontally(node.getRight(), level + 1, maxLevel));

        return treeBuilder;
    }

    /**
     * @param node
     * @param <T>
     * @return
     */
    public static <T> StringBuilder printPrettyTreeHorizontally(Node<T> node) {
        /**
         * <pre>
         *        ┌─     1     ─┐
         *    ┌─  2  ─┐     ┌─  3  ─┐
         *
         * </pre>
         */
        final StringBuilder treeBuilder = new StringBuilder();
        if (Objects.nonNull(node)) {
            int level = 0;
            int maxLevels = maxHeight(node);
            Queue<Node<T>> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                int floor = maxLevels - level;
                int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
                int size = queue.size();
                level++;
                while (size > 0) {
                    Node<T> tempNode = queue.remove();
                    int sideSpaces = floor * edgeLines;
                    // print current tempNode
                    int leftSpaces = (int) Math.pow(2, (edgeLines + 1)) - 1;
                    addSpaces(leftSpaces, treeBuilder);
                    addNode(sideSpaces, treeBuilder, tempNode);
                    addSpaces(leftSpaces - 1, treeBuilder);

                    // add left tempNode if available
                    if (tempNode.getLeft() != null) {
                        queue.add(tempNode.getLeft());
                    }

                    // add right tempNode if available
                    if (tempNode.getRight() != null) {
                        queue.add(tempNode.getRight());
                    }
                    size--;
                }
                treeBuilder.append(NEW_LINE);
            }
        }

        return treeBuilder;
    }

    /**
     * Removes the last space.
     *
     * @param nodeBuilder
     */
    public static void trimLastSpace(final StringBuilder nodeBuilder) {
        // remove last white space.
        int lastIndex = nodeBuilder.lastIndexOf(SPACE);
        if (lastIndex != -1) {
            nodeBuilder.deleteCharAt(lastIndex);
        }
    }

    /**
     * Returns the list of level-order nodes.
     *
     * <pre>
     *             1
     *           /   \
     *          /     \
     *         2       3
     *        / \     / \
     *       4  5    6   7
     * </pre>
     * <p>
     * Level Order Traversal <code>Leve 0 -> Level 1 -> Level N</code>
     * <p>
     * InOrder: [[1], [2, 3], [4, 5, 6, 7]]
     *
     * @param treeNode
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> getLevelOrders(TreeNode<T> treeNode) {
        List<List<T>> levelOrders = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.add(treeNode);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<T> levelOrder = new ArrayList<>();
                while (size > 0) {
                    TreeNode<T> node = queue.remove();
                    // print current node
                    levelOrder.add(node.getValue());
                    // add left node if available
                    if (node.getLeft() != null) {
                        queue.add(node.getLeft());
                    }
                    // add right node if available
                    if (node.getRight() != null) {
                        queue.add(node.getRight());
                    }
                    size--;
                }
                levelOrders.add(levelOrder);
            }
        }

        return levelOrders;
    }


    /**
     * Returns the list of level-order nodes.
     *
     * <pre>
     *             1
     *           /   \
     *          /     \
     *         2       3
     *        / \     / \
     *       4  5    6   7
     * </pre>
     * <p>
     * Level Order Traversal <code>Leve 0 -> Level 1 -> Level N</code>
     * <p>
     * InOrder: [[1], [2, 3], [4, 5, 6, 7]]
     *
     * @param node
     * @param <T>
     * @return
     */
    public static <T> List<List<T>> getLevelOrders(Node<T> node) {
        List<List<T>> levelOrders = new ArrayList<>();
        if (Objects.nonNull(node)) {
            Queue<Node<T>> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<T> levelOrder = new ArrayList<>();
                while (size > 0) {
                    Node<T> tempNode = queue.remove();
                    // print current tempNode
                    levelOrder.add(tempNode.getValue());
                    // add left tempNode if available
                    if (tempNode.getLeft() != null) {
                        queue.add(tempNode.getLeft());
                    }
                    // add right tempNode if available
                    if (tempNode.getRight() != null) {
                        queue.add(tempNode.getRight());
                    }
                    size--;
                }
                levelOrders.add(levelOrder);
            }
        }

        return levelOrders;
    }

    /**
     * Returns the list of nodes using <code>in-order</code> traversal recursively.
     *
     * <pre>
     *             1
     *           /   \
     *          /     \
     *         2       3
     *        / \     / \
     *       4  5    6   7
     * </pre>
     * <p>
     * InOrder Traversal <code>Left -> Root -> Right</code>
     * <p>
     * i.e: [4, 2, 5, 1, 6, 3, 7]
     *
     * @param treeNode
     */
    public static <T> List<T> inOrder(TreeNode<T> treeNode) {
        List<T> inOrder = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            inOrder.addAll(inOrder(treeNode.getLeft()));
            inOrder.add((T) treeNode.getValue());
            inOrder.addAll(inOrder(treeNode.getRight()));
        }

        return inOrder;
    }

    /**
     * Returns the list of nodes using <code>pre-order</code> traversal recursively.
     *
     * <pre>
     *             1
     *           /   \
     *          /     \
     *         2       3
     *        / \     / \
     *       4  5    6   7
     * </pre>
     * <p>
     * InOrder Traversal <code>Root -> Left -> Right</code>
     * <p>
     * i.e: [1, 2, 4, 5, 3, 6, 7]
     *
     * @param treeNode
     */
    public static <T> List<T> preOrder(TreeNode treeNode) {
        List<T> inOrder = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            inOrder.add((T) treeNode.getValue());
            inOrder.addAll(preOrder(treeNode.getLeft()));
            inOrder.addAll(preOrder(treeNode.getRight()));
        }

        return inOrder;
    }

    /**
     * Returns the list of nodes using <code>post-order</code> traversal recursively.
     *
     * <pre>
     *             1
     *           /   \
     *          /     \
     *         2       3
     *        / \     / \
     *       4  5    6   7
     * </pre>
     * <p>
     * InOrder Traversal <code>Left -> Right -> Root</code>
     * <p>
     * i.e: [4, 5, 2, 6, 7, 3, 1]
     *
     * @param treeNode
     */
    public static <T> List<T> postOrder(TreeNode<T> treeNode) {
        List<T> inOrder = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            inOrder.addAll(postOrder(treeNode.getLeft()));
            inOrder.addAll(postOrder(treeNode.getRight()));
            inOrder.add((T) treeNode.getValue());
        }

        return inOrder;
    }

    /**
     * Returns the list of nodes using <code>in-order</code> traversal recursively.
     *
     * <pre>
     *             1
     *           /   \
     *          /     \
     *         2       3
     *        / \     / \
     *       4  5    6   7
     * </pre>
     * <p>
     * InOrder Traversal <code>Left -> Root -> Right</code>
     * <p>
     * i.e: [4, 2, 5, 1, 6, 3, 7]
     *
     * <pre>
     *  1. Pick a node. Push all adjacent nodes into a stack.
     *  2. Pop a node from that stack and push adjacent nodes into another stack.
     *  3. Repeat until the stack is empty or you have reached your goal. As you visit nodes, you must mark them as
     *  visited before proceeding, or you will be stuck in an infinite loop.
     * </pre>
     *
     * @param node
     */
    public static <T> String inOrderTraversal(Node<T> node) {
        final boolean includeNullNode = false;
        final List<String> inOrder = new ArrayList<>();
        if (isNotNull(node)) {
            Node tempNode = node;
            Stack<Node<T>> stack = new Stack<>();
            while (!stack.isEmpty() || isNotNull(tempNode)) {
                // push left tree to the stack
                while (isNotNull(tempNode)) {
                    stack.push(tempNode);
                    tempNode = tempNode.getLeft();
                }

                // remove the top node of the stack
                tempNode = stack.pop();
                // check if the tempNode is null or not
                if (BeanUtils.isNull(tempNode)) {
                    if (includeNullNode) { // include <null> tempNode or not.
                        inOrder.add(NULL);
                    }

                    continue;
                }

                inOrder.add(tempNode.getValue().toString());
                tempNode = tempNode.getRight();
            }
        }

        return inOrder.toString();
    }


    /**
     * Returns the list of nodes using <code>pre-order</code> traversal recursively.
     *
     * <pre>
     *             1
     *           /   \
     *          /     \
     *         2       3
     *        / \     / \
     *       4  5    6   7
     * </pre>
     * <p>
     * InOrder Traversal <code>Root -> Left -> Right</code>
     * <p>
     * i.e: [1, 2, 4, 5, 3, 6, 7]
     *
     * @param treeNode
     */
    public static <T> String preOrderTraversal(TreeNode<T> treeNode) {
        final boolean includeNullNode = false;
        final List<String> preOrder = new ArrayList<>();
        if (isNotNull(treeNode)) {
            Stack<TreeNode<T>> stack = new Stack<>();
            stack.push(treeNode);
            while (!stack.isEmpty()) {
                // remove the top node of the stack
                TreeNode popNode = stack.pop();
                // check if the treeNode is null or not
                if (BeanUtils.isNull(popNode)) {
                    if (includeNullNode) { // include <null> treeNode or not.
                        preOrder.add(NULL);
                    }

                    continue;
                }

                preOrder.add(popNode.getValue().toString());
                stack.push(popNode.getRight());
                stack.push(popNode.getLeft());
            }
        }

        return preOrder.toString();
    }

    /**
     * Returns the list of nodes using <code>post-order</code> traversal recursively.
     *
     * <pre>
     *             1
     *           /   \
     *          /     \
     *         2       3
     *        / \     / \
     *       4  5    6   7
     * </pre>
     * <p>
     * InOrder Traversal <code>Left -> Right -> Root</code>
     * <p>
     * i.e: [4, 5, 2, 6, 7, 3, 1]
     *
     * @param treeNode
     */
    public static <T> String postOrderTraversal(TreeNode<T> treeNode) {
        final boolean includeNullNode = false;
        final List<String> postOrder = new ArrayList<>();
        if (isNotNull(treeNode)) {
            Stack<TreeNode<T>> stack = new Stack<>();
            TreeNode current = treeNode;
            TreeNode lastVisited = null;
            while (!stack.isEmpty() || isNotNull(current)) {
                // push left tree to the stack
                if (isNotNull(current)) { // push left tree to the stack if the current is not null
                    stack.push(current);
                    current = current.getLeft();
                } else {
                    // peek node from the stack
                    TreeNode peekNode = stack.peek();
                    // check peekNode has right child and is not the last visited node
                    if (peekNode.hasRight() && peekNode.getRight() != lastVisited) {
                        current = peekNode.getRight();
                    } else {
                        // process the current node
                        postOrder.add(peekNode.getValue().toString());
                        // mark the last visited node of the stack
                        lastVisited = stack.pop();
                    }
                }
            }
        }

        return postOrder.toString();
    }

}
