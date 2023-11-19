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

import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 10:00:30 AM
 * @since 1.0.0
 */
public class LinkedList<E extends Comparable<? super E>> extends AbstractLinkedList<E> implements List<E> {

    private ListNode<E> root;

    public LinkedList() {
    }

    /**
     * @param value
     * @return
     */
    @Override
    public boolean addHead(E value) {
        return false;
    }

    /**
     * @param value
     * @return
     */
    private ListNode insert(ListNode parent, E value) {
        if (parent == null) {
            parent = new ListNode(value);
            super.incrementSize();
            return parent;
        } else {
            return insert(parent.getNext(), value);
        }
    }

    /**
     * @param item element to be appended to this list
     * @return
     */
    @Override
    public boolean add(E item) {
        root = insert(root, item);
        return true;
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[");
        if (!isEmpty()) {
            ListNode temp = root;
            boolean isFirst = true;
            while (temp != null) {
                if (isFirst) {
                    isFirst = false;
                }

                if (!isFirst) {
                    sBuilder.append(", ");
                }

                sBuilder.append(temp.getValue());
                temp = temp.getNext();
            }
        }

        return sBuilder.append("]").toString();
    }

    /**
     * @param value
     * @return
     */
    @Override
    public boolean addTail(E value) {
        return false;
    }

    /**
     * @param value
     * @return
     */
    @Override
    public boolean addNode(E value) {
        return false;
    }

    /**
     * @param value
     * @return
     */
    @Override
    public E find(E value) {
        return null;
    }

    /**
     * @param value
     * @return
     */
    @Override
    public boolean removeHead(E value) {
        return false;
    }

    /**
     * @param value
     * @return
     */
    @Override
    public boolean removeTail(E value) {
        return false;
    }

    /**
     * @param value
     * @return
     */
    @Override
    public boolean removeNode(E value) {
        return false;
    }

}
