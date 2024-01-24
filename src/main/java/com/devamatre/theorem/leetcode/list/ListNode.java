/**
 *
 */
package com.devamatre.theorem.leetcode.list;

import java.util.Objects;

/**
 * @author Rohtash Lakra
 */
public class ListNode<E> {

    private E data;
    private ListNode<E> next;

    /**
     * @param data
     */
    public ListNode(E data) {
        this.data = data;
        next = null;
    }

    /**
     * @return
     */
    public E getData() {
        return data;
    }

    /**
     * @return
     */
    public ListNode<E> getNext() {
        return next;
    }

    /**
     * @param next
     */
    public void setNext(ListNode<E> next) {
        this.next = next;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        if (!Objects.isNull(getData())) {
            sBuilder.append(getData());
            if (!Objects.isNull(getNext())) {
                sBuilder.append(", ").append(getNext().toString());
            }
        }

        return sBuilder.toString();
    }

    /**
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ListNode<T> newNode(T data) {
        return new ListNode<>(data);
    }

}
