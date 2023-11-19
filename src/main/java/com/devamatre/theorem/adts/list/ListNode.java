package com.devamatre.theorem.adts.list;

import com.devamatre.appsuite.core.ToString;
import lombok.Getter;

import java.util.Objects;

/**
 * @author Rohtash Lakra
 * @created 9/19/23 1:56 PM
 */
@Getter
public class ListNode<E extends Comparable<? super E>> extends Node<E> {

    /**
     * @param value
     */
    public ListNode(E value) {
        super(value);
    }

    @Override
    public ListNode getPrevious() {
        return (ListNode) super.getPrevious();
    }

    @Override
    public ListNode getNext() {
        return (ListNode) super.getNext();
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
        if (getValue() != listNode.getValue()) {
            return false;
        }

        return (getNext() != null ? getNext().equals(listNode.getNext()) : listNode.getNext() == null);
    }

    /**
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getNext());
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(ListNode.class)
            .add("value", getValue())
            .add("next", getNext())
            .toString();
    }

}
