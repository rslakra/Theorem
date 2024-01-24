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
package com.devamatre.theorem.adts.stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-12-28 04:41:23 PM
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class ArrayStack<E> implements Stack<E> {

    private final static int DEFAULT_SIZE = 16;

    private int capacity;
    private Object[] items;
    private int index;

    /**
     * @param capacity
     */
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        items = new Object[capacity];
        index = 0;
    }

    /**
     *
     */
    public ArrayStack() {
        this(DEFAULT_SIZE);
    }

    /**
     * @return
     */
    public boolean isFull() {
        return index == capacity;
    }

    /**
     * @param item
     * @return
     * @see com.devamatre.coder.stack.Stack#push(java.lang.Object)
     */
    @Override
    public E push(E item) {
        if (isFull()) {
            throw new RuntimeException("Overflow!");
        }

        items[index++] = item;
        return item;
    }

    /**
     * @return
     * @see com.devamatre.coder.stack.Stack#pop()
     */
    @Override
    public E pop() {
        if (empty()) {
            throw new RuntimeException("Underflow!");
        }

        return (E) items[--index];
    }

    /**
     * @return
     * @see com.devamatre.coder.stack.Stack#peek()
     */
    @Override
    public E peek() {
        if (empty()) {
            throw new RuntimeException("Underflow!");
        }

        int topIndex = index;
        return (E) items[--topIndex];
    }

    /**
     * @return
     * @see com.devamatre.coder.stack.Stack#empty()
     */
    @Override
    public boolean empty() {
        return index == 0;
    }

    @Override
    public int size() {
        return index;
    }

    /**
     * @param item
     * @return
     * @see com.devamatre.coder.stack.Stack#contains(java.lang.Object)
     */
    @Override
    public boolean contains(E item) {
        if (!empty()) {
            for (int i = index; i >= 0; i--) {
                if (items[i] == item) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * @return
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder stackString = new StringBuilder("[");
        if (!empty()) {
            for (int i = index - 1; i >= 0; i--) {
                stackString.append(items[i].toString());
                if (i > 0) {
                    stackString.append(", ");
                }
            }
        }
        stackString.append("]");
        return stackString.toString();
    }

}
