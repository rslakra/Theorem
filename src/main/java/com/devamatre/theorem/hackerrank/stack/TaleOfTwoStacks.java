package com.devamatre.theorem.hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rohtash Singh Lakra
 * @created 10/03/2017 02:31:05 PM
 */
public class TaleOfTwoStacks {

    public static class MyQueue<T> {

        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        private void mergeStacks() {
            if (stackOldestOnTop.isEmpty()) {
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
            }
        }

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            mergeStacks();
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            mergeStacks();
            return stackOldestOnTop.pop();
        }
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
