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
        Node<Integer> second = new Node<Integer>(2);
        linkedList.push(new Node<Integer>(1));
        linkedList.append(second);
        linkedList.push(new Node<Integer>(0));
        linkedList.append(new Node<Integer>(3));
        linkedList.insertAfter(second, new Node<Integer>(4));
        linkedList.removeAt(2);
        LOGGER.debug("createIntegerLinkedList(), linkedList: {}", linkedList);
        return linkedList;
    }

    /**
     * @return
     */
    private final static LinkedList<String> createStringLinkedList() {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.push(new Node<String>("One"));
        Node<String> second = new Node<String>("Two");
        linkedList.append(second);
        linkedList.push(new Node<String>("Zero"));
        linkedList.append(new Node<String>("Three"));
        linkedList.insertAfter(second, new Node<String>("Four"));
        LOGGER.debug("createStringLinkedList(), linkedList: {}", linkedList);
        return linkedList;
    }

    /**
     * Lists the linked list.
     */
    @Test
    public void testPrintLinkedList() {
        LinkedList<Integer> intLinkedList = createIntegerLinkedList();
        LOGGER.debug("intLinkedList: {}", intLinkedList);
        LOGGER.debug("Size: {}", intLinkedList.size());

        LinkedList<String> stringLinkedList = createStringLinkedList();
        LOGGER.debug("stringLinkedList: {}", stringLinkedList);
        LOGGER.debug("Size: {}", stringLinkedList.size());
        LOGGER.debug("Size with recursion: {}", stringLinkedList.size(stringLinkedList.getHead()));
    }

    /**
     * Removes nodes
     */
    @Test
    public void testRemoveNodes() {
        LinkedList<Integer> linkedList = createIntegerLinkedList();
        assertNotNull(linkedList);
        LOGGER.debug("linkedList: {}", linkedList);
        LOGGER.debug("Size: {}", linkedList.size());
        assertEquals(4, linkedList.size());

        // remove
        linkedList.removeFirst();
        linkedList.removeFirst();
        LOGGER.debug("linkedList: {}", linkedList);
        LOGGER.debug("Size: {}", linkedList.size());
        assertEquals(2, linkedList.size());

        // remove
        linkedList.remove(1);
        LOGGER.debug("linkedList: {}", linkedList);
        LOGGER.debug("Size: {}", linkedList.size());
        assertEquals(2, linkedList.size());
    }

    /**
     *
     */
    @Test
    public void testFindNodes() {
        LinkedList<Integer> linkedList = createIntegerLinkedList();
        assertNotNull(linkedList);
        assertEquals(4, linkedList.size());
        LOGGER.debug("linkedList: {}", linkedList);
        LOGGER.debug("contain 3: {}", linkedList.contain(3));
        LOGGER.debug("contain 16: {}", linkedList.contain(16));
        LOGGER.debug("contain 2:{}", linkedList.contain(2));

        // contain
        System.out.println("contain using recursion 2:" + linkedList.contain(linkedList.getHead(), 2));
        System.out.println("contain using recursion 10:" + linkedList.contain(linkedList.getHead(), 10));
        System.out.println("contain using recursion 4:" + linkedList.contain(linkedList.getHead(), 4));

        // contain
        LinkedList<String> stringLinkedList = createStringLinkedList();
        assertNotNull(stringLinkedList);
        assertEquals(5, stringLinkedList.size());
        System.out.println(stringLinkedList);
        System.out.println("contain \"Four\":" + stringLinkedList.contain("Four"));
        System.out.println("contain \"Zero\":" + stringLinkedList.contain("ZERO"));
        System.out.println("contain \"Ten\":" + stringLinkedList.contain("Ten"));
    }

    /**
     *
     */
    @Test
    public void testSwapNodes() {
        LinkedList<Integer> linkedList = createIntegerLinkedList();
        assertNotNull(linkedList);
        assertEquals(4, linkedList.size());
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
        assertEquals(4, linkedList.size());
        System.out.println(linkedList);
        System.out.println(linkedList.getValue(0));
    }

    /**
     *
     */
    @Test
    public void testInsertAt() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.append(new Node<Integer>(1));
        linkedList.append(new Node<Integer>(2));
        linkedList.append(new Node<Integer>(3));
        linkedList.append(new Node<Integer>(4));
        linkedList.append(new Node<Integer>(5));
        assertNotNull(linkedList);
        assertEquals(5, linkedList.size());
        System.out.println(linkedList);

        linkedList.insertAt(3, new Node<Integer>(20));
        assertEquals(6, linkedList.size());
        System.out.println(linkedList);
    }

}
