package com.devamatre.theorem.leetcode.lang;

import java.util.Random;

/**
 * @author Rohtash Lakra
 * @created 1/31/24 3:28 PM
 */
public class LC470ImplementRand10UsingRand7 {

    private static final Random RANDOM = new Random();

    private int rand7() {
        return RANDOM.nextInt(7);
    }


    /**
     * <url>https://leetcode.com/problems/implement-rand10-using-rand7</url>
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @return
     */
    public int rand10_1() {
        while (true) {
            int row = (rand7() - 1) * 7;
            int col = rand7();
            if ((row + col) <= 40) {
                return ((row + col - 1) % 10 + 1);
            }
        }
    }

    /**
     * <url>https://leetcode.com/problems/implement-rand10-using-rand7</url>
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @return
     */
    public int rand10_2() {
        int row = (rand7() - 1) * 7;
        int col = rand7();
        return ((row + col) > 40 ? rand10_2() : ((row + col - 1) % 10 + 1));
    }
}
