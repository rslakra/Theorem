/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code, in source 
 * and binary forms, with or without modification, are permitted provided 
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 * 	  notice, this list of conditions and the following disclaimer.
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

import com.devamatre.theorem.adts.list.ListTest;
import com.devamatre.theorem.adts.list.Node;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Singh Lakra
 * @date 01/31/2017 03:49:55 PM
 */
public class DoublyLinkedListTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListTest.class);

    @Test
    public void testDoublyLinkedList() {
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.size(), linkedList);
        assertNotNull(linkedList);
        assertEquals(0, linkedList.size());
        assertEquals(0, linkedList.getSize());

        // add at head
        linkedList.addHead(1);
        linkedList.addHead(2);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.size(), linkedList);
        assertNotNull(linkedList);
        assertEquals(2, linkedList.size());
        assertEquals(2, linkedList.getSize());

        // add at tail
        linkedList.addTail(3);
        linkedList.addTail(4);
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.size(), linkedList);
        assertNotNull(linkedList);
        assertEquals(4, linkedList.size());
        assertEquals(4, linkedList.getSize());

        LOGGER.debug("Reversed linkedList:{}", linkedList.toStringReverse());

        linkedList.insertAt(2, new Node<>(100));
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.size(), linkedList);
        assertNotNull(linkedList);
        assertEquals(5, linkedList.size());
        assertEquals(5, linkedList.getSize());

        linkedList.insertAt(linkedList.getSize(), new Node<>(200));
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.size(), linkedList);
        assertNotNull(linkedList);
        assertEquals(6, linkedList.size());
        assertEquals(6, linkedList.getSize());

        linkedList.insertAt(2, new Node<>(300));
        LOGGER.debug("Size:{}, linkedList:{}", linkedList.size(), linkedList);
        assertNotNull(linkedList);
        assertEquals(7, linkedList.size());
        assertEquals(7, linkedList.getSize());
    }

}
