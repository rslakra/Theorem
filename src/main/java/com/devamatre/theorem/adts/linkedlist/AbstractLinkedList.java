package com.devamatre.theorem.adts.linkedlist;

import com.devamatre.theorem.adts.list.AbstractList;

/**
 * @author Rohtash Lakra
 * @created 5/20/22 11:53 AM
 */
public abstract class AbstractLinkedList<E extends Comparable<? super E>> extends AbstractList<E> {

    /**
     * Returns true if the head of the linked-list is empty otherwise false.
     *
     * <pre>
     *  Time Complexity: O(1)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @return
     */
    public abstract boolean isEmpty();

    /**
     * Adds the node with the provided <code>data</code> at the head of the linked-list.
     *
     * <pre>
     *  Time Complexity: O(1)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param data
     * @return
     */
    public abstract boolean addHead(E data);

    /**
     * Adds the node with the provided <code>data</code> at the tail of the linked-list.
     *
     * <pre>
     *  Time Complexity: O(1)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param data
     * @return
     */
    public abstract boolean addTail(E data);

    /**
     * Adds the node with the provided <code>data</code> to the linked-list.
     *
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param data
     * @return
     */
    public abstract boolean addNode(E data);

    /**
     * Returns the node with the provided <code>data</code> if exists in the linked-list otherwise null.
     *
     * <pre>
     *  Time Complexity: O(N)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param data
     * @return
     */
    public abstract E findNode(E data);

    /**
     * Removes the head node of the linked-list if exists.
     *
     * <pre>
     *  Time Complexity: O(1)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @return
     */
    public abstract boolean removeHead();

    /**
     * Removes the tail node of the linked-list if exists.
     *
     * <pre>
     *  Time Complexity: O(1)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @return
     */
    public abstract boolean removeTail();

    /**
     * Removes the provided node of the linked-list if exists.
     *
     * <pre>
     *  Time Complexity: O(1)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param data
     * @return
     */
    public abstract boolean removeNode(E data);

}
