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
package com.rslakra.theorem.algos.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 10, 2019 9:02:18 PM
 */
public class PairsWithSumK {

    /**
     * @param arr
     * @param sum
     * @return
     */
    public List<Set<Integer>> pairsWithSumOfK(int[] arr, int sum) {
        List<Set<Integer>> sumPairs = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];
            if (map.containsKey(diff)) {
                if (arr[map.get(diff)] + arr[i] == sum) {
                    Set<Integer> set = new HashSet<>();
                    set.add(arr[map.get(diff)]);
                    set.add(arr[i]);
                    sumPairs.add(set);
                }
            } else {
                map.put(arr[i], i);
            }
        }

        return sumPairs;

    }

    /**
     * Time Complexity: O(N)
     * <p>
     * Space Complexity: O(N)
     *
     * @param arr
     * @param sum
     */
    public void printPairsWithSumOfK(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = sum - arr[i];
            if (set.contains(diff)) {
                System.out.println("(" + diff + ", " + arr[i] + ")");
            } else {
                set.add(arr[i]);
            }
        }
    }

    /**
     * @param arr
     * @param sum
     */
    public void printPairsWithSumOfKNoExtraSpace(int[] arr, int sum) {
        int i = 0;
        int j = arr.length - 1;
        Arrays.sort(arr);
        while (i < j) {
            int result = arr[i] + arr[j];
            if (result < sum) {
                i++;
            } else if (result > sum) {
                j--;
            } else {
                System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                i++;
                j--;
            }
        }
    }

    /**
     * @param nums
     * @param total
     * @param index
     * @return
     */
    private int setOfNumbersWhichSumEqualTotal(int[] nums, int total, int index) {
        if (total == 0) {
            return 1;
        } else if (total < 0) {
            return 0;
        } else if (index < 0) {
            return 0;
        } else if (total < nums[index]) {
            return setOfNumbersWhichSumEqualTotal(nums, total, index - 1);
        } else {
            return setOfNumbersWhichSumEqualTotal(nums, total - nums[index], index - 1)
                   + setOfNumbersWhichSumEqualTotal(nums, total, index - 1);
        }
    }

    /**
     * @param nums
     * @param total
     * @return
     */
    public int setOfNumbersWhichSumEqualTotal(int[] nums, int total) {
        return setOfNumbersWhichSumEqualTotal(nums, total, nums.length - 1);
    }

    /**
     * @param nums
     * @param total
     * @param index
     * @return
     */
    private int setOfNumbersWhichSumEqualTotalUsingDP(int[] nums, int total, int index, HashMap<String, Integer> map) {
        String key = String.valueOf(total) + "-" + String.valueOf(index);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int result = 0;
        if (total == 0) {
            return 1;
        } else if (total < 0) {
            return 0;
        } else if (index < 0) {
            return 0;
        } else if (total < nums[index]) {
            result = setOfNumbersWhichSumEqualTotalUsingDP(nums, total, index - 1, map);
        } else {
            result =
                setOfNumbersWhichSumEqualTotalUsingDP(nums, total - nums[index], index - 1, map)
                + setOfNumbersWhichSumEqualTotalUsingDP(nums, total, index - 1, map);
        }
        map.put(key, result);

        return result;
    }

    /**
     * @param nums
     * @param total
     * @return
     */
    public int setOfNumbersWhichSumEqualTotalUsingDP(int[] nums, int total) {
        final HashMap<String, Integer> map = new HashMap<>();
        int result = setOfNumbersWhichSumEqualTotalUsingDP(nums, total, nums.length - 1, map);
        // System.out.println(map);
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        PairsWithSumK obj = new PairsWithSumK();
        int[] arr = {2, 6, 3, 9, 11};
        int sum = 9;
        System.out.println(obj.pairsWithSumOfK(arr, sum));
        obj.printPairsWithSumOfK(arr, sum);
        obj.printPairsWithSumOfKNoExtraSpace(arr, sum);
        System.out.println();
        arr = new int[]{2, 4, 3, 5, 6, -2, 4, 7, 8, 9};
        sum = 7;
        System.out.println(obj.pairsWithSumOfK(arr, sum));
        obj.printPairsWithSumOfK(arr, sum);
        obj.printPairsWithSumOfKNoExtraSpace(arr, sum);
        System.out.println();

        System.out.println("Sets Of Numbers That Add Up To k");
        arr = new int[]{2, 4, 6, 10};
        sum = 10;
        System.out.println(obj.setOfNumbersWhichSumEqualTotal(arr, sum));
        System.out.println(obj.setOfNumbersWhichSumEqualTotalUsingDP(arr, sum));
        System.out.println();
        arr = new int[]{2, 4, 6, 10, 12};
        sum = 16;
        System.out.println(obj.setOfNumbersWhichSumEqualTotal(arr, sum));
        System.out.println(obj.setOfNumbersWhichSumEqualTotalUsingDP(arr, sum));

    }

}
