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

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

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
     * Returns the index of the left child.
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
     * @param node
     * @return
     */
    public static <E extends Comparable> boolean isLeaf(Node node) {
        return (node != null && !node.hasLeft() && !node.hasRight());
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
     *       /\
     *      1 #
     * </pre>
     *
     * @param treeValues
     * @return
     */
    public static <E extends Comparable> TreeNode<E> buildBinaryTree(List<E> treeValues) {
        TreeNode<E> treeNode = new TreeNode(treeValues.get(0));
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.offer(treeNode);
        for (int i = 1; i < treeValues.size(); i++) {
            TreeNode<E> current = queue.poll();
            if (Objects.nonNull(treeValues.get(i))) {
                current.setLeft(new TreeNode(treeValues.get(i)));
                queue.offer(current.getLeft());
            }
            if (++i < treeValues.size() && Objects.nonNull(treeValues.get(i))) {
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
    public static <E extends Comparable> TreeNode<E> buildBinaryTree(String inputCommaSeparated) {
        if (BeanUtils.isEmpty(inputCommaSeparated)) {
            return null;
        }

        String[] inputs = inputCommaSeparated.split(",");
        // consider first element as the root element
        String item = inputs[0].trim();
        TreeNode<E> rootNode = new TreeNode(item);
        Queue<TreeNode<E>> queue = new LinkedList<>();
        queue.add(rootNode);

        int index = 1; // the next element of the input is the child of the root.
        while (!queue.isEmpty()) {
            // removes head of the queue
            TreeNode<E> treeNode = queue.remove();

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
     * @param node
     * @return
     */
    public static int getHeight(Node node) {
        return (node == null ? 0 : (Math.max(getHeight(node.getLeft()), getHeight(node.getRight())) + 1));
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
     * @param nodes
     * @param level
     * @param maxLevel
     */
    private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || AlgoUtils.isAllNull(nodes)) {
            return;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int gapBetweenNodes = (int) Math.pow(2, (floor + 1)) - 1;

        AlgoUtils.printWhiteSpaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (Objects.nonNull(node)) {
                System.out.print(node.getData());
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
            for (int j = 0; j < nodes.size(); j++) {
                AlgoUtils.printWhiteSpaces(firstSpaces - i);
                if (Objects.isNull(nodes.get(j))) {
                    AlgoUtils.printWhiteSpaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).hasLeft()) {
                    System.out.print(BACK_SLASH);
                } else {
                    AlgoUtils.printWhiteSpaces(1);
                }

                AlgoUtils.printWhiteSpaces(i + i - 1);

                if (nodes.get(j).hasRight()) {
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
    public static void printBinaryTree(Node treeNode) {
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
    public static void printPrettyTreeVertically(Node node, String prefix, boolean isLeft) {
        if (node == null) {
            System.out.println("Empty tree");
            return;
        }

        if (node.hasRight()) {
            printPrettyTreeVertically(node.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + node.getData());

        if (node.hasLeft()) {
            printPrettyTreeVertically(node.getLeft(), prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    /**
     * Prints the pretty tree.
     *
     * @param node
     */
    public static void printPrettyTreeVertically(Node node) {
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
    public static <E extends Comparable> int maxDepth(Node<E> node) {
        return (node == null ? 0 : maxDepth(node.getParent()) + 1);
    }

    /**
     * Returns the length of the longest path to a leaf.
     *
     * @param node
     * @return
     */
    public static <E extends Comparable> int maxHeight(Node<E> node) {
        return (node == null ? 0 : Math.max(maxHeight(node.getLeft()), maxHeight(node.getRight())) + 1);
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
    private static <E extends Comparable> void addNode(int totalSpaces, StringBuilder treeBuilder, Node<E> node) {
        // left side
        treeBuilder.append(LEFT);
        for (int i = 0; i < totalSpaces; i++) {
            treeBuilder.append(DASH);
        }
        treeBuilder.append(SPACE);
        treeBuilder.append(node.getData());
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
     * @return
     */
    private static <E extends Comparable> String buildSpatialBlock(final Node<E> node, int spaces) {
        return (node == null ? String.format("%" + (2 * spaces + 1) + "s%n", "")
//                : String.format("%" + (spaces + 1) + "s%" + spaces + "s", node.getValue(), "")
                             : String.format("%" + (spaces + 1) + "s%" + spaces + "s", LEFT + node.getData() + RIGHT,
                                             ""));
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
    public static <E extends Comparable> StringBuilder printPrettyTree(Node<E> node, int currentHeight, int maxHeight) {
        final StringBuilder treeBuilder = new StringBuilder();
        int spaces = countSpaces(maxHeight - currentHeight + 1);
        if (Objects.isNull(node)) {
            // create a 'spatial' block and return it
            String row = buildSpatialBlock(node, spaces);
            // now repeat this row space+1 times
            final String block = new String(new char[spaces + 1]).replace("\0", row);
            return new StringBuilder(block);
        }

        if (currentHeight == maxHeight) {
            return new StringBuilder(node.getData().toString());
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
     * @param <E   extends Comparable>
     * @return
     */
    public static <E extends Comparable> StringBuilder printPrettyTree(Node<E> node) {
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
     * @param level
     * @param maxLevel
     * @return
     */
    public static <E extends Comparable> StringBuilder prettyTreeHorizontally(Node<E> node, int level, int maxLevel) {
        StringBuilder treeBuilder = new StringBuilder();
        if (Objects.isNull(node)) {
            return treeBuilder;
        }

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int gapBetweenNodes = (int) Math.pow(2, (floor + 1)) - 1;

        addSpaces(firstSpaces, treeBuilder);
        treeBuilder.append(node.getData());

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
     * @param <E   extends Comparable>
     * @return
     */
    public static <E extends Comparable> StringBuilder printPrettyTreeHorizontally(Node<E> node) {
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
            Queue<Node<E>> queue = new LinkedList<>();
            queue.add(node);
            while (!queue.isEmpty()) {
                int floor = maxLevels - level;
                int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
                int size = queue.size();
                level++;
                while (size > 0) {
                    Node<E> tempNode = queue.remove();
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
     * @return
     */
    public static <E extends Comparable> List<List<E>> getLevelOrders(Node<E> treeNode) {
        List<List<E>> levelOrders = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            Queue<Node<E>> queue = new LinkedList<>();
            queue.add(treeNode);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<E> levelOrder = new ArrayList<>();
                while (size > 0) {
                    Node<E> node = queue.remove();
                    // print current node
                    levelOrder.add(node.getData());
                    // add left node if available
                    if (node.hasLeft()) {
                        queue.add(node.getLeft());
                    }
                    // add right node if available
                    if (node.hasRight()) {
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
    public static <E extends Comparable> List<E> inOrder(Node<E> treeNode) {
        LOGGER.debug("+preOrder({})", treeNode);
        List<E> inOrder = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            inOrder.addAll(inOrder(treeNode.getLeft()));
            LOGGER.debug("data:{}", treeNode.getData());
            inOrder.add(treeNode.getData());
            inOrder.addAll(inOrder(treeNode.getRight()));
        }

        LOGGER.debug("-preOrder(), inOrder:{}", inOrder);
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
    public static <E extends Comparable> List<E> preOrder(Node<E> treeNode) {
        LOGGER.debug("+preOrder({})", treeNode);
        List<E> preOrder = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            LOGGER.debug("data:{}", treeNode.getData());
            preOrder.add(treeNode.getData());
            if (treeNode.hasLeft()) {
                preOrder.addAll(preOrder(treeNode.getLeft()));
            }

            if (treeNode.hasRight()) {
                preOrder.addAll(preOrder(treeNode.getRight()));
            }
        }

        LOGGER.debug("-preOrder(), preOrder:{}", preOrder);
        return preOrder;
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
    public static <E extends Comparable> List<E> postOrder(Node<E> treeNode) {
        LOGGER.debug("+postOrder({})", treeNode);
        List<E> postOrder = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            postOrder.addAll(postOrder(treeNode.getLeft()));
            postOrder.addAll(postOrder(treeNode.getRight()));
            LOGGER.debug("data:{}", treeNode.getData());
            postOrder.add(treeNode.getData());
        }

        LOGGER.debug("-postOrder(), postOrder:{}", postOrder);
        return postOrder;
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
    public static <E extends Comparable> String inOrderTraversal(Node<E> node) {
        final boolean includeNullNode = false;
        final List<String> inOrder = new ArrayList<>();
        if (Objects.nonNull(node)) {
            Node tempNode = node;
            Stack<Node<E>> stack = new Stack<>();
            while (!stack.isEmpty() || Objects.nonNull(tempNode)) {
                // push left tree to the stack
                while (Objects.nonNull(tempNode)) {
                    stack.push(tempNode);
                    tempNode = tempNode.getLeft();
                }

                // remove the top node of the stack
                tempNode = stack.pop();
                // check if the tempNode is null or not
                if (Objects.isNull(tempNode)) {
                    if (includeNullNode) { // include <null> tempNode or not.
                        inOrder.add(NULL);
                    }

                    continue;
                }

                inOrder.add(tempNode.getData().toString());
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
    public static <E extends Comparable> String preOrderTraversal(Node<E> treeNode) {
        final boolean includeNullNode = false;
        final List<String> preOrder = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            Stack<Node<E>> stack = new Stack<>();
            stack.push(treeNode);
            while (!stack.isEmpty()) {
                // remove the top node of the stack
                Node popNode = stack.pop();
                // check if the treeNode is null or not
                if (Objects.isNull(popNode)) {
                    if (includeNullNode) { // include <null> treeNode or not.
                        preOrder.add(NULL);
                    }

                    continue;
                }

                preOrder.add(popNode.getData().toString());
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
    public static <E extends Comparable> String postOrderTraversal(Node<E> treeNode) {
        final boolean includeNullNode = false;
        final List<String> postOrder = new ArrayList<>();
        if (Objects.nonNull(treeNode)) {
            Stack<Node<E>> stack = new Stack<>();
            Node current = treeNode;
            Node lastVisited = null;
            while (!stack.isEmpty() || Objects.nonNull(current)) {
                // push left tree to the stack
                if (Objects.nonNull(current)) { // push left tree to the stack if the current is not null
                    stack.push(current);
                    current = current.getLeft();
                } else {
                    // peek node from the stack
                    Node peekNode = stack.peek();
                    // check peekNode has right child and is not the last visited node
                    if (peekNode.hasRight() && peekNode.getRight() != lastVisited) {
                        current = peekNode.getRight();
                    } else {
                        // process the current node
                        postOrder.add(peekNode.getData().toString());
                        // mark the last visited node of the stack
                        lastVisited = stack.pop();
                    }
                }
            }
        }

        return postOrder.toString();
    }


    /**
     * Traverses a tree in a pre-order (ROOT-LEFT-RIGHT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Visit root node. Step 2 − Recursively traverse left subtree. Step 3 −
     * Recursively traverse right subtree.
     *
     * @param node
     * @param addBrackets
     * @return
     */
    public static <E extends Comparable> String preOrderTraversal(Node<E> node, final boolean addBrackets) {
        final StringBuilder nodeBuilder = new StringBuilder();
        if (addBrackets) {
            nodeBuilder.append("[");
        }

        /*
         * Push root node in the stack. Iterate until stack is empty.
         * Pop all items one by one. Do following for every popped item:
         * a) print it
         * b) push its right child
         * c) push its left child
         * Note that right child is pushed first so that left is processed
         * first.
         */
        if (node != null) {
            final Stack<Node<E>> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                // append root node
                nodeBuilder.append(node.getData()).append(" ");

                // push right node
                if (node.hasRight()) {
                    stack.push(node.getRight());
                }

                // push left node
                if (node.hasLeft()) {
                    stack.push(node.getLeft());
                }
            }

            // remove last white space.
            TreeUtils.trimLastSpace(nodeBuilder);
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

    /**
     * Traverses a tree in an in-order (LEFT-ROOT-RIGHT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Recursively traverse left subtree. Step 2 − Visit root node. Step 3 −
     * Recursively traverse right subtree.
     */
    public static <E extends Comparable> String inOrderTraversal(Node<E> node, final boolean addBrackets) {
        final StringBuilder nodeBuilder = new StringBuilder();
        if (addBrackets) {
            nodeBuilder.append("[");
        }

        /*
         * Create empty stack.
         * Iterate until stack is empty or node != null.
         * If node != null, push the node into stack and assign traverse to
         * left tree.
         * Else pop item from the stack, print it and traverse to right
         * tree.
         */
        if (node != null) {
            final Stack<Node<E>> stack = new Stack<>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                } else {
                    node = stack.pop();
                    // append node
                    nodeBuilder.append(node.getData()).append(" ");
                    node = node.getRight();
                }
            }

            // remove last white space.
            TreeUtils.trimLastSpace(nodeBuilder);
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

    /**
     * Traverses a tree in a post-order (LEFT-RIGHT-ROOT) manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Recursively traverse left subtree. Step 2 − Recursively traverse right
     * subtree. Step 3 − Visit root node.
     */
    public static <E extends Comparable> String postOrderTraversal(Node<E> node, final boolean addBrackets) {
        final StringBuilder nodeBuilder = new StringBuilder();
        if (addBrackets) {
            nodeBuilder.append("[");
        }

        /*
         * Create empty stack.
         * Set lastVisited to be null;
         * Iterate until stack is empty or node != null
         * If node != null, push the node into stack and traverse to left
         * tree.
         * Else peek item from the stack and do the following
         * if peekNode.right != null and lastVisited != peekNode.right then
         * traverse to right tree
         * node = peekNode.right
         * else
         * visit(node)
         * lastVisited = stack.pop()
         */
        if (node != null) {
            final Stack<Node<E>> stack = new Stack<>();
            Node<E> lastVisited = null;
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.getLeft();
                } else {
                    Node<E> peekNode = stack.peek();
                    if (peekNode.getRight() != null && lastVisited != peekNode.getRight()) {
                        node = peekNode.getRight();
                    } else {
                        // append node
                        nodeBuilder.append(peekNode.getData()).append(" ");
                        lastVisited = stack.pop();
                    }
                }
            }

            // remove last white space.
            TreeUtils.trimLastSpace(nodeBuilder);
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

    /**
     * Traverses a tree in a level order manner.
     * <p>
     * Until all nodes are traversed: Step 1 − Visit root node. Step 2 − Traverse left and right siblings. Step 3 −
     * Iterate till the leafs.
     */
    public static <E extends Comparable> String levelOrderTraversal(Node<E> node, final boolean addBrackets) {
        final StringBuilder nodeBuilder = new StringBuilder();
        if (addBrackets) {
            nodeBuilder.append("[");
        }

        /*
         * Create empty Queue.
         * Add root node into the queue.
         * Iterate until queue is empty
         * Poll node from the queue.
         * Visit node.
         * If node's left child is not null, push into the queue.
         * If node's right child is not null, push into the queue.
         */
        if (node != null) {
            final Queue<Node<E>> queue = new LinkedList<>();
            queue.offer(node);
            while (!queue.isEmpty()) {
                node = queue.poll();
                // append node
                nodeBuilder.append(node.getData()).append(" ");
                if (node.hasLeft()) {
                    queue.offer(node.getLeft());
                }
                if (node.hasRight()) {
                    queue.offer(node.getRight());
                }
            }

            // remove last white space.
            TreeUtils.trimLastSpace(nodeBuilder);
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

    /**
     * @param <E>
     */
    private static class TempNode<E extends Comparable> {

        private Node<E> node;
        private int level;

        TempNode(Node<E> node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /**
     * @param node
     * @param addBrackets
     * @return
     */
    public static <E extends Comparable> String treeViewTraversal(Node<E> node, final boolean addBrackets) {
        final StringBuilder nodeBuilder = new StringBuilder();
        if (addBrackets) {
            nodeBuilder.append("[");
        }

        /*
         * Create empty Queue.
         * Add root node into the queue.
         * Iterate until queue is empty
         * Poll node from the queue.
         * Visit node.
         * If node's left child is not null, push into the queue.
         * If node's right child is not null, push into the queue.
         */
        if (node != null) {
            final HashMap<Integer, Node<E>> treeView = new HashMap<>();
            final Queue<TempNode> queue = new LinkedList<>();
            queue.offer(new TempNode(node, 0));
            while (!queue.isEmpty()) {
                TempNode tempNode = queue.poll();
                if (!treeView.containsKey(tempNode.level)) {
                    // append node
                    nodeBuilder.append(tempNode.node.getData()).append(" ");
                    treeView.put(tempNode.level, tempNode.node);
                }

                if (tempNode.node.hasLeft()) {
                    queue.offer(new TempNode(tempNode.node.getLeft(), tempNode.level - 1));
                }

                if (tempNode.node.hasRight()) {
                    queue.offer(new TempNode(tempNode.node.getRight(), tempNode.level + 1));
                }
            }

            // remove last white space.
            TreeUtils.trimLastSpace(nodeBuilder);
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

    /**
     * @param node
     * @param addBrackets
     * @return
     */
    public static <E extends Comparable> String treeBottomViewTraversal(Node<E> node, final boolean addBrackets) {
        final StringBuilder nodeBuilder = new StringBuilder();
        if (addBrackets) {
            nodeBuilder.append("[");
        }

        /*
         * Create empty Queue.
         * Add root node into the queue.
         * Iterate until queue is empty
         * Poll node from the queue.
         * Visit node.
         * If node's left child is not null, push into the queue.
         * If node's right child is not null, push into the queue.
         */
        if (node != null) {
            final Map<Integer, Node<E>> treeBottomView = new TreeMap<>();
            final Queue<TempNode> queue = new LinkedList<>();
            queue.offer(new TempNode(node, 0));
            while (!queue.isEmpty()) {
                TempNode tempNode = queue.poll();
                treeBottomView.put(tempNode.level, tempNode.node);
                if (tempNode.node.hasLeft()) {
                    queue.offer(new TempNode(tempNode.node.getLeft(), tempNode.level - 1));
                }

                if (tempNode.node.hasRight()) {
                    queue.offer(new TempNode(tempNode.node.getRight(), tempNode.level + 1));
                }
            }

            treeBottomView.forEach((k, v) -> {
                nodeBuilder.append(v.getData()).append(" ");
            });

            // remove last white space.
            TreeUtils.trimLastSpace(nodeBuilder);
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

    /**
     * @param node
     * @param addBrackets
     * @return
     */
    public static <E extends Comparable> String treeLeftViewTraversal(Node<E> node, final boolean addBrackets) {
        final StringBuilder nodeBuilder = new StringBuilder();
        if (addBrackets) {
            nodeBuilder.append("[");
        }

        /*
         * Create empty Queue.
         * Add root node into the queue.
         * Iterate until queue is empty
         * Poll node from the queue.
         * Visit node.
         * If node's left child is not null, push into the queue.
         * If node's right child is not null, push into the queue.
         */
        if (node != null) {
            final Map<Integer, Node<E>> treeLeftView = new TreeMap<>();
            final Queue<TempNode> queue = new LinkedList<>();
            queue.offer(new TempNode(node, 0));
            while (!queue.isEmpty()) {
                TempNode tempNode = queue.poll();
                if (!treeLeftView.containsKey(tempNode.level)) {
                    treeLeftView.put(tempNode.level, tempNode.node);
                }
                if (tempNode.node.hasLeft()) {
                    queue.offer(new TempNode(tempNode.node.getLeft(), tempNode.level + 1));
                }

                if (tempNode.node.hasRight()) {
                    queue.offer(new TempNode(tempNode.node.getRight(), tempNode.level + 1));
                }
            }

            treeLeftView.forEach((k, v) -> {
                nodeBuilder.append(v.getData()).append(" ");
            });

            // remove last white space.
            TreeUtils.trimLastSpace(nodeBuilder);
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

    /**
     * @param node
     * @param addBrackets
     * @return
     */
    public static <E extends Comparable> String treeRightViewTraversal(Node<E> node, final boolean addBrackets) {
        final StringBuilder nodeBuilder = new StringBuilder();
        if (addBrackets) {
            nodeBuilder.append("[");
        }

        /*
         * Create empty Queue.
         * Add root node into the queue.
         * Iterate until queue is empty
         * Poll node from the queue.
         * Visit node.
         * If node's left child is not null, push into the queue.
         * If node's right child is not null, push into the queue.
         */
        if (node != null) {
            final Map<Integer, Node<E>> treeLeftView = new TreeMap<>();
            final Queue<TempNode> queue = new LinkedList<>();
            queue.offer(new TempNode(node, 0));
            while (!queue.isEmpty()) {
                TempNode tempNode = queue.poll();
                treeLeftView.put(tempNode.level, tempNode.node);
                if (tempNode.node.hasLeft()) {
                    queue.offer(new TempNode(tempNode.node.getLeft(), tempNode.level + 1));
                }

                if (tempNode.node.hasRight()) {
                    queue.offer(new TempNode(tempNode.node.getRight(), tempNode.level + 1));
                }
            }

            treeLeftView.forEach((k, v) -> {
                nodeBuilder.append(v.getData()).append(" ");
            });

            // remove last white space.
            TreeUtils.trimLastSpace(nodeBuilder);
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

}
