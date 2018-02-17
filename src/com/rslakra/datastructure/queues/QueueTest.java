package com.rslakra.datastructure.queues;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * 
 *
 * @author Rohtash Singh Lakra (Rohtash.Lakra@nasdaq.com)
 * @date 01/03/2018 06:15:55 PM
 *
 */
public class QueueTest {
	
	private static void fillQueue(Queue<Integer> queue) {
		Random random = new Random();
		for(int i = 1; i <= 10; i++) {
			queue.add(random.nextInt(i));
		}
	}
	
	private static void printQueue(Queue<Integer> queue) {
		StringBuilder sBuilder = new StringBuilder("[");
		while(!queue.isEmpty()) {
			sBuilder.append(queue.remove());
			if(!queue.isEmpty()) {
				sBuilder.append(", ");
			}
		}
		sBuilder.append("]");
		System.out.println(sBuilder.toString());
	}
	
	public static void main(String[] args) {
		Queue<Integer> queue = null;
		queue = new LinkedList<>();
		queue = new ArrayDeque<>();
		queue = new LinkedBlockingQueue<>();
		queue = new PriorityQueue<>();
		queue = new PriorityBlockingQueue<>();
		queue = new ConcurrentLinkedQueue<>();
		fillQueue(queue);
		System.out.println(queue);
		printQueue(queue);
		
	}
	
}
