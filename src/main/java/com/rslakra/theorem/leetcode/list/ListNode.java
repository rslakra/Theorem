/**
 *
 */
package com.rslakra.theorem.leetcode.list;

import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 11/03/20245 08:28:44 PM
 */
public class ListNode<E> {

    public E data;
    public ListNode<E> next;

    /**
     * @param data
     */
    public ListNode(E data) {
        this.data = data;
    }

    /**
     * @param data
     * @param next
     */
    public ListNode(E data, ListNode<E> next) {
        this(data);
        this.next = next;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return Objects.toString(data);
    }

}
