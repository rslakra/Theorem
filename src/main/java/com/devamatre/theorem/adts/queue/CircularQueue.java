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
package com.devamatre.theorem.adts.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class CircularQueue<E extends Comparable<? super E>> extends ArrayQueue<E> implements Queue<E> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CircularQueue.class);

    private int head = -1;

    /**
     * @param capacity
     */
    public CircularQueue(int capacity) {
        super(capacity);
    }

    /**
     *
     */
    public CircularQueue() {
        super();
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return (head == -1 && tail == -1);
    }

    /**
     * Returns the size of the circular queue.
     *
     * @param tail
     * @param head
     * @param size
     * @return
     */
    private int getSize(int tail, int head, int size) {
        return ((tail -= head) < 0) ? tail += size : tail;
    }

    /**
     * Returns the size of the queue.
     *
     * @return
     */
    @Override
    public int getSize() {
        return (isEmpty() ? 0 : getSize(tail, head, elements.length) + 1);
    }

    /**
     * Returns true if the head == tail.
     *
     * @return
     */
    protected boolean isFull() {
        return ((tail + 1) % elements.length == head);
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity
     * restrictions, returning {@code true} upon success and throwing an {@code IllegalStateException} if no space is
     * currently available.
     *
     * @param item the element to add
     * @return {@code true} (as specified by {@link java.util.Collection#add})
     * @throws IllegalStateException if the element cannot be added at this time due to capacity restrictions added to
     *                               this queue
     * @throws NullPointerException  if the specified element is null and this queue does not permit null elements
     */
    @Override
    public boolean add(E item) {
        checkNull(item);

        // if queue is full, you can't add more items to it.
        if (isFull()) {
            return false;
        }

        // on adding first time, move head to first element
        if (tail == -1) {
            head = 0;
        }

        // move the tail to the next index and add an item at that index.
        tail = (tail + 1) % elements.length;
        elements[tail] = item;

        return true;
    }

    /**
     * Retrieves and removes the head of this queue. This method differs from {@link #poll poll} only in that it throws
     * an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    @Override
    public E remove() {
        E element = null;
        if (!isEmpty()) {
            element = (E) elements[head];
            // make the element null at the index to make the space available for reuse.
            elements[head] = null;
            // if there is only 1 element in the queue
            if (head == tail) {
                // point the head and tail out of the queue
                head = tail = -1;
            } else {
                // otherwise move the head to the next element of the queue.
                head = (head + 1) % elements.length;
            }
        }

        return element;
    }

    /**
     * Retrieves, but does not remove, the head of this queue. This method differs from {@link #peek peek} only in that
     * it throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    @Override
    public E element() {
        return (isEmpty() ? null : (E) elements[head]);
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E peek() {
        return element();
    }

    /**
     * Returns the string representation of this object.
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("[");
        if (!isEmpty()) {
            int index = head;
            LOGGER.debug("elements:{}", Arrays.toString(elements));
            // iterate elements till index < size or index < tail
            while (index < tail || (index > tail && index < elements.length)) {
                strBuilder.append(elements[index]);
                // move the head pointer to the start of the elements
                if (index > tail) {
                    index = (index + 1) % elements.length;
                    strBuilder.append(", ");
                } else if (index < tail) { // if not reached till tail, add separator.
                    strBuilder.append(", ");
                    index++;
                }
            }
        }
        strBuilder.append("]");
        return strBuilder.toString();
    }
}
