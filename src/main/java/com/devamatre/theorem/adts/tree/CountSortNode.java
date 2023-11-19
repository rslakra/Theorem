package com.devamatre.theorem.adts.tree;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Rohtash Lakra
 * @created 9/18/23 7:00 PM
 */
@Getter
@Setter
public class CountSortNode<E> implements Comparable<CountSortNode> {

    private CountSortNode<E> parent;
    private final E value;
    private int count;
    private CountSortNode<E> left;
    private CountSortNode<E> right;

    /**
     * @param value
     */
    public CountSortNode(E value) {
        parent = null;
        this.value = value;
        left = null;
        right = null;
    }

    /**
     * Returns the value of data.
     *
     * @return the data
     */
    public E getValue() {
        return value;
    }

    /**
     *
     */
    public void incrementCount() {
        count++;
    }

    /**
     *
     */
    public void decrementCount() {
        count--;
    }

    /**
     * Returns the value of parent.
     *
     * @return the parent
     */
    public CountSortNode<E> getParent() {
        return parent;
    }

    /**
     * The parent to be set.
     *
     * @param parent the parent to set
     */
    public void setParent(CountSortNode<E> parent) {
        this.parent = parent;
    }

    /**
     * Returns true if the left node is not null otherwise false.
     *
     * @return
     */
    public boolean hasLeft() {
        return (left != null);
    }

    /**
     * Returns the value of leftNode.
     *
     * @return the leftNode
     */
    public CountSortNode<E> getLeft() {
        return left;
    }

    /**
     * The leftNode to be set.
     *
     * @param left the leftNode to set
     */
    public void setLeft(CountSortNode<E> left) {
        this.left = left;
    }

    /**
     * Returns true if the right node is not null otherwise false.
     *
     * @return
     */
    public boolean hasRight() {
        return (right != null);
    }

    /**
     * Returns the value of rightNode.
     *
     * @return the rightNode
     */
    public CountSortNode<E> getRight() {
        return right;
    }

    /**
     * The rightNode to be set.
     *
     * @param right the rightNode to set
     */
    public void setRight(CountSortNode<E> right) {
        this.right = right;
    }

    /**
     * Returns true if this is leaf node (means both left and right nodes are empty of this node).
     *
     * @return
     */
    public boolean isLeafNode() {
        return (left == null && right == null);
    }

    /**
     * Returns true if the node has both left and right children otherwise false.
     *
     * @return
     */
    public boolean hasChildren() {
        return (left != null && right != null);
    }

    /**
     * Adds the left node to the current node.
     *
     * @param newData
     */
    public void addLeftNode(final E newData) {
        final CountSortNode<E> newNode = new CountSortNode<E>(newData);
        if (this.hasLeft()) {
            newNode.setLeft(getLeft());
        }
        setLeft(newNode);
    }

    /**
     * Adds the right node to the current node.
     *
     * @param newData
     */
    public void addRightNode(final E newData) {
        final CountSortNode<E> newNode = new CountSortNode<E>(newData);
        if (hasRight()) {
            newNode.setRight(getRight());
        }
        setRight(newNode);
    }

    /**
     * @param other
     * @return
     */
    public boolean equals(CountSortNode<E> other) {
        return (other != null && getValue().equals(other.getValue()));
    }

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
     * integer as this object is less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))} for all {@code x} and {@code y}.  (This implies that
     * {@code x.compareTo(y)} must throw an exception iff {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements the
     * {@code Comparable} interface and violates this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(CountSortNode other) {
        return ((Comparable) getValue()).compareTo(other.getValue());
    }
}
