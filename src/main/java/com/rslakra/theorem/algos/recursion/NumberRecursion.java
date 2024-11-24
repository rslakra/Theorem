package com.rslakra.theorem.algos.recursion;

import com.rslakra.theorem.adts.lang.Maths;

/**
 * @author Rohtash Lakra
 * @created 1/11/24 10:37 AM
 */
public class NumberRecursion {

    /**
     * Reverse the number.
     *
     * @param num
     * @param digits
     * @return
     */
    private int reverseRecursively(int num, int digits) {
        // any remainder when divide by 10 should be equal to the number
        if (num % 10 == num) {
            return num;
        }

        return (num % 10) * (int) Math.pow(10, digits - 1) + reverseRecursively(num / 10, digits - 1);
    }

    /**
     * @param num
     * @return
     */
    public int reverseRecursively(int num) {
        return reverseRecursively(num, Maths.countDigits(num));
    }

    /**
     * @param num
     * @return
     */
    private int countZeroRecursively(int num, int count) {
        if (num == 0) {
            return count;
        }

        if (num % 10 == 0) {
            return countZeroRecursively(num / 10, count + 1);
        }

        return countZeroRecursively(num / 10, count);
    }

    /**
     * @param num
     * @return
     */
    public int countZeroRecursively(int num) {
        return (num == 0 ? 1 : countZeroRecursively(num, 0));
    }

}
