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
package com.devamatre.theorem.adts.text;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author rsingh
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
    }

}
