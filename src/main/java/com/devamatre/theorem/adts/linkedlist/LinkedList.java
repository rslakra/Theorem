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

import com.devamatre.appsuite.core.BeanUtils;
import com.devamatre.theorem.adts.list.Node;
import com.devamatre.theorem.adts.queue.Queue;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Rohtash Lakra
 * @date 11/03/2016 04:28:44 PM
 */
public class LinkedList<E extends Comparable<? super E>> extends AbstractLinkedList<E> implements Queue<E>, List<E> {

    protected Node<E> head;

    // helps to add node at the tail of linkedList in constant time.
    protected transient Node<E> tail;

    /**
     *
     */
    public LinkedList() {
    }

    /**
     * Returns true if the head of the linked-list is empty otherwise false.
     *
     * @return
     */
    public boolean isEmpty() {
        return (head == null && getSize() == 0);
    }

    /**
     * Adds the provided <code>data</code> at the head of the linked-list.
     * <p>
     * Time complexity of append is O(1) because it uses the head pointer of linked list.
     *
     * @param listNode
     * @param data
     * @return
     */
    protected Node<E> linkHead(Node<E> listNode, E data) {
        Node newNode = new Node(data);
        if (listNode == null) {
            listNode = newNode;
        } else {
            newNode.setNext(listNode);
            listNode = newNode;
        }

        return listNode;
    }

    /**
     * Adds the provided <code>data</code> at the head of the linked-list.
     *
     * @param data
     * @return
     */
    @Override
    public boolean addHead(E data) {
        if (head == null) {
            head = linkHead(head, data);
            tail = head;
        } else {
            head = linkHead(head, data);
        }
        incrementSize();
        return true;
    }

    /**
     * Adds the provided <code>data</code> at the head of the linked-list.
     * <p>
     * Time complexity of insertion is O(1), because it takes constant amount of time.
     *
     * @param newNode
     */
    public void addFirst(Node<E> newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        incrementSize();
    }

    /**
     * Adds the provided <code>data</code> at the head of the linked-list.
     * <p>
     * Time complexity of insertion is O(1), because it takes constant amount of time.
     *
     * @param data
     */
    public void addFirst(E data) {
        addFirst(new Node<>(data));
    }

    /**
     * Links the <code>data</code> node at the end of the linkedList.
     * <p>
     * Time complexity of append is O(n) where n is the number of nodes in linked list. Since there is a loop from head
     * to end, the function does O(n) work.
     * <p>
     * This method can also be optimized to work in O(1) by keeping an extra pointer to tail of linked list.
     *
     * @param listNode
     * @param data
     * @return
     */
    protected Node<E> linkTail(Node<E> listNode, E data) {
        Node newNode = new Node(data);
        if (listNode == null) {
            listNode = newNode;
        } else {
            listNode.setNext(newNode);
            listNode = newNode;
        }

        return listNode;
    }

    /**
     * Adds the provided <code>data</code> at the tail of the linked-list.
     * <p>
     * Time complexity of append is O(1) because it uses the tail pointer to add node at the end of linked list.
     *
     * @param data
     * @return
     */
    @Override
    public boolean addTail(E data) {
        if (head == null) {
            head = linkHead(head, data);
            tail = head;
        } else {
            tail = linkTail(tail, data);
        }
        incrementSize();
        return true;
    }

    /**
     * Adds the <code>newNode</code> at the end of the linkedList in the constant time.
     * <p>
     * Time complexity of append is O(1) because it uses an extra tail pointer of linked list.
     *
     * @param newNode
     */
    public void addLast(Node<E> newNode) {
        // new node will be the last node, so set it's next to be null;
        newNode.setNext(null);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        incrementSize();
    }

    /**
     * Adds the provided <code>data</code> to the end of the linked-list.
     * <p>
     * Time complexity of append is O(1) because it uses an extra tail pointer of linked list.
     *
     * @param data
     */
    @Override
    public boolean addNode(E data) {
        addLast(new Node<>(data));
        return true;
    }

    /**
     * Returns the node with the provided <code>data</code> if exists in the linked-list otherwise null.
     *
     * @param data
     * @return
     */
    @Override
    public E findNode(E data) {
        return null;
    }

    /**
     * Returns the count from the given listNode.
     *
     * @param listNode
     * @return
     */
    public int getCount(Node<E> listNode) {
        return (BeanUtils.isNull(listNode) ? 0 : getCount(listNode.getNext()) + 1);
    }

    /**
     * Returns the count from the linkedList.
     *
     * @return
     */
    public int getCount() {
        return getCount(head);
    }

    /**
     * @return
     */
    public int getCountWithIteration() {
        int count = 0;
        Node<E> listNode = head;
        while (listNode != null) {
            count++;
            listNode = listNode.getNext();
        }

        return count;
    }

    /**
     * Removes the head node of the linked-list if exists.
     *
     * @return
     */
    @Override
    public boolean removeHead() {
        return (removeAt(1) != null);
    }

    /**
     * Removes the tail node of the linked-list if exists.
     *
     * @return
     */
    @Override
    public boolean removeTail() {
        return false;
    }

    /**
     * Removes the provided node of the linked-list if exists.
     *
     * @param data
     * @return
     */
    @Override
    public boolean removeNode(E data) {
        return false;
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
            // tail = newNode;
        } else {
            newNode.setNext(parentNode.getNext());
            parentNode.setNext(newNode);
        }
    }

    /**
     * Inserts the new node after the specified parent node.
     * <p>
     * Time complexity of insertAfter() is O(1) as it does constant amount of work.
     *
     * @param index
     * @param newNode
     */
    public void insertAt(int index, Node<E> newNode) {
        int listSize = getSize();
        // if index is valid (means >= 0 and < size of the list)
        if (index > 0 && index < listSize) {
            if (listSize == 1) {
                addFirst(newNode);
            } else {
                int count = 1;
                Node<E> parentNode = head;
                while (parentNode.getNext() != null && (count < (index - 1))) {
                    parentNode = parentNode.getNext();
                    count++;
                }
                insertAfter(parentNode, newNode);
                incrementSize();
            }
        } else {
            /**
             * if index is not valid (means < 0 OR > size of the list), add value at the end of the list.
             */
            addLast(newNode);
        }
    }

    /**
     * Removes the <code>currentNode</code> and returns the <code>data</code>.
     *
     * @param previous
     * @param currentNode
     * @return
     */
    protected E removeNode(Node<E> previous, Node<E> currentNode) {
        E data = null;
        if (previous != null && currentNode != null) {
            if (previous == currentNode) {
                head = currentNode.getNext();
                // make sure the tail is set to be null when the list is empty
                if (head == null) {
                    tail = null;
                }
            } else {
                previous.setNext(currentNode.getNext());
            }

            // make available for garbage collection
            data = currentNode.getData();
            currentNode.setNext(null);
            currentNode = null;
        }

        return data;
    }

    /**
     * Removes the provided node.
     *
     * @param element
     */
    public void remove(E element) {
        Node<E> previous = head;
        Node<E> currentNode = head;
        while (currentNode != null && !currentNode.getData().equals(element)) {
            previous = currentNode;
            currentNode = currentNode.getNext();
        }

        removeNode(previous, currentNode);
    }

    /**
     * Removes the node of the specified position.
     *
     * @param position
     */
    public E removeAt(int position) {
        E data = null;
        Node<E> previous = head;
        Node<E> currentNode = head;
        for (int i = 0; i < position - 1 && currentNode != null; i++) {
            previous = currentNode;
            currentNode = currentNode.getNext();
        }

        // remove the node and get its value.
        data = removeNode(previous, currentNode);
        return data;
    }

    /**
     * Removes the value at <code>index</code>.
     *
     * @param index the index of the element to be removed
     * @return
     */
    @Override
    public E remove(int index) {
        return removeAt(index);
    }

    /**
     * Removes the first node of the linked list.
     */
    public void removeFirst() {
        removeAt(1);
    }

    /**
     * Returns the size of the linked list.
     *
     * @return
     */
    public int getSize() {
        int size = 0;
        Node<E> current = head;
        while (current != null) {
            current = current.getNext();
            size++;
        }

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
    public boolean contains(E element) {
        boolean contains = false;
        Node<E> current = head;
        while (current != null) {
            if (current.getData().equals(element)) {
                contains = true;
                break;
            }
            current = current.getNext();
        }

        return contains;
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

        return (current == null ? null : current.getData());
    }

    /**
     * Returns the string representation of the linkedList.
     *
     * @param listNode
     * @return
     */
    public String toString(Node<E> listNode) {
        Node<E> current = listNode;
        StringBuilder sBuilder = new StringBuilder();
        while (current != null) {
            if (current.equals(head)) {
                sBuilder.append(current.getData());
            } else {
                sBuilder.append(", ").append(current.getData());
            }
            current = current.getNext();
        }

        return sBuilder.toString();
    }

    /**
     * Returns the string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("[").append(toString(head)).append("]");
        return sBuilder.toString();
    }

    /**
     * Returns the reversed string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    public String reversedToString() {
        StringBuilder sBuilder = new StringBuilder();
        reverse();
        sBuilder.append("[").append(toString(tail)).append("]");
        return sBuilder.toString();
    }

    /**
     * Returns the previous node.
     *
     * @param key
     * @return
     */
    private Node<E> findParent(E key) {
        Node<E> prevNode = null;
        Node<E> listNode = head;
        while (listNode != null) {
            if (listNode.isEquals(key)) {
                break;
            }
            prevNode = listNode;
            listNode = listNode.getNext();
        }

        return prevNode;
    }

    /**
     * Swaps the left and right nodes.
     *
     * @param leftNode
     * @param rightNode
     */
    public void swapNode(Node<E> leftNode, Node<E> rightNode) {
        if (leftNode != null && rightNode != null) {
            Node<E> tempNode = leftNode.getNext();
            leftNode.setNext(rightNode.getNext());
            rightNode.setNext(tempNode);
        }
    }

//    /**
//     * Swap nodes for two given keys. Nodes should be swapped by changing links. It has following cases to be handled.
//     * 1) x and y may or may not be adjacent. 2) Either x or y may be a head node. 3) Either x or y may be last node. 4)
//     * x and/or y may not be present in linked list.
//     *
//     * @param leftKey
//     * @param rightKey
//     */
//    public void swapNodes(E leftKey, E rightKey) {
//        if (head != null && leftKey != rightKey) {
//            // find left node and its parent
//            Node<E> leftNodeParent = null;
//            Node<E> leftNode = head;
//            while (leftNode != null && !leftNode.isEquals(leftKey)) {
//                leftNodeParent = leftNode;
//                leftNode = leftNode.getNext();
//            }
//
//            // find left node and it's parent
//            Node<E> rightNodeParent = null;
//            Node<E> rightNode = head;
//            while (rightNode != null && !rightNode.isEquals(rightKey)) {
//                rightNodeParent = rightNode;
//                rightNode = rightNode.getNext();
//            }
//
//            if (leftNode != null && rightNode != null) {
//                // if left node parent is null
//                if (leftNodeParent == null) {
//                    head = rightNode;
//                } else {
//                    leftNodeParent.setNext(rightNode);
//                }
//
//                // if right node parent is null
//                if (rightNodeParent == null) {
//                    head = leftNode;
//                } else {
//                    rightNodeParent.setNext(leftNode);
//                }
//
//                Node<E> temp = leftNode.getNext();
//                leftNode.setNext(rightNode.getNext());
//                rightNode.setNext(temp);
//            }
//        }
//    }

    /**
     * Reverses the linked list by changing the links between nodes.
     */
    public LinkedList<E> reversed() {
        LinkedList<E> reversed = new LinkedList<>();
        Node<E> current = head;
        // change next to previous, previous to current and current to next.
        while (current != null) {
            reversed.addFirst(current.getData());
            current = current.getNext();
        }

        assert getSize() == reversed.getSize();

        return reversed;
    }

    /**
     * Reverses the linked list by changing the links between nodes.
     */
    public void reverse() {
        Node<E> previous = null;
        Node<E> current = head;
        Node<E> next = null;
        // change next to previous, previous to current and current to next.
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    /**
     * @param previous
     * @param current
     */
    public Node<E> reverseRecursively(Node<E> previous, Node<E> current) {
        if (current.getNext() == null) {
            head = current;
            current.setNext(previous);
            return null;
        }

        Node<E> next = current.getNext();
        current.setNext(previous);
        reverseRecursively(current, next);
        return head;
    }

    /**
     * Reverses the linkedList recursively.
     */
    public void reverseRecursively() {
        head = reverseRecursively(null, head);
    }

    /**
     * Write a SortedMerge() function that takes two lists, each of which is sorted in increasing order, and merges the
     * two together into one list which is in increasing order. SortedMerge() should return the new list. The new list
     * should be made by splicing together the nodes of the first two lists.
     * <p>
     * For example if the first linked list a is 5->10->15 and the other linked list b is 2->3->20, then SortedMerge()
     * should return a pointer to the head node of the merged list 2->3->5->10->15->20.
     * <p>
     * There are many cases to deal with: either ‘a’ or ‘b’ may be empty, during processing either ‘a’ or ‘b’ may run
     * out first, and finally there’s the problem of starting the result list empty, and building it up while going
     * through ‘a’ and ‘b’.
     *
     * @param linkedList1
     * @param linkedList2
     */
    public static LinkedList mergeSortedLists(LinkedList linkedList1, LinkedList linkedList2) {
        LinkedList linkListMerged = null;
        // both linked lists are null, return null
        if ((linkedList1 == null || linkedList1.isEmpty()) && (linkedList2 == null || linkedList2.isEmpty())) {
            return linkListMerged;
        }

        // If first linked list is null, return second linked list.
        if (linkedList1 == null || linkedList1.isEmpty()) {
            return linkedList2;
        }

        // if 2nd linked list is null, return 1st linked list.
        if (linkedList2 == null || linkedList2.isEmpty()) {
            return linkedList1;
        }

        linkListMerged = new LinkedList();
        Node temp1 = linkedList1.head;
        Node temp2 = linkedList1.head;
        Node nextNode = linkListMerged.head;
        while (temp1 != null && temp2 != null) {
            // first find the smaller node.
            Node newNode = ((int) temp1.getData() < (int) temp2.getData() ? temp1 : temp2);
            if (nextNode == null) {
                linkListMerged.head = newNode;
                nextNode = linkListMerged.head;
                nextNode.setNext((nextNode == temp1 ? temp2 : temp1));
                nextNode = nextNode.getNext();
                temp1 = temp1.getNext();
                temp2 = temp2.getNext();
            } else {
                // nextNode.next = newNode;
                nextNode.setNext(null);
                break;
            }
        }

        return linkListMerged;
    }

    /**
     * Prints the list.
     */
    public void printList() {
        System.out.println(toString(head));
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity
     * restrictions, returning {@code true} upon success and throwing an {@code IllegalStateException} if no space is
     * currently available.
     *
     * @param element the element to add
     * @return {@code true} (as specified by {@link java.util.Collection#add})
     * @throws IllegalStateException if the element cannot be added at this time due to capacity restrictions added to
     *                               this queue
     * @throws NullPointerException  if the specified element is null and this queue does not permit null elements
     */
    @Override
    public boolean add(E element) {
        return addTail(element);
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity
     * restrictions. When using a capacity-restricted queue, this method is generally preferable to {@link #add}, which
     * can fail to insert an element only by throwing an exception.
     *
     * @param element the element to add
     * @return {@code true} if the element was added to this queue, else {@code false}
     * @throws NullPointerException if the specified element is null and this queue does not permit null elements
     */
    @Override
    public boolean offer(E element) {
        return false;
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
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        E data = head.getData();
        if (removeHead()) {
            return data;
        }

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
     * @throws java.util.NoSuchElementException if this queue is empty
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

//
//    /**
//     * @param value
//     * @return
//     */
//    private Node<E> insert(Node<E> parent, E value) {
//        if (parent == null) {
//            parent = new Node<>(value);
//            super.incrementSize();
//            return parent;
//        } else {
//            return insert(parent.getNext(), value);
//        }
//    }
//
//    /**
//     * @param element element to be appended to this list
//     * @return
//     */
//    @Override
//    public boolean add(E element) {
//        root = insert(root, element);
//        return true;
//    }
//
//    /**
//     * Returns the string representation of this object.
//     *
//     * @return
//     * @see java.lang.Object#toString()
//     */
//    public String toString() {
//        StringBuilder sBuilder = new StringBuilder("[");
//        if (!isEmpty()) {
//            Node<E> temp = root;
//            boolean isFirst = true;
//            while (temp != null) {
//                if (isFirst) {
//                    isFirst = false;
//                }
//
//                if (!isFirst) {
//                    sBuilder.append(", ");
//                }
//
//                sBuilder.append(temp.getData());
//                temp = temp.getNext();
//            }
//        }
//
//        return sBuilder.append("]").toString();
//    }


}
