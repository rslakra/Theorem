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

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 08:54:06 AM
 * @since 1.0.0
 */
public class QueueDemo {

    /**
     * @author Rohtash Lakra
     * @version 1.0.0
     * @created 2018-01-06 03:32:51 PM
     * @since 1.0.0
     */
    static class TrainCoach implements Comparable<TrainCoach> {

        int id;
        String coachType;

        public TrainCoach(int id, String coachType) {
            this.id = id;
            this.coachType = coachType;
        }

        /**
         * @param o
         * @return
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(TrainCoach trainCoach) {
            if (trainCoach != null) {
                int result = id - trainCoach.id;
                if (result == 0) {
                    return coachType.compareTo(trainCoach.coachType);
                } else {
                    return result;
                }
            }

            return -1;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Queue<Integer> queue = null;
        queue = QueueFactory.getQueueFor(QueueType.ARRAY_QUEUE);
        // queue = QueueFactory.getQueueFor(QueueType.LIST_QUEUE);
        // queue = QueueFactory.getQueueFor(QueueType.LINKED_LIST_QUEUE);
        System.out.println(queue);

        for (int i = 0; i < 16; i++) {
            queue.add((i + 1));
        }

        System.out.println(queue);
        System.out.println("size:" + queue.size());

        queue.offer(10);
        System.out.println(queue);
        System.out.println("size:" + queue.size());

        queue.remove();
        System.out.println(queue);
        System.out.println("size:" + queue.size());

        queue.poll();
        System.out.println(queue);
        System.out.println("size:" + queue.size());

        System.out.println(queue.element());
        System.out.println(queue);
        System.out.println("size:" + queue.size());

        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println("size:" + queue.size());

        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        queue.poll();
        System.out.println(queue);
        System.out.println("size:" + queue.size());

        queue.remove();
        System.out.println(queue);
        System.out.println("size:" + queue.size());

    }

}
