package com.devamatre.theorem.adts.queue;

/**
 * @author Rohtash Lakra
 * @created 11/17/23 6:43 PM
 */
public abstract class AbstractQueue<E> implements Queue<E> {

    private int size;

    /**
     * Returns the size of the queue.
     *
     * @return
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (getSize() == 0);
    }
}
