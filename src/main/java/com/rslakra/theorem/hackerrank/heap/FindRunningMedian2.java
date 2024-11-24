package com.rslakra.theorem.hackerrank.heap;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 10/03/2017 03:12:11 PM
 */
public class FindRunningMedian2 {

    static class IntMaiden {

        private int capacity = 5;
        transient int[] items;
        private int size = 0;

        public IntMaiden(int initialCapacity) {
            this.capacity = initialCapacity;
            this.items = new int[initialCapacity];
        }

        public IntMaiden() {
            this(5);
        }

        private void ensureCapacity() {
            if (size == capacity) {
                capacity *= 2;
                this.items = Arrays.copyOf(items, capacity);
            }
        }

        private void arrange() {
            if (size > 1) {
                int index = size - 1;
                while (index > 0 && items[index - 1] > items[index]) {
                    int temp = items[index];
                    items[index] = items[index - 1];
                    items[index - 1] = temp;
                    index--;
                }
            }
        }

        public boolean add(int number) {
            ensureCapacity();
            items[size] = number;
            size++;
            arrange();
            return true;
        }

        /**
         * @return
         */
        public double maiden() {
            if (size % 2 == 0) {
                int index = size / 2;
                return (items[index - 1] + items[index]) / 2.0;
            } else {
                return items[size / 2];
            }
        }

        public String toString() {
            return Arrays.toString(items);
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
        IntMaiden queue = new IntMaiden();
        for (int i = 0; i < n; i++) {
            int value = in.nextInt();
            queue.add(value);
            System.out.printf("%.1f\n", queue.maiden());
        }
        in.close();
    }
}
