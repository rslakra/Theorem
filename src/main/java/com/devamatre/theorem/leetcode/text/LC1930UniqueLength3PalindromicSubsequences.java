package com.devamatre.theorem.leetcode.text;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 11/13/2023 7:05 PM
 */
public class LC1930UniqueLength3PalindromicSubsequences {


    public static int countPalindromicSubsequence(String s) {
        int[] leftIndices = new int[26];
        int[] rightIndices = new int[26];
        int result = 0;
        Arrays.fill(leftIndices, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            System.out.println("i:" + i + ", index:" + index);
            leftIndices[index] = Math.max(leftIndices[i], i);
            rightIndices[index] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            if (leftIndices[i] < rightIndices[i]) {
                result += s.substring(leftIndices[i] + 1, rightIndices[i]).chars().distinct().count();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequence("aabca"));
    }
}
