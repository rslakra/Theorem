package com.devamatre.theorem.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer
 * in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all
 * the original letters exactly once.
 * <p>
 * <p>
 * <p>
 * Example 1: Input: s = "cbaebabacd", p = "abc" Output: [0,6] Explanation: The substring with start index = 0 is "cba",
 * which is an anagram of "abc". The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2: Input: s = "abab", p = "ab" Output: [0,1,2] Explanation: The substring with start index = 0 is "ab", which
 * is an anagram of "ab". The substring with start index = 1 is "ba", which is an anagram of "ab". The substring with
 * start index = 2 is "ab", which is an anagram of "ab".
 *
 * @author Rohtash Lakra
 * @created 9/19/23 4:46 PM
 */
public class LC438FindAllAnagrams {

    /**
     * @param input
     * @param search
     * @return
     */
    public List<Integer> findAnagrams(String input, String search) {
        List<Integer> result = new ArrayList<>();
        int[] hash = new int[26];
        for (int i = 0; i < search.length(); i++) {
            hash[input.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(hash));

        int start = 0;
        int end = 0;
        int count = search.length();
        while (end < input.length()) {
            if (hash[input.charAt(end) - 'a'] > 0) {
                count--;
            }

            hash[input.charAt(end) - 'a']--;
            end++;

            if (count == 0) {
                result.add(start);
            }

            if ((end - start) == search.length()) {
                if (hash[input.charAt(start) - 'a'] >= 0) {
                    count++;
                }

                hash[input.charAt(start) - 'a']++;
                start++;
            }
        }

        return result;
    }
}
