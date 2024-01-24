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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-12-03 07:42:27 AM
 * @since 1.0.0
 */
public class PickingNumbers {

    public static void pickNumbers() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        // An array of zeroes
        int[] frequency = new int[100 + 1];

        // Fill array so that the value at each index corresponds to the number
        // of occurrences of that integer
        for (int i = 0; i < n; i++) {
            frequency[in.nextInt()]++;
        }
        in.close();

        // Determine which pair of adjacent integers has the highest number of
        // occurrences
        int max = 0;
        for (int i = 1; i <= 100; i++) {
            int count = frequency[i] + frequency[i - 1];
            if (count > max) {
                max = count;
            }
        }

        System.out.println(max);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        HashMap<Integer, ArrayList<Integer>> results = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            ArrayList<Integer> picked = results.get(arr[i]);
            if (picked == null) {
                picked = new ArrayList<>();
                picked.add(arr[i]);
                results.put(arr[i], picked);
            } else {
                ArrayList<Integer> copy = new ArrayList<>(picked);
                for (Integer number : copy) {
                    if (number - arr[i] <= 1) {

                    }
                }
            }
        }
    }

}
