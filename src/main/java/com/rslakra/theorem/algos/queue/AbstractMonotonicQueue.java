package com.rslakra.theorem.algos.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Monotonic increasing queue: to push an element e, starts from the rear element, we pop out element s≥e(violation);
 * <p>
 * Monotonic decreasing queue: we pop out element s<=e (violation).
 *
 * @param <E>
 * @author Rohtash Lakra
 * @verion 1.0.0
 * @created Nov 3, 2020 06:39:28 PM
 */
public abstract class AbstractMonotonicQueue<E extends Comparable> implements MonotonicQueue<E> {

    private final Deque<E> monotonicQueue = new LinkedList<>();

    /**
     *
     */
    public AbstractMonotonicQueue() {
    }

    /**
     * @return
     */
    public Deque getMonotonicQueue() {
        return monotonicQueue;
    }

    /**
     * @return
     */
    protected E getLast() {
        return monotonicQueue.getLast();
    }

// /**
// * Usually removes elements from queue compared to value in {@param newItem} to
// * preserve monotonicity. Then adds a new element.
// * <p>
// * Monotonic increasing queue: to push an element e, starts from the rear element,
// * we pop out element s≥e(violation);
// * Monotonic decreasing queue: we pop out element s<=e (violation).
// *
// * @param newItem
// */
// @Override
// public void push(E newItem) {
// while (!monotonicQueue.isEmpty() && monotonicQueue.getLast().compareTo(newItem) > 0) {
// monotonicQueue.removeLast();
// }
//
// //add new item into the queue
// monotonicQueue.addLast(newItem);
// }

    /**
     * @return the first value of the queue, which is usually a maximum or a minimum.
     */
    @Override
    public E getFirst() {
        return monotonicQueue.getFirst();
    }

    /**
     * Removes min or max when it is no longer needed.
     */
    @Override
    public void removeFirst() {
        monotonicQueue.removeFirst();
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return monotonicQueue.toString();
    }

}
