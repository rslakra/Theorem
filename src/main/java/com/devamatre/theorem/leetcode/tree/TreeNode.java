package com.devamatre.theorem.leetcode.tree;

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
     */
    public TreeNode(int val) {
        this.val = val;
    }

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
}
