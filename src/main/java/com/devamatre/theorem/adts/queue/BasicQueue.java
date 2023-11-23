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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class BasicQueue<E> extends AbstractQueue<E> implements Queue<E> {

    private List<E> data;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BasicQueue<Integer> queue = new BasicQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue);

        System.out.println(queue.peek());
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println(queue);

        queue.remove();

    }

    public BasicQueue() {
        data = new ArrayList<>();
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity
     * restrictions, returning {@code true} upon success and throwing an {@code IllegalStateException} if no space is
     * currently available.
     *
     * @param item the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this time due to capacity restrictions added to
     *                               this queue
     * @throws NullPointerException  if the specified element is null and this queue does not permit null elements
     */
    @Override
    public boolean add(E item) {
        return false;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity
     * restrictions. When using a capacity-restricted queue, this method is generally preferable to {@link #add}, which
     * can fail to insert an element only by throwing an exception.
     *
     * @param item the element to add
     * @return {@code true} if the element was added to this queue, else {@code false}
     * @throws NullPointerException if the specified element is null and this queue does not permit null elements
     */
    @Override
    public boolean offer(E item) {
        return false;
    }

    /**
     * Retrieves and removes the head of this queue. This method differs from {@link #poll poll} only in that it throws
     * an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E remove() {
        return null;
    }

    /**
     * Retrieves and removes the head of this queue, or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E poll() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of this queue. This method differs from {@link #peek peek} only in that
     * it throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E element() {
        return null;
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E peek() {
        return null;
    }

    public String toString() {
        return data.toString();
    }

}
