/**
 *
 */
package com.devamatre.theorem.leetcode.text;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Rohtash Lakra
 */
public final class LongestSubstring {

    /**
     * Problem #3
     *
     * @param str
     * @return
     */
    public int lengthOfLongestSubstring(String str) {
        if (str.length() <= 1) {
            return str.length();
        }

        int longest = 1;
        int startIndex = 0;
        int endIndex = startIndex + 1;
        while (startIndex <= endIndex && endIndex < str.length()) {
            String subStr = str.substring(startIndex, endIndex);
            char cChar = str.charAt(endIndex);
            if (subStr.lastIndexOf(cChar) == -1) {
                if (startIndex < endIndex && longest < subStr.length() + 1) {
                    longest = subStr.length() + 1;
                }
                endIndex++;
            } else {
                startIndex++;
            }
        }

        return longest;
    }

    /**
     * Problem #3
     *
     * @param str
     * @return
     */
    public int lengthOfLongestSubstringOptimized(String str) {
        int result = 0;
        int lastStartIndex = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char cChar = str.charAt(i);
            if (map.containsKey(cChar)) {
                lastStartIndex = Math.max(result, map.get(cChar));
            }
            result = Math.max(result, i - lastStartIndex + 1);
            map.put(cChar, i + 1);
        }

        return result;
    }

    /**
     * @author Rohtash Lakra
     */
    final static class AlphaComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

    /**
     * @author Rohtash Lakra
     */
    final static class LengthComparator implements Comparator<String> {

        final boolean isAscending;

        public LengthComparator(final boolean isAscending) {
            this.isAscending = isAscending;
        }

        @Override
        public int compare(String o1, String o2) {
            int result = 0;
            if (isAscending) {
                result = o1.length() - o2.length();
                if (result == 0) {
                    result = o1.compareTo(o2);
                }
            } else {
                result = o2.length() - o1.length();
                if (result == 0) {
                    result = o2.compareTo(o1);
                }
            }

            return result;
        }
    }

    public Set<String> uniqueLetterSubStrings(String str) {
        // Set<String> uniqueSubstrings = new TreeSet<String>(new AlphaComparator());
        // Set<String> uniqueSubstrings = new TreeSet<String>(new LengthComparator(true));
        Set<String> uniqueSubstrings = new TreeSet<String>(new LengthComparator(false));

        if (str.length() > 0) {
            if (str.length() == 1) {
                uniqueSubstrings.add(str);
            }

            int startIndex = 0;
            int index = startIndex + 1;
            while (startIndex <= index && index < str.length()) {
                String subStr = str.substring(startIndex, index);
                if (subStr.length() > 0) {
                    uniqueSubstrings.add(subStr);
                }
                char cChar = str.charAt(index);
                if (subStr.lastIndexOf(cChar) == -1) {
                    index++;
                } else {
                    startIndex++;
                }
            }
        }

        return uniqueSubstrings;
    }

    /**
     * @param str
     * @return
     */
    public Set<String> uniqueLetterSubStringsOptimized(String str) {
        Set<String> uniqueSubstring = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < str.length() && j < str.length()) {
            String sub = str.substring(i, j + 1);
            if (!sub.isEmpty()) {
                uniqueSubstring.add(sub);
            }
            if (j == str.length() - 1) {
                i++;
                j = i;
            } else if (sub.lastIndexOf(str.charAt(j + 1)) == -1) {
                j++;
            } else {
                i++;
            }
        }

        return uniqueSubstring;

    }

    /**
     * Problem #828
     * <p>
     * <p>
     * A character is unique in string S if it occurs exactly once in it.
     * <p>
     * For example, in string S = "LETTER", the only unique characters are "L" and "R".
     * <p>
     * Let's define UNIQ(S) as the number of unique characters in string S.
     * <p>
     * For example, UNIQ("LETTER") = 2.
     * <p>
     * Given a string S with only uppercases, calculate the sum of UNIQ(substring) over all non-empty substrings of S.
     * <p>
     * If there are two or more equal substrings at different positions in S, we consider them different.
     * <p>
     * Since the answer can be very large, return the answer modulo 10 ^ 9 + 7.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: "ABC" Output: 10 Explanation: All possible substrings are: "A","B","C","AB","BC" and "ABC". Evey substring
     * is composed with only unique letters. Sum of lengths of all substring is 1 + 1 + 1 + 2 + 2 + 3 = 10
     *
     * @param str
     * @return
     */
    public int sumOfUniqueLetterString(String str) {
        if (str.length() <= 1) {
            return str.length();
        }

        int result = 0;
        Set<String> uniqueSubstring = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < str.length() && j < str.length()) {
            String sub = str.substring(i, j + 1);
            if (!sub.isEmpty() && !uniqueSubstring.contains(sub)) {
                uniqueSubstring.add(sub);
                result += sub.length();
            }

            if (j == str.length() - 1) {
                i++;
                j = i;
            } else if (sub.lastIndexOf(str.charAt(j + 1)) == -1) {
                j++;
            } else {
                i++;
            }
        }

        return result;

    }

    public int sumOfUniqueLetterStrings(String str) {
        return 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LongestSubstring longSubStr = new LongestSubstring();

        String string = "abcabcbb";
        System.out.println(longSubStr.lengthOfLongestSubstring(string));
        System.out.println(longSubStr.lengthOfLongestSubstringOptimized(string));
        string = "bbbb";
        System.out.println(longSubStr.lengthOfLongestSubstring(string));
        System.out.println(longSubStr.lengthOfLongestSubstringOptimized(string));
        string = "pwwkew";
        System.out.println(longSubStr.lengthOfLongestSubstring(string));
        System.out.println(longSubStr.lengthOfLongestSubstringOptimized(string));
        string = "";
        System.out.println(longSubStr.lengthOfLongestSubstring(string));
        System.out.println(longSubStr.lengthOfLongestSubstringOptimized(string));
        System.out.println();

        // unique letters.
        System.out.println(longSubStr.uniqueLetterSubStrings(string));
        System.out.println(longSubStr.uniqueLetterSubStringsOptimized(string));

        string = "abcabcbb";
        System.out.println(longSubStr.uniqueLetterSubStrings(string));
        System.out.println(longSubStr.uniqueLetterSubStringsOptimized(string));

        string = "abc";
        System.out.println(longSubStr.uniqueLetterSubStrings(string));
        System.out.println(longSubStr.uniqueLetterSubStringsOptimized(string));

        System.out.println();
        string = "abc";
        System.out.println(longSubStr.sumOfUniqueLetterString(string));
        string = "aba";
        System.out.println(longSubStr.sumOfUniqueLetterString(string));

        System.out.println();
        for (int i = 0; i <= 2; i++) {
            System.out.println(i + "/2:" + (i / 2));
        }

    }

}
