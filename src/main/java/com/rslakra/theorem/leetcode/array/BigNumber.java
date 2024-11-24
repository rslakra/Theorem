/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code, in source
 * and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
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
package com.rslakra.theorem.leetcode.array;

import com.rslakra.theorem.adts.array.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Aug 3, 2019 7:38:26 PM
 */
public class BigNumber {

    /**
     * @param leftIndex
     * @param index
     * @return
     */
    public boolean isGreater(int[] nums, int leftIndex, int index) {
        if (leftIndex >= 0 && index < nums.length) {
            String left = String.format("%d%d", nums[leftIndex], nums[index]);
            String right = String.format("%d%d", nums[index], nums[leftIndex]);
            return (left.compareTo(right) <= 0 ? true : false);
        }

        return false;
    }

    /**
     * @param numbers
     * @param left
     * @param right
     */
    public void swap(int[] numbers, int left, int right) {
        int temp = numbers[left];
        numbers[left] = numbers[right];
        numbers[right] = temp;
    }

    /**
     * @param numbers
     * @return
     */
    public String largestNumber(int[] numbers) {
        boolean allZeros = true;
        for (int i = 0; i < numbers.length; i++) {
            if (allZeros && numbers[i] != 0) {
                allZeros = false;
            }

            for (int j = i; j >= 0 && isGreater(numbers, j - 1, j); j--) {
                swap(numbers, j - 1, j);
            }
        }

        if (allZeros) {
            return "0";
        }

        return Arrays.toString(numbers).replace(", ", "").replace("[", "").replace("]", "");
    }

    /**
     * @param nums
     * @return
     */
    public String largestNumberOptimized(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        List<Integer> listNumbers = ArrayUtils.asIntList(nums);
        Collections.sort(listNumbers, new Comparator<Integer>() {

            @Override
            public int compare(Integer left, Integer right) {
                String leftOperand = String.format("%d%d", left, right);
                String rightOperand = String.format("%d%d", right, left);
                return (rightOperand.compareTo(leftOperand));
            }
        });

        boolean allZeros = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                allZeros = false;
                break;
            }
        }

        if (allZeros) {
            return "0";
        }

        return listNumbers.toString().replace(", ", "").replace("[", "").replace("]", "");
    }


    /**
     * @param nums
     * @return
     */
    public int sumNumbers(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int[] result = new int[nums.length * 2];
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = nums.length - 1; j >= 0; j--) {
                String str = String.valueOf(nums[i]) + String.valueOf(nums[j]);
                int number = Integer.parseInt(str);
                int k = result.length - 1;
                int counter = 0;
                while (number >= 0 && k >= 0) {
                    int rem = (number % 10);
                    result[k] += counter + rem;
                    counter = result[k] / 10;
                    result[k] = result[k] % 10;
                    number /= 10;
                    k--;
                }

                if (counter > 0) {
                    result[k] = counter;
                }
            }
        }

        int index = 0;
        for (; index < result.length && result[index] <= 0; index++) {
        }

        StringBuilder sBuilder = new StringBuilder();
        for (; index < result.length; index++) {
            sBuilder.append(result[index]);
        }

        return Integer.parseInt(sBuilder.toString());
    }
}
