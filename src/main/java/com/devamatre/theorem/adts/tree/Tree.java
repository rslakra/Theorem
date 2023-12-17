package com.devamatre.theorem.adts.tree;

import java.util.Iterator;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:00 PM
 * @since 1.0.0
 */
public class Tree<E extends Comparable<? super E>> extends AbstractTree<E> {

    private final boolean binary;

    /**
     * Builds the tree based on the <code>binary</code> property.
     *
     * @param binary
     */
    public Tree(boolean binary) {
        super();
        this.binary = binary;
    }

    /**
     * Builds the non-binary tree.
     */
    public Tree() {
        this(false);
    }

    /**
     * Returns the <code>binary</code> value.
     *
     * @return
     */
    public boolean isBinary() {
        return binary;
    }

    /**
     * Builds the tree representation of the binary tree.
     *
     * @param parent
     * @param child
     * @return
     */
    @Override
    protected void insert(Node<E> parent, Node<E> child) {
        // check, if node need to add in left side.
        if (parent.compareTo(child) > 0) {
            if (child.getLeft() == null) {
                parent.setLeft(child);
                child.setParent(parent);
                incrementSize();
            } else {
                insert(child.getLeft(), child);
            }
        } else if (child.getData().compareTo(parent.getData()) < 0) {
            if (child.getRight() == null) {
                parent.setRight(child);
                child.setParent(parent);
                incrementSize();
            } else {
                insert(child.getRight(), child);
            }
        } else {
            // same data, don't allow duplicates in binary tree.
        }
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
    public int compareTo(E other) {
        return 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
