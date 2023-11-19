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
package com.devamatre.theorem.adts.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Rohtash Lakra
 * @created 10/18/23 9:10 AM
 */
public enum Sorts {

    INSTANCE;

    /**
     * Sorts the values of the given array in ascending order.
     *
     * @param values
     */
    public static void selectionSortAscending(int[] values) {
        int temp;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] > values[j]) {
                    temp = values[j];
                    values[j] = values[i];
                    values[i] = temp;
                }
            }
        }
    }

    /**
     * Sorts the values of the given array in descending order.
     *
     * @param values
     */
    public static void selectionSortDescending(int[] values) {
        int temp;
        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] < values[j]) {
                    temp = values[j];
                    values[j] = values[i];
                    values[i] = temp;
                }
            }
        }
    }

    /**
     * Sorts the values of the given array in ascending order.
     *
     * @param values
     */
    public static void insertionSortAscending(int[] values) {
        int j, temp;
        for (int i = 1; i < values.length; i++) {
            temp = values[i];
            for (j = i; j > 0 && temp < values[j - 1]; j--) {
                values[j] = values[j - 1];
            }
            values[j] = temp;
        }
    }

    /**
     * Sorts the values of the given array in descending order.
     *
     * @param values
     */
    public static void insertionSortDescending(int[] values) {
        int j, temp;
        for (int i = 1; i < values.length; i++) {
            temp = values[i];
            for (j = i; j > 0 && temp > values[j - 1]; j--) {
                values[j] = values[j - 1];
            }
            values[j] = temp;
        }
    }

    /**
     * Sorts the values of the given array in ascending order.
     *
     * @param values
     */
    public static void bubbleSortAscending(int[] values) {
        int temp;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] > values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts the values of the given array in descending order.
     * <p>
     * f(n) = O(n2)
     *
     * @param values
     */
    public static void bubbleSortDescending(int[] values) {
        int temp;
        for (int i = 0; i < values.length - 1; i++) {
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] < values[j + 1]) {
                    temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Fills the specified array with random numbers of the specified length.
     *
     * @param values
     * @param length
     */
    public static void fillRandoms(int[] values, int length) {
        if (values != null) {
            Random random = new Random();
            for (int i = 0; i < values.length; i++) {
                values[i] = random.nextInt(100);
            }
        }
    }

    /**
     * Sorts the values of the given array in ascending order.
     *
     * @param values
     */
    public static void insertSortAscending(int[] values) {
        int j, temp;
        for (int i = 1; i < values.length; i++) {
            temp = values[i];
            for (j = i; j > 0 && temp < values[j - 1]; j--) {
                values[j] = values[j - 1];
            }
            values[j] = temp;
        }
    }

    /**
     * Sorts the values of the given array in descending order.
     *
     * @param values
     */
    public static void insertSortDescending(int[] values) {
        int j, temp;
        for (int i = 1; i < values.length; i++) {
            temp = values[i];
            for (j = i; j > 0 && temp > values[j - 1]; j--) {
                values[j] = values[j - 1];
            }
            values[j] = temp;
        }
    }

    /**
     * Sorts the values using the merge sort, which is most efficient algorithm of sorting large data sets.
     *
     * @param values
     */
    public static void mergeSort(int[] sortArray, int[] tempArray, int lowIndex, int highIndex) {
        // stop recursion at some point
        if (highIndex > lowIndex) {
            int midIndex = (highIndex + lowIndex) / 2;
            mergeSort(sortArray, tempArray, lowIndex, midIndex);
            mergeSort(sortArray, tempArray, midIndex + 1, highIndex);
            merge(sortArray, tempArray, lowIndex, midIndex, highIndex);
        }
    }

    /**
     * Merges the values of sub-sets into one.
     *
     * @param sortArray
     * @param tempArray
     * @param lowIndex
     * @param midIndex
     * @param highIndex
     */
    private static void merge(int[] sortArray, int[] tempArray, int lowIndex, int midIndex, int highIndex) {
        int lowIndex1 = lowIndex;
        int lowIndex2 = midIndex + 1;
        int ctr = lowIndex;

        // make the copy of the sortArray into tempArray
        System.arraycopy(sortArray, 0, tempArray, 0, sortArray.length);

        // now start merging the sub-sets and updating the sortArray.
        while (lowIndex1 <= midIndex && lowIndex2 <= highIndex) {
            if (tempArray[lowIndex1] <= tempArray[lowIndex2]) {
                sortArray[ctr] = tempArray[lowIndex1];
                lowIndex1++;
            } else {
                sortArray[ctr] = tempArray[lowIndex2];
                lowIndex2++;
            }
            ctr++;
        }

        // merge the left half remaining array
        while (lowIndex1 <= midIndex) {
            sortArray[ctr] = tempArray[lowIndex1];
            ctr++;
            lowIndex1++;
        }

        // merge the right half remaining array
        while (lowIndex2 <= highIndex) {
            sortArray[ctr] = tempArray[lowIndex2];
            ctr++;
            lowIndex2++;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] values = new int[]{5, 2, 6, 1, 9, 4, 7};
        System.out.println(Arrays.toString(values));

        // selectionSortAscending(values);
        // selectionSortDescending(values);

        // insertionSortAscending(values);
        // insertionSortDescending(values);

        // bubbleSortAscending(values);
        // bubbleSortDescending(values);
        System.out.println(Arrays.toString(values));
    }

}
