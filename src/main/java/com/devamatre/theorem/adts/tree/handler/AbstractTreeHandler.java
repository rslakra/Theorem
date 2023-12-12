package com.devamatre.theorem.adts.tree.handler;

import com.devamatre.theorem.adts.tree.AbstractTree;
import com.devamatre.theorem.adts.tree.TraversalMode;
import com.devamatre.theorem.adts.tree.TreeHandler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 11/25/23 4:26 PM
 */
public abstract class AbstractTreeHandler<E extends Comparable<? super E>> extends AbstractTree<E>
    implements TreeHandler<E> {

    private TraversalMode traversalMode;
    protected int index;
    protected Map<E, Integer> nodeIndices;

    /**
     * @param traversalMode
     */
    public AbstractTreeHandler(TraversalMode traversalMode) {
        super();
        this.traversalMode = traversalMode;
        this.nodeIndices = new HashMap<>();
    }

    /**
     * Returns the <code>TraversalMode</code> of the tree handler.
     *
     * @return
     */
    @Override
    public TraversalMode getTraversalMode() {
        return traversalMode;
    }

    /**
     * Returns the <code>index</code>.
     *
     * @return
     */
    protected final int getIndex() {
        return index;
    }

    /**
     * The <code>index</code> to be set.
     *
     * @param index
     */
    protected final void setIndex(int index) {
        this.index = index;
    }

    /**
     * Fills the <code>nodeIndices</code> with the <code>inputData</code> values.
     *
     * @param inputData
     */
    protected void fillNodeIndices(E[] inputData) {
        for (int i = 0; i < inputData.length; i++) {
            nodeIndices.put(inputData[i], i);
        }
    }

    /**
     * Returns the index of the <code>nodeData</code>.
     *
     * @param nodeData
     * @return
     */
    protected int getNodeIndex(E nodeData) {
        return nodeIndices.getOrDefault(nodeData, -1);
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
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(E o) {
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
