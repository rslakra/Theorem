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
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-12-03 10:56:57 AM
 * @since 1.0.0
 */
public class CircularArrayRotation {

    private static int[] circularRotation(int[] arr, int rotations) {
        int[] rotated = new int[arr.length];
        int k = rotations % arr.length;
        for (int i = 0; i < arr.length; i++) {
            rotated[k++] = arr[i];
            if (k == arr.length) {
                k = 0;
            }
        }

        return rotated;
    }

    private static void reverse(int[] arr, int i, int j) {
        for (; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private static int[] arrayRotation(int[] arr, int rotations) {
        int k = rotations % arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);

        return arr;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        // int q = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int[] rotated = circularRotation(arr, k);
        System.out.println(Arrays.toString(rotated));

        System.out.println();
        rotated = arrayRotation(arr, k);
        System.out.println(Arrays.toString(rotated));

        // for (int i = 0; i < q; i++) {
        // int m = in.nextInt();
        // System.out.println(rotated[m]);
        //
        // }

        in.close();
    }

}
