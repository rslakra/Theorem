package com.devamatre.theorem.leetcode;

import com.devamatre.theorem.adts.Pair;

import java.util.PriorityQueue;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Jan 09, 2021 09:37:20
 */
public class LC1705MaximumNumberOfEatenApples {

    /**
     * @param apples
     * @param days
     * @return
     */
    public int eatenApples(int[] apples, int[] days) {
        int maxApples = 0;
        PriorityQueue<Pair<Integer, Integer>> pairs = new PriorityQueue<>(Pair.KEY_COMPARATOR);
        for (int i = 0; i < days.length; i++) {
            pairs.add(Pair.of(days[i], apples[i]));
        }

        while (!pairs.isEmpty()) {
            Pair pair = pairs.poll();
            System.out.println(pair);

            //eat apple
            Integer day = (Integer) pair.getKey();
            Integer apple = (Integer) pair.getValue();
            Pair eatApple = Pair.of(day - 1, apple - 1);
            maxApples++;
            if (day > 0 && apple > 0) {
                pairs.add(eatApple);
            }
        }

        return maxApples;
    }


    public static void main(String[] args) {
        LC1705MaximumNumberOfEatenApples maxApples = new LC1705MaximumNumberOfEatenApples();
        int[] apple = {1, 2, 3, 5, 2};
        int[] days = {3, 2, 1, 4, 2};

        System.out.println(maxApples.eatenApples(apple, days));

    }
}
