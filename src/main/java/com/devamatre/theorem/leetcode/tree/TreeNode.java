package com.devamatre.theorem.leetcode.tree;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 3:46 PM
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}