/**
 *
 */
package com.devamatre.theorem.leetcode.palindrome;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 9, 2019 5:27:40 PM
 */
public class LC9PalindromeNumber {

    /**
     * https://leetcode.com/problems/palindrome-number
     *
     * @param x
     * @return
     */
    public boolean palindromeNumber(int x) {
        // all negative numbers will not be palindrome.
        if (x < 0) {
            return false;
        }

        // if last digit is zero, then it's not a palindrom
        if (x % 10 == 0 && x != 0) {
            return false;
        }

        int num = 0;
        while (x > num) {
            num = num * 10 + (x % 10);
            x /= 10;
        }

        return (num == x || x == num / 10);
    }

}
