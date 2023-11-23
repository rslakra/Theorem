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
package com.devamatre.theorem.adts.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.devamatre.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 08:54:06 AM
 * @since 1.0.0
 */
public class QueueDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(QueueDemo.class);

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @created 2018-01-06 03:32:51 PM
     * @since 1.0.0
     */
    static class TrainCoach implements Comparable<TrainCoach> {

        private int id;
        private String coachType;

        public TrainCoach(int id, String coachType) {
            this.id = id;
            this.coachType = coachType;
        }

        public int getId() {
            return id;
        }

        public String getCoachType() {
            return coachType;
        }

        /**
         * @param trainCoach
         * @return
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(TrainCoach trainCoach) {
            int result = -1;
            if (trainCoach != null) {
                result = getId() - trainCoach.getId();
                if (result == 0) {
                    return getCoachType().compareTo(trainCoach.getCoachType());
                }
            }

            return result;
        }
    }

    /**
     * @param queue
     * @param size
     */
    public static void fillIntQueue(Queue<Integer> queue, int size) {
        AlgoUtils.positiveIntListGenerator(size).forEach(element -> queue.add(element));
    }

    @Test
    public void testQueue() {
        Queue<Integer> queue = QueueFactory.getQueueFor(QueueType.ARRAY_QUEUE);
        // queue = QueueFactory.getQueueFor(QueueType.LIST_QUEUE);
        // queue = QueueFactory.getQueueFor(QueueType.LINKED_LIST_QUEUE);
        fillIntQueue(queue, 16);
        assertNotNull(queue);
        LOGGER.debug(queue.toString());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(16, queue.getSize());
        assertEquals(false, queue.isEmpty());

        LOGGER.debug("offer");
        try {
            queue.offer(10);
        } catch (IllegalStateException ex) {
            assertEquals("Overflow!", ex.getMessage());
        }
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(16, queue.getSize());

        LOGGER.debug("remove");
        assertEquals(0, queue.remove());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(15, queue.getSize());

        LOGGER.debug("poll");
        assertEquals(1, queue.poll());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(14, queue.getSize());

        LOGGER.debug("element");
        assertEquals(2, queue.element());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(14, queue.getSize());

        LOGGER.debug("peek");
        assertEquals(2, queue.peek());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(14, queue.getSize());

        LOGGER.debug("poll");
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(9, queue.getSize());

        LOGGER.debug("remove");
        assertEquals(7, queue.remove());
        LOGGER.debug("size:{}", queue.getSize());
        assertEquals(8, queue.getSize());
    }

}
