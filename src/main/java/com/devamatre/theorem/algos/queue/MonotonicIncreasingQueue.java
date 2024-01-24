package com.devamatre.theorem.queue;

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
public class MonotonicIncreasingQueue<E extends Comparable> extends AbstractMonotonicQueue<E> {

    /**
     *
     */
    public MonotonicIncreasingQueue() {
    }

    /**
     * Usually removes elements from queue compared to value in {@param newItem} to preserve monotonicity. Then adds a
     * new element.
     * <p>
     * Monotonic increasing queue: to push an element e, starts from the rear element, we pop out element
     * s≥e(violation); Monotonic decreasing queue: we pop out element s<=e (violation).
     *
     * @param newItem
     */
    @Override
    public void push(E newItem) {
        while (!getMonotonicQueue().isEmpty() && getLast().compareTo(newItem) > 0) {
            getMonotonicQueue().removeLast();
        }

        //add new item into the queue
        getMonotonicQueue().addLast(newItem);
    }

    public static void main(String[] args) {
        MonotonicIncreasingQueue<Integer> mQueue = new MonotonicIncreasingQueue<>();
        int[] input = new int[]{5, 3, 1, 2, 4};
        for (int i = 0; i < input.length; i++) {
            mQueue.push(input[i]);
            System.out.println("i:" + input[i] + ", mQueue:" + mQueue);
        }
    }
}
