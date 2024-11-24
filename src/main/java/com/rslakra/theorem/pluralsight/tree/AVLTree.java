/**
 *
 */
package com.rslakra.theorem.pluralsight.tree;

/**
 * @author Rohtash Lakra
 */
public class AVLTree<E> extends BinaryTree<E> {

    protected AVLTreeNode<E> rootNode;

    public AVLTree() {
    }

    /**
     * @param node
     * @param newNode
     * @return
     */
    protected final AVLTreeNode<E> add(AVLTreeNode<E> node, AVLTreeNode<E> newNode) {
        if (node == null) {
            return newNode;
        }

        TreeNode<E> nextNode = null;
        if (node.compareTo(newNode) <= 0) {
            nextNode = add(node.getRightNode(), newNode);
            node.setRightNode(nextNode);
        } else if (node.compareTo(newNode) > 0) {
            nextNode = add(node.getLeftNode(), newNode);
            node.setLeftNode(nextNode);
        }
        nextNode.setParent(node);

        return node;
    }

    /**
     *
     */
    public final void add(E data) {
        rootNode = add(rootNode, new AVLTreeNode<E>(data));
    }

    /**
     * @return
     */
    public boolean isLeftHeavy() {
        return (rootNode.hasLeftNode() && ((AVLTreeNode<?>) rootNode.getLeftNode()).getBalanceFactor() > 0);
    }

    /**
     * @return
     */
    public boolean isRightHeavy() {
        return (rootNode.hasRightNode() && ((AVLTreeNode<?>) rootNode.getRightNode()).getBalanceFactor() > 0);
    }

    /**
     * Balances the AVL Tree.
     */
    public void balance() {
        switch (rootNode.getTreeState()) {
            // Left Heavy Tree
            case LEFT_HEAVY:
                // if left child is right heavy
                // right left rotation
                // else
                // right rotation
                if (isLeftHeavy()) {
                    rightLeftRotation();
                } else {
                    rightRotation();
                }

                break;

            // Right Heavy Tree
            case RIGHT_HEAVY:
                // if right child is left heavy
                // left right rotation
                // else
                // leftRotation

                if (isRightHeavy()) {
                    leftRightRotation();
                } else {
                    leftRotation();
                }

                break;

            default:
                break;
        }

    }

    /**
     * To Rotate a node to the left
     *
     * <pre>
     * 1. Right child becomes the new root.
     * 2. Left child of new root is assigned to right child of old root.
     * 3. Previous root becomes the new root's left child.
     * </pre>
     */
    public void leftRotation() {

    }

    /**
     * To Rotate a node to the right
     *
     * <pre>
     * 1. Left child becomes the new root.
     * 2. Right child of new root is assigned to left child of old root.
     * 3. Previous root becomes the new root's right child.
     * </pre>
     */
    public void rightRotation() {

    }

    /**
     * <pre>
     * 1. Right rotate the right child.
     * 2. Left rotate the updated tree.
     * </pre>
     */
    public void leftRightRotation() {

    }

    /**
     * <pre>
     * 1. Left rotate the left child.
     * 2. Right rotate the updated tree.
     * </pre>
     */
    public void rightLeftRotation() {

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        int nodes = 10;
        for (int i = 0; i < nodes; i++) {
            tree.add((i + 1));
        }

        System.out.println("Tree:" + tree);
        System.out.println("Height:" + tree.getHeight());
        System.out.println();
    }

}
