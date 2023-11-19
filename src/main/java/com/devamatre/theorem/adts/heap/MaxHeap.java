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
        HeapUtils.buildMaxHeap((E[]) getData());
    }

    /**
     * Creates a <code>MaxHeap</code> with the specified initial capacity that orders its elements according to their
     * natural ordering.
     *
     * @param initialCapacity
     */
    public MaxHeap(int initialCapacity) {
        super(initialCapacity);
        HeapUtils.buildMaxHeap((E[]) getData());
    }

    /**
     * Creates a <code>MaxHeap</code> with the specified initial capacity that orders its elements according to the
     * specified comparator.
     *
     * @param initialCapacity
     * @param comparator
     */
    public MaxHeap(int initialCapacity, Comparator<? super E> comparator) {
        super(initialCapacity, comparator);
        HeapUtils.buildMaxHeap((E[]) getData());
    }

    /**
     * Creates a <code>MaxHeap</code> containing the elements in the specified collection.
     *
     * @param c
     */
    public MaxHeap(Collection<? extends E> c) {
        super(c);
        HeapUtils.buildMaxHeap((E[]) getData());
    }

    /**
     * Creates a <code>MaxHeap</code> with the default initial capacity and whose elements are ordered according to the
     * specified comparator.
     *
     * @param comparator
     */
    public MaxHeap(Comparator<? super E> comparator) {
        super(comparator);
        HeapUtils.buildMaxHeap((E[]) getData());
    }

    /**
     * Creates a <code>MaxHeap</code> containing the elements in the specified priority queue.
     *
     * @param c
     */
    public MaxHeap(Heap<? extends E> c) {
        super(c);
        HeapUtils.buildMaxHeap((E[]) getData());
    }

    /**
     * Creates a <code>MaxHeap</code> containing the elements in the specified sorted set.
     *
     * @param c
     */
    public MaxHeap(SortedSet<? extends E> c) {
        super(c);
        HeapUtils.buildMaxHeap((E[]) getData());
    }

    /**
     * Sorts the heap.
     */
    @Override
    public void sort() {
        HeapUtils.heapSortAsc((E[]) getData());
    }

}
