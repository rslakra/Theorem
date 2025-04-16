/**
 *
 */
package com.rslakra.theorem.algos.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rohtash Lakra
 */
public class Palindrome {

    private static Logger LOGGER = LoggerFactory.getLogger(Palindrome.class);

    /**
     * @param str
     * @return
     */
    public static boolean areEquals(String str, int start, int end) {
        return (str != null && start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end));
    }

    /**
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return true;
        }

        for (int i = 0, j = str.length() - 1; i < j; i++, j--) {
            if (!areEquals(str, i, j)) {
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
                    LOGGER.debug("row={}, column={}, d={}", row, column, Arrays.toString(dp[row]));
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
     * @param start
     * @param end
     * @return
     */
    public String longestPalindrome(String str, int start, int end) {
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            start--;
            end++;
        }

        return str.substring(start + 1, end);
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
     * Returns true if the string is palindrome after removing K characters.
     *
     * @param str
     * @return
     */
    public boolean isPalindromeByRemovingKChars(String str, int K) {
        if (str == null) {
            return true;
        }

        int count = 0;
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                count++;
                if (count <= K) {
                    if (areEquals(str, start + 1, end) || areEquals(str, start, end - 1)) {
                        start++;
                    } else if (areEquals(str, start, end - 1)) {
                        end--;
                    }
                }
                if (count > K) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Palindrome instance = new Palindrome();

        final List<String> list = Arrays.asList("abba", "madam", "banana", "devamatre", "maadam", "maaedam");
        int K = 1;
        list.forEach(str -> {
            LOGGER.debug("isPalindrome({}) = {}", str, isPalindrome(str));
            LOGGER.debug("isPalindromeRecursive({}) = {}", str, isPalindromeRecursive(str));
            LOGGER.debug("longestPalindromeSlow({}) = {}", str, instance.longestPalindromeSlow(str));
            LOGGER.debug("longestPalindrome({}) = {}", str, instance.longestPalindrome(str));
            LOGGER.debug("isPalindromeByRemovingKChars({}, {}) = {}", str, K, instance.isPalindromeByRemovingKChars(str, K));
            System.out.println();
        });
    }

}
