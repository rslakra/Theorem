package com.devamatre.theorem.leetcode.text;

/**
 * @author Rohtash Lakra
 * @created 1/26/24 10:42 AM
 */
public class LC28FindIndexOfFirstOccurrenceInString {

    /**
     * <url>https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string</url>
     *
     * <pre>
     *  Time Complexity: O(N)
     *  N - the longest length of the haystack or needle.
     *
     *  Time Complexity: O(1)
     * </pre>
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        } else if (needle == null) {
            return 0;
        } else if (needle.length() > haystack.length()) {
            return -1;
        }

        int index = -1;
        int i = 0, j = 0;

        while (i < needle.length() && j < haystack.length()) {
            if (haystack.charAt(j) == needle.charAt(i)) {
                if (index == -1 && haystack.length() >= needle.length() + j) {
                    index = j;
                }
                i++;
                j++;
            } else {
                if (index != -1) {
                    index = -1;
                    i = 0;
                    j--;
                } else {
                    j++;
                }
            }
        }

        return index;
    }

    /**
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr2(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        } else if (needle == null) {
            return 0;
        } else if (needle.length() > haystack.length()) {
            return -1;
        }

        int index = 0;
        int i = 0, j = 0;

        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = 0;
                i = index + 1;
                index = i;
            }
        }

        return (j == needle.length() ? index : -1);
    }

    /**
     * Returns true if the target string equals to the substring of source string starting from the index until target's
     * string length.
     *
     * <pre>
     *  Time Complexity: O(N)
     *  N - the length of the target string.
     *
     *  Time Complexity: O(1)
     * </pre>
     *
     * @param index
     * @param source
     * @param target
     * @return
     */
    private boolean isSame(int index, String source, String target) {
        return source.subSequence(index, index + target.length()).equals(target);
    }

    /**
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr3(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        } else if (needle == null) {
            return 0;
        } else if (needle.length() > haystack.length()) {
            return -1;
        }

        int size = haystack.length() - needle.length();
        for (int i = 0; i <= size; i++) {
            if (isSame(i, haystack, needle)) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Returns true if the <code>input</code>  string equals to the <code>other</code> string starting from the provided
     * <code>index</code> otherwise false.
     * <pre>
     *  Time Complexity: O(log N)
     *  N - the length of the input string.
     *
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param index
     * @param haystack
     * @param needle
     * @return
     */
    private boolean areEquals(int index, String haystack, String needle) {
        int size = needle.length();
        for (int i = 0, j = needle.length() - 1; i <= j; i++, j--) {
            // beginning index
            if (haystack.charAt(i + index) != needle.charAt(i)) {
                return false;
            } else if (haystack.charAt(index + (size - i - 1)) != needle.charAt(
                size - i - 1)) { // end of the string index
                return false;
            }
        }

        return true;
    }

    /**
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr4(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        } else if (needle == null) {
            return 0;
        } else if (needle.length() > haystack.length()) {
            return -1;
        }

        int size = haystack.length() - needle.length();
        for (int i = 0; i <= size; i++) {
            if (areEquals(i, haystack, needle)) {
                return i;
            }
        }

        return -1;
    }
}
