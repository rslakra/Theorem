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
package com.rslakra.theorem.hackerrank.array;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-08-27 05:50:00 PM
 * @since 1.0.0
 */
public class Matrix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] data = new int[9];
        int[][] matrix = new int[3][3];
        for (int i = 0; i < data.length; i++) {
            int row = (i / 3);
            int col = (i % 3);
            System.out.println("i:" + i + ", row:" + row + ", col:" + col);
            matrix[row][col] = i;
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }

    }

}
