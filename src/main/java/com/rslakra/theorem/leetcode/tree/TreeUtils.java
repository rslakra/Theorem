package com.rslakra.theorem.leetcode.tree;

import com.rslakra.theorem.adts.tree.TraversalMode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author Rohtash Lakra
 * @created 1/22/24 6:08 PM
 */
public enum TreeUtils {
    INSTANCE;

    private static final String EMPTY = "";

    /**
     * Returns the next node based on the in-order <code>inputData</code>.
     *
     * @param inputData
     * @param index
     * @return
     */
    private TreeNode nextNode(Integer[] inputData, int index) {
        if (index >= 0 && index < inputData.length && inputData[index] != null) {
            return new TreeNode(inputData[index]);
        }

        return null;
    }

    /**
     * Builds the tree with in-order <code>inputData</code>.
     *
     * @param inputData
     * @return
     */
    public static TreeNode buildTree(Integer[] inputData) {
        TreeNode rootNode = null;
        if (inputData != null) {
            int index = 0;
            rootNode = INSTANCE.nextNode(inputData, index);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(rootNode);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                treeNode.left = INSTANCE.nextNode(inputData, ++index);
                treeNode.right = INSTANCE.nextNode(inputData, ++index);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }

                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }

        return rootNode;
    }

    /**
     * Level Order: [[1], [2, 3], [4, 5, 6, 7]]
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * @param rootNode
     * @return
     */
    public static List<List<TreeNode>> levelOrderTraversal(TreeNode rootNode) {
        List<List<TreeNode>> levelOrders = new ArrayList<>();
        if (Objects.nonNull(rootNode)) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<TreeNode> levelOrder = new ArrayList<>();
            queue.add(rootNode);
            queue.add(null);
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.remove();
                // print current treeNode
                if (treeNode == null) {
                    levelOrders.add(new ArrayList<>(levelOrder));
                    levelOrder.clear();
                    if (!queue.isEmpty()) {
                        queue.add(null);
                    }
                } else {
                    levelOrder.add(treeNode);
                    // add left treeNode if available
                    if (treeNode.left != null) {
                        queue.add(treeNode.left);
                    }
                    // add right treeNode if available
                    if (treeNode.right != null) {
                        queue.add(treeNode.right);
                    }
                }
            }
        }

        return levelOrders;
    }

    /**
     * InOrder Traversal <code>Left -> Root -> Right</code>
     * <p>
     * i.e: [4, 2, 5, 1, 6, 3, 7] Time Complexity: <code>O(N)</code>
     * <p>
     *
     * @param rootNode
     */
    public static List<TreeNode> inOrderTraversal(TreeNode rootNode) {
        List<TreeNode> inOrder = new ArrayList<>();
        if (Objects.nonNull(rootNode)) {
            inOrder.addAll(inOrderTraversal(rootNode.left));
            inOrder.add(rootNode);
            inOrder.addAll(inOrderTraversal(rootNode.right));
        }

        return inOrder;
    }

    /**
     * InOrder Traversal <code>Root -> Left -> Right</code>
     * <p>
     * i.e: [1, 2, 4, 5, 3, 6, 7]
     *
     * @param rootNode
     */
    public static List<TreeNode> preOrderTraversal(TreeNode rootNode) {
        List<TreeNode> preOrder = new ArrayList<>();
        if (Objects.nonNull(rootNode)) {
            preOrder.add(rootNode);
            preOrder.addAll(preOrderTraversal(rootNode.left));
            preOrder.addAll(preOrderTraversal(rootNode.right));
        }

        return preOrder;
    }

    /**
     * @param traversalMode
     * @param rootNode
     * @return
     */
    private String toString(TraversalMode traversalMode, TreeNode rootNode) {
        switch (traversalMode) {
            case LEVEL_ORDER_TRAVERSAL:
                List<TreeNode>
                    flatTree =
                    levelOrderTraversal(rootNode).stream().flatMap(List::stream).collect(Collectors.toList());
                return flatTree.toString();

            case IN_ORDER_TRAVERSAL:
                return inOrderTraversal(rootNode).toString();

            case PRE_ORDER_TRAVERSAL:
                return preOrderTraversal(rootNode).toString();

            default:
                break;
        }

        return EMPTY;
    }

    /**
     * @param rootNode
     * @return
     */
    public static String levelOrder(TreeNode rootNode) {
        return INSTANCE.toString(TraversalMode.LEVEL_ORDER_TRAVERSAL, rootNode);
    }

    /**
     * @param rootNode
     * @return
     */
    public static String inOrder(TreeNode rootNode) {
        return INSTANCE.toString(TraversalMode.IN_ORDER_TRAVERSAL, rootNode);
    }

    /**
     * @param rootNode
     * @return
     */
    public static String preOrder(TreeNode rootNode) {
        return INSTANCE.toString(TraversalMode.PRE_ORDER_TRAVERSAL, rootNode);
    }

    /**
     * Returns the list of nodes as values.
     *
     * @param treeNodes
     * @return
     */
    public static List<Integer> asList(List<TreeNode> treeNodes) {
        return treeNodes.stream().map(treeNode -> treeNode.val).collect(Collectors.toList());
    }
}
