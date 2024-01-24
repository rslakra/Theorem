package com.devamatre.theorem.hackerrank.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class MyPriorityQueue {

    public static void main(String[] args) {
        // final Queue<Integer> queue = new
        // PriorityQueue<Integer>(Collections.reverseOrder());
        final Queue<Integer> queue = new PriorityQueue<Integer>();
        // for(int i = 1; i <= 10; i++) {
        // for(int i = 10; i > 0; i--) {
        // queue.add(i);
        // System.out.println(i + " - " + queue);
        // }

        queue.add(4);
        queue.add(10);
        queue.add(5);
        queue.add(9);
        queue.add(1);
        System.out.println(queue);
        System.out.println(queue.size() / 2);
        System.out.println(queue.peek());

    }

}
