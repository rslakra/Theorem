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
package com.rslakra.theorem.hackerrank.array;

import java.util.Scanner;

/**
 * Task Given an array, , of integers, print 's elements in reverse order as a single line of space-separated numbers.
 * <p>
 * Input Format
 * <p>
 * The first line contains an integer, (the size of our array). The second line contains space-separated integers
 * describing array 's elements.
 * <p>
 * Constraints
 * <p>
 * , where is the integer in the array.
 * <p>
 * Output Format
 * <p>
 * Print the elements of array in reverse order as a single line of space-separated numbers.
 * <p>
 * Sample Input
 * <p>
 * 4 1 4 3 2
 * <p>
 * Sample Output
 * <p>
 * 2 3 4 1
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-08-21 12:35:37 PM
 * @since 1.0.0
 */
public class Reverse {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.close();

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i > 0) {
                System.out.print(' ');
            }
        }
    }

}
