/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code, in source
 * and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.theorem.algos.linkedlist;

import com.rslakra.appsuite.core.ToString;

import java.util.Objects;

/**
 * This class represents the nodes of the linked list.
 *
 * @author Rohtash Lakra
 * @created 09/20/2016 01:51:00 PM
 * @See <url>https://en.wikipedia.org/wiki/Linked_list</url>
 */
public class ListNode<E extends Comparable<? super E>> implements Comparable<ListNode<E>> {

    public ListNode<E> previous;
    public E data;
    public ListNode<E> next;

    /**
     * @param previous
     * @param data
     * @param next
     */
    public ListNode(ListNode<E> previous, E data, ListNode<E> next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    /**
     * @param data
     * @param next
     */
    public ListNode(E data, ListNode<E> next) {
        this(null, data, next);
    }

    /**
     * @param data
     */
    public ListNode(E data) {
        this(null, data, null);
    }

    /**
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof ListNode)) {
            return false;
        }

        ListNode listNode = (ListNode) object;
        boolean result = Objects.equals(data, listNode.data);
        if (!result) {
            result = Objects.equals(previous, listNode.previous);
            if (!result) {
                result = Objects.equals(next, listNode.next);
            }
        }

        return result;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(ListNode.class, true).add("previous", previous).add("data", data).add("next", next)
            .toString();
    }

    /**
     * Compares this object with the specified object for order.  Returns a negative integer, zero, or a positive
     * integer as this object is less than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))} for all {@code x} and {@code y}.  (This implies that
     * {@code x.compareTo(y)} must throw an exception iff {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any class that implements the
     * {@code Comparable} interface and violates this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than
     * the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it from being compared to this object.
     */
    @Override
    public int compareTo(ListNode<E> other) {
        return data.compareTo(other.data);
    }


    /**
     * Returns the string representation of the <code>headNode</code> linkedList.
     *
     * @param headNode
     * @param addBrackets
     * @return
     */
    public static <E extends Comparable<? super E>> String toString(ListNode<E> headNode, boolean addBrackets) {
        StringBuilder sBuilder = new StringBuilder();
        if (addBrackets) {
            sBuilder.append("[");
        }

        if (headNode != null) {
            ListNode<E> current = headNode;
            while (current != null) {
                sBuilder.append(current.data);
                if (current.next != null) {
                    sBuilder.append(", ");
                }

                current = current.next;
            }
        }

        if (addBrackets) {
            sBuilder.append("]");
        }

        return sBuilder.toString();
    }

    /**
     * Returns the string representation of the <code>headNode</code> linkedList.
     *
     * @param headNode
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> String toString(ListNode<E> headNode) {
        return toString(headNode, true);
    }

}
