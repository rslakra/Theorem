package com.devamatre.theorem.adts.heap;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

/**
 * @author Rohtash Lakra
 * @created 5/17/22 2:18 PM
 */
public class MaxHeap<E extends Comparable<? super E>> extends Heap<E> {

    /**
     * Creates a <code>MaxHeap</code> with the default initial capacity (11) that orders its elements according to their
     * natural ordering.
     */
    public MaxHeap() {
        super();
        super.buildMaxHeap();
    }

    /**
     * Creates a <code>MaxHeap</code> with the specified initial capacity that orders its elements according to their
     * natural ordering.
     *
     * @param initialCapacity
     */
    public MaxHeap(int initialCapacity) {
        super(initialCapacity);
        super.buildMaxHeap();
    }

    /**
     * Creates a <code>MaxHeap</code> with the specified initial capacity that orders its elements according to the
     * specified comparator.
     *
     * @param initialCapacity
     * @param comparator
     */
    public MaxHeap(int initialCapacity, Comparator<E> comparator) {
        super(initialCapacity, comparator);
        super.buildMaxHeap();
    }

    /**
     * Creates a <code>MaxHeap</code> containing the elements in the specified collection.
     *
     * @param elements
     */
    public MaxHeap(Collection<? extends E> elements) {
        super(elements);
        super.buildMaxHeap();
    }

    /**
     * Creates a <code>MaxHeap</code> with the default initial capacity and whose elements are ordered according to the
     * specified comparator.
     *
     * @param comparator
     */
    public MaxHeap(Comparator<E> comparator) {
        super(comparator);
        super.buildMaxHeap();
    }

    /**
     * Creates a <code>MaxHeap</code> containing the elements in the specified priority queue.
     *
     * @param elements
     */
    public MaxHeap(Heap<? extends E> elements) {
        super(elements);
        super.buildMaxHeap();
    }

    /**
     * Creates a <code>MaxHeap</code> containing the elements in the specified sorted set.
     *
     * @param elements
     */
    public MaxHeap(SortedSet<? extends E> elements) {
        super(elements);
        super.buildMaxHeap();
    }

}
