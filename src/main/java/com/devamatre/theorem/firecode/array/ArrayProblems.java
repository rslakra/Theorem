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
package com.devamatre.theorem.firecode.array;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-10-26 12:50:38 PM
 * @since 1.0.0
 */
public class ArrayProblems {

    /**
     * The idea behind the classic Mergesort algorithm is to divide an array in half, sort each half, and then use a
     * merge() method to merge the two halves into a single sorted array.
     * <p>
     * <p>
     * Implement the merge() method that takes in two sorted array and returns a third sorted array that contains
     * elements of both the input array.
     * <p>
     * You can assume that the input array will always be sorted in ascending order and can have different sizes.
     * <p>
     * <p>
     * Examples:
     * <p>
     * merge({2,5,7,8,9},{9}) -> {2,5,7,8,9,9} merge()({7,8},{1,2}) -> {1,2,7,8} merge()({2},{}) -> {2} {} -> [Empty]
     * Array
     *
     * @param arrLeft
     * @param arrRight
     * @return
     */
    public static int[] merge(int[] arrLeft, int[] arrRight) {
        int[] merged = null;
        if (arrLeft != null && arrRight != null) {
            merged = new int[arrLeft.length + arrRight.length];
        } else if (arrLeft != null && arrRight == null) {
            merged = new int[arrLeft.length];
        } else if (arrLeft == null && arrRight != null) {
            merged = new int[arrRight.length];
        } else {
            merged = new int[0];
        }

        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (arrLeft != null && arrRight != null && leftIndex < arrLeft.length && rightIndex < arrRight.length) {
            if (arrLeft[leftIndex] < arrRight[rightIndex]) {
                merged[index++] = arrLeft[leftIndex];
                leftIndex++;
            } else {
                merged[index++] = arrRight[rightIndex];
                rightIndex++;
            }
        }

        // move left array values.
        while (arrLeft != null && leftIndex < arrLeft.length) {
            merged[index++] = arrLeft[leftIndex];
            leftIndex++;
        }

        // move right array values.
        while (arrRight != null && rightIndex < arrRight.length) {
            merged[index++] = arrRight[rightIndex];
            rightIndex++;
        }

        return merged;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] leftArray = new int[]{2, 5, 7, 8, 9};
        int[] rightArray = new int[]{9};
        int[] result = merge(leftArray, rightArray);
        System.out.println(Arrays.toString(result));

        leftArray = new int[]{7, 8};
        rightArray = new int[]{1, 2};
        result = merge(leftArray, rightArray);
        System.out.println(Arrays.toString(result));

        leftArray = new int[]{2};
        rightArray = new int[]{};
        result = merge(leftArray, rightArray);
        System.out.println(Arrays.toString(result));

    }

}
