/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.hackerrank.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * A left rotation operation on an array of size shifts each of the array's elements unit to the left. For example, if
 * left rotations are performed on array , then the array would become .
 * <p>
 * Given an array of integers and a number, , perform left rotations on the array. Then print the updated array as a
 * single line of space-separated integers.
 * <p>
 * Input Format
 * <p>
 * The first line contains two space-separated integers denoting the respective values of (the number of integers) and
 * (the number of left rotations you must perform). The second line contains space-separated integers describing the
 * respective elements of the array's initial state.
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print a single line of space-separated integers denoting the final state of the array after performing left
 * rotations.
 * <p>
 * Sample Input
 * <p>
 * 5 4 1 2 3 4 5
 * <p>
 * Sample Output
 * <p>
 * 5 1 2 3 4
 * <p>
 * Explanation
 * <p>
 * When we perform left rotations, the array undergoes the following sequence of changes:
 * <p>
 * Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-08-10 07:43:41 PM
 * @since 1.0.0
 */
public class LeftRotation {

    /**
     * Left rotates the values.
     *
     * @param n
     * @param d
     */
    public void leftRotation(int n, int d) {
        int[] values = null;
        System.out.println("Sample Input");
        System.out.println(n + " " + d);
        if (n > 0 && d > 0 && d < n) {
            values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = (i + 1);
            }

            System.out.println(Arrays.toString(values));

            // rotate
            for (int i = 1; i <= d; i++) {
                int temp = values[0];
                for (int j = 1; j < values.length; j++) {
                    values[j - 1] = values[j];
                }
                values[values.length - 1] = temp;
            }

            System.out.println("\nSample Output");
            System.out.println(Arrays.toString(values));
        }
    }

    /**
     * @param values
     * @param n
     * @param k
     */
    public void leftRotation(int[] values, int n, int k) {
        System.out.println("Sample Input");
        System.out.println(n + " " + k);
        System.out.println(Arrays.toString(values));
        if (n > 0 && k > 0 && k < n) {
            // rotate
            for (int i = 1; i <= k; i++) {
                int temp = values[0];
                for (int j = 1; j < values.length; j++) {
                    values[j - 1] = values[j];
                }
                values[values.length - 1] = temp;
            }

            System.out.println("\nSample Output");
            System.out.println(Arrays.toString(values));
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.close();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (i + 1);
        }

        LeftRotation leftRotation = new LeftRotation();
        // leftRotation.leftRotation(2, 4);
        leftRotation.leftRotation(a, n, k);
    }

}
