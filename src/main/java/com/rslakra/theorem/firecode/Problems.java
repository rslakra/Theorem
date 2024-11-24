/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.rslakra.theorem.firecode;

import java.util.HashMap;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-10-20 12:43:05 PM
 * @since 1.0.0
 */
public class Problems {

    /**
     * Given an array of integers, write a method - maxGain - that returns the maximum gain. Maximum Gain is defined as
     * the maximum difference between 2 elements in a list such that the larger element appears after the smaller
     * element. If no gain is possible, return 0.
     *
     * @param a
     * @return
     */
    public static int maxGain(int[] a, boolean optimized) {
        int maxGain = 0;
        if (optimized) {
            int min = a[0];
            int max = min;
            if (a.length > 1) {
                max = a[1] - min;
                for (int i = 1; i < a.length; i++) {
                    if (a[i] - min > max) {
                        max = a[i] - min;
                    }
                    if (a[i] < min) {
                        min = a[i];
                    }
                }
            }

            maxGain = (max < 0 ? 0 : max);
        } else {
            for (int i = 1; i < a.length; i++) {
                for (int j = i - 1; j >= 0; j--) {
                    if ((a[i] - a[j]) > maxGain) {
                        maxGain = a[i] - a[j];
                    }
                }
            }
        }

        return maxGain;
    }

    /**
     * Selection sort offers improved performance over bubble sort, especially for array with a large number of
     * elements. Where bubble sort accumulated the largest elements towards the end of the array, selection sort
     * accumulates the smallest elements at the beginning of the array.
     * <p>
     * Write a method that uses the selection sort algorithm to sort an input array of integers. See the hints and click
     * the red colored links for additonal details on the algorithm.
     * <p>
     * Examples:
     * <p>
     * selectionSortArray({1,5,2}) -> {1,2,5}
     * <p>
     * selectionSortArray({11}) -> {11}
     * <p>
     * selectionSortArray({}) -> {} {} -> [Empty] Array
     *
     * @param arr
     * @return
     */
    public static int[] selectionSortArray(int[] arr) {
        if (arr != null) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        return arr;
    }

    /**
     * Implement a method that checks if two strings are permutations of each other.
     * <p>
     * permutation("CAT","ACT") --> true
     * <p>
     * permutation("hello","aloha") --> false
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean permutation(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        } else if (str1 == null && str2 != null) {
            return false;
        } else if (str1 != null && str2 == null) {
            return false;
        } else if (str1.length() != str2.length()) {
            return false;
        } else {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str1.length(); i++) {
                Character cChar = str1.charAt(i);
                int value = 0;
                if (map.containsKey(cChar)) {
                    value = map.get(cChar) + 1;
                    if (value == 0) {
                        map.remove(cChar);
                    } else {
                        map.put(cChar, value);
                    }
                } else {
                    map.put(cChar, 1);
                }

                value = 0;
                cChar = str2.charAt(i);
                if (map.containsKey(cChar)) {
                    value = map.get(cChar) - 1;
                    if (value == 0) {
                        map.remove(cChar);
                    } else {
                        map.put(cChar, value);
                    }
                } else {
                    map.put(cChar, -1);
                }
            }

            return (map.isEmpty() ? true : false);
        }
    }

    /**
     * Write a method isAnagram that checks if two lowercase input Strings are anagrams of each other. An anagram of a
     * String is a String that is formed by simply re-arranging its letters, using each letter exactly once. Your
     * algorithm should run in linear O(n) time and use constant O(1) space.
     * <p>
     * Examples:
     * <p>
     * isAnagram("abc","cab") => true isAnagram("b","b") => true isAnagram("bd","cb") => false
     *
     * @param input1
     * @param input2
     * @return
     */
    public static boolean isAnagram(String input1, String input2) {
        if (input1 != null && input2 != null) {
            if (input1.length() != input2.length()) {
                return false;
            }

            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < input1.length(); i++) {
                Character cChar = input1.charAt(i);
                int value = 0;
                if (map.containsKey(cChar)) {
                    value = map.get(cChar) + 1;
                    if (value == 0) {
                        map.remove(cChar);
                    } else {
                        map.put(cChar, value);
                    }
                } else {
                    map.put(cChar, 1);
                }

                // check 2nd string
                cChar = input2.charAt(i);
                value = 0;
                if (map.containsKey(cChar)) {
                    value = map.get(cChar) - 1;
                    if (value == 0) {
                        map.remove(cChar);
                    } else {
                        map.put(cChar, value);
                    }
                } else {
                    map.put(cChar, -1);
                }
            }

            return (map.isEmpty() ? true : false);
        }

        return false;
    }

    /**
     * @param input1
     * @param input2
     * @return
     */
    public static boolean isAnagramOptimized(String input1, String input2) {
        if (input1 == null || input2 == null || (input1.length() != input2.length())) {
            return false;
        }

        int[] buffer = new int[26];
        for (int i = 0; i < input1.length(); i++) {
            buffer[input1.charAt(i) - 'a']++;
            buffer[input2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Space Optimized.
     *
     * @param input1
     * @param input2
     * @return
     */
    public static boolean isAnagramSpaceOptimized(String input1, String input2) {
        if (input1 == null || input2 == null || (input1.length() != input2.length())) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < input1.length(); i++) {
            sum += input1.charAt(i) - 'a';
        }

        for (int i = 0; i < input2.length(); i++) {
            sum -= input2.charAt(i) - 'a';
        }

        return (sum == 0);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // System.out.println(i/
        System.out.println(maxGain(new int[]{2}, true));
        // int[] arr = new int[] { 1, 5, 2 };
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(selectionSortArray(arr)));
        //
        // String str1 = "hello";
        // String str2 = "lleho";
        // System.out.println(permutation(str1, str2));
        //
        // int[][] matrix = new int[3][3];
        // matrix[0][0] = 1;
        // matrix[0][1] = 0;
        // matrix[0][2] = 1;
        //
        // matrix[1][0] = 1;
        // matrix[1][1] = 0;
        // matrix[1][2] = 1;
        //
        // matrix[2][0] = 1;
        // matrix[2][1] = 0;
        // matrix[2][2] = 1;
        // // {{1,0,1},{1,0,1},{1,0,1}}
        // // Utility.printMatrix(matrix);
        // //
        // // transposeMatrix(matrix);
        // // // {{1,1,1},{0,0,0},{1,1,1}}
        // // Utility.printMatrix(matrix);
        //
        // System.out.println("isAnagram");
        // String input1 = "abc";
        // String input2 = "cab";
        // System.out.println(isAnagramSpaceOptimized(input1, input2));
        // input1 = "b";
        // input2 = "b";
        // System.out.println(isAnagramSpaceOptimized(input1, input2));
        // input1 = "bd";
        // input2 = "cb";
        // System.out.println(isAnagramSpaceOptimized(input1, input2));

    }

}
