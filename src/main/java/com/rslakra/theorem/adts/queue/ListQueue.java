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
package com.rslakra.theorem.adts.queue;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 08:55:38 AM
 * @since 1.0.0
 */
public class ListQueue<E extends Comparable<? super E>> extends ArrayQueue<E> implements Queue<E> {

    /**
     * @param capacity
     */
    public ListQueue(int capacity) {
        super(capacity);
    }

    /**
     *
     */
    public ListQueue() {
        this(DEFAULT_SIZE);
    }

    /**
     * checks the capacity and increases it if required.
     */
    private void checkCapacity() {
        if ((tail + 1) == elements.length) {
            Object[] oldItems = elements;
            elements = new Object[capacity * 2];
            System.arraycopy(oldItems, 0, elements, 0, oldItems.length);
        }
    }

    /**
     * Adds an item into the queue.
     *
     * @param item
     * @return
     * @see java.util.Queue#add(java.lang.Object)
     */
    @Override
    public boolean add(E item) {
        checkCapacity();
        elements[++tail] = item;
        return true;
    }

    /**
     * @return
     * @see Queue#remove()
     */
    @Override
    public E remove() {
        checkUnderflow();
        return removeFirst();
    }

    /**
     * @return
     * @see Queue#element()
     */
    @SuppressWarnings("unchecked")
    @Override
    public E element() {
        checkUnderflow();
        return (E) elements[0];
    }

}
