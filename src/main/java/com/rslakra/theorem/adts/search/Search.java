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
package com.rslakra.theorem.adts.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 02/18/2017 01:36:46 PM
 */
public class Search {

    private static final Logger LOGGER = LoggerFactory.getLogger(Search.class);

    /**
     * Returns the pivot (max number index) in the sorted array in the given range.
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int findPivotInRotatedArray(int[] arr, int start, int end) {
        LOGGER.debug("+findPivotInRotatedArray({}, {}, {})", arr, start, end);
        // handle rotated sorted array
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && arr[mid] > arr[mid + 1]) {
                LOGGER.debug("-findPivotInRotatedArray(), mid:{}", (mid));
                return mid;
            } else if (mid > start && arr[mid] < arr[mid - 1]) {
                LOGGER.debug("-findPivotInRotatedArray(), mid-1:{}", (mid - 1));
                return mid - 1;
            } else if (arr[mid] <= arr[start]) {
                LOGGER.debug("end:{}, mid-1:{}", end, mid - 1);
                end = mid - 1;
            } else {
                LOGGER.debug("start:{}, mid+1:{}", start, mid + 1);
                start = mid + 1;
            }
        }

        LOGGER.debug("-findPivotInRotatedArray(), result: -1");
        return -1;
    }

    /**
     * Finds pivot in the sorted array.
     *
     * @param arr
     * @return
     */
    public static int findPivotInRotatedArray(int[] arr) {
        return (arr == null ? -1 : findPivotInRotatedArray(arr, 0, arr.length - 1));
    }

    /**
     * Returns the pivot (max value index) in the sorted duplicate rotated array.
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int findPivotInDuplicateRotatedArray(int[] arr, int start, int end) {
        LOGGER.debug("+findPivotInDuplicateRotatedArray({}, {}, {})", arr, start, end);
        while (start < end) {
            LOGGER.debug("start:{}, end:{}", start, end);
            int mid = start + (end - start) / 2;
            LOGGER.debug("mid:{}", mid);
            if (arr[start] > arr[mid]) {
                start++;
                end = mid;
            } else if (arr[mid] > arr[end]) {
                start = mid + 1;
            } else {
                if (arr[start] < arr[end]) {
                    break;
                } else {
                    end--;
                }
            }
        }

        // one loop break, return the start index
        LOGGER.debug("-findPivotInDuplicateRotatedArray(), result:{}", start);
        return start;
    }

    /**
     * Finds pivot in the sorted array.
     *
     * @param arr
     * @return
     */
    public static int findPivotInDuplicateRotatedArray(int[] arr) {
        return (arr == null ? -1 : findPivotInDuplicateRotatedArray(arr, 0, arr.length - 1));
    }

    /**
     * Returns the index of the <code>findWhat</code> in an array if exists otherwise -1. It uses the binary search
     * approach iteratively to find the index.
     *
     * <pre>
     *  Time Complexity: O(log N)
     * </pre>
     *
     * @param input
     * @param findWhat
     * @param startIndex
     * @param endIndex
     * @return
     */
    public static int findIteratively(int[] input, int findWhat, int startIndex, int endIndex) {
        LOGGER.debug("+findIteratively({}, {}, {}, {})", input, findWhat, startIndex, endIndex);
        int result = -1;
        while (startIndex < endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            LOGGER.debug("midIndex:{}", midIndex);
            if (input[midIndex] > findWhat) {
                // find next value on the left side of the mid in an array.
                endIndex = midIndex;
            } else if (input[midIndex] < findWhat) {
                // find next value on the right side of the mid in an array.
                startIndex = midIndex + 1;
            } else {
                result = midIndex;
                break;
            }
        }

        // if the value equals to findWhat then return index otherwise -1
        LOGGER.debug("-findIteratively(), result:{}", result);
        return result;
    }

    /**
     * Returns the index of the value == target in a sorted mountain array if exists otherwise -1;
     *
     * @param arr
     * @param target
     * @param start
     * @param end
     * @return
     */
    public int findTargetIndexWithOrderAgnosticBinarySearch(int[] arr, int target, int start, int end) {
        boolean isAsc = arr[start] < arr[start + 1];
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (arr[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (arr[mid] < target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * Returns the index of the peak/the highest value in a sorted mountain array.
     *
     * @param arr
     * @return
     */
    public int findPeakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    /**
     * Returns the index of the <code>findWhat</code> in an array if exists otherwise -1. It uses the binary search
     * approach recursively to find the index.
     *
     * <pre>
     *  Time Complexity: O(log N)
     * </pre>
     *
     * @param values
     * @param findWhat
     * @param lowIndex
     * @param highIndex
     * @return
     */
    public static int findRecursively(int[] values, int findWhat, int lowIndex, int highIndex) {
        if (highIndex > lowIndex) {
            int midIndex = lowIndex + (highIndex - lowIndex) / 2;
            if (values[midIndex] > findWhat) {
                // find next value on the left side of the mid in an array.
                return findRecursively(values, findWhat, lowIndex, midIndex);
            } else if (values[midIndex] < findWhat) {
                // find next value on the right side of the mid in an array.
                return findRecursively(values, findWhat, midIndex + 1, highIndex);
            } else {
                return midIndex;
            }
        }

        // if the value equals to findWhat then return index otherwise -1
        return (findWhat == values[highIndex] ? highIndex : -1);
    }

    public static void main(String[] args) {
        int[] values = {2, 4, 6, 9, 11, 38};
        System.out.println(findRecursively(values, 0, values.length - 1, 11));

    }

}
