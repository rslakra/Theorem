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
package com.devamatre.theorem.algos.lang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must
 * be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p>
 * For example:
 * <p>
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=0, index2=1
 * <p>
 * ============== Two Sum III – Data structure design ==============
 * <p>
 * <p>
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure. find - Find if there exists any pair of numbers which sum is
 * equal to the value.
 * <p>
 * For example,
 * <p>
 * add(1); add(3); add(5); find(4) -> true find(7) -> false
 *
 * @author Rohtash Lakra
 * @created 02/15/2017 10:44:29 AM
 */
public class Sum {

    private HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();

    public Sum() {

    }

    /**
     * Returns the indexes of two values which sum is equal to target.
     *
     * @param values
     * @param target
     * @return
     */
    public static int[] twoSumTypeI(int[] values, int target) {
        int[] result = new int[2];
        if (values != null && target > 0) {
            HashMap<Integer, Integer> indexes = new HashMap<Integer, Integer>();
            for (int i = 0; i < values.length; i++) {
                if (indexes.containsKey(values[i])) {
                    result[0] = indexes.get(values[i]);
                    result[1] = i;
                    break;
                } else {
                    indexes.put(target - values[i], i);
                }
            }
            System.out.println(indexes);
        }

        return result;
    }

    /**
     * Returns the indexes of two values which sum is equal to target.
     *
     * @param values
     * @param target
     * @return
     */
    public static int[] twoSumTypeII(int[] values, int target) {
        int[] result = new int[2];
        if (values != null && target > 0) {
            Arrays.sort(values);
            int i = 0, j = values.length - 1;
            while (i < j) {
                int sum = values[i] + values[j];
                if (sum < target) {
                    i++;
                } else if (sum > target) {
                    j--;
                } else {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }

    /**
     * Add the number to an internal data structure.
     *
     * @param value
     */
    public void add(int value) {
        if (elements.containsKey(value)) {
            elements.put(value, elements.get(value) + 1);
        } else {
            elements.put(value, 1);
        }
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     *
     * @param value
     * @return
     */
    public boolean find(int value) {
        for (Integer key : elements.keySet()) {
            int target = value - key;
            if (elements.containsKey(target)) {
                if (target == key && elements.get(target) < 2) {
                    continue;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Problem:
     * <p>
     * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets
     * in the array which gives the sum of zero.
     * <p>
     * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not
     * contain duplicate triplets.
     * <p>
     * For example, given array S = {-1 0 1 2 -1 -4},
     * <p>
     * A solution set is: (-1, 0, 1) (-1, -1, 2)
     *
     * @param elements
     * @return
     */
    public static List<List<Integer>> uniqueTripletsZeroSum(int[] elements) {
        List<List<Integer>> uniqueTriplets = new ArrayList<List<Integer>>();

        if (elements != null && elements.length > 2) {
            Arrays.sort(elements);

            for (int i = 0; i < elements.length - 2; i++) {
                if (i == 0 || elements[i] > elements[i - 1]) {

                    int j = i + 1;
                    int k = elements.length - 1;

                    while (j < k) {
                        int sum = (elements[i] + elements[j] + elements[k]);
                        if (sum == 0) {
                            List<Integer> set = new ArrayList<>();
                            set.add(i);
                            set.add(j);
                            set.add(k);
                            uniqueTriplets.add(set);

                            j++;
                            k--;

                            // handle duplicates here
                            while (j < k && elements[j] == elements[j - 1]) {
                                j++;
                            }

                            while (j < k && elements[k] == elements[k + 1]) {
                                k--;
                            }

                        } else if (sum < 0) {
                            j++;
                        } else {
                            k--;
                        }
                    }
                }
            }
        }

        return uniqueTriplets;
    }

    /**
     * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which
     * the sum ≥ s. If there isn't one, return 0 instead.
     * <p>
     * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2 under the
     * problem constraint.
     *
     * @param array
     * @param sum
     * @return
     */
    public static int[] minSubArrayLength(int[] array, int sum) {
        int[] result = new int[2];
        // Arrays.sort(array);
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            if (array[i] + array[j] > sum) {
                i++;
            } else if (array[i] + array[j] < sum) {
                j--;
            } else if (array[i] + array[j] == sum) {
                result[0] = array[i];
                result[1] = array[j];
                break;
            }
        }

        return result;
    }

    public static int productCalculator(int[] values, int index, int cValue) {
        int result = index == 0 ? 0 : 1;
        for (int i = index - 1; i >= 0 && index - i <= cValue; i--) {
            result = result * values[i];
        }

        return result;
    }

    /**
     * You have a range of consecutive numbers, from 1 to n (inclusive). e.g. [1,2,3,4,...,n].
     * <p>
     * We would like to calculate a sum of a function across the entire range, where the function returns the product of
     * the *preceding* C elements.
     * <p>
     * If there are less than C previous elements, just use the available numbers. i.e. if you are processing the fourth
     * number in the range, but C is greater than 3, then you will calculate the product using only the 3 available
     * preceding numbers. In this situation as you move further along in this range more preceding numbers become
     * available.
     * <p>
     * A worked example follows: if n=5 and C=2, the correct products and final sum for each element of the range are: 0
     * + 1 + 2 + 6 + 12 = 21
     * <p>
     * The solution should be implemented in Java. Initially calculate the value where n=100 and C=10, and let us know
     * the answer
     * <p>
     * Please additionally tell us the values where n=1000000 and C=200, but only include the first 10 digits of the
     * result in your answer.
     * <p>
     * What is the algorithmic complexity of your solution? What if you needed to calculate n=10,000,000 and C=200 ?
     *
     * @param n
     * @param check
     * @return
     */
    public static void sumOfProduct(int n, int check) {
        // loader values
        int sum = 0;
        int[] results = new int[n];
        int[] numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
            results[i] = productCalculator(numbers, i, check);
            sum += results[i];
        }

        System.out.println(Arrays.toString(results) + "=" + sum);
    }

    /**
     * Sum of n odd numbers = n^2 where n is a natural number.
     * <p>
     * To calculate the sum of first n odd numbers together without actually adding them individually. i.e., 1 + 3 + 5
     * +... n terms = n^2
     *
     * @param n
     * @return
     */
    public static int sumOfNOddNumbers(int n) {
        return (n * n);
    }

    /**
     * Returns the sum of <code>N</code> odd numbers.
     * <p>
     * Sum of odd numbers from 1 to n = <code>([(n+1)/2] ^ 2)</code>.
     * <p>
     * To find the sum of all consecutive odd numbers between 1 and n, add 1 and n. Get half of it. Square it to get the
     * answer.
     *
     * @param n
     * @return
     */
    public static int sumOfOddNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & 1) != 0) { // i % 2 != 0
                sum += i;
            }
        }

        return sum;
    }

    /**
     * Sum of odd numbers from 1 to n = <code>([(n+1)/2] ^ 2)</code>.
     * <p>
     * To find the sum of all consecutive odd numbers between 1 and n, add 1 and n. Get half of it. Square it to get the
     * answer.
     *
     * @param n
     * @return
     */
    public static int sumOfOddNumbersFormula(int n) {
        return (int) Math.pow((n + 1) / 2, 2);
    }

    /**
     * Sum of squares of n odd numbers 1^2 + 3^2 + 5^2 + ... (2n-1)^2 terms = n(4n^2 -1)/3
     *
     * @param n
     * @return
     */
    public static int sumOfSquareOfNOddNumber(int n) {
        return (n * (4 * (int) Math.pow(n, 2) - 1) / 3);
    }

    /**
     * Sum of cubes of n odd numbers 1^3 + 3^3+ 5^3 +... (2n-1)^3 = n^2(2n^2 -1).
     *
     * @param n
     * @return
     */
    public static int sumOfCubesOfNOddNumber(int n) {
        return (int) Math.pow(n, 2) * (2 * (int) Math.pow(n, 2) - 1);
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        // int[] numbers = { 2, 7, 11, 15 };
        int[] numbers = {2, 5, 9, 7, 11, 15};
        int target = 9;
        // int[] results = Sum.twoSumTypeI(numbers, target);
        // int[] results = Sum.twoSumTypeII(numbers, target);
        // System.out.println(Arrays.toString(results));

        Sum instance = new Sum();
        instance.add(1);
        instance.add(2);
        instance.add(3);
        // instance.add(5);
        System.out.println(instance.find(2));
        System.out.println(instance.find(4));
        System.out.println(instance.find(6));
        System.out.println(instance.find(13));

        int[] elements = {-1, 0, 1, 2, -1, -4};
        System.out.println(uniqueTripletsZeroSum(elements));

        int[] array = {2, 3, 1, 2, 4, 3};
        System.out.println(Arrays.toString(minSubArrayLength(array, 7)));

        int n = 5;
        int check = 2;
        sumOfProduct(n, check);

    }

}
