package com.rslakra.theorem.adts.heap;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

/**
 * @author Rohtash Lakra
 * @created 5/17/22 2:17 PM
 */
public class MinHeap<E extends Comparable<? super E>> extends Heap<E> {

    /**
     * Creates a <code>MinHeap</code> with the default initial capacity (11) that orders its elements according to their
     * natural ordering.
     */
    public MinHeap() {
        super();
        super.buildMinHeap();
    }

    /**
     * Creates a <code>MinHeap</code> with the specified initial capacity that orders its elements according to their
     * natural ordering.
     *
     * @param initialCapacity
     */
    public MinHeap(int initialCapacity) {
        super(initialCapacity);
        super.buildMinHeap();
    }

    /**
     * Creates a <code>MinHeap</code> with the specified initial capacity that orders its elements according to the
     * specified comparator.
     *
     * @param initialCapacity
     * @param comparator
     */
    public MinHeap(int initialCapacity, Comparator<E> comparator) {
        super(initialCapacity, comparator);
        super.buildMinHeap();
    }

    /**
     * Creates a <code>MinHeap</code> containing the elements in the specified collection.
     *
     * @param elements
     */
    public MinHeap(Collection<? extends E> elements) {
        super(elements);
        super.buildMinHeap();
    }

    /**
     * Creates a <code>MinHeap</code> with the default initial capacity and whose elements are ordered according to the
     * specified comparator.
     *
     * @param comparator
     */
    public MinHeap(Comparator<E> comparator) {
        super(comparator);
        super.buildMinHeap();
    }

    /**
     * Creates a <code>MinHeap</code> containing the elements in the specified priority queue.
     *
     * @param elements
     */
    public MinHeap(Heap<? extends E> elements) {
        super(elements);
        super.buildMinHeap();
    }

    /**
     * Creates a <code>MinHeap</code> containing the elements in the specified sorted set.
     *
     * @param elements
     */
    public MinHeap(SortedSet<? extends E> elements) {
        super(elements);
        super.buildMinHeap();
    }
}
