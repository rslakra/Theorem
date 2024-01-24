/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.hackerrank.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-10-02 05:53:35 PM
 * @since 1.0.0
 */
public class FindRunningMedian {

    private Queue<Integer> low = new PriorityQueue<>(Comparator.reverseOrder());
    private Queue<Integer> high = new PriorityQueue<>();

    private void balance() {
        while (!low.isEmpty() && !high.isEmpty() && low.peek() > high.peek()) {
            Integer lowHead = low.poll();
            Integer highHead = high.poll();
            low.add(highHead);
            high.add(lowHead);
        }
    }

    public double median() {
        if (low.isEmpty() && high.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        } else {
            return low.size() == high.size() ? (low.peek() + high.peek()) / 2.0 : low.peek();
        }
    }

    public void add(int number) {
        Queue<Integer> target = low.size() <= high.size() ? low : high;
        target.add(number);
        balance();
    }

    public void findRunningMedian(final int number) {
        List<Integer> data = new ArrayList<Integer>();
        int position = Collections.binarySearch(data, number);
        if (position < 0) {
            position = Math.abs(position) - 1;
        }
        data.add(number);

        if (data.size() % 2 == 0) {
            int index = data.size() / 2;
            int result = data.get(index - 1) + data.get(index);
            System.out.printf("%.1f", Double.valueOf(result / 2.0f));
        } else {
            System.out.printf("%.1f", Double.valueOf(data.get(data.size() / 2)));
        }
        System.out.println();
    }

    public void printQueues() {
        System.out.println(low);
        System.out.println(high);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        FindRunningMedian findMedian = new FindRunningMedian();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            findMedian.add(number);
            System.out.printf("%.1f", findMedian.median());
        }
        findMedian.printQueues();
        in.close();
    }

}
