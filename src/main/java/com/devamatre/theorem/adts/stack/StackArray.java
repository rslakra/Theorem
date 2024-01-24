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

import java.util.Arrays;

/**
 * @param <E>
 * @author Rohtash Lakra
 * @created 09/20/2016 02:00:49 PM
 */
public class StackArray<E> {

    private static final int MAX_CAPACITY = 16;
    private int index;
    private Object[] elements;

    /**
     * @param capacity
     */
    public StackArray(int capacity) {
        elements = new Object[capacity];
        index = 0;
    }

    /**
     *
     */
    public StackArray() {
        this(MAX_CAPACITY);
    }

    /**
     * Returns true if the stack is full otherwise false.
     *
     * @return
     */
    public boolean isFull() {
        return (index == elements.length - 1);
    }

    /**
     * Returns true if the stack is empty otherwise false.
     *
     * @return
     */
    public boolean isEmpty() {
        return (index == 0);
    }

    /**
     * Adds the new element into the stack.
     *
     * @param element
     */
    public void push(E element) {
        if (isFull()) {
            int newSize = elements.length + MAX_CAPACITY;
            elements = Arrays.copyOf(elements, newSize, Object[].class);
        }
        elements[index] = element;
        index++;
    }

    /**
     * Removes the top element from the stack.
     *
     * @return
     */
    public E pop() {
        E element = peek();
        if (element != null && !isEmpty()) {
            elements[index - 1] = null;
            index--;
        }

        return element;
    }

    /**
     * Returns the element at the specified index.
     *
     * @param index
     * @return
     */
    protected E peekElement(int index) {
        E element = null;
        if (isEmpty()) {
            System.out.println("Stack is empty!");
        } else {
            element = (E) elements[index];
        }

        return element;
    }

    /**
     * Returns the top element of the stack without removing it.
     *
     * @return
     */
    public E peek() {
        return peekElement(index - 1);
    }

    /**
     * Returns the string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder("[");
        if (!isEmpty()) {
            for (int i = elements.length - 1; i >= 0; i--) {
                Object element = peekElement(i);
                if (element != null) {
                    sBuilder.append(peekElement(i));
                    if (i > 0) {
                        sBuilder.append(", ");
                    }
                }
            }
        }
        sBuilder.append("]");
        return sBuilder.toString();
    }

}
