/**
 *
 */
package com.rslakra.theorem.leetcode.tree;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 7, 2019 8:32:31 PM
 */
public class LC297SerializeDeserializeBinaryTree {

    /**
     * <pre>
     *  Time Complexity: <code>O(log N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        return null;
    }

    /**
     * @param nodeSerialized
     * @return
     */
    public TreeNode deserialize(String nodeSerialized) {
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC297SerializeDeserializeBinaryTree instance = new LC297SerializeDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        String str = instance.serialize(root);
        TreeNode dNode = instance.deserialize(str);
    }

}
