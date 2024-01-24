package com.devamatre.theorem.queue;

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
public class DefaultMonotonicQueue<E extends Comparable> implements MonotonicQueue<E> {

    private final Order order;
    private Deque<E> queue = new LinkedList<>();

    /**
     * @param order
     */
    public DefaultMonotonicQueue(Order order) {
        this.order = order;
    }

    /**
     * Usually removes elements from queue compared to value in {@param newItem} to preserve monotonicity. Then adds a
     * new element.
     * <p>
     * Monotonic increasing queue: to push an element e, starts from the rear element, we pop out element s ≥ e
     * (violation); Monotonic decreasing queue: we pop out element s <= e (violation).
     *
     * @param newItem
     */
    @Override
    public void push(E newItem) {
        if (order == Order.INCREASING) {
            while (!queue.isEmpty() && queue.getLast().compareTo(newItem) > 0) {
                queue.removeLast();
            }
        } else if (order == Order.DECREASING) {
            while (!queue.isEmpty() && queue.getLast().compareTo(newItem) < 0) {
                queue.removeLast();
            }
        }

        //add new item into the queue
        queue.add(newItem);
    }

    /**
     * @return the first value of the queue, which is usually a maximum or a minimum.
     */
    @Override
    public E getFirst() {
        return queue.peek();
    }

    /**
     * Removes min or max when it is no longer needed.
     */
    @Override
    public void removeFirst() {
        queue.poll();
    }


    /**
     * @return
     */
    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args) {
        DefaultMonotonicQueue<Integer> incMonotonicQueue = new DefaultMonotonicQueue<Integer>(Order.INCREASING);
        DefaultMonotonicQueue<Integer> descMonotonicQueue = new DefaultMonotonicQueue<Integer>(Order.DECREASING);
        int[] input = new int[]{5, 3, 1, 2, 4};
        for (int i = 0; i < input.length; i++) {
            incMonotonicQueue.push(input[i]);
            descMonotonicQueue.push(input[i]);
            System.out.println("i:" + input[i] + ", incMonotonicQueue:" + incMonotonicQueue + ", descMonotonicQueue:"
                               + descMonotonicQueue);
        }
    }
}
