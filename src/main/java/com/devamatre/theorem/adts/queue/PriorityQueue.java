package com.devamatre.theorem.adts.queue;

import com.devamatre.theorem.adts.heap.Heap;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

/**
 * A simple priority queue supports the following basic operations:
 * <p>
 * Create: Create an empty queue.
 * <p>
 * Insert: Insert an element into a queue.
 * <p>
 * <p>
 * ExtractMax: Return the element with maximum key/value from the queue.(Actually it is more common to extract the
 * minimum. It is easy to modify the implementation (by reversing < and > to do this.)
 * <p>
 * Empty: Test whether the queue is empty.
 * <p>
 * <p>
 * AdjustPriority: Change the priority of an item in the queue.
 * <p>
 * <p>
 * Applications:
 * <pre>
 *  1. Scheduling Jobs
 *  2.
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 10/10/23 5:32 PM
 */
public class PriorityQueue<E extends Comparable<? super E>> extends Heap<E> {

    /**
     * Creates a <code>PriorityQueue</code> with the default initial capacity (11) that orders its elements according to
     * their natural ordering.
     */
    public PriorityQueue() {
        super();
    }

    /**
     * Creates a <code>PriorityQueue</code> with the specified initial capacity that orders its elements according to
     * their natural ordering.
     *
     * @param initialCapacity
     */
    public PriorityQueue(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Creates a <code>PriorityQueue</code> with the specified initial capacity that orders its elements according to
     * the specified comparator.
     *
     * @param initialCapacity
     * @param comparator
     */
    public PriorityQueue(int initialCapacity, Comparator<E> comparator) {
        super(initialCapacity, comparator);
    }

    /**
     * Creates a <code>PriorityQueue</code> containing the elements in the specified collection.
     *
     * @param elements
     */
    public PriorityQueue(Collection<? extends E> elements) {
        super(elements);
    }

    /**
     * Creates a <code>PriorityQueue</code> with the default initial capacity and whose elements are ordered according
     * to the specified comparator.
     *
     * @param comparator
     */
    public PriorityQueue(Comparator<E> comparator) {
        super(comparator);
    }

    /**
     * Creates a <code>PriorityQueue</code> containing the elements in the specified priority queue.
     *
     * @param elements
     */
    public PriorityQueue(PriorityQueue<? extends E> elements) {
        super(elements);
    }

    /**
     * Creates a <code>PriorityQueue</code> containing the elements in the specified sorted set.
     *
     * @param elements
     */
    public PriorityQueue(SortedSet<? extends E> elements) {
        super(elements);
    }

}
