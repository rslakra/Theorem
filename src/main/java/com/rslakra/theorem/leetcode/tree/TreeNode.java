package com.rslakra.theorem.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 3:46 PM
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    /**
     * @param val
     * @param left
     * @param right
     */
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    /**
     * @param val
     */
    public TreeNode(int val) {
        this.val = val;
    }

    /**
     *
     */
    public TreeNode() {
    }

    /**
     * Returns true if the left and right nodes are null.
     *
     * @return
     */
    public boolean isLeaf() {
        return (left == null && right == null);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return Objects.toString(val);
    }

    /**
     * @param treeNode
     * @param includeNullLeafs
     * @return
     */
    public static List<Integer> preOrder(TreeNode treeNode, boolean includeNullLeafs) {
        List<Integer> preOrder = new ArrayList<>();
        if (Objects.isNull(treeNode)) {
            if (includeNullLeafs) {
                preOrder.add(null);
            }
        } else {
            preOrder.add(treeNode.val);
            preOrder.addAll(preOrder(treeNode.left, includeNullLeafs));
            preOrder.addAll(preOrder(treeNode.right, includeNullLeafs));
        }

        return preOrder;
    }

    /**
     * Returns the string representation of the provided <code>rootNode</code>.
     *
     * @param rootNode
     * @return
     */
    public static String toString(TreeNode rootNode) {
        return preOrder(rootNode, false).toString();
    }
}
