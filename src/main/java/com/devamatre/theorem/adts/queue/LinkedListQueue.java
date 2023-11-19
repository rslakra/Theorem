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

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 08:55:49 AM
 * @since 1.0.0
 */
public class LinkedListQueue<E> implements Queue<E> {

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @created 2018-01-06 03:03:08 PM
     * @since 1.0.0
     */
    private class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            next = null;
        }

        public String toString() {
            return (data != null ? data.toString() : "");
        }
    }

    private Node<E> root;
    private int size;

    /**
     * @param item
     * @return
     * @see com.devamatre.algorithm.queue.Queue#add(java.lang.Object)
     */
    @Override
    public boolean add(E item) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @param item
     * @return
     * @see com.devamatre.algorithm.queue.Queue#offer(java.lang.Object)
     */
    @Override
    public boolean offer(E item) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @return
     * @see com.devamatre.algorithm.queue.Queue#remove()
     */
    @Override
    public E remove() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     * @see com.devamatre.algorithm.queue.Queue#poll()
     */
    @Override
    public E poll() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     * @see com.devamatre.algorithm.queue.Queue#element()
     */
    @Override
    public E element() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     * @see com.devamatre.algorithm.queue.Queue#peek()
     */
    @Override
    public E peek() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     * @see com.devamatre.algorithm.queue.Queue#size()
     */
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }


}
