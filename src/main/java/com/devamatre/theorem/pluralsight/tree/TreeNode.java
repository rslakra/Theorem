/**
 *
 */
package com.devamatre.theorem.pluralsight.tree;

/**
 * @author Rohtash Lakra
 */
public class TreeNode<E> implements Comparable<TreeNode<E>> {

    private TreeNode<E> parent;
    private E data;
    private TreeNode<E> leftNode;
    private TreeNode<E> rightNode;

    /**
     * @param data
     */
    public TreeNode(E data) {
        this.data = data;
    }

    /**
     * @return
     */
    public TreeNode<E> getParent() {
        return parent;
    }

    /**
     * @return
     */
    public E getData() {
        return data;
    }

    /**
     * Returns true if the <code>parent</code> node is not null otherwise false.
     *
     * @return
     */
    public boolean hasParent() {
        return (getParent() != null);
    }

    /**
     * The <code>parent</code> to be set.
     *
     * @param parent
     */
    public void setParent(TreeNode<E> parent) {
        this.parent = parent;
    }

    /**
     * @return
     */
    public TreeNode<E> getLeftNode() {
        return leftNode;
    }

    /**
     * Returns true if the left node is not null otherwise false.
     *
     * @return
     */
    public boolean hasLeftNode() {
        return (getLeftNode() != null);
    }

    /**
     * Returns true this node is the left node of it's parent node otherwise false.
     *
     * @return
     */
    public boolean isLeftNode() {
        return (hasParent() && getParent().hasLeftNode() && getParent().getLeftNode().compareTo(this) == 0);
    }

    /**
     * @param leftNode
     */
    public void setLeftNode(TreeNode<E> leftNode) {
        this.leftNode = leftNode;
    }

    /**
     * @return
     */
    public TreeNode<E> getRightNode() {
        return rightNode;
    }

    /**
     * Returns true if the right node is not null otherwise false.
     *
     * @return
     */
    public boolean hasRightNode() {
        return (getRightNode() != null);
    }

    /**
     * Returns true this node is the right node of it's parent node otherwise false.
     *
     * @return
     */
    public boolean isRightNode() {
        return (hasParent() && getParent().hasRightNode() && getParent().getRightNode().compareTo(this) == 0);
    }

    /**
     * @param rightNode
     */
    public void setRightNode(TreeNode<E> rightNode) {
        this.rightNode = rightNode;
    }

    /**
     * Returns true if the node does not have left and right nodes otherwise false.
     *
     * @return
     */
    public boolean isLeafNode() {
        return (!hasLeftNode() && !hasRightNode());
    }

    /**
     * @return
     */
    public final int getHeight(TreeNode<E> rootNode) {
        return Tree.maxHeight(rootNode);
    }

    /**
     *
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override
    public int compareTo(TreeNode<E> other) {
        int result = 0;
        if (other != null) {
            result = ((Comparable) getData()).compareTo((Comparable) other.getData());
        }

        return result;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return (getData() == null ? "" : getData().toString());
    }

}
