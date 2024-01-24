/**
 *
 */
package com.devamatre.theorem.leetcode.tree;

import java.util.Stack;

/**
 * @author Rohtash Lakra
 */
public class BSTRangeSum {

    public int rangeSumBST(TreeNode root, int left, int right) {
        int sum = 0;
        if (root == null) {
            System.out.println("null return 0");
            return 0;
        }

        if (root.left != null) {
            sum += rangeSumBST(root.left, left, right);
        }

        if (root.val >= left && root.val <= right) {
            sum += root.val;
        }

        if (root.right != null) {
            sum += rangeSumBST(root.right, left, right);
        }

        return sum;
    }

    public int rangeSumBSTOptimized(TreeNode root, int left, int right) {
        int sum = 0;
        if (root != null) {
            Stack<TreeNode> heap = new Stack<TreeNode>();
            heap.add(root);
            while (!heap.isEmpty()) {
                root = heap.pop();
                if (root.val >= left && root.val <= right) {
                    sum += root.val;
                }

                if (root.left != null) {
                    if (root.left.val >= left) {
                        heap.push(root.left);
                    } else if (root.left.right != null && root.left.right.val >= left) {
                        heap.push(root.left.right);
                    }
                }

                if (root.right != null) {
                    if (root.right.val >= left && root.right.val <= right) {
                        heap.push(root.right);
                    } else if (root.right.left != null && root.right.left.val >= left
                            && root.right.left.val <= right) {
                        heap.push(root.right.left);
                    }
                }

                System.out.println("heap.size:" + heap.size());
            }
        }

        return sum;
    }

}
