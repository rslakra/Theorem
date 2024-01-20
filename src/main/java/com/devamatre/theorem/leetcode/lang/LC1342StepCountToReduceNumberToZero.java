package com.devamatre.theorem.leetcode.lang;

/**
 * @author Rohtash Lakra
 * @created 1/11/24 1:11 PM
 */
public class LC1342StepCountToReduceNumberToZero {

    /**
     * @param num
     * @param steps
     * @return
     */
    public int numberOfSteps(int num, int steps) {
        if (num == 0) {
            return steps;
        }

        if (num % 2 == 0) { // even number
            return numberOfSteps(num / 2, steps + 1);
        }

        return numberOfSteps(num - 1, steps + 1);
    }

    /**
     * <url>https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero</url>
     *
     * @param num
     * @return
     */
    public int numberOfSteps(int num) {
        return (num == 0 ? 0 : numberOfSteps(num, 0));
    }
}
