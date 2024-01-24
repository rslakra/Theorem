/**
 *
 */
package com.devamatre.theorem.algos.lang;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 */
public class Palindrome {

    /**
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return true;
        }

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * @param str
     * @return
     */
    public static boolean isPalindromeRecursive(String str) {
        if (str == null || str.length() <= 1) {
            return true;
        }

        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(str.substring(1, str.length() - 1));

    }

    /**
     * Time Complexity: O(n ^ 3)
     *
     * @param str
     * @return
     */
    public String longestPalindromeSlow(String str) {
        if (str == null) {
            return str;
        }

        if (str.length() == 1) {
            return str;
        }

        if (str.length() == 2 && str.charAt(0) == str.charAt(1)) {
            return str;
        }

        int maxLength = 1;
        int size = str.length();
        boolean[][] dp = new boolean[size][size];
        String longest = "";
        for (int i = 0; i < size; i++) {
            for (int row = 0; row < size - 1; row++) {
                int column = row + 1;
                if (str.charAt(row) == str.charAt(column) && (column - row <= 2 || dp[row + 1][column - 1])) {
                    System.out.println("row:" + row + ", column:" + column + ", dp:" + Arrays.toString(dp[row]));
                    dp[row][column] = true;
                    if (column - row + 1 > maxLength) {
                        maxLength = column - row + 1;
                        longest = str.substring(row, column + 1);
                    }
                }

            }
        }

        return longest;
    }

    /**
     * @param str
     * @param low
     * @param high
     * @return
     */
    public String longestPalindrome(String str, int low, int high) {
        while (low >= 0 && high < str.length() && str.charAt(low) == str.charAt(high)) {
            low--;
            high++;
        }

        return str.substring(low + 1, high);
    }

    /**
     * Time Complexity: O(n ^ 2)
     *
     * @param str
     * @return
     */
    public String longestPalindrome(String str) {
        if (str == null) {
            return str;
        }

        if (str.length() == 1) {
            return str;
        }

        if (str.length() == 2 && str.charAt(0) == str.charAt(1)) {
            return str;
        }

        String longest = "";
        for (int i = 0; i < str.length(); i++) {
            // find longest for odd length (where center = length / 2 + 1)
            String pStr = longestPalindrome(str, i, i);
            if (longest.length() < pStr.length()) {
                longest = pStr;
            }

            // find longest for even length (where center is length / 2 and center - 1)
            pStr = longestPalindrome(str, i, i + 1);
            if (longest.length() < pStr.length()) {
                longest = pStr;
            }
        }

        return longest;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Palindrome instance = new Palindrome();

        String str = "abba";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindromeRecursive(str));
        System.out.println(instance.longestPalindromeSlow(str));
        System.out.println(instance.longestPalindrome(str));
        System.out.println();

        str = "madam";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindromeRecursive(str));
        System.out.println(instance.longestPalindromeSlow(str));
        System.out.println(instance.longestPalindrome(str));
        System.out.println();

        str = "banana";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindromeRecursive(str));
        System.out.println(instance.longestPalindromeSlow(str));
        System.out.println(instance.longestPalindrome(str));
        System.out.println();

        str = "devamatre";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindromeRecursive(str));
        System.out.println(instance.longestPalindromeSlow(str));
        System.out.println(instance.longestPalindrome(str));
        System.out.println();

    }

}
