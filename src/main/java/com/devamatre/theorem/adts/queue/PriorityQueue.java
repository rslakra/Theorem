package com.devamatre.theorem.adts.queue;

import com.devamatre.theorem.adts.heap.Heap;

import java.util.Collection;
import java.util.Comparator;

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
    public PriorityQueue(int initialCapacity, Comparator<? super E> comparator) {
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
    public PriorityQueue(Comparator<? super E> comparator) {
        super(comparator);
    }

    /**
     * Creates a <code>PriorityQueue</code> containing the elements in the specified priority queue.
     *
     * @param elements
     */
    public PriorityQueue(Heap<? extends E> elements) {
        super(elements);
    }

    /**
     * Inserts an elements into queue at the specified index.
     *
     * @param item
     */
    public void addItem(int index, E item) {

    }

    /**
     * Removes and returns the maximum/minimum element of the queue.
     * <p>
     * The maximum/minimum element will be returned and the last element of heap will be placed at index 1 and
     * <code>maxHeapify()</code> will be performed on node 1 as placing last element on index 1 will violate the
     * property of max-heap.
     * <p>
     * Time Complexity: O(log N)
     *
     * @param object
     * @return
     */
    @Override
    public boolean remove(E object) {
        return super.remove(object);
    }

    /**
     * Sorts the heap.
     */
    @Override
    public void sort() {
    }

}
