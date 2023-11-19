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
package com.devamatre.theorem.adts.linkedlist;

import com.devamatre.theorem.adts.list.Node;

/**
 * @author Rohtash Lakra
 * @date 01/31/2017 03:49:55 PM
 */
public class DoublyLinkedList<E extends Comparable<? super E>> extends LinkedList<E> {

    // root node of the list.
    private Node<E> head;

    // last node of the list.
    private Node<E> tail;

    // total nodes of the list.
    private int size;

    /**
     *
     */
    public DoublyLinkedList() {
    }

    /**
     * Returns the size of the list.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns true if the linked list is empty otherwise false.
     *
     * @return
     */
    public boolean isEmpty() {
        return (head == null && size == 0);
    }

    /**
     * Inserts the new node at the first position of the linked list.
     * <p>
     * Time complexity of insertion is O(1), because it takes constant amount of time.
     *
     * @param newNode
     */
    public void push(Node<E> newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        } else {
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
            size++;
            if (getSize() == 1) {
                tail.setPrevious(head.getPrevious());
                tail = head;
            }
        }
    }

    /**
     * Inserts the new node after the specified parent node.
     * <p>
     * Time complexity of insertAfter() is O(1) as it does constant amount of work.
     *
     * @param parentNode
     * @param newNode
     */
    public void insertAfter(Node<E> parentNode, Node<E> newNode) {
        if (parentNode == null) {
            parentNode = newNode;
            tail = newNode;
        } else {
            newNode.setNext(parentNode.getNext());
            parentNode.setNext(newNode);
        }
    }

    /**
     * Inserts the new node at the end of the linked list.
     * <p>
     * Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head
     * to end, the function does O(n) work.
     * <p>
     * This method can also be optimized to work in O(1) by keeping an extra pointer to tail of linked list.
     *
     * @param newNode
     */
    public void append(Node<E> newNode) {
        // new node will be the last node, so set it's next to be null;
        newNode.setNext(null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size++;
    }

    /**
     * Inserts the node at the specified index.
     *
     * @param index
     * @param data
     */
    public void insertAt(int index, E data) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid index:" + index);
        }

        Node<E> newNode = new Node<E>(data);
        if (size == 0) {
            push(newNode);
        } else if (size == 1) {
            append(newNode);
        } else {
            int ctr = 0;
            Node<E> curNode = head;
            while (ctr < (index - 2)) {
                curNode = curNode.getNext();
                ctr++;
            }
            newNode.setNext(curNode.getNext());
            newNode.setPrevious(curNode);
            newNode.getNext().setPrevious(newNode);
            curNode.setNext(newNode);
            size++;
        }
    }

    /**
     * Removes the provided node.
     *
     * @param element
     */
    public void remove(E element) {
        Node<E> currentNode = head;
        Node<E> previous = head;
        while (currentNode != null && !currentNode.getValue().equals(element)) {
            previous = currentNode;
            currentNode = currentNode.getNext();
        }

        if (previous != null && currentNode != null) {
            if (previous == currentNode) {
                head = currentNode.getNext();
            } else {
                previous.setNext(currentNode.getNext());
            }

            // make available for garbage collection
            currentNode.setNext(null);
            currentNode = null;
        }
    }

    /**
     * Removes the node of the specified position.
     *
     * @param position
     */
    public void removeAt(int position) {
        Node<E> currentNode = head;
        Node<E> previous = head;
        for (int i = 0; i < position - 1 && currentNode != null; i++) {
            previous = currentNode;
            currentNode = currentNode.getNext();
        }

        if (previous != null && currentNode != null) {
            if (previous == currentNode) {
                head = currentNode.getNext();
            } else {
                previous.setNext(currentNode.getNext());
            }

            // make available for garbage collection
            currentNode.setNext(null);
            currentNode = null;
        }
    }

    /**
     * Removes the first node of the linked list.
     */
    public void removeFirst() {
        Node<E> current = head;
        head = current.getNext();
        current.setNext(null);
        current = null;
    }

    /**
     * Removes the first node of the linked list.
     *
     * @param node
     * @return
     */
    // @Deprecated
    // public Node<E> removeFirst(Node<E> node) {
    // return (node == null ? null : node.getNext());
    // }

    /**
     * Returns the size of the linked list.
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Returns the size of the linked list using recursion.
     * <p>
     * Time complexity of size is O(n) where n is the number of nodes in linked list. Since there is a loop from head to
     * end, the function does O(n) work.
     *
     * @param node
     * @return
     */
    public int size(Node<E> node) {
        return (node == null ? 0 : (1 + size(node.getNext())));
    }

    /**
     * Return true if the linked list contains the specified node for an element otherwise false. The comparison is
     * case-sensitive.
     * <p>
     * Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head
     * to end, the function does O(n) work.
     *
     * @param element
     * @return
     */
    public boolean contain(E element) {
        boolean contains = false;
        Node<E> current = head;
        while (current != null) {
            if (current.getValue().equals(element)) {
                contains = true;
                break;
            }
            current = current.getNext();
        }

        return contains;
    }

    /**
     * @param node
     * @param element
     * @return
     */
    public boolean contain(Node<E> node, E element) {
        return (node == null ? false : node.getValue().equals(element) ? true : contain(node.getNext(), element));
    }

    /**
     * Swaps the source node with the target node.
     *
     * @param source
     * @param target
     */
    public void swapNodes(E source, E target) {
        if (source == target) {
            return;
        }

        // find source and its previous nodes.
        Node<E> sNode = head;
        Node<E> sPrevious = null;
        while (sNode != null && !sNode.getValue().equals(source)) {
            sPrevious = sNode;
            sNode = sNode.getNext();
        }

        // find target and its previous nodes.
        Node<E> tNode = head;
        Node<E> tPrevious = null;
        while (tNode != null && !tNode.getValue().equals(target)) {
            tPrevious = tNode;
            tNode = tNode.getNext();
        }

        // if any node does not exist, nothing to do.
        if (sNode == null || tNode == null) {
            return;
        }

        if (sPrevious != null) {
            sPrevious.setNext(tNode);
        } else {
            head = tNode;
        }

        if (tPrevious != null) {
            tPrevious.setNext(sNode);
        } else {
            head = sNode;
        }

        // swap next pointers
        Node<E> tempNode = sNode.getNext();
        sNode.setNext(tNode.getNext());
        tNode.setNext(tempNode);
    }

    /**
     * @param index
     * @return
     */
    public E getValue(int index) {
        Node<E> current = head;
        int ctr = 0;
        while (current != null) {
            if (ctr == index) {
                break;
            }
            ctr++;
            current = current.getNext();
        }

        return (current == null ? null : current.getValue());
    }

    /**
     * Returns the string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        Node<E> current = head;
        sBuilder.append("[");

        while (current != null) {
            sBuilder.append(current.getValue());
            current = current.getNext();
            if (current != null) {
                sBuilder.append(", ");
            }
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }

    /**
     * Returns the reverse string representation of this object.
     */
    public String toStringReverse() {
        StringBuilder sBuilder = new StringBuilder();
        Node<E> current = tail;
        sBuilder.append("[");

        while (current != null) {
            sBuilder.append(current.getValue());
            current = current.getPrevious();
            if (current != null) {
                sBuilder.append(", ");
            }
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        DoublyLinkedList<Integer> linkList = new DoublyLinkedList<>();
        // push or prepend
        // linkList.push(new Node<Integer>(1));
        // linkList.push(new Node<Integer>(2));
        // linkList.push(new Node<Integer>(3));

        linkList.append(new Node<Integer>(1));
        linkList.append(new Node<Integer>(2));
        linkList.append(new Node<Integer>(3));
        linkList.append(new Node<Integer>(4));

        System.out.println(linkList);
        System.out.println(linkList.toStringReverse());
        // System.out.println(linkList.size());

        linkList.insertAt(2, 100);
        linkList.insertAt(linkList.getSize(), 200);
        linkList.insertAt(3, 300);
        System.out.println(linkList);
        // System.out.println(linkList.toStringReverse());

    }

}
