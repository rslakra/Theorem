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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.theorem.adts.list.Node;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @date 11/03/2016 04:45:23 PM
 */
public class LinkedListTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListTest.class);

    /**
     * @return
     */
    private final static LinkedList<Integer> createIntegerLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>();
        assertEquals(0, linkedList.getSize());
        Node<Integer> secondNode = new Node<Integer>(2);
        linkedList.addHead(1);
        assertEquals(1, linkedList.getSize());
        linkedList.addLast(secondNode);
        assertEquals(2, linkedList.getSize());
        linkedList.addHead(0);
        assertEquals(3, linkedList.getSize());
        linkedList.addTail(3);
        assertEquals(4, linkedList.getSize());
        linkedList.insertAfter(secondNode, new Node<Integer>(4));
        assertEquals(5, linkedList.getSize());
        LOGGER.debug("createIntegerLinkedList(), linkedList: {}", linkedList);
        return linkedList;
    }

    /**
     * @return
     */
    private final static LinkedList<String> createStringLinkedList() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.addFirst(new Node<String>("One"));
        Node<String> secondNode = new Node<String>("Two");
        linkedList.addLast(secondNode);
        linkedList.addHead("Zero");
        linkedList.addTail("Three");
        linkedList.insertAfter(secondNode, new Node<String>("Four"));
        LOGGER.debug("createStringLinkedList(), linkedList:{}", linkedList);
        return linkedList;
    }

    /**
     * Tests the <code>toString</code> method.
     */
    @Test
    public void testToString() {
        LinkedList<Integer> linkedList = createIntegerLinkedList();
        LOGGER.debug("linkedList: {}", linkedList);
        assertEquals(5, linkedList.getSize());
        assertEquals("[0, 1, 2, 4, 3]", linkedList.toString());
    }

    /**
     * Tests the <code>reversedToString</code> method.
     */
    @Test
    public void testReversedToString() {
        LinkedList<Integer> linkedList = createIntegerLinkedList();
        LOGGER.debug("linkedList: {}", linkedList);
        assertEquals(5, linkedList.getSize());
        LinkedList<Integer> reversed = linkedList.reversed();
        LOGGER.debug("Reversed linkedList: {}", reversed);
        assertEquals("[3, 4, 2, 1, 0]", reversed.toString());
    }

    /**
     * Lists the linked list.
     */
    @Test
    public void testPrintLinkedList() {
        LinkedList<Integer> intLinkedList = createIntegerLinkedList();
        LOGGER.debug("intLinkedList: {}", intLinkedList);
        LOGGER.debug("Size: {}", intLinkedList.getSize());

        LinkedList<String> stringLinkedList = createStringLinkedList();
        LOGGER.debug("stringLinkedList: {}", stringLinkedList);
        LOGGER.debug("Size: {}", stringLinkedList.getSize());
        LOGGER.debug("Size with recursion: {}", stringLinkedList.size());
    }

    /**
     * Removes nodes
     */
    @Test
    public void testRemoveNodes() {
        LinkedList<Integer> linkedList = createIntegerLinkedList();
        assertNotNull(linkedList);
        LOGGER.debug("linkedList: {}", linkedList);
        LOGGER.debug("Size: {}", linkedList.getSize());
        assertEquals(5, linkedList.getSize());

        // remove
        linkedList.removeFirst();
        linkedList.removeFirst();
        LOGGER.debug("linkedList: {}", linkedList);
        LOGGER.debug("Size: {}", linkedList.getSize());
        assertEquals(3, linkedList.getSize());

        // remove
        linkedList.remove(1);
        LOGGER.debug("linkedList: {}", linkedList);
        LOGGER.debug("Size: {}", linkedList.getSize());
        assertEquals(2, linkedList.getSize());
    }

    /**
     *
     */
    @Test
    public void testFindNodes() {
        LinkedList<Integer> linkedList = createIntegerLinkedList();
        assertNotNull(linkedList);
        assertEquals(5, linkedList.getSize());
        LOGGER.debug("linkedList: {}", linkedList);
        LOGGER.debug("contain 3: {}", linkedList.contains(3));
        LOGGER.debug("contain 16: {}", linkedList.contains(16));
        LOGGER.debug("contain 2:{}", linkedList.contains(2));

        // contain
        System.out.println("contain using recursion 2:" + linkedList.contains(2));
        System.out.println("contain using recursion 10:" + linkedList.contains(10));
        System.out.println("contain using recursion 4:" + linkedList.contains(4));

        // contain
        LinkedList<String> stringLinkedList = createStringLinkedList();
        assertNotNull(stringLinkedList);
        assertEquals(5, stringLinkedList.getSize());
        System.out.println(stringLinkedList);
        System.out.println("contain \"Four\":" + stringLinkedList.contains("Four"));
        System.out.println("contain \"Zero\":" + stringLinkedList.contains("ZERO"));
        System.out.println("contain \"Ten\":" + stringLinkedList.contains("Ten"));
    }

    /**
     *
     */
    @Test
    public void testSwapNodes() {
        LinkedList<Integer> linkedList = createIntegerLinkedList();
        assertNotNull(linkedList);
        assertEquals(5, linkedList.getSize());
        System.out.println(linkedList);

        // swap nodes
        linkedList.swapNodes(1, 3);
        linkedList.swapNodes(1, 4);
        linkedList.swapNodes(2, 3);
        linkedList.swapNodes(0, 3);
        linkedList.swapNodes(2, 4);
        linkedList.swapNodes(2, 2);

        System.out.println(linkedList);
    }

    /**
     *
     */
    @Test
    public void testGetValue() {
        LinkedList<Integer> linkedList = createIntegerLinkedList();
        assertNotNull(linkedList);
        assertEquals(5, linkedList.getSize());
        System.out.println(linkedList);
        System.out.println(linkedList.getValue(0));
    }

    /**
     *
     */
    @Test
    public void testInsertAt() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addTail(1);
        linkedList.addTail(2);
        linkedList.addTail(3);
        linkedList.addTail(4);
        linkedList.addTail(5);
        assertNotNull(linkedList);
        assertEquals(5, linkedList.getSize());
        System.out.println(linkedList);

        linkedList.insertAt(3, new Node<>(20));
        assertEquals(6, linkedList.getSize());
        System.out.println(linkedList);
    }

    @Test

    public void testLinkedList() {
        /* Start with the empty list */
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addHead(1);
        linkedList.addHead(2);
        linkedList.addHead(3);
        linkedList.addHead(4);
        linkedList.addHead(5);
        linkedList.addHead(6);
        linkedList.printList();

        linkedList.removeHead();
        linkedList.removeFirst();
        linkedList.printList();
        System.out.println("Nodes Count:" + linkedList.getCount());

        linkedList.swapNodes(1, 5);
        linkedList.reverse();
        linkedList.reverseRecursively();
        linkedList.printList();

        LinkedList linkList1 = new LinkedList();
        linkList1.addTail(10);
        linkList1.addTail(22);
        linkList1.addTail(30);
        linkList1.addTail(43);
        linkList1.addTail(50);
        linkList1.addTail(64);
        linkList1.printList();

        LinkedList linkList2 = new LinkedList();
        linkList2.addNode(11);
        linkList2.addNode(20);
        linkList2.addNode(33);
        linkList2.addNode(34);
        linkList2.addNode(55);
        linkList2.addNode(60);
        linkList2.printList();

        LinkedList mergedLinkedList = LinkedList.mergeSortedLists(linkList1, linkList2);
        mergedLinkedList.printList();
    }


}
