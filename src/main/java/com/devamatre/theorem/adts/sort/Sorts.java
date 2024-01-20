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
 * This class handles the sorting.
 *
 * @author Rohtash Lakra
 * @created 05/13/2017 03:51:19 PM
 */
public enum Sorts {

    INSTANCE;

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
     * Sorts using bubble sort.
     *
     * @param values
     */
    public static void bubbleSort(int[] values) {
        for (int i = 0; i < values.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < values.length - 1 - i; j++) {
                if (values[j] > values[j + 1]) {
                    int temp = values[j];
                    values[j] = values[j + 1];
                    values[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                // array is already sorted, nothing to do.
                break;
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
     * Sorts the values using the merge sort, which is the most efficient algorithm of sorting large data sets.
     *
     * @param sortArray
     * @param tempArray
     * @param lowIndex
     * @param highIndex
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

    //--------

    /**
     * @param values
     */
    public static void mergeSort(int[] values) {
        int[] temp = new int[values.length];
        mergeSort(values, 0, values.length - 1, temp);
    }

    /**
     * @param values
     * @param low
     * @param high
     */
    private static void mergeSort(int[] values, int low, int high, int[] temp) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(values, low, mid, temp);
            mergeSort(values, mid + 1, high, temp);
            merge(values, low, mid, high, temp);
        }
    }

    /**
     * @param values
     * @param low
     * @param middle
     * @param high
     * @param temp
     */
    private static void merge(int[] values, int low, int middle, int high, int[] temp) {
        int index = low;
        int leftIndex = low;
        int rightIndex = middle + 1;

        // copy the existing sorted values to temp
        System.arraycopy(values, 0, temp, 0, values.length);

        // merge both (left and right array values
        while (leftIndex <= middle && rightIndex <= high) {
            if (temp[leftIndex] < temp[rightIndex]) {
                values[index] = temp[leftIndex];
                leftIndex++;
            } else {
                values[index] = temp[rightIndex];
                rightIndex++;
            }
            index++;
        }

        // merge left array remaining items, if any
        while (leftIndex <= middle) {
            values[index] = temp[leftIndex];
            leftIndex++;
            index++;
        }

        // merge right array remaining items, if any.
        while (rightIndex <= high) {
            values[index] = temp[rightIndex];
            rightIndex++;
            index++;
        }
    }

    /**
     * @param values
     */
    public static void mergeSortWithRecursion(int[] values) {
        int[] result = mergeSort(values, values.length);
        System.arraycopy(result, 0, values, 0, result.length);
    }

    /**
     * @param values
     * @param length
     * @return
     */
    private static int[] mergeSort(int[] values, int length) {
        if (values.length == 1) {
            return values;
        } else {
            int mid = length / 2;
            int[] lArray = new int[mid];
            System.arraycopy(values, 0, lArray, 0, mid);
            int[] rArray = new int[length - mid];
            System.arraycopy(values, mid, rArray, 0, (length - mid));
            return merge(mergeSort(lArray, mid), mergeSort(rArray, (length - mid)));
        }
    }

    /**
     * @param leftArray
     * @param rightArray
     */
    private static int[] merge(int[] leftArray, int[] rightArray) {
        int[] values = new int[leftArray.length + rightArray.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;

        // merge both (left and right array values
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            if (leftArray[leftIndex] < rightArray[rightIndex]) {
                values[index] = leftArray[leftIndex];
                leftIndex++;
            } else {
                values[index] = rightArray[rightIndex];
                rightIndex++;
            }
            index++;
        }

        // merge left array remaining items, if any
        while (leftIndex < leftArray.length) {
            values[index] = leftArray[leftIndex];
            leftIndex++;
            index++;
        }

        // merge right array remaining items, if any.
        while (rightIndex < rightArray.length) {
            values[index] = rightArray[rightIndex];
            rightIndex++;
            index++;
        }

        return values;
    }

    //--------

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

        values = new int[]{3, 1, 6, 4, 9, 5, 0, 8};
        System.out.println("Values:" + Arrays.toString(values));
        // Sorts.mergeSort(values);
        // Sorts.mergeSortWithRecursion(values);
        // System.out.println("Sorted:" + Arrays.toString(values));
        Sorts.bubbleSort(values);
        System.out.println("Sorted:" + Arrays.toString(values));

    }

    /**
     * Returns true if the array is strictly sorted.
     *
     * @param input
     * @param index
     * @return
     */
    public static boolean isSortedStrictly(int[] input, int index) {
        if (input.length == index) {
            return true;
        } else if (input[index - 1] > input[index]) {
            return false;
        }

        return isSortedStrictly(input, index + 1);
    }

    /**
     * @param input
     * @return
     */
    public static boolean isSortedStrictly(int[] input) {
        if (input == null || input.length == 1) {
            return true;
        }

        return isSortedStrictly(input, 1);
    }

}
