package com.devamatre.theorem.hackerrank.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 10/03/2017 03:12:11 PM
 */
public class FindMedianWithQueue {

    private Queue<Integer> low = new PriorityQueue<Integer>(Collections.reverseOrder());
    private Queue<Integer> high = new PriorityQueue<Integer>();

    private void arrange() {
        while (!low.isEmpty() && !high.isEmpty() && low.peek() > high.peek()) {
            Integer lowNumber = low.poll();
            Integer highNumber = high.poll();
            low.add(highNumber);
            high.add(lowNumber);
        }
    }

    public void addNumber(int number) {
        Queue<Integer> heap = low.size() == high.size() ? low : high;
        heap.add(number);
        arrange();
    }

    /**
     * @param index
     * @return
     */
    public double maiden() {
        if ((low.size() + high.size()) % 2 == 0) {
            return (low.peek() + high.peek()) / 2.0;
        } else {
            return low.peek();
        }
    }

    /**
     * <pre>
     * 5
     * 10 15 20 17 8
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        FindMedianWithQueue queue = new FindMedianWithQueue();
        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            queue.addNumber(value);
            System.out.printf("%.1f\n", queue.maiden());
        }
        in.close();
    }
}
