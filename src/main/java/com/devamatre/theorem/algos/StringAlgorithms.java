/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code, in source
 * and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.algos;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Rohtash Lakra
 * @date 01/27/2017 10:39:52 AM
 */
public class StringAlgorithms {

    /**
     * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
     * <p>
     * The input string does not contain leading or trailing spaces and the words are always separated by a single
     * space.
     * <p>
     * For example:
     *
     * <pre>
     *  String str = "The great day ahead";
     *  return "ahead day great The"
     * </pre>
     *
     * @param string
     */
    public static String wordReversal(final String string) {
        // long sTime = System.currentTimeMillis();
        String wordReversed = string;
        if (null != string) {
            String[] words = string.split(" ");
            if (null != words) {
                StringBuilder sBuilder = new StringBuilder();
                for (int i = words.length - 1; i >= 0; i--) {
                    sBuilder.append(words[i]);
                    if (i > 0) {
                        sBuilder.append(" ");
                    }
                }
                wordReversed = sBuilder.toString();
            }
        }
        // System.out.println("Took:" + (System.currentTimeMillis() - sTime));
        return wordReversed;
    }

    /**
     * @param string
     * @param startIndex
     * @param endIndex
     */
    private static void wordReverse(char[] string, int startIndex, int endIndex) {
        while (endIndex > startIndex) {
            char temp = string[startIndex];
            string[startIndex] = string[endIndex];
            string[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    /**
     * @param string
     */
    public static void wordReversal(final char[] string) {
        // long sTime = System.currentTimeMillis();
        if (null != string) {
            int startIndex = 0;
            for (int ctr = 0; ctr < string.length; ctr++) {
                if (string[ctr] == ' ') {
                    wordReverse(string, startIndex, ctr - 1);
                    startIndex = ctr + 1;
                }
            }

            wordReverse(string, startIndex, string.length - 1);

            // now reverse all the characters.
            wordReverse(string, 0, string.length - 1);
        }
        // System.out.println("Took:" + (System.currentTimeMillis() - sTime));
    }

    /**
     * TODO - Implement Me!
     *
     * @param string
     * @return
     */
    public static void wordReversalByArrayCopy(char[] string) {
        char[] reversed = new char[string.length];
        int ctr = string.length - 1;
        int lastIndex = string.length;
        int startIndex = 0;
        while (ctr >= 0) {
            if (string[ctr] == ' ') {
                System.arraycopy(string, (ctr + 1), reversed, startIndex, (lastIndex - 1 - ctr));
                startIndex += (lastIndex - ctr);
                lastIndex = ctr;
            }
            ctr--;
        }

        System.arraycopy(string, (ctr + 1), reversed, startIndex, (lastIndex - 1 - ctr));
        System.arraycopy(reversed, 0, string, 0, string.length);
    }

    /**
     * Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if the characters in s
     * can be replaced to get t.
     * <p>
     * For example,"egg" and "add" are isomorphic, "foo" and "bar" are not.
     *
     * @param string
     * @param another
     * @return
     */
    public static boolean isIsomorphic(String string, String another) {
        if (string == null || another == null) {
            return false;
        } else if (string.length() != another.length()) {
            return false;
        } else {
            HashMap<Character, Character> isomorphic = new HashMap<>();
            for (int i = 0; i < string.length(); i++) {
                char key = string.charAt(i);
                char value = another.charAt(i);
                if (isomorphic.containsKey(key)) {
                    if (isomorphic.get(key) != value) {
                        return false;
                    }
                } else if (isomorphic.containsValue(value)) {
                    return false;
                } else {
                    isomorphic.put(key, value);
                }
            }
        }

        return true;
    }

    /**
     * Implement wildcard pattern matching with support for '?' and '*'.
     * <p>
     * Java Solution
     * <p>
     * To understand this solution, you can use s="aab" and p="*ab".
     *
     * @return
     */
    public static boolean wildCardMatching(String source, String criteria) {
        int i = 0;
        int j = 0;
        int starIndex = -1;
        int iIndex = -1;

        while (i < source.length()) {
            if (j < criteria.length() && (criteria.charAt(j) == '?' || criteria.charAt(j) == source.charAt(i))) {
                ++i;
                ++j;
            } else if (j < criteria.length() && criteria.charAt(j) == '*') {
                starIndex = j;
                iIndex = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                i = iIndex + 1;
                iIndex++;
            } else {
                return false;
            }
        }

        while (j < criteria.length() && criteria.charAt(j) == '*') {
            ++j;
        }

        return j == criteria.length();
    }

    /**
     * Implement atoi to convert a string to an integer.
     * <p>
     * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask
     * yourself what are the possible input cases.
     * <p>
     * Analysis
     * <p>
     * The following cases should be considered for this problem:
     * <p>
     * 1. null or empty string 2. white spaces 3. +/- sign 4. calculate real value 5. handle min & max
     *
     * @param string
     * @return
     */
    public static int stringToInteger(String string) {
        double result = 0;
        // 1. handle null or empty string.
        if (string != null && string.length() > 0) {
            // 2. handle white spaces
            string = string.trim();
            int index = 0;
            char sign = '+';
            if (string.charAt(index) == '-') {
                sign = '-';
                index++;
            } else if (string.charAt(index) == '+') {
                index++;
            }

            // 4. calculate value.
            while (index < string.length() && (string.charAt(index) >= '0' && string.charAt(index) <= '9')) {
                result = result * 10 + (string.charAt(index) - '0');
                index++;
            }

            // 3. handle +/- sign
            if (sign == '-') {
                result = -result;
            }

            // 5. handle min & max values.
            if (result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
            }

            if (result < Integer.MIN_VALUE) {
                result = Integer.MIN_VALUE;
            }
        }

        return (int) result;
    }

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * <p>
     * For example, "Red rum, sir, is murder" is a palindrome, while "Programcreek is awesome" is not.
     * <p>
     * Note: Have you consider that the string might be empty? This is a good question to ask during an interview.
     * <p>
     * For the purpose of this problem, we define empty string as valid palindrome.
     * <p>
     * Thoughts
     * <p>
     * From start and end loop though the string, i.e., char array. If it is not alpha or number, increase or decrease
     * pointers. Compare the alpha and numeric characters. The solution below is pretty straightforward.
     *
     * @param string
     * @return
     */
    public static boolean isPalindrome(String string, boolean ignoreCase) {
        if (string != null) {
            if (ignoreCase) {
                string = string.toLowerCase();
            }

            int startIndex = 0;
            int endIndex = string.length() - 1;
            while (startIndex < endIndex) {
                if (!Character.isLetterOrDigit(string.charAt(startIndex))) {
                    startIndex++;
                } else if (!Character.isLetterOrDigit(string.charAt(endIndex))) {
                    endIndex--;
                } else if (string.charAt(startIndex) != string.charAt(endIndex)) {
                    return false;
                }
                startIndex++;
                endIndex--;
            }
        }

        return true;
    }

    /**
     * By default ignore case.
     *
     * @param string
     * @return
     */
    public static boolean isPalindromeNew(String string) {
        if (string != null) {
            string = string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

            int startIndex = 0;
            int endIndex = string.length() - 1;
            while (startIndex < endIndex) {
                if (string.charAt(startIndex) != string.charAt(endIndex)) {
                    return false;
                }
                startIndex++;
                endIndex--;
            }
        }

        return true;
    }

    /**
     * Starting point.
     *
     * @param args
     */
    public static void main(String[] args) {
        // String string = "The great day ahead";
        String string = "Rohtash Singh Lakra";
        string = "The quick brown fox jumps over the little lazy dog.";

        System.out.println("string:" + string);
        String wordReversed = wordReversal(string);
        System.out.println("wordReversed:" + wordReversed);

        char[] values = string.toCharArray();
        wordReversal(values);
        System.out.println(Arrays.toString(values));

        values = string.toCharArray();
        wordReversalByArrayCopy(values);
        System.out.println(Arrays.toString(values));

        string = "foo";
        String another = "bar";
        System.out.println("isIsomorphic(" + string + ", " + another + "):" + isIsomorphic(string, another));

        String source = "aaxab";
        String criteria = "*ab";
        System.out.println("wildCardMatching(" + source + ", " + criteria + "):" + wildCardMatching(source, criteria));

        String numbers = "-542422242454545464654546465544";
        System.out.println("stringToInteger(" + numbers + "):" + stringToInteger(numbers));

        string = "-542422242454545464654546465544";
        string = "Red rum, sir, is murder";
        // string = "Programcreek is awesome";
        System.out.println("isPalindrome(" + string + ", true):" + isPalindrome(string, true));
        System.out.println("isPalindrome(" + string + ", false):" + isPalindrome(string, false));

        // new way
        System.out.println("isPalindrome(" + string + "):" + isPalindromeNew(string));
    }

}
