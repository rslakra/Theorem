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
 * @created 2017-12-28 04:41:02 PM
 * @since 1.0.0
 */
@SuppressWarnings("unchecked")
public class LinkedListStack<E> implements Stack<E> {

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @created 2018-01-06 03:03:08 PM
     * @since 1.0.0
     */
    private class Node {

        E data;
        Node next;

        Node(E data) {
            this.data = data;
            next = null;
        }

        public String toString() {
            return (data != null ? data.toString() : "");
        }
    }

    private Node root;
    private int size;

    public LinkedListStack() {
        root = null;
        size = 0;
    }

    public E push(E data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        } else {
            node.next = root;
            root = node;
        }
        size++;
        return data;
    }

    public E pop() {
        if (empty()) {
            return null;
        }

        Node node = root;
        root = root.next;
        size--;
        return (E) node;
    }

    public E peek() {
        if (empty()) {
            return null;
        }

        return (E) root.data;
    }

    /**
     * @return
     * @see com.devamatre.coder.stack.Stack#empty()
     */
    @Override
    public boolean empty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    /**
     * @param item
     * @return
     * @see com.devamatre.coder.stack.Stack#contains(java.lang.Object)
     */
    @Override
    public boolean contains(E item) {
        if (!empty()) {
            Node temp = root;
            while (temp != null) {
                if (temp.data == item) {
                    return true;
                }
                temp = temp.next;
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
            Node temp = root;
            while (temp != null) {
                stackString.append(temp.data.toString());
                if (temp.next != null) {
                    stackString.append(", ");
                }
                temp = temp.next;
            }
        }
        stackString.append("]");
        return stackString.toString();
    }

}
