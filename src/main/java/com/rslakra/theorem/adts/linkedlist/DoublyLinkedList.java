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
package com.rslakra.theorem.adts.linkedlist;

import com.rslakra.theorem.adts.list.Node;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 01/31/2017 03:49:55 PM
 * @since 1.0.0
 */
public class DoublyLinkedList<E extends Comparable<? super E>> extends LinkedList<E> {

    /**
     *
     */
    public DoublyLinkedList() {
    }

    // /**
    // * Inserts the new node at the first position of the linked list.
    // * <p>
    // * Time complexity of insertion is O(1), because it takes constant amount of time.
    // *
    // * @param newNode
    // */
    // public void addHead(Node<E> newNode) {
    // if (head == null) {
    // head = newNode;
    // tail = newNode;
    // } else {
    // newNode.setNext(head);
    // head.setPrevious(newNode);
    // head = newNode;
    // if (getSize() == 1) {
    // tail.setPrevious(head.getPrevious());
    // tail = head;
    // }
    // }
    // incrementSize();
    // }
    //
    // /**
    // * Inserts the new node after the specified parent node.
    // * <p>
    // * Time complexity of insertAfter() is O(1) as it does constant amount of work.
    // *
    // * @param parentNode
    // * @param newNode
    // */
    // public void insertAfter(Node<E> parentNode, Node<E> newNode) {
    // if (parentNode == null) {
    // parentNode = newNode;
    // tail = newNode;
    // } else {
    // newNode.setNext(parentNode.getNext());
    // parentNode.setNext(newNode);
    // }
    // }
    //
    // /**
    // * Inserts the new node at the end of the linked list.
    // * <p>
    // * Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head
    // * to end, the function does O(n) work.
    // * <p>
    // * This method can also be optimized to work in O(1) by keeping an extra pointer to tail of linked list.
    // *
    // * @param newNode
    // */
    // public void addTail(Node<E> newNode) {
    // // new node will be the last node, so set it's next to be null;
    // newNode.setNext(null);
    // if (head == null) {
    // head = newNode;
    // tail = newNode;
    // } else {
    // tail.setNext(newNode);
    // newNode.setPrevious(tail);
    // tail = newNode;
    // }
    // incrementSize();
    // }
    //
    // /**
    // * Inserts the node at the specified index.
    // *
    // * @param index
    // * @param data
    // */
    // public void insertAt(int index, E data) {
    // if (index < 0 || index > getSize()) {
    // throw new IllegalArgumentException("Invalid index:" + index);
    // }
    //
    // Node<E> newNode = new Node<E>(data);
    // if (isEmpty()) {
    // addHead(newNode);
    // } else if (getSize() == 1) {
    // addTail(newNode);
    // } else {
    // int ctr = 0;
    // Node<E> curNode = head;
    // while (ctr < (index - 2)) {
    // curNode = curNode.getNext();
    // ctr++;
    // }
    // newNode.setNext(curNode.getNext());
    // newNode.setPrevious(curNode);
    // newNode.getNext().setPrevious(newNode);
    // curNode.setNext(newNode);
    // incrementSize();
    // }
    // }
    //
    // /**
    // * Removes the provided node.
    // *
    // * @param element
    // */
    // public void remove(E element) {
    // Node<E> currentNode = head;
    // Node<E> previous = head;
    // while (currentNode != null && !currentNode.getData().equals(element)) {
    // previous = currentNode;
    // currentNode = currentNode.getNext();
    // }
    //
    // if (previous != null && currentNode != null) {
    // if (previous == currentNode) {
    // head = currentNode.getNext();
    // } else {
    // previous.setNext(currentNode.getNext());
    // }
    //
    // // make available for garbage collection
    // currentNode.setNext(null);
    // currentNode = null;
    // }
    // }
    //
    // /**
    // * Removes the node of the specified position.
    // *
    // * @param position
    // */
    // public E removeAt(int position) {
    // return super.removeAt(position);
    // }
    //
    // /**
    // * Removes the first node of the linked list.
    // */
    // public void removeFirst() {
    // super.removeFirst();
    // }
    //
    // /**
    // * Returns the size of the linked list using recursion.
    // * <p>
    // * Time complexity of size is O(n) where n is the number of nodes in linked list. Since there is a loop from head to
    // * end, the function does O(n) work.
    // *
    // * @param listNode
    // * @return
    // */
    // public int size(Node<E> listNode) {
    // return (listNode == null ? 0 : (1 + size(listNode.getNext())));
    // }
    //
    // /**
    // * Return true if the linked list contains the specified node for an element otherwise false. The comparison is
    // * case-sensitive.
    // * <p>
    // * Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head
    // * to end, the function does O(n) work.
    // *
    // * @param element
    // * @return
    // */
    // public boolean contains(E element) {
    // boolean contains = false;
    // Node<E> current = head;
    // while (current != null) {
    // if (current.getData().equals(element)) {
    // contains = true;
    // break;
    // }
    // current = current.getNext();
    // }
    //
    // return contains;
    // }
    //
    // /**
    // * @param listNode
    // * @param element
    // * @return
    // */
    // public boolean contains(Node<E> listNode, E element) {
    // return (listNode == null ? false
    // : listNode.getData().equals(element) ? true : contains(listNode.getNext(), element));
    // }

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
        while (sNode != null && !sNode.getData().equals(source)) {
            sPrevious = sNode;
            sNode = sNode.getNext();
        }

        // find target and its previous nodes.
        Node<E> tNode = head;
        Node<E> tPrevious = null;
        while (tNode != null && !tNode.getData().equals(target)) {
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

    // /**
    // * @param index
    // * @return
    // */
    // public E getValue(int index) {
    // Node<E> current = head;
    // int ctr = 0;
    // while (current != null) {
    // if (ctr == index) {
    // break;
    // }
    // ctr++;
    // current = current.getNext();
    // }
    //
    // return (current == null ? null : current.getData());
    // }
    //
    // /**
    // * Returns the string representation of this object.
    // *
    // * @see java.lang.Object#toString()
    // */
    // public String toString() {
    // StringBuilder sBuilder = new StringBuilder();
    // Node<E> current = head;
    // sBuilder.append("[");
    //
    // // iterate all elements of the linkedList
    // while (current != null) {
    // sBuilder.append(current.getData());
    // current = current.getNext();
    // if (current != null) {
    // sBuilder.append(", ");
    // }
    // }
    //
    // sBuilder.append("]");
    // return sBuilder.toString();
    // }

    /**
     * Returns the reverse string representation of this object.
     */
    public String toStringReverse() {
        StringBuilder sBuilder = new StringBuilder();
        Node<E> current = tail;
        sBuilder.append("[");

        while (current != null) {
            sBuilder.append(current.getData());
            current = current.getPrevious();
            if (current != null) {
                sBuilder.append(", ");
            }
        }

        sBuilder.append("]");
        return sBuilder.toString();
    }

}
