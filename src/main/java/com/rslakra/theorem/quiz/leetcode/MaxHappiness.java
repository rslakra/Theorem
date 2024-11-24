package com.rslakra.theorem.quiz.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Rohtash Lakra
 * @created 3/9/24 6:28 PM
 */
public class MaxHappiness {

    static class Pair {

        int index;
        int capacity;

        Pair(int index, int capacity) {
            this.index = index;
            this.capacity = capacity;
        }

        public static Pair of(int index, int capacity) {
            return new Pair(index, capacity);
        }
    }

    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int result = o2.capacity - o1.capacity;
                if (result == 0) {
                    result = o1.index - o2.index;
                }

                return result;
            }
        });

        for (int i = 0; i < happiness.length; i++) {
            pq.add(Pair.of(i, happiness[i]));
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            final Pair pair = pq.poll();
            sum += pair.capacity;
            happiness[pair.index] -= pair.capacity;
            for (int j = 0; j < happiness.length; j++) {
                final int index = j;
                if (happiness[j] > 0) {
                    happiness[j] -= 1;
                    pq.removeIf(p -> p.index == index);
                    pq.add(Pair.of(j, happiness[j]));
                }
            }
        }

        return sum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MaxHappiness instance = new MaxHappiness();
        long result = instance.maximumHappinessSum(new int[]{1, 2, 3}, 2);
        System.out.println("result:" + result);
        long result1 = instance.maximumHappinessSum(new int[]{2, 3, 4, 5}, 1);
        System.out.println("result1:" + result1);
    }

}
