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
package com.rslakra.theorem.adts.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.rslakra.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 08:54:06 AM
 * @since 1.0.0
 */
public class QueueTest extends AbstractQueueTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueTest.class);

    /**
     * Tests the <code>Queue</code>
     */
    @Test
    @Override
    public void buildQueue() {
        Queue<Integer> queue = new ArrayQueue<>();
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(0, queue.getSize());
    }

    /**
     * Tests the <code>getSize()</code>
     */
    @Test
    @Override
    public void testGetSize() {
        Queue<Integer> queue = new ArrayQueue<>();
        int size = 5;
        fillIntQueue(queue, size);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(size, queue.getSize());
    }

    /**
     * Tests the <code>isEmpty()</code>
     */
    @Test
    @Override
    public void testIsEmpty() {
        Queue<Integer> queue = new ArrayQueue<>();
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertTrue(queue.isEmpty());
    }

    /**
     * Tests the <code>add</code>
     *
     * @return
     */
    @Test
    @Override
    public void testAdd() {
        Queue<Integer> queue = new ArrayQueue<>();
        int size = 5;
        fillIntQueue(queue, size);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(size, queue.getSize());
    }

    /**
     * Tests the <code>offer(element)</code>
     */
    @Test
    @Override
    public void testOffer() {
        Queue<Integer> queue = new ArrayQueue<>();
        int size = 5;
        AlgoUtils.positiveIntListGenerator(size).forEach(element -> queue.offer(element));
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(size, queue.getSize());
    }

    /**
     * Tests the <code>remove()</code>
     */
    @Test
    @Override
    public void testRemove() {
        Queue<Integer> queue = new ArrayQueue<>();
        int size = 5;
        fillIntQueue(queue, size);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(size, queue.getSize());

        // offer
        Integer result = queue.remove();
        LOGGER.debug("result:{}, queue:{}", result, queue);
        assertEquals(0, result);
        assertEquals(size - 1, queue.getSize());
    }

    /**
     * Tests the <code>poll()</code>
     */
    @Test
    @Override
    public void testPoll() {
        Queue<Integer> queue = new ArrayQueue<>();
        int size = 5;
        fillIntQueue(queue, size);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(size, queue.getSize());

        // offer
        Integer result = queue.poll();
        LOGGER.debug("result:{}", result);
        assertEquals(0, result);
        assertEquals(size - 1, queue.getSize());
    }

    /**
     * Tests the <code>element()</code>
     */
    @Test
    @Override
    public void testElement() {
        Queue<Integer> queue = new ArrayQueue<>();
        int size = 5;
        fillIntQueue(queue, size);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(size, queue.getSize());

        // offer
        Integer result = queue.element();
        LOGGER.debug("result:{}", result);
        assertEquals(0, result);
        assertEquals(size, queue.getSize());
    }

    /**
     * Tests the <code>peek()</code>
     */
    @Test
    @Override
    public void testPeek() {
        Queue<Integer> queue = new ArrayQueue<>();
        int size = 5;
        fillIntQueue(queue, size);
        LOGGER.debug("queue:{}", queue);
        assertNotNull(queue);
        assertEquals(size, queue.getSize());

        // offer
        Integer result = queue.peek();
        LOGGER.debug("result:{}", result);
        assertEquals(0, result);
        assertEquals(size, queue.getSize());
    }

    /**
     * Tests the <code>Queue</code> object.
     */
    @Test
    public void testQueue() {
        int size = Queue.DEFAULT_SIZE;
        Queue<Integer> queue = QueueFactory.getQueueFor(QueueType.ARRAY_QUEUE);
        LOGGER.debug("size:{}, queue:{}", queue.getSize(), queue);
        assertNotNull(queue);
        assertEquals(0, queue.getSize());
        assertTrue(queue.isEmpty());

        // fill queue with elements
        fillIntQueue(queue, size);
        LOGGER.debug("size:{}, queue:{}", queue.getSize(), queue);
        assertNotNull(queue);
        assertEquals(size, queue.getSize());
        assertFalse(queue.isEmpty());

        try {
            // offer an element of the queue
            LOGGER.debug("offer:{}", queue.offer(10));
        } catch (IllegalStateException ex) {
            assertEquals("Overflow!", ex.getMessage());
        }
        assertEquals(size, queue.getSize());

        // peek an element of the queue
        LOGGER.debug("peek:{}", queue.peek());
        LOGGER.debug("after peeking an element, queue:{}", queue);
        assertEquals(size, queue.getSize());

        // remove an element of the queue
        assertEquals(0, queue.remove());
        LOGGER.debug("after removing an element, queue:{}", queue);
        assertEquals(15, queue.getSize());

        // poll an element of the queue
        assertEquals(1, queue.poll());
        LOGGER.debug("after poll an element, queue:{}", queue);
        assertEquals(14, queue.getSize());

        LOGGER.debug("call an element() on the queue");
        assertEquals(2, queue.element());
        LOGGER.debug("after element() call, queue:{}", queue);
        assertEquals(14, queue.getSize());

        int pollSize = 5;
        LOGGER.debug("poll {} items", pollSize);
        for (int i = 0; i < pollSize; i++) {
            LOGGER.debug("poll:{}, queue:{}", queue.poll(), queue);
        }
        assertEquals(9, queue.getSize());

        LOGGER.debug("remove");
        assertEquals(7, queue.remove());
        LOGGER.debug("queue:{}", queue);
        assertEquals(8, queue.getSize());
        LOGGER.debug("queue:{}", queue);
    }

    @Test
    public void buildCircularQueue() {
//        Queue<Integer> queue = QueueFactory.getQueueFor(QueueType.CIRCULAR_QUEUE);
//        assertNotNull(queue);
//        assertEquals(0, queue.getSize());
//
//        fillIntQueue(queue, 5);
//        LOGGER.debug("size:{}, queue:{}", queue.getSize(), queue);
//        assertNotNull(queue);
//        assertEquals(0, queue.getSize());
    }

}
