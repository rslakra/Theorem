package com.devamatre.theorem.adts.tree;

/**
 * @author Rohtash Lakra
 * @created 5/17/22 2:05 PM
 */
public abstract class AbstractTree<E extends Comparable> implements Iterable<E>, Comparable<E> {

    /**
     * Returns the parent index.
     * <p>
     * The <code>index</code> should be greater than or equal to 1.
     * <p>
     * * Parent(r) = ⌊(r−1)/2⌋ if r≠0.
     *
     * @param index
     * @return
     */
    public int parentIndex(int index) {
        return TreeUtils.parentIndex(index);
    }

    /**
     * Returns the index of the left child.
     * <p>
     * The <code>index</code> should be greater than or equal to 0.
     * <p>
     * Left child(r) = 2r+1 if 2r+1<n.
     *
     * @param index
     * @return
     */
    public int leftNodeIndex(int index) {
        return TreeUtils.leftNodeIndex(index);
    }

    /**
     * Returns the right index.
     * <p>
     * The <code>index</code> should be greater than or equal to 0.
     * <p>
     * Right child(r) = 2r+2 if 2r+2<n.
     *
     * @param index
     * @return
     */
    public int rightNodeIndex(int index) {
        return TreeUtils.rightNodeIndex(index);
    }

}
