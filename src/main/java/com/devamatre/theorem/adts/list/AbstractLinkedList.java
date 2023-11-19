package com.devamatre.theorem.adts.list;

/**
 * @author Rohtash Lakra
 * @created 5/20/22 11:53 AM
 */
public abstract class AbstractLinkedList<E extends Comparable<? super E>> extends AbstractList<E> {

    /**
     * @param value
     * @return
     */
    public abstract boolean addHead(E value);

    /**
     * @param value
     * @return
     */
    public abstract boolean addTail(E value);

    /**
     * @param value
     * @return
     */
    public abstract boolean addNode(E value);

    /**
     * @param value
     * @return
     */
    public abstract E find(E value);

    /**
     * @param value
     * @return
     */
    public abstract boolean removeHead(E value);

    /**
     * @param value
     * @return
     */
    public abstract boolean removeTail(E value);

    /**
     * @param value
     * @return
     */
    public abstract boolean removeNode(E value);

}
