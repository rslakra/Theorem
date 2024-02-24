package com.devamatre.theorem.algos.queue;

/**
 * @author Rohtash Lakra
 * @verion 1.0.0
 * @created Nov 3, 2020 06:39:28 PM
 */
public interface MonotonicQueue<E extends Comparable> {

    enum Order {
        INCREASING, DECREASING;
    }

    /**
     * Usually removes elements from queue compared to value in {@param newItem} to preserve monotonicity. Then adds a
     * new element.
     */
    void push(E newItem);

    /**
     * @return the first value of the queue, which is usually a maximum or a minimum.
     */
    E getFirst();

    /**
     * Removes min or max when it is no longer needed.
     */
    void removeFirst();

// /**
// * @return
// */
// E getLast();
//
// /**
// *
// */
// void removeLast();
}
