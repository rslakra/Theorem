/**
 *
 */
package com.rslakra.theorem.leetcode.text;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Rohtash Lakra
 */
public class Anagram {

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int[] target = new int[26];
        int[] now = new int[26];
        char[] targetChar = p.toCharArray();
        int len = targetChar.length;
        for (char it : targetChar) {
            target[it - 'a']++;
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            now[chars[i] - 'a']++;
        }

        for (int i = 0; i <= s.length() - len; i++) {
            boolean match = true;
            for (int j = 0; j < 26; j++) {
                if (target[j] != now[j]) {
                    match = false;
                    break;
                }
            }

            if (match) {
                result.add(i);
            }

            if (i != s.length() - len) {
                now[chars[i] - 'a']--;
                now[chars[i + len] - 'a']++;
            }
        }
        return result;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String s = "abad";
        String p = "ab";
        System.out.println(findAnagrams(s, p));
        System.out.println();

        s = "cbaebabacd";
        p = "abc";
        System.out.println(findAnagrams(s, p));

    }

}
