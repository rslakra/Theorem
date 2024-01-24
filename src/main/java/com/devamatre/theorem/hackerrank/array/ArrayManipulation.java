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
package com.devamatre.theorem.hackerrank.array;

import com.devamatre.theorem.hackerrank.Utils;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-08-24 06:35:34 PM
 * @since 1.0.0
 */
public class ArrayManipulation {

    // Complete the arrayManipulation function below.
    static long arrayManipulationTimeout(int n, int[][] queries) {
        long maxValue = 0;
        long[] values = new long[n];
        for (int i = 0; i < queries.length; i++) {
            for (int j = (queries[i][0] - 1); j < queries[i][1]; j++) {
                values[j] += queries[i][2];
                if (values[j] > maxValue) {
                    maxValue = values[j];
                }
            }
        }

        return maxValue;
    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long maxValue = 0;
        long[] values = new long[n];
        for (int i = 0; i < queries.length; i++) {
            values[queries[i][0] - 1] += queries[i][2];
            if (queries[i][1] < n) {
                values[queries[i][1]] -= queries[i][2];
            }
        }

        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
            if (sum > maxValue) {
                maxValue = sum;
            }
        }

        return maxValue;
    }

    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String[] nm = SCANNER.nextLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = SCANNER.nextLine().split(" ");
            SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                queries[i][j] = Integer.parseInt(queriesRowItems[j]);
            }
        }

        long result = arrayManipulation(n, queries);
        Utils.writeToFile("ArrayManipulation.txt", result);
        SCANNER.close();
    }

}
