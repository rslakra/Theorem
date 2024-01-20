package com.devamatre.theorem.leetcode.tree;

import java.util.HashSet;

/**
 * @author Rohtash Lakra
 * @created 1/16/24 3:45 PM
 */
public class LC653TwoSumIVInputBST {

    public boolean findTargetRecursively(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) {
            return false;
        }

        if (set.contains(k - root.val)) {
            return true;
        }

        set.add(root.val);
        return findTargetRecursively(root.left, k, set) || findTargetRecursively(root.right, k, set);
    }

    /**
     * <url>https://leetcode.com/problems/two-sum-iv-input-is-a-bst</url>
     *
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        return findTargetRecursively(root, k, new HashSet<>());
    }

}
