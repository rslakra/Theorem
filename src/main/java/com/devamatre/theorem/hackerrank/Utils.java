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
package com.devamatre.theorem.hackerrank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-01 12:45:31 PM
 * @since 1.0.0
 */
public final class Utils {

    /**
     * magic constant m = n(n^2 + 1)/2 so for a 3X3 magic square m = 3(3^2 + 1)/2 = 15
     *
     * @param n
     * @return
     */
    public static int magixConstant(int n) {
        return (n * ((int) Math.pow(n, 2) + 1) / 2);
    }

    /**
     * Sorts the two dimensional array.
     *
     * @param arr
     */
    public static void sort(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    char temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts the two dimensional array.
     *
     * @param arr
     */
    public static void sort(char[][] arr) {
        for (int k = 0; k < arr.length; k++) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[k][j] > arr[k][j + 1]) {
                        char temp = arr[k][j];
                        arr[k][j] = arr[k][j + 1];
                        arr[k][j + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * Prints the array.
     *
     * @param arr
     */
    public static void println(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    /**
     * Prints the array.
     *
     * @param arr
     */
    public static void println(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static void main(String[] args) {
        System.out.println(magixConstant(3));
        System.out.println(magixConstant(4));
    }

    /**
     * @param fileName
     * @param value
     */
    public static void writeToFile(final String fileName, Object value) {
        final String filePath = System.getProperty("user.dir") + File.separator + fileName;
        BufferedWriter fileWriter = null;
        try {
            fileWriter = new BufferedWriter(new FileWriter(filePath));
            fileWriter.write(String.valueOf(value));
            fileWriter.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
