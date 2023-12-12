package com.devamatre.theorem.adts.linkedlist;

/**
 * @author Rohtash Lakra
 * @created 12/1/23 11:10 AM
 */
public class CircularLinkedList<E extends Comparable<? super E>> extends AbstractLinkedList<E> {

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
    @Override
    public boolean isEmpty() {
        return false;
    }

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
    @Override
    public boolean addHead(E data) {
        return false;
    }

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
    @Override
    public boolean addTail(E data) {
        return false;
    }

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
    @Override
    public boolean addNode(E data) {
        return false;
    }

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
    @Override
    public E findNode(E data) {
        return null;
    }

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
    @Override
    public boolean removeHead() {
        return false;
    }

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
    @Override
    public boolean removeTail() {
        return false;
    }

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
    @Override
    public boolean removeNode(E data) {
        return false;
    }
}
