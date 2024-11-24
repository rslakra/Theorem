package com.rslakra.theorem.quiz.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Rohtash Lakra
 * @created 3/9/24 6:28 PM
 */
public class WeeklyContest388 {

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

    public int minimumBoxes(int[] apple, int[] capacity) {
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

        for (int i = 0; i < capacity.length; i++) {
            pq.add(Pair.of(i, capacity[i]));
        }

        int sum = 0;
        for (int i = 0; i < apple.length; i++) {
            sum += apple[i];
        }

        int remaining = 0;
        for (int i = 0; i < apple.length; i++) {
            while (remaining < apple[i]) {
                remaining += pq.poll().capacity;
            }

            if (remaining > 0 && remaining >= apple[i]) {
                remaining -= apple[i];
            }
        }

        return capacity.length - pq.size();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        WeeklyContest388 instance = new WeeklyContest388();
        int result = instance.minimumBoxes(new int[]{1, 3, 2}, new int[]{4, 3, 1, 5, 2});
        System.out.println("result:" + result);
        int result1 = instance.minimumBoxes(new int[]{5, 5, 5}, new int[]{2, 4, 2, 7});
        System.out.println("result1:" + result1);
    }

}
