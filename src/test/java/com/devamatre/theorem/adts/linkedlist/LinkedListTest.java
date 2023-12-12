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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devamatre.theorem.adts.list.Node;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @date 11/03/2016 04:45:23 PM
 */
public class LinkedListTest extends AbstractLinkedListTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinkedListTest.class);

    /**
     * Tests <code>new LinkedList()</code> method.
     *
     * @return
     */
    @Override
    public void testBuildLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertEquals(0, linkedList.getSize());
        assertEquals(null, linkedList.head);
    }

    /**
     * Tests <code>getSize()</code> method.
     *
     * <pre>
     *  Time Complexity: O(1)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @return
     */
    @Override
    public void testGetSize() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertEquals(0, linkedList.getSize());
    }

    /**
     * Tests <code>isEmpty()</code> method.
     *
     * <pre>
     *  Time Complexity: O(1)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @return
     */
    @Override
    public void testIsEmpty() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertTrue(linkedList.isEmpty());

        buildIntRandomLinkedList(SIZE, UPPER_BOUND, linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertFalse(linkedList.isEmpty());
        assertEquals(SIZE, linkedList.getSize());
    }

    /**
     * Tests <code>toString()</code> method.
     *
     * @return
     */
    @Test
    @Override
    public void testToString() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertEquals(5, linkedList.getSize());
        assertEquals("[1, 0, 2, 4, 3]", linkedList.toString());
    }

    /**
     * Tests <code>addHead()</code> method.
     *
     * @return
     */
    @Override
    public void testAddHead() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        boolean result = linkedList.addHead(6);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertEquals(true, result);
        assertEquals(6, linkedList.getSize());
        assertEquals(6, linkedList.head);
        assertEquals("[6, 1, 0, 2, 4, 3]", linkedList.toString());
    }

    /**
     * Tests <code>addTail()</code> method.
     *
     * @return
     */
    @Override
    public void testAddTail() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        boolean result = linkedList.addTail(6);
        assertEquals(true, result);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertEquals(6, linkedList.getSize());
        assertEquals(1, linkedList.head);
        assertEquals("[1, 0, 2, 4, 3, 6]", linkedList.toString());
    }

    /**
     * Tests <code>addNode()</code> method.
     *
     * @return
     */
    @Override
    public void testAddNode() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        boolean result = linkedList.addNode(6);
        assertEquals(true, result);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertEquals(6, linkedList.getSize());
        assertEquals(1, linkedList.head);
        assertEquals("[1, 0, 2, 4, 3, 6]", linkedList.toString());
    }

    /**
     * Tests <code>findNode()</code> method.
     *
     * @return
     */
    @Override
    public void testFindNode() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        // empty list
        Integer result = linkedList.findNode(16);
        LOGGER.debug("result:{}", result);
        assertNull(result);

        // list has only 1 item.
        linkedList.addNode(16);
        result = linkedList.findNode(16);
        LOGGER.debug("result:{}", result);
        assertNull(result);

        linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);

        // find 6 (not exists)
        result = linkedList.findNode(6);
        LOGGER.debug("result:{}", result);
        assertNull(result);

        // find 2 (exists)
        result = linkedList.findNode(2);
        LOGGER.debug("result:{}", result);
        assertEquals(2, result);
    }

    /**
     * Tests <code>removeHead()</code> method.
     *
     * @return
     */
    @Override
    public void testRemoveHead() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);

        // find head (list is not empty)
        boolean result = linkedList.removeHead();
        LOGGER.debug("result:{}", result);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertTrue(result);
        assertEquals(4, linkedList.getSize());
        assertEquals(0, linkedList.head);
        assertEquals("[0, 2, 4, 3]", linkedList.toString());

        // find head (list is empty)
        linkedList = new LinkedList<>();
        result = linkedList.removeHead();
        LOGGER.debug("result:{}", result);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertFalse(result);
        assertEquals(0, linkedList.getSize());
        assertNull(linkedList.head);
        assertEquals("[]", linkedList.toString());
    }

    /**
     * Tests <code>removeTail()</code> method.
     *
     * @return
     */
    @Override
    public void testRemoveTail() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);

        // remove tail (list is not empty)
        boolean result = linkedList.removeTail();
        LOGGER.debug("result:{}", result);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertTrue(result);
        assertEquals(4, linkedList.getSize());
        assertEquals(0, linkedList.head);
        assertEquals("[1, 0, 2, 4]", linkedList.toString());

        // remove tail (list is empty)
        linkedList = new LinkedList<>();
        result = linkedList.removeTail();
        LOGGER.debug("result:{}", result);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertFalse(result);
        assertEquals(0, linkedList.getSize());
        assertNull(linkedList.head);
        assertEquals("[]", linkedList.toString());
    }

    /**
     * Tests <code>removeNode()</code> method.
     *
     * @return
     */
    @Override
    public void testRemoveNode() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);

        // remove node (list is not empty and exists)
        boolean result = linkedList.removeNode(2);
        LOGGER.debug("result:{}", result);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertTrue(result);
        assertEquals(4, linkedList.getSize());
        assertEquals(0, linkedList.head);
        assertEquals("[1, 0, 4, 3]", linkedList.toString());

        // remove node (either list is not empty, but not exists
        result = linkedList.removeNode(6);
        LOGGER.debug("result:{}", result);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertFalse(result);
        assertEquals(4, linkedList.getSize());
        assertEquals(0, linkedList.head);
        assertEquals("[1, 0, 4, 3]", linkedList.toString());

        // remove node (either list is empty, but not exists
        linkedList = new LinkedList<>();
        result = linkedList.removeNode(2);
        LOGGER.debug("result:{}", result);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertFalse(result);
        assertEquals(0, linkedList.getSize());
        assertNull(linkedList.head);
        assertEquals("[]", linkedList.toString());
    }

    /**
     * Lists the linked list.
     */
    @Test
    public void testPrintLinkedList() {
        LinkedList<Integer> intLinkedList = new LinkedList<>();
        buildIntRandomLinkedList(intLinkedList);
        LOGGER.debug("Size:{}, linkedList:{}", intLinkedList.getSize(), intLinkedList);

        LinkedList<String> stringLinkedList = new LinkedList<>();
        buildStringLinkedList(stringLinkedList);
        LOGGER.debug("Size:{}, linkedList:{}", stringLinkedList.getSize(), stringLinkedList);
    }

    /**
     * Tests the <code>reversedToString</code> method.
     */
    @Test
    public void testNewReversedLinkedList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("linkedList: {}", linkedList);
        assertEquals(5, linkedList.getSize());
        LinkedList<Integer> reversed = linkedList.newReversedLinkedList();
        LOGGER.debug("Reversed linkedList: {}", reversed);
        assertEquals("[3, 4, 2, 0, 1]", reversed.toString());
    }

    /**
     * Tests the <code>reversedRecursively()</code> method.
     */
    @Test
    public void testReversedRecursively() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);

        // reverse the linkedList
        linkedList.head = linkedList.reversedRecursively(linkedList.head);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertNotNull(linkedList);
        assertEquals(5, linkedList.getSize());
        assertEquals(3, linkedList.head.getData());
    }

    /**
     * Lists the linked list.
     */
    @Test
    public void testReversed() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);

        // reverse the linkedList
        linkedList.reversed();
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertNotNull(linkedList);
        assertEquals(5, linkedList.getSize());
        assertEquals(3, linkedList.head.getData());
    }

    /**
     * Removes nodes
     */
    @Test
    public void testRemoveNodes() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);

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
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);

        assertTrue(linkedList.contains(3));
        assertFalse(linkedList.contains(16));
        assertTrue(linkedList.contains(2));

        // contain
        LinkedList<String> stringLinkedList = new LinkedList<>();
        buildStringLinkedList(stringLinkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
        assertNotNull(stringLinkedList);
        assertEquals(5, stringLinkedList.getSize());
        assertEquals("[One, Zero, Two, Four, Three]", stringLinkedList.toString());

        assertTrue(stringLinkedList.contains("Four"));
        assertFalse(stringLinkedList.contains("Ten"));
        assertFalse(stringLinkedList.contains("ZERO"));
        assertTrue(stringLinkedList.contains("Zero"));
    }

    /**
     *
     */
    @Test
    public void testSwapNodes() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);

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
        LinkedList<Integer> linkedList = new LinkedList<>();
        buildIntRandomLinkedList(linkedList);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.getSize(), linkedList);
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

    /**
     *
     */
    @Test
    public void testAllOperations() {
        /* Start with the empty list */
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addHead(1);
        linkedList.addHead(2);
        linkedList.addHead(3);
        linkedList.addHead(4);
        linkedList.addHead(5);
        linkedList.addHead(6);
        LOGGER.debug("linkedList:{}", linkedList);

        linkedList.removeHead();
        linkedList.removeFirst();
        LOGGER.debug("linkedList:{}", linkedList);
        LOGGER.debug("Nodes Count:{}", linkedList.getCount());

        linkedList.swapNodes(1, 5);
        linkedList.reversed();
        linkedList.reversedRecursively();
        LOGGER.debug("linkedList:{}", linkedList);

        LinkedList linkList1 = new LinkedList();
        linkList1.addTail(10);
        linkList1.addTail(22);
        linkList1.addTail(30);
        linkList1.addTail(43);
        linkList1.addTail(50);
        linkList1.addTail(64);
        LOGGER.debug("linkList1:{}", linkList1);

        LinkedList linkList2 = new LinkedList();
        linkList2.addNode(11);
        linkList2.addNode(20);
        linkList2.addNode(33);
        linkList2.addNode(34);
        linkList2.addNode(55);
        linkList2.addNode(60);
        LOGGER.debug("linkList2:{}", linkList2);

        LinkedList mergedLinkedList = LinkedList.mergeSortedLists(linkList1, linkList2);
        LOGGER.debug("mergedLinkedList:{}", mergedLinkedList);
    }


}
