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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 08:54:30 AM
 * @since 1.0.0
 */
public class ArrayQueue<E extends Comparable<? super E>> extends AbstractQueue<E> implements Queue<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArrayQueue.class);

    protected transient int capacity;
    protected transient Object[] elements;
    protected transient int tail;

    /**
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        elements = new Object[capacity];
        tail = -1;
    }

    /**
     *
     */
    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }

    /**
     * @return
     * @see Queue#getSize()
     */
    @Override
    public int getSize() {
        return (tail < 0 ? 0 : tail + 1);
    }

    /**
     * Returns true when the queue is full.
     *
     * @return
     */
    protected boolean isFull() {
        return (tail == elements.length);
    }

    /**
     * Checks the <code>Underflow</code>
     *
     * @return
     */
    protected void checkUnderflow() {
        if (tail < 0) {
            throw new NoSuchElementException("Underflow!");
        }
    }

    /**
     * Checks the <code>Overflow</code>
     */
    protected void checkOverflow() {
        // check overflow (tail + 1) because the tail points the last element
        if ((tail + 1) == elements.length) {
            throw new IllegalStateException("Overflow!");
        }
    }

    /**
     * @param element
     */
    protected void checkNull(E element) {
        // check if an element is null or not
        if (element == null) {
            throw new NullPointerException("Item is null!");
        }
    }


    /**
     * @param item the element to add
     * @return
     */
    @Override
    public boolean add(E item) {
        checkNull(item);
        // check overflow
        checkOverflow();

        if (isFull()) {
            return false;
        }

        elements[++tail] = item;
        return true;
    }

    /**
     * @param item
     * @return
     * @see java.util.Queue#offer(java.lang.Object)
     */
    @Override
    public boolean offer(E item) {
        return add(item);
    }

    /**
     * Removes the first item.
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    protected E removeFirst() {
        E element = null;
        if (tail >= 0) {
            element = (E) elements[0];
            --tail;
            LOGGER.trace("tail:{}", tail);
            if (tail >= 0) {
                LOGGER.trace("before arraycopy:{}", Arrays.toString(elements));
                System.arraycopy(elements, 1, elements, 0, tail + 1);
                LOGGER.trace("after arraycopy:{}", Arrays.toString(elements));
            }
            elements[tail + 1] = null;
            LOGGER.trace("after marking last element as null:{}", Arrays.toString(elements));
        }

        return element;
    }

    /**
     * @return
     * @see Queue#remove()
     */
    @Override
    public E remove() {
        checkUnderflow();
        if (tail > elements.length) {
            throw new ArrayIndexOutOfBoundsException("tail:" + tail);
        }

        return removeFirst();
    }

    /**
     * @return
     * @see Queue#poll()
     */
    @Override
    public E poll() {
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

    /**
     * @return
     * @see Queue#peek()
     */
    @SuppressWarnings("unchecked")
    @Override
    public E peek() {
        return (E) (tail < 0 ? null : elements[0]);
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("[");
        if (!isEmpty()) {
            for (int index = 0; index <= tail; index++) {
                strBuilder.append(elements[index].toString());
                if (index < tail) {
                    strBuilder.append(", ");
                }
            }
        }
        strBuilder.append("]");

        return strBuilder.toString();
    }

}
