package com.rslakra.theorem.leetcode.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 2/15/24 3:53 PM
 */
public class LC662MaximumWidthOfBinaryTree {

    /**
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Deque<TreeNode> deque = new LinkedList();
        deque.add(root);
        while (!deque.isEmpty()) {
            // remove the left or right nodes, till it's null
            while (!deque.isEmpty() && (Objects.isNull(deque.getFirst()) || Objects.isNull(deque.getLast()))) {
                if (Objects.isNull(deque.getFirst())) {
                    deque.removeFirst();
                }

                if (Objects.isNull(deque.getLast())) {
                    deque.removeLast();
                }
            }

            int size = deque.size();
            maxWidth = Math.max(maxWidth, size);
            for (int i = 0; i < size && !deque.isEmpty(); i++) {
                root = deque.poll();
                if (Objects.nonNull(root)) {
                    deque.add(root.left);
                    deque.add(root.right);
                } else {
                    deque.add(null);
                    deque.add(null);
                }
            }
        }

        return maxWidth;
    }

    static class Pair {

        TreeNode treeNode;
        int level;

        Pair(TreeNode treeNode, int level) {
            this.treeNode = treeNode;
            this.level = level;
        }

        public String toString() {
            return treeNode.val + ":" + level;
        }
    }

    /**
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(N)</code>
     * </pre>
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxWidth = 0;
        Deque<Pair> deque = new LinkedList();
        deque.addLast(new Pair(root, 0));
        while (!deque.isEmpty()) {
            maxWidth = Math.max(maxWidth, (deque.getLast().level - deque.getFirst().level + 1));
            int size = deque.size();
            for (int i = 0; i < size && !deque.isEmpty(); i++) {
                Pair pair = deque.removeFirst();
                if (Objects.nonNull(pair.treeNode.left)) {
                    deque.addLast(new Pair(pair.treeNode.left, 2 * pair.level + 1));
                }
                if (Objects.nonNull(pair.treeNode.right)) {
                    deque.addLast(new Pair(pair.treeNode.right, 2 * pair.level + 2));
                }
            }
        }

        return maxWidth;
    }

}
