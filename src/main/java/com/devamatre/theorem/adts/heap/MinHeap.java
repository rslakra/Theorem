package com.devamatre.theorem.adts.heap;

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
        HeapUtils.buildMinHeap((E[]) getData());
    }

    /**
     * Creates a <code>MinHeap</code> with the specified initial capacity that orders its elements according to their
     * natural ordering.
     *
     * @param initialCapacity
     */
    public MinHeap(int initialCapacity) {
        super(initialCapacity);
        HeapUtils.buildMinHeap((E[]) getData());
    }

    /**
     * Creates a <code>MinHeap</code> with the specified initial capacity that orders its elements according to the
     * specified comparator.
     *
     * @param initialCapacity
     * @param comparator
     */
    public MinHeap(int initialCapacity, Comparator<? super E> comparator) {
        super(initialCapacity, comparator);
        HeapUtils.buildMinHeap((E[]) getData());
    }

    /**
     * Creates a <code>MinHeap</code> containing the elements in the specified collection.
     *
     * @param c
     */
    public MinHeap(Collection<? extends E> c) {
        super(c);
        HeapUtils.buildMinHeap((E[]) getData());
    }

    /**
     * Creates a <code>MinHeap</code> with the default initial capacity and whose elements are ordered according to the
     * specified comparator.
     *
     * @param comparator
     */
    public MinHeap(Comparator<? super E> comparator) {
        super(comparator);
        HeapUtils.buildMinHeap((E[]) getData());
    }

    /**
     * Creates a <code>MinHeap</code> containing the elements in the specified priority queue.
     *
     * @param c
     */
    public MinHeap(Heap<? extends E> c) {
        super(c);
        HeapUtils.buildMinHeap((E[]) getData());
    }

    /**
     * Creates a <code>MinHeap</code> containing the elements in the specified sorted set.
     *
     * @param c
     */
    public MinHeap(SortedSet<? extends E> c) {
        super(c);
        HeapUtils.buildMinHeap((E[]) getData());
    }

    /**
     * Sorts the heap.
     */
    @Override
    public void sort() {
        HeapUtils.heapSortDesc((E[]) getData());
    }
}
