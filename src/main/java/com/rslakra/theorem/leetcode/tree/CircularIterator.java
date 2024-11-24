package com.rslakra.theorem.leetcode.tree;

import java.util.Iterator;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Feb 13, 2021 10:14:27
 */
public class CircularIterator implements Iterator<TreeNode> {

    private TreeNode rootNode;
    private TreeNode currentNode;

    /**
     * @param treeNode
     * @return
     */
    public static TreeNode initTree(TreeNode treeNode) {
        TreeNode left = new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null));
        TreeNode right = new TreeNode(6, new TreeNode(5, null, null), new TreeNode(7, null, null));
        treeNode = new TreeNode(4, left, right);
        return treeNode;
    }

    /**
     * @param rootNode
     */
    public CircularIterator(TreeNode rootNode) {
        this.rootNode = asCircularList(rootNode);
        this.currentNode = null;
    }

    /**
     * Concatenate both the lists and returns the head of the List
     *
     * @param leftList
     * @param rightList
     * @return
     */
    private TreeNode join(TreeNode leftList, TreeNode rightList) {
        if (leftList == null) {
            return rightList;
        }

        if (rightList == null) {
            return leftList;
        }

        // last node of left list
        TreeNode leftLast = leftList.left;
        // last node of right list
        TreeNode rightLast = rightList.left;

        // Connect the last node of Left List with the first Node of the right List
        leftLast.right = rightList;
        rightList.left = leftLast;

        // left of first node refers to the last node in the list
        leftList.left = (rightLast);

        // Right of last node refers to the first node of the List
        rightLast.right = leftList;

        return leftList;
    }

    /**
     * @param rootNode
     * @return
     */
    public TreeNode asCircularList(TreeNode rootNode) {
        if (rootNode == null) {
            return null;
        }

        // Recursively convert left and right subtrees
        TreeNode leftNode = asCircularList(rootNode.left);
        TreeNode rightNode = asCircularList(rootNode.right);

        // Make a circular linked list of single node (or root).
        // To do so, make the right and left pointers of this node point to itself
        rootNode.left = rootNode;
        rootNode.right = rootNode;

        // Step 1 (concatenate the left list with the list with single node, i.e., current node)
        // Step 2 (concatenate the returned list with the right List)

        return join(join(leftNode, rootNode), rightNode);
    }

    /**
     * Returns {@code true} if the iteration has more elements. (In other words, returns {@code true} if {@link #next}
     * would return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return (currentNode != rootNode);
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws java.util.NoSuchElementException if the iteration has no more elements
     */
    @Override
    public TreeNode next() {
        TreeNode tempNode = currentNode;
        if (currentNode == null) {
            tempNode = currentNode = rootNode;
        }
        currentNode = currentNode.right;
        return tempNode;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        final StringBuilder sBuilder = new StringBuilder();
        if (rootNode != null) {
            TreeNode tempNode = rootNode;
            do {
                sBuilder.append(tempNode.val);
                if (tempNode.right != rootNode) {
                    sBuilder.append(" ");
                }
                tempNode = tempNode.right;
            }
            while (tempNode != rootNode);
        }

        return sBuilder.toString();
    }

    /**
     * Tests
     *
     * @param rootNode
     */
    public static void testCircularIterator(TreeNode rootNode) {
        CircularIterator inOrder = new CircularIterator(rootNode);
        System.out.println("inOrder: " + inOrder);
        System.out.println();

        System.out.println("Iterator of Circular list");
        while (inOrder.hasNext()) {
            System.out.println(inOrder.next().val);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        testCircularIterator(null);
        TreeNode rootNode = CircularIterator.initTree(null);
        testCircularIterator(rootNode);
    }
}
