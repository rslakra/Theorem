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
package com.devamatre.theorem.algos.array;

import java.util.Arrays;

/**
 * Provides an algorithms of an array.
 *
 * @author Rohtash Lakra
 * @created 06/20/2017 08:41:33 PM
 */
public final class PeakFinder {

    /**
     * Peak b is only the peak if b >= a and b >= c.
     * <p>
     * Divide & Concur.
     *
     * @param values
     * @return
     */
    public static int peakFinder(int[] values) {
        int peakValue = -1;
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                if (values[i + 1] >= values[i]) {
                    peakValue = values[i];
                }
            } else if (i == values.length - 1) {
                if (values[i] >= values[i - 1]) {
                    peakValue = values[i];
                }
            } else if (values[i] >= values[i - 1] && values[i] >= values[i + 1]) {
                peakValue = values[i];
            }
        }

        return peakValue;
    }

    /**
     * Given two sorted integer arrays A and B, merge B into A as one sorted array.
     * <p>
     * Note: You may assume that A has enough space to hold additional elements from B. The number of elements
     * initialized in A and B are m and n respectively.
     * <p>
     * Analysis
     * <p>
     * The key to solve this problem is moving element of A and B backwards. If B has some elements left after A is
     * done, also need to handle that case.
     * <p>
     * The takeaway message from this problem is that the loop condition. This kind of condition is also used for
     * merging two sorted linked list.
     *
     * @param first
     * @param second
     * @return
     */
    public static int[] mergeSortedArrays(int[] first, int[] second) {
        int[] target = new int[first.length + second.length];
        int i = first.length - 1;
        int j = second.length - 1;
        int index = target.length - 1;

        while (i >= 0 && j >= 0) {
            if (first[i] < second[j]) {
                target[index] = second[j];
                j--;
            } else {
                target[index] = first[i];
                i--;
            }
            index--;
        }

        while (i >= 0) {
            target[index] = first[i];
            i--;
            index--;
        }

        while (j >= 0) {
            target[index] = second[j];
            j--;
            index--;
        }

        return target;
    }

    /**
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where
     * it would be if it were inserted in order. You may assume no duplicates in the array.
     * <p>
     * Here are few examples.
     * <p>
     * [1,3,5,6], 5 -> 2 [1,3,5,6], 2 -> 1 [1,3,5,6], 7 -> 4 [1,3,5,6], 0 -> 0
     *
     * @param array
     * @param find
     * @return
     */
    public static int searchIndex(int[] array, int find) {
        int i = 0;
        int j = array.length;
        while (i < j) {
            int mid = (i + j) / 2;
            if (find > array[mid]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }

        return j;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] values = {2, 3, 5, 8, 9, 4, 3};
        int peak = peakFinder(values);
        System.out.println("Peak:" + peak);

        int[] first = {2, 4, 6, 7};
        int[] second = {3, 5, 8, 90, 994};
        System.out.println(Arrays.toString(mergeSortedArrays(first, second)));

        int[] array = {1, 3, 5, 6};
        System.out.println("searchIndex(" + Arrays.toString(array) + ", 5):" + searchIndex(array, 5));
        System.out.println("searchIndex(" + Arrays.toString(array) + ", 2):" + searchIndex(array, 2));
        System.out.println("searchIndex(" + Arrays.toString(array) + ", 7):" + searchIndex(array, 7));
        System.out.println("searchIndex(" + Arrays.toString(array) + ", 0):" + searchIndex(array, 0));

    }

}
