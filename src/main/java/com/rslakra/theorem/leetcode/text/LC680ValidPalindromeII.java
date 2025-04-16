package com.rslakra.theorem.leetcode.text;

/**
 * <url>https://leetcode.com/problems/valid-palindrome-ii/description/</url>
 * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
 *
 * <pre>
 * Example 1:
 *
 * Input: s = "aba"
 * Output: true
 * Example 2:
 *
 * Input: s = "abca"
 * Output: true
 * Explanation: You could delete the character 'c'.
 * Example 3:
 *
 * Input: s = "abc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of lowercase English letters.
 * </pre>
 */
public class LC680ValidPalindromeII {

    /**
     * @param str
     * @return
     */
    public boolean areEquals(String str, int start, int end) {
        return (str != null && start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end));
    }

    /**
     * @param str
     * @return
     */
    public boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (!areEquals(str, start, end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    /**
     * Given a string s, return true if the s can be palindrome after deleting at most one character from it.
     *
     * @param str
     * @return
     */
    public boolean validPalindrome(String str) {
        if (str != null) {
            int start = 0;
            int end = str.length() - 1;
            while (start < end) {
                if (!areEquals(str, start, end)) {
                    return isPalindrome(str, start + 1, end) || isPalindrome(str, start, end - 1);
                }

                start++;
                end--;
            }
        }

        return true;
    }
}
