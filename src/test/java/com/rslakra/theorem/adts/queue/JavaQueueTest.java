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

import com.rslakra.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Rohtash Lakra
 * @created 01/03/2018 06:15:55 PM
 */
public class JavaQueueTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(JavaQueueTest.class);

    /**
     * @param queue
     */
    public static void fillRandomQueue(java.util.Queue<Integer> queue) {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            queue.add(random.nextInt(i));
        }
    }

    /**
     * @param queue
     * @param size
     */
    public static void fillIntQueue(java.util.Queue<Integer> queue, int size) {
        AlgoUtils.positiveIntListGenerator(size).forEach(element -> queue.add(element));
    }

    /**
     * @param queue
     */
    public static void printQueue(java.util.Queue<Integer> queue) {
        StringBuilder sBuilder = new StringBuilder("[");
        while (!queue.isEmpty()) {
            sBuilder.append(queue.remove());
            if (!queue.isEmpty()) {
                sBuilder.append(", ");
            }
        }
        sBuilder.append("]");
        System.out.println(sBuilder.toString());
    }

    @Test
    public void testLinkedList() {
        java.util.Queue<Integer> queue = new LinkedList<>();
        JavaQueueTest.fillRandomQueue(queue);
        LOGGER.debug(queue.toString());
        printQueue(queue);
    }

    @Test
    public void testArrayDeque() {
        java.util.Queue<Integer> queue = new ArrayDeque<>();
        JavaQueueTest.fillRandomQueue(queue);
        LOGGER.debug(queue.toString());
        printQueue(queue);
    }

    @Test
    public void testLinkedBlockingQueue() {
        java.util.Queue<Integer> queue = new LinkedBlockingQueue<>();
        JavaQueueTest.fillRandomQueue(queue);
        LOGGER.debug(queue.toString());
        printQueue(queue);
    }

    @Test
    public void testPriorityQueue() {
        java.util.Queue<Integer> queue = new PriorityQueue<>();
        JavaQueueTest.fillRandomQueue(queue);
        LOGGER.debug(queue.toString());
        printQueue(queue);
    }

    @Test
    public void testPriorityBlockingQueue() {
        java.util.Queue<Integer> queue = new PriorityBlockingQueue<>();
        JavaQueueTest.fillRandomQueue(queue);
        LOGGER.debug(queue.toString());
        printQueue(queue);
    }

    @Test
    public void testConcurrentLinkedQueue() {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        JavaQueueTest.fillRandomQueue(queue);
        LOGGER.debug(queue.toString());
        printQueue(queue);
    }

}
