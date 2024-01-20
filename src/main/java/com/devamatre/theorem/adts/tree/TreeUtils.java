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
import com.devamatre.theorem.adts.lang.Maths;
import com.devamatre.theorem.adts.tree.data.NodeInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
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
    public static final String COMMA = ",";
    public static final String COMMA_SPACE = ", ";
    public static final String LEFT = "┌─";
    public static final String RIGHT = "─┐";
    public static final String DASH = "─";
    public static final Integer MINUS_ONE = new Integer(-1);

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
     * Builds the tree recursively.
     *
     * @param inputData
     * @param index
     * @param <E>
     * @return
     */
    private <E extends Comparable<? super E>> Node<E> buildTree(List<E> inputData, int index) {
        LOGGER.debug("+buildTree({}, {})", inputData, index);
        if (index < 0 || index >= inputData.size()) { // check index is valid or not
            LOGGER.debug("-buildTree(), index:{}, newNode:null", index);
            return null;
        } else if (Maths.isEmptyOrMinusOne(inputData.get(index))) { // is null/empty/-1 data
            LOGGER.debug("-buildTree(), index:{}, newNode:null", index);
            return null;
        }

        Node<E> newNode = new Node<>(inputData.get(index));
        newNode.setLeft(buildTree(inputData, TreeUtils.leftNodeIndex(index)));
        newNode.setRight(buildTree(inputData, TreeUtils.rightNodeIndex(index)));

        LOGGER.debug("-buildTree(), newNode:{}", newNode);
        return newNode;
    }

    /**
     * This method is to construct a normal binary tree.
     * <p>
     * The input reads like this for [1, 2, 3, 4, 5, 6, 7, 8, 9]:
     *
     * <pre>
     *             1
     *           /   \
     *          2     3
     *         / \   / \
     *        4   5 6   7
     *       /\
     *      8 9
     * </pre>
     *
     * @param inputData
     * @return
     */
    public static <E extends Comparable<? super E>> Node<E> buildTree(List<E> inputData) {
        return INSTANCE.buildTree(inputData, 0);
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
     * @param inputData
     * @return
     */
    public static <E extends Comparable<? super E>> Node<E> buildBinaryTree(List<E> inputData) {
        Node<E> rootNode = null;
        if (BeanUtils.isNotEmpty(inputData)) {
            rootNode = new Node(inputData.get(0));
            Queue<Node<E>> queue = new LinkedList<>();
            queue.offer(rootNode);
            for (int i = 1; i < inputData.size(); i++) {
                Node<E> current = queue.poll();
                if (Objects.nonNull(inputData.get(i))) {
                    current.setLeft(new Node(inputData.get(i)));
                    queue.offer(current.getLeft());
                }

                if (++i < inputData.size() && Objects.nonNull(inputData.get(i))) {
                    current.setRight(new Node(inputData.get(i)));
                    queue.offer(current.getRight());
                }
            }
        }

        return rootNode;
    }

    /**
     * Builds the binary tree with the inputCommaSeparated string.
     *
     * @param inputCommaSeparated
     * @return
     */
    public static <E extends Comparable<? super E>> Node<E> buildBinaryTree(String inputCommaSeparated) {
        if (BeanUtils.isEmpty(inputCommaSeparated)) {
            return null;
        }

        String[] inputs = inputCommaSeparated.split(",");
        // consider first element as the root element
        String item = inputs[0].trim();
        Node<E> rootNode = new Node(item);
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(rootNode);

        int index = 1; // the next element of the input is the child of the root.
        while (!queue.isEmpty()) {
            // removes head of the queue
            Node<E> treeNode = queue.remove();

            // check more elements exist
            if (index == inputs.length) {
                break;
            }

            item = inputs[index++].trim();
            if (!NULL.equals(item)) {
                treeNode.setLeft(new Node(item));
                queue.add(treeNode.getLeft());
            }

            // check more elements exist
            if (index == inputs.length) {
                break;
            }

            item = inputs[index++].trim();
            if (!NULL.equals(item)) {
                treeNode.setRight(new Node(item));
                queue.add(treeNode.getRight());
            }
        }

        return rootNode;
    }

    /**
     * Builds the <code>N-ary</code> tree of the <code>inputData</code>.
     * <p>
     * After adding 3 nodes, the next parents is picked randomly.
     * <pre>
     *  1
     *  |-- 2
     *  |   |-- 4
     *  |   |   |-- 7
     *  |   |   |   |-- 10
     *  |   |   |   |   |-- 13
     *  |   |   |   |   |-- 14
     *  |   |   |   |   |-- 15
     *  |   |   |   |-- 11
     *  |   |   |   |-- 12
     *  |   |   |-- 8
     *  |   |   |-- 9
     *  |   |-- 5
     *  |   |-- 6
     *  |-- 3
     * </pre>
     */
    public static <E extends Comparable<? super E>> Node<E> buildNaryTree(List<E> inputData) {
        Node<E> rootNode = null;
        if (Objects.nonNull(inputData)) {
            // add 1st node as the root node and rest as the child nodes
            rootNode = new Node<>(false, inputData.get(0));
            Node<E> parentNode = rootNode;
            for (int i = 1; i < inputData.size(); i++) {
                int index = i % 3;
                LOGGER.trace("index:{}", index);
                if (parentNode.getChildren().size() > index) {
                    parentNode = parentNode.getChildren().get(index);
                }
                parentNode.addNode(new Node<>(false, inputData.get(i)));
            }
        }

        return rootNode;
    }

    /**
     * Prints the white space(s).
     *
     * @param count
     */
    public static void printWhiteSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(SPACE);
        }
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
     * @param nodeList
     * @param minLevel
     * @param maxLevel
     */
    private static <E extends Comparable<? super E>> void printNodeInternal(List<Node<E>> nodeList, int minLevel, int maxLevel) {
        LOGGER.trace("+printNodeInternal({}, {}, {})", nodeList, minLevel, maxLevel);
        if (nodeList.isEmpty() || AlgoUtils.isAllNull(nodeList)) {
            return;
        }

        int level = maxLevel - minLevel;
        int levelPower = (int) Math.pow(2, level);
//        int nodePosition = (int) Math.pow(2, levelPower) - 1;
        int nodePosition = (int) Math.pow(2, level) - 1;
        int edgeLines = (int) Math.pow(2, (Math.max(level - 1, 0)));
//        int gapBetweenNodes = (int) Math.pow(2, levelPower) + 1;
        int gapBetweenNodes = (int) Math.pow(2, (level + 1)) - 1;
        LOGGER.trace("level:{}, nodePosition:{}, edgeLines:{}, gapBetweenNodes:{}", level, nodePosition, edgeLines, gapBetweenNodes);

        printWhiteSpaces(nodePosition);

        List<Node<E>> levelOrders = new ArrayList<>();
        for (Node<E> nextNode : nodeList) {
            if (Objects.nonNull(nextNode)) { // non-null nextNode
                System.out.print(nextNode.getData());
                levelOrders.add(nextNode.getLeft());
                levelOrders.add(nextNode.getRight());
            } else {
                levelOrders.add(null);
                levelOrders.add(null);
                System.out.print(SPACE);
            }

            printWhiteSpaces(gapBetweenNodes);
        }
        System.out.println();

        // print edge lines with gaps in-between
        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodeList.size(); j++) {
                printWhiteSpaces(nodePosition - i);
                if (Objects.isNull(nodeList.get(j))) { // null node
                    printWhiteSpaces((2 * edgeLines) + i + 1);
                    continue;
                }

                // left edge line
                if (nodeList.get(j).hasLeft()) {
                    System.out.print(BACK_SLASH);
                } else {
                    printWhiteSpaces(1);
                }

                // gap between edges
                printWhiteSpaces((2 * i) - 1);

                // right edge line
                if (nodeList.get(j).hasRight()) {
                    System.out.print(SLASH);
                } else {
                    printWhiteSpaces(1);
                }

                printWhiteSpaces((2 * edgeLines) - i);
            }

            System.out.println();
        }

        printNodeInternal(levelOrders, minLevel + 1, maxLevel);
    }

    /**
     * @param treeNode
     */
    public static <E extends Comparable<? super E>> void printBinaryTree(Node<E> treeNode) {
        AlgoUtils.println("\nPrinting out the visual tree:\n");
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
     * @param rootNode
     * @param prefix
     * @param isLeft
     */
    public static <E extends Comparable<? super E>> void printPrettyTreeVertically(Node<E> rootNode, String prefix, boolean isLeft) {
        if (rootNode == null) {
            System.out.println("Empty tree");
            return;
        }

        if (rootNode.hasRight()) {
            printPrettyTreeVertically(rootNode.getRight(), prefix + (isLeft ? "│   " : "    "), false);
        }

        System.out.println(prefix + (isLeft ? "└── " : "┌── ") + rootNode.getData());

        if (rootNode.hasLeft()) {
            printPrettyTreeVertically(rootNode.getLeft(), prefix + (isLeft ? "    " : "│   "), true);
        }
    }

    /**
     * Prints the pretty tree.
     *
     * @param rootNode
     */
    public static <E extends Comparable<? super E>> void printPrettyTreeVertically(Node<E> rootNode) {
        printPrettyTreeVertically(rootNode, "", true);
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
     * The height or maximum depth of a tree is the total number of edges on the longest path from the root
     * rootNode to the leaf rootNode.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * @param rootNode
     * @return
     */
    public static <E extends Comparable<? super E>> int maxDepth(Node<E> rootNode) {
        if (Objects.isNull(rootNode)) {
            return 0;
        } else if (rootNode.isBinary()) {
            return (Math.max(maxDepth(rootNode.getLeft()), maxDepth(rootNode.getRight())) + 1);
        } else {
            int maxDepth = 0;
            for (Node<E> childNode : rootNode.getChildren()) {
                maxDepth = Math.max(maxDepth, maxDepth(childNode));
            }

            return (maxDepth + 1);
        }
    }

    /**
     * Returns the max level (height) of the provided <code>rootNode</code>. It's kind of longest path to the leaf.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * @param rootNode
     * @return
     */
    public static <E extends Comparable<? super E>> int getHeight(Node<E> rootNode) {
        if (Objects.isNull(rootNode)) {
            return 0;
        } else if (rootNode.isBinary()) {
            return Math.max(getHeight(rootNode.getLeft()), getHeight(rootNode.getRight())) + 1;
        } else {
            int maxHeight = 0;
            for (Node<E> childNode : rootNode.getChildren()) {
                maxHeight = Math.max(maxHeight, getHeight(childNode));
            }

            return (maxHeight + 1);
        }
    }

    /**
     * Returns the count from the <code>rootNode</code> and it's children.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * @param rootNode
     * @return
     */
    public static <E extends Comparable<? super E>> int countNodes(Node<E> rootNode) {
        if (Objects.isNull(rootNode)) {
            return 0;
        } else if (rootNode.isBinary()) {
            return (countNodes(rootNode.getLeft()) + countNodes(rootNode.getRight()) + 1);
        } else {
            int nodeCount = 1;
            for (Node<E> childNode : rootNode.getChildren()) {
                nodeCount += countNodes(childNode);
            }

            return nodeCount;
        }
    }

    /**
     * Returns the length of the path to its root.
     *
     * @param rootNode
     * @return
     */
    public static <E extends Comparable<? super E>> int maxAncestorDepth(Node<E> rootNode) {
        return (Objects.isNull(rootNode) ? 0 : maxAncestorDepth(rootNode.getParent()) + 1);
    }

    /**
     * Returns the edge count of the provided <code>rootNode</code>.
     * A tree with n nodes should have <code>n-1</code> edges.
     *
     * @param rootNode
     * @return
     */
    public static <E extends Comparable<? super E>> int maxEdges(Node<E> rootNode) {
        if (Objects.isNull(rootNode)) {
            return 0;
        } else if (rootNode.isBinary()) {
            return (maxEdges(rootNode.getLeft()) + maxEdges(rootNode.getRight()) + 1);
        } else {
            int maxEdges = 0;
            for (Node childNode : rootNode.getChildren()) {
                maxEdges += maxEdges(childNode) + 1;
            }

            return maxEdges;
        }
    }

    /**
     * Removes the last <code>separator</code> from the <code>strBuilder</code> object.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * @param strBuilder
     * @param separator
     */
    public static void addSeparator(int totalSpaces, StringBuilder strBuilder, String separator) {
        for (int i = 0; i < totalSpaces; i++) {
            strBuilder.append(separator);
        }
    }

    /**
     * Adds the <code>totalSpaces</code>.
     *
     * @param totalSpaces
     * @param treeBuilder
     */
    public static void addSpaces(int totalSpaces, StringBuilder treeBuilder) {
        addSeparator(totalSpaces, treeBuilder, SPACE);
    }

    /**
     * Adds the <code>totalSpaces</code>.
     *
     * @param totalSpaces
     * @param treeBuilder
     */
    private static <E extends Comparable<? super E>> void addNode(int totalSpaces, StringBuilder treeBuilder, Node<E> node) {
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
    private static <E extends Comparable<? super E>> String buildSpatialBlock(final Node<E> node, int spaces) {
        return (node == null ? String.format("%" + (2 * spaces + 1) + "s%n", "")
//                : String.format("%" + (spaces + 1) + "s%" + spaces + "s", node.getValue(), "")
                : String.format("%" + (spaces + 1) + "s%" + spaces + "s", LEFT + node.getData() + RIGHT, ""));
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
     * @param rootNode
     * @param currentHeight
     * @param maxHeight
     * @return
     */
    public static <E extends Comparable<? super E>> StringBuilder printPrettyTree(Node<E> rootNode, int currentHeight, int maxHeight) {
        final StringBuilder treeBuilder = new StringBuilder();
        int spaces = countSpaces(maxHeight - currentHeight + 1);
        if (Objects.isNull(rootNode)) {
            // create a 'spatial' block and return it
            String row = buildSpatialBlock(rootNode, spaces);
            // now repeat this row (space+1) times
            return new StringBuilder(new String(new char[spaces + 1]).replace("\0", row));
        }

        if (currentHeight == maxHeight) {
            return new StringBuilder(rootNode.getData().toString());
        }

        treeBuilder.append(buildSpatialBlock(rootNode, spaces));
        treeBuilder.append(NEW_LINE);
        /* now print / and \ but make sure that left and right exists */
        String leftSlash = rootNode.hasLeft() ? BACK_SLASH : SPACE;
        String rightSlash = rootNode.hasRight() ? SLASH : SPACE;
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
        final StringBuilder leftTreeBuilder = printPrettyTree(rootNode.getLeft(), currentHeight + 1, maxHeight);
        final StringBuilder rightTreeBuilder = printPrettyTree(rootNode.getRight(), currentHeight + 1, maxHeight);
        /* now line by line print the trees side by side */
        final Scanner leftScanner = new Scanner(leftTreeBuilder.toString());
        final Scanner rightScanner = new Scanner(rightTreeBuilder.toString());
        // spaceInBetween += 1;
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
     * Prints the pretty tree.
     *
     * @param rootNode
     * @param showDetails
     * @return
     */
    public static <E extends Comparable<? super E>> void printPrettyTree(Node<E> rootNode, boolean showDetails) {
        if (Objects.nonNull(rootNode)) {
            System.out.println();
            if (rootNode.isBinary()) {
                System.out.println(printPrettyTree(rootNode, 0, getHeight(rootNode)));
            } else {
                System.out.println(toStringNaryTree(rootNode, showDetails));
            }
        }
    }

    /**
     * Prints the pretty tree.
     *
     * @param rootNode
     * @param <E>
     */
    public static <E extends Comparable<? super E>> void printPrettyTree(Node<E> rootNode) {
        printPrettyTree(rootNode, false);
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
     * @param minLevel
     * @param maxLevel
     * @return
     */
    public static <E extends Comparable<? super E>> StringBuilder prettyTreeHorizontally(Node<E> node, int minLevel, int maxLevel) {
        StringBuilder treeBuilder = new StringBuilder();
        if (Objects.isNull(node)) {
            return treeBuilder;
        }

        int level = maxLevel - minLevel;
        int edgeLines = (int) Math.pow(2, (Math.max(level - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (level)) - 1;
        int gapBetweenNodes = (int) Math.pow(2, (level + 1)) - 1;

        addSpaces(firstSpaces, treeBuilder);
        treeBuilder.append(node.getData());

//        List<Node> newNodes = new ArrayList<>();
//        for (Node node : list) {
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
//            printWhiteSpaces(gapBetweenNodes);
//        }
//        System.out.println("");

//        for (int i = 1; i <= edgeLines; i++) {
//            for (int j = 0; j < list.size(); j++) {
//                printWhiteSpaces(firstSpaces - i);
//                if (list.get(j) == null) {
//                    printWhiteSpaces(edgeLines + edgeLines + i + 1);
//                    continue;
//                }
//
//                if (list.get(j).hasLeft()) {
//                    System.out.print(BACK_SLASH);
//                } else {
//                    printWhiteSpaces(1);
//                }
//
//                printWhiteSpaces(i + i - 1);
//
//                if (list.get(j).hasRight()) {
//                    System.out.print(SLASH);
//                } else {
//                    printWhiteSpaces(1);
//                }
//
//                printWhiteSpaces(edgeLines + edgeLines - i);
//            }
//
//            System.out.println("");
//        }

        treeBuilder.append(prettyTreeHorizontally(node.getLeft(), minLevel + 1, maxLevel));
        treeBuilder.append(prettyTreeHorizontally(node.getRight(), minLevel + 1, maxLevel));

        return treeBuilder;
    }

    /**
     * Prints the pretty tree horizontally.
     * <pre>
     *           ┌──────── 1 ────────┐
     *      ┌─── 2 ───┐         ┌─── 3 ───┐
     *  ┌── 4 ──┐ ┌── 5 ──┐ ┌── 6 ──┐ ┌── 7 ──┐
     *                                    ┌── 8 ──┐
     * </pre>
     *
     * @param rootNode
     * @param <E       extends Comparable>
     * @return
     */
    public static <E extends Comparable<? super E>> StringBuilder printPrettyTreeHorizontally(Node<E> rootNode) {
        /**
         * <pre>
         *  Conventions:
         *      L - Left Side
         *      S - Spaces
         *      D - Node Data
         *      R - Right Side
         *      C - Columns
         * </pre>
         *
         * <pre>
         *
         *  |              1                (Row:1 -> Spaces: L:14,D,R:0)                   - C:14
         *  |            /  \               (Row:2 -> Spaces: L:12,/,S:2,\,R:0)             - C:16
         *  |          /     \              (Row:3 -> Spaces: L:10,/,S:5,\,R:0)             - C:17
         *  |        /        \             (Row:4 -> Spaces: L:8,/,S:8,\,R:0)              - C:18
         *  |      2           3            (Row:5 -> Spaces: L:6,D,S:11,D,R:0)             - C:19
         *  |    /  \        /  \           (Row:6 -> Spaces: L:4,/,S:2,\,S:8,/,S:2,\,:R:0) - C:20
         *  |  /     \     /     \          (Row:7 -> Spaces: L:2,/,S:5,\,S:5,/,S:5,\,:R:0) - C:21
         *  |4        5  6        7         (Row:8 -> Spaces: L:0,D,S:8,D,S:2,D,S:8,D,:R:0) - C:22
         *
         *  Height of Tree  : 3
         *  Total Nodes     : 2 ^ h -1 (2 ^ 3 - 1 = 7)
         *  Rows            : 2 ^ h (2 ^ 3 = 8)
         *  Columns         : Height * Rows (3 * 8 = 24)
         *  Left Spaces     : Nodes * (Height - 1) (7 * (3 - 1) = 14)
         *
         *  OR
         *      ┌─── 1 ───┐
         *  ┌── 2 ──┐ ┌── 3 ──┐
         *                ┌── 4 ──┐
         *  OR
         *           ┌──────── 1 ────────┐
         *      ┌─── 2 ───┐         ┌─── 3 ───┐
         *  ┌── 4 ──┐ ┌── 5 ──┐ ┌── 6 ──┐ ┌── 7 ──┐
         *                                    ┌── 8 ──┐
         * </pre>
         */
        final StringBuilder treeBuilder = new StringBuilder();
        if (Objects.nonNull(rootNode)) {
            /**
             * <pre>
             *
             *         Height of Tree  : 3
             *          Total Nodes     : 2 ^ h -1 (2 ^ 3 - 1 = 7)
             *           Rows            : 2 ^ h (2 ^ 3 = 8)
             *           Columns         : Height * Rows (3 * 8 = 24)
             *           Left Spaces     : Nodes * (Height - 1) (7 * (3 - 1) = 14)
             * -------------------------
             *
             *  |              1                (Row:1 -> Spaces: L:14,D,R:0)                   - C:14
             *  |            /  \               (Row:2 -> Spaces: L:12,/,S:2,\,R:0)             - C:16
             *  |          /     \              (Row:3 -> Spaces: L:10,/,S:5,\,R:0)             - C:17
             *  |        /        \             (Row:4 -> Spaces: L:8,/,S:8,\,R:0)              - C:18
             *  |      2           3            (Row:5 -> Spaces: L:6,D,S:11,D,R:0)             - C:19
             *  |    /  \        /  \           (Row:6 -> Spaces: L:4,/,S:2,\,S:8,/,S:2,\,:R:0) - C:20
             *  |  /     \     /     \          (Row:7 -> Spaces: L:2,/,S:5,\,S:5,/,S:5,\,:R:0) - C:21
             *  |4        5  6        7         (Row:8 -> Spaces: L:0,D,S:8,D,S:2,D,S:8,D,:R:0) - C:22
             * </pre>
             */
            final int maxHeight = getHeight(rootNode);
            final int totalNodes = (int) Math.pow(2, maxHeight) - 1;
            final int rows = (int) Math.pow(2, maxHeight);
            final int leftSpaces = totalNodes * (maxHeight - 1);
            LOGGER.debug("maxHeight:{}, totalNodes:{}, rows:{}, leftSpaces:{}", maxHeight, totalNodes, rows, leftSpaces);
            List<List<E>> levelOrders = TreeUtils.getLevelOrders(rootNode);
            LOGGER.debug("levelOrders:{}", levelOrders);
            for (int level = 0; level < levelOrders.size(); level++) {
                // for each level order
                List<E> levelOrder = levelOrders.get(level);
                // find rootNode value to print
                for (int k = 0; k < levelOrder.size(); k++) {
                    // print per row left spaces
                    int perRowLeftSpaces = leftSpaces - (2 * level);
//                    LOGGER.debug("perRowLeftSpaces:{}", perRowLeftSpaces);
                    TreeUtils.printWhiteSpaces(perRowLeftSpaces);
                    System.out.print(levelOrder.get(k));
                }
                System.out.println();

                // find rootNode value to print
                for (int j = maxHeight; j > level; j--) {
                    System.out.println();
                }
            }

//            Queue<Node<E>> queue = new LinkedList<>();
//            queue.add(rootNode);
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                level++;
//                while (size > 0) {
//                    int floor = maxLevels - level;
//                    int edgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
//                    Node<E> tempNode = queue.remove();
//                    int sideSpaces = floor * edgeLines;
//                    // print current tempNode
//                    int leftSpaces = (int) Math.pow(2, (edgeLines + 1)) - 1;
//                    addSpaces(leftSpaces, treeBuilder);
//                    addNode(sideSpaces, treeBuilder, tempNode);
//                    addSpaces(leftSpaces - 1, treeBuilder);
//
//                    // add left tempNode if available
//                    if (tempNode.getLeft() != null) {
//                        queue.add(tempNode.getLeft());
//                    }
//
//                    // add right tempNode if available
//                    if (tempNode.getRight() != null) {
//                        queue.add(tempNode.getRight());
//                    }
//                    size--;
//                }
//                treeBuilder.append(NEW_LINE);
//            }
        }

        return treeBuilder;
    }

    /**
     * Removes the last <code>separator</code> from the <code>nodeBuilder</code> object.
     * <p>
     * Time Complexity: <code>O(1)</code>
     *
     * @param nodeBuilder
     * @param separator
     */
    public static void trimLastSeparator(final StringBuilder nodeBuilder, final String separator) {
        // remove last white space.
        int lastIndex = nodeBuilder.lastIndexOf(separator);
        if (lastIndex != -1) {
            nodeBuilder.delete(lastIndex, nodeBuilder.length());
        }
    }

    /**
     * Removes the last space.
     *
     * @param nodeBuilder
     */
    public static void trimLastSpace(final StringBuilder nodeBuilder) {
        trimLastSeparator(nodeBuilder, SPACE);
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
     * Level Order: [[1], [2, 3], [4, 5, 6, 7]]
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * @param treeNode
     * @return
     */
    public static <E extends Comparable<? super E>> List<List<E>> getLevelOrders(Node<E> treeNode) {
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
     * <p>
     * Time Complexity: <code>O(N)</code>
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
     * @param includeNullLeafs
     */
    public static <E extends Comparable<? super E>> List<E> inOrder(Node<E> treeNode, boolean includeNullLeafs) {
        LOGGER.debug("+inOrder({})", treeNode);
        List<E> inOrder = new ArrayList<>();
        if (BeanUtils.isNull(treeNode)) {
            if (includeNullLeafs) {
                inOrder.add(null);
            }
        } else {
            inOrder.addAll(inOrder(treeNode.getLeft(), includeNullLeafs));
            LOGGER.debug("data:{}", treeNode.getData());
            inOrder.add(treeNode.getData());
            inOrder.addAll(inOrder(treeNode.getRight(), includeNullLeafs));
        }

        LOGGER.debug("-inOrder(), inOrder:{}", inOrder);
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
     * @param treeNode
     */
    public static <E extends Comparable<? super E>> List<E> inOrder(Node<E> treeNode) {
        return inOrder(treeNode, false);
    }

    /**
     * Returns the list of nodes using <code>pre-order</code> traversal recursively.
     * <p>
     * Time Complexity: <code>O(N)</code>
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
    public static <E extends Comparable<? super E>> List<E> preOrder(Node<E> treeNode, boolean includeNullLeafs) {
        LOGGER.debug("+preOrder({})", treeNode);
        List<E> preOrder = new ArrayList<>();
        if (BeanUtils.isNull(treeNode)) {
            if (includeNullLeafs) {
                preOrder.add(null);
            }
        } else {
            LOGGER.debug("data:{}", treeNode.getData());
            preOrder.add(treeNode.getData());
            preOrder.addAll(preOrder(treeNode.getLeft(), includeNullLeafs));
            preOrder.addAll(preOrder(treeNode.getRight(), includeNullLeafs));
        }

        LOGGER.debug("-preOrder(), preOrder:{}", preOrder);
        return preOrder;
    }


    /**
     * Returns the list of nodes using <code>pre-order</code> traversal recursively.
     * <p>
     * Time Complexity: <code>O(N)</code>
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
    public static <E extends Comparable<? super E>> List<E> preOrderChildren(Node<E> treeNode, boolean includeNullLeafs) {
        LOGGER.debug("+preOrderChildren({}, {})", treeNode, includeNullLeafs);
        List<E> preOrder = new ArrayList<>();
        if (Objects.isNull(treeNode)) {
            if (includeNullLeafs) {
                preOrder.add(null);
            }
        } else {
            LOGGER.debug("data:{}", treeNode.getData());
            preOrder.add(treeNode.getData());
            for (Node<E> childNode : treeNode.getChildren()) {
                preOrder.addAll(preOrderChildren(childNode, includeNullLeafs));
            }
        }

        LOGGER.debug("-preOrderChildren(), preOrder:{}", preOrder);
        return preOrder;
    }

    /**
     * Returns the list of nodes using <code>pre-order</code> traversal recursively.
     * <p>
     * Time Complexity: <code>O(N)</code>
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
     * PreOrder Traversal <code>Left -> Root -> Right</code>
     * <p>
     * i.e: [1, 2, 4, 5, 3, 6, 7]
     *
     * @param treeNode
     */
    public static <E extends Comparable<? super E>> List<E> preOrder(Node<E> treeNode) {
        return preOrder(treeNode, false);
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
     * PostOrder Traversal <code>Left -> Right -> Root</code>
     * <p>
     * i.e: [4, 5, 2, 6, 7, 3, 1]
     *
     * @param treeNode
     */
    public static <E extends Comparable<? super E>> List<E> postOrder(Node<E> treeNode, boolean includeNullLeafs) {
        LOGGER.debug("+postOrder({})", treeNode);
        List<E> postOrder = new ArrayList<>();
        if (BeanUtils.isNull(treeNode)) {
            if (includeNullLeafs) {
                postOrder.add(null);
            }
        } else {
            postOrder.addAll(postOrder(treeNode.getLeft(), includeNullLeafs));
            postOrder.addAll(postOrder(treeNode.getRight(), includeNullLeafs));
            LOGGER.debug("data:{}", treeNode.getData());
            postOrder.add(treeNode.getData());
        }

        LOGGER.debug("-postOrder(), postOrder:{}", postOrder);
        return postOrder;
    }

    /**
     * Returns the list of nodes using <code>post-order</code> traversal recursively.
     * <p>
     * Time Complexity: <code>O(N)</code>
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
     * LevelOrder Traversal
     * <pre>
     *  Root - (Level 1)
     *  Left Child (Level 2)
     *  Right Child (Level 2)
     *  Children (Level N)
     * </pre>
     *
     * <p>
     * i.e: [4, 5, 2, 6, 7, 3, 1]
     *
     * @param treeNode
     */
    public static <E extends Comparable<? super E>> List<E> postOrder(Node<E> treeNode) {
        return postOrder(treeNode, false);
    }

    /**
     * Returns the list of nodes using <code>in-order</code> traversal recursively.
     * <p>
     * Time Complexity: <code>O(N)</code>
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
    public static <E extends Comparable<? super E>> String inOrderTraversal(Node<E> node) {
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
     * <p>
     * Time Complexity: <code>O(N)</code>
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
     * PreOrder Traversal <code>Root -> Left -> Right</code>
     * <p>
     * i.e: [1, 2, 4, 5, 3, 6, 7]
     *
     * @param treeNode
     */
    public static <E extends Comparable<? super E>> String preOrderTraversal(Node<E> treeNode) {
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
     * <p>
     * Time Complexity: <code>O(N)</code>
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
     * PostOrder Traversal <code>Left -> Right -> Root</code>
     * <p>
     * i.e: [4, 5, 2, 6, 7, 3, 1]
     *
     * @param treeNode
     */
    public static <E extends Comparable<? super E>> String postOrderTraversal(Node<E> treeNode) {
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
     * Traverses a tree in a pre-order (ROOT -> LEFT -> RIGHT) manner.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * <p>
     * Until all nodes are traversed:
     *
     * <pre>
     *  Step 1 − Visit root node.
     *  Step 2 − Recursively traverse left subtree.
     *  Step 3 − Recursively traverse right subtree.
     * </pre>
     *
     * @param node
     * @param addBrackets
     * @return
     */
    public static <E extends Comparable<? super E>> String preOrderTraversal(Node<E> node, final boolean addBrackets) {
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
         * Note that right child is pushed first so that left is processed first.
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
     * Traverses a tree in an in-order (LEFT -> ROOT -> RIGHT) manner.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * <p>
     * Until all nodes are traversed:
     * <pre>
     *  Step 1 − Recursively traverse left subtree.
     *  Step 2 − Visit root node.
     *  Step 3 − Recursively traverse right subtree.
     * </pre>
     */
    public static <E extends Comparable<? super E>> String inOrderTraversal(Node<E> node, final boolean addBrackets) {
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
     * Traverses a tree in a post-order (LEFT -> RIGHT -> ROOT) manner.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * <p>
     * Until all nodes are traversed:
     * <pre>
     *  Step 1 − Recursively traverse left subtree.
     *  Step 2 − Recursively traverse right subtree.
     *  Step 3 − Visit root node.
     * </pre>
     */
    public static <E extends Comparable<? super E>> String postOrderTraversal(Node<E> node, final boolean addBrackets) {
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
     * Time Complexity: <code>O(N)</code>
     *
     * <p>
     * Until all nodes are traversed:
     * <pre>
     *  Step 1 − Visit root node.
     *  Step 2 − Traverse left and right siblings.
     *  Step 3 − Iterate till the leafs.
     * </pre>
     */
    public static <E extends Comparable<? super E>> String levelOrderTraversal(Node<E> node, final boolean addBrackets) {
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
     * Steps:
     * <pre>
     *
     * </pre>
     *
     * @param node
     * @param addBrackets
     * @return
     */
    public static <E extends Comparable<? super E>> String treeViewTraversal(Node<E> node, final boolean addBrackets) {
        final StringBuilder nodeBuilder = new StringBuilder();
        if (addBrackets) {
            nodeBuilder.append("[");
        }

        /*
         * Create empty Queue.
         * Add root node into the queue (as level node, node and level = 0)
         * Iterate until queue is empty
         * Poll node from the queue.
         * Visit node.
         * If node's left child is not null, push into the queue.
         * If node's right child is not null, push into the queue.
         */
        if (node != null) {
            final Map<Integer, Node<E>> treeView = new HashMap<>();
            final Queue<NodeInfo<E>> queue = new LinkedList<>();
            queue.offer(new NodeInfo(node, 0));
            while (!queue.isEmpty()) {
                NodeInfo<E> nodeInfo = queue.poll();
                if (!treeView.containsKey(nodeInfo.getLevel())) {
                    // append node to the string
                    nodeBuilder.append(nodeInfo.getNode().getData()).append(COMMA_SPACE);
                    treeView.put(nodeInfo.getLevel(), nodeInfo.getNode());
                }

                if (nodeInfo.getNode().hasLeft()) {
                    queue.offer(new NodeInfo(nodeInfo.getNode().getLeft(), nodeInfo.getLevel() - 1));
                }

                if (nodeInfo.getNode().hasRight()) {
                    queue.offer(new NodeInfo(nodeInfo.getNode().getRight(), nodeInfo.getLevel() + 1));
                }
            }

            // remove last white space.
            TreeUtils.trimLastSeparator(nodeBuilder, COMMA_SPACE);
        }

        if (addBrackets) {
            nodeBuilder.append("]");
        }

        return nodeBuilder.toString();
    }

    /**
     * @param node
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> String treeViewTraversal(Node<E> node) {
        return treeViewTraversal(node, true);
    }

    /**
     * @param node
     * @param addBrackets
     * @return
     */
    public static <E extends Comparable<? super E>> String treeBottomViewTraversal(Node<E> node, final boolean addBrackets) {
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
            final Queue<NodeInfo> queue = new LinkedList<>();
            queue.offer(new NodeInfo(node, 0));
            while (!queue.isEmpty()) {
                NodeInfo<E> nodeInfo = queue.poll();
                treeBottomView.put(nodeInfo.getLevel(), nodeInfo.getNode());
                if (nodeInfo.getNode().hasLeft()) {
                    queue.offer(new NodeInfo(nodeInfo.getNode().getLeft(), nodeInfo.getLevel() - 1));
                }

                if (nodeInfo.getNode().hasRight()) {
                    queue.offer(new NodeInfo(nodeInfo.getNode().getRight(), nodeInfo.getLevel() + 1));
                }
            }

            treeBottomView.forEach((k, v) -> {
                nodeBuilder.append(v.getData()).append(",");
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
    public static <E extends Comparable<? super E>> String treeLeftViewTraversal(Node<E> node, final boolean addBrackets) {
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
            final Queue<NodeInfo<E>> queue = new LinkedList<>();
            queue.offer(new NodeInfo(node, 0));
            while (!queue.isEmpty()) {
                NodeInfo<E> nodeInfo = queue.poll();
                if (!treeLeftView.containsKey(nodeInfo.getLevel())) {
                    treeLeftView.put(nodeInfo.getLevel(), nodeInfo.getNode());
                }
                if (nodeInfo.getNode().hasLeft()) {
                    queue.offer(new NodeInfo(nodeInfo.getNode().getLeft(), nodeInfo.getLevel() + 1));
                }

                if (nodeInfo.getNode().hasRight()) {
                    queue.offer(new NodeInfo(nodeInfo.getNode().getRight(), nodeInfo.getLevel() + 1));
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
    public static <E extends Comparable<? super E>> String treeRightViewTraversal(Node<E> node, final boolean addBrackets) {
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
            final Queue<NodeInfo<E>> queue = new LinkedList<>();
            // add root node at level 0
            queue.offer(new NodeInfo<>(node, 0));

            // iterate till queue is not empty
            while (!queue.isEmpty()) {
                NodeInfo<E> nodeInfo = queue.poll();
                treeLeftView.put(nodeInfo.getLevel(), nodeInfo.getNode());
                if (nodeInfo.getNode().hasLeft()) {
                    queue.offer(new NodeInfo(nodeInfo.getNode().getLeft(), nodeInfo.getLevel() + 1));
                }

                if (nodeInfo.getNode().hasRight()) {
                    queue.offer(new NodeInfo(nodeInfo.getNode().getRight(), nodeInfo.getLevel() + 1));
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
     * Returns the string representation of this object. For Example:
     *
     * <pre>
     * CEO
     * |-- CTO
     * |   |-- Server
     * |   |-- iOS
     * |   |   |-- Objective-C
     * |   |   |-- Swift
     * |   |-- Android
     * |-- CFO
     * </pre>
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public static <E extends Comparable<? super E>> String toStringNaryTree(Node<E> rootNode, boolean showDepth) {
        StringBuilder strBuilder = new StringBuilder();
        if (Objects.nonNull(rootNode)) {
            if (!rootNode.hasParent()) {
//                strBuilder.append("|").append(NEW_LINE);
                strBuilder.append(NEW_LINE);
            }
            strBuilder.append(rootNode.getData());
            if (showDepth) {
                strBuilder.append(" [height:").append(getHeight(rootNode)).append(", size:").append(rootNode.getSize()).append(", count:").append(rootNode.getCount()).append("]");
            }
            strBuilder.append(NEW_LINE);

            // traverse children
            if (rootNode.hasChildren()) {
                for (Node child : rootNode.getChildren()) {
                    int maxDepth = maxAncestorDepth(child);
                    for (int i = 1; i < maxDepth - 1; i++) {
                        strBuilder.append("|   ");
                    }
                    strBuilder.append("|-- ").append(toStringNaryTree(child, showDepth));
                }
            }
        }

        return strBuilder.toString();
    }

    /**
     * Returns the left-most child of the provided <code>rootNode</code>.
     *
     * @return
     */
    public static <E extends Comparable<? super E>> Node<E> findLeftMostChild(Node<E> rootNode) {
        Node<E> leftMostChild = rootNode;
        while (Objects.nonNull(leftMostChild) && leftMostChild.hasLeft()) {
            leftMostChild = leftMostChild.getLeft();
        }

        return leftMostChild;
    }

    /**
     * Returns the right-most child of the provided <code>rootNode</code>.
     *
     * @return
     */
    public static <E extends Comparable<? super E>> Node<E> findRightMostChild(Node<E> rootNode) {
        Node<E> rightMostChild = rootNode;
        while (Objects.nonNull(rightMostChild) && rightMostChild.hasRight()) {
            rightMostChild = rightMostChild.getRight();
        }

        return rightMostChild;
    }

    /**
     * Returns the in-order successor of the provided <code>rootNode</code>. The in-order successor of the
     * <code>rootNode</code> is left-most node of the right node.
     *
     * @return
     */
    public static <E extends Comparable<? super E>> Node<E> findInOrderSuccessor(Node<E> rootNode) {
        return (rootNode != null && rootNode.hasRight() ? findLeftMostChild(rootNode.getRight()) : null);
    }

    /**
     * Returns the count from the <code>node</code> and it's children.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * @param node
     * @return
     */
    public static <E extends Comparable<? super E>> BigDecimal getSum(Node<E> node) {
        return (node == null ? BigDecimal.ZERO : getSum(node.getLeft()).add(getSum(node.getRight())).add(new BigDecimal(node.getData().toString())));
    }

    /**
     * Returns the diameter of the tree. It also uses the <code>withRoot</code> property to decided if the diameter is
     * with or without root.
     * <p>
     * Time Complexity: <code>O(N ^ 2)</code>
     *
     * @param node
     * @return
     */
    public static <E extends Comparable<? super E>> long getDiameterNSquare(Node<E> node, boolean withRoot) {
        long nodeDiameter = 0;
        if (node != null) {
            long leftDiameter = getDiameterNSquare(node.getLeft(), withRoot);
            long rightDiameter = getDiameterNSquare(node.getRight(), withRoot);
            long maxHeight = getHeight(node.getLeft()) + getHeight(node.getRight()) + 1;
            nodeDiameter = Math.max(Math.max(leftDiameter, rightDiameter), maxHeight);
        }

        return nodeDiameter;
    }

    /**
     * Returns the diameter of the tree. It also uses the <code>withRoot</code> property to decided if the diameter is
     * with or without root.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * @param node
     * @return
     */
    public static <E extends Comparable<? super E>> NodeInfo<E> getDiameter(Node<E> node) {
        // base case
        NodeInfo<E> nodeInfo = null;
        if (node == null) {
            nodeInfo = new NodeInfo(0, 0);
        } else {
            NodeInfo<E> leftNode = getDiameter(node.getLeft());
            NodeInfo<E> rightNode = getDiameter(node.getRight());
            int myHeight = Math.max(leftNode.getHeight(), rightNode.getHeight()) + 1;
            int nodeHeight = leftNode.getHeight() + rightNode.getHeight() + 1;
            long myDiameter = Math.max(Math.max(leftNode.getDiameter(), rightNode.getDiameter()), nodeHeight);
            LOGGER.debug("node:{}, myHeight:{}, myDiameter:{}", node, myHeight, myDiameter);
            nodeInfo = new NodeInfo(myHeight, myDiameter);
        }

        return nodeInfo;
    }

    /**
     * @param tree
     * @param subTree
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> boolean treeContains(Node<E> tree, Node<E> subTree) {
        // the leaf nodes of both tree should be null
        if (tree == null && subTree == null) {
            return true;
        }

        // only 1 node is not null
        if (tree == null || subTree == null) {
            return false;
        }

        // both nodes are same, check both left and right nodes of these nodes
        if (tree.equals(subTree)) {
            return (treeContains(tree.getLeft(), subTree.getLeft()) && treeContains(tree.getRight(), subTree.getRight()));
        }

        return false;
    }

    /**
     * Returns true if the <code>subTree</code> exists the <code>tree</code> otherwise false.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * @param tree
     * @param subTree
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> boolean isSubtree(Node<E> tree, Node<E> subTree) {
        // the subTree is null, means exists
        if (subTree == null) {
            return true;
        }

        // the tree is null, means not exists
        if (tree == null) {
            return false;
        }

        // both tree and subTree values matches
        if (tree.equals(subTree)) {
            // either left tree or right tree contains the subTree
            if (treeContains(tree, subTree)) {
                return true;
            }
        }

        return treeContains(tree.getLeft(), subTree) || treeContains(tree.getRight(), subTree);
    }

}
