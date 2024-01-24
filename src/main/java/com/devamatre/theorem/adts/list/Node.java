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
package com.devamatre.theorem.adts.list;

import com.devamatre.appsuite.core.ToString;
import lombok.Getter;

import java.util.Objects;

/**
 * This class represents the nodes of the linked list.
 *
 * @author Rohtash Lakra
 * @created 09/20/2016 01:51:00 PM
 * @See <url>https://en.wikipedia.org/wiki/Linked_list</url>
 */
@Getter
public class Node<E extends Comparable<? super E>> implements Comparable<Node<E>> {

    private Node<E> previous;
    private final E data;
    private Node<E> next;

    /**
     * @param previous
     * @param data
     * @param next
     */
    public Node(Node<E> previous, E data, Node<E> next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    /**
     * @param data
     * @param next
     */
    public Node(E data, Node<E> next) {
        this(null, data, next);
    }

    /**
     * @param data
     */
    public Node(E data) {
        this(null, data, null);
    }

    /**
     * @param previous
     */
    public void setPrevious(Node<E> previous) {
        this.previous = previous;
    }

    /**
     * @param next
     */
    public void setNext(Node<E> next) {
        this.next = next;
        if (next != null) {
            next.setPrevious(this);
        }
    }

    /**
     * @return
     */
    public boolean hasPrevious() {
        return Objects.nonNull(getPrevious());
    }

    /**
     * @return
     */
    public boolean hasNext() {
        return Objects.nonNull(getNext());
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getPrevious(), getData(), next);
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

        if (!(object instanceof Node)) {
            return false;
        }

        Node<E> listNode = (Node<E>) object;
        boolean result = Objects.equals(getData(), listNode.getData());
        if (!result) {
            result = Objects.equals(getPrevious(), listNode.getPrevious());
            if (!result) {
                result = Objects.equals(getNext(), listNode.getNext());
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
        return ToString.of(Node.class, true)
                .add("previous", toString(getPrevious()))
                .add("data", getData())
                .add("next", toString(getNext()))
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
    public int compareTo(Node<E> other) {
        return getData().compareTo(other.getData());
    }

    /**
     * Returns true if the node data is greater than the <code>other</code> node's data otherwise false.
     *
     * @param other
     * @return
     */
    public boolean isGreaterThan(Node<E> other) {
        return (this.compareTo(other) > 0);
    }

    /**
     * Returns true if the node data is less than the <code>other</code> node's data otherwise false.
     *
     * @param other
     * @return
     */
    public boolean isLessThan(Node<E> other) {
        return (this.compareTo(other) < 0);
    }

    /**
     * Returns true if the node data is equals to the <code>other</code> node's data otherwise false.
     *
     * @param other
     * @return
     */
    public boolean isEquals(Node<E> other) {
        return (this.compareTo(other) == 0);
    }

    /**
     * Returns true if the node's data is greater than the <code>other</code> otherwise false.
     *
     * @param other
     * @return
     */
    public boolean isGreaterThan(E other) {
        return (getData().compareTo(other) > 0);
    }

    /**
     * Returns true if the node's data is less than the <code>other</code> otherwise false.
     *
     * @param other
     * @return
     */
    public boolean isLessThan(E other) {
        return (getData().compareTo(other) < 0);
    }

    /**
     * Returns true if the node's data is equal to the <code>other</code> otherwise false.
     *
     * @param other
     * @return
     */
    public boolean isEquals(E other) {
        return (getData().compareTo(other) == 0);
    }

    /**
     * Returns the string representation of the <code>headNode</code> linkedList.
     *
     * @param headNode
     * @param addBrackets
     * @return
     */
    public static <E extends Comparable<? super E>> String toString(Node<E> headNode, boolean addBrackets) {
        StringBuilder sBuilder = new StringBuilder();
        if (addBrackets) {
            sBuilder.append("[");
        }

        if (headNode != null) {
            Node<E> current = headNode;
            while (current != null) {
                sBuilder.append(current.getData());
                if (current.hasNext()) {
                    sBuilder.append(", ");
                }

                current = current.getNext();
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
    public static <E extends Comparable<? super E>> String toString(Node<E> headNode) {
        return toString(headNode, true);
    }
}
