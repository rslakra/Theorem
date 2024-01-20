package com.devamatre.theorem.leetcode.lang;

/**
 * @author Rohtash Lakra
 * @created 1/11/24 1:56 PM
 */
public class LC2169CountOperationsToObtainZero {

    /**
     * @param num1
     * @param num2
     * @param count
     * @return
     */
    private int countOperations(int num1, int num2, int count) {
        if (num1 == 0 || num2 == 0) {
            return count;
        }

        if (num1 > num2) {
            return countOperations(num1 - num2, num2, count + 1);
        }

        return countOperations(num1, num2 - num1, count + 1);
    }

    /**
     * <url>https://leetcode.com/problems/count-operations-to-obtain-zero</url>
     *
     * @param num1
     * @param num2
     * @return
     */
    public int countOperations(int num1, int num2) {
        return (num1 == 0 || num2 == 0 ? 0 : countOperations(num1, num2, 0));
    }

}
