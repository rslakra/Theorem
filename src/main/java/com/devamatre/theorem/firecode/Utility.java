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
package com.devamatre.theorem.firecode;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-10-26 10:59:06 AM
 * @since 1.0.0
 */
public final class Utility {

    private Utility() {
    }

    /**
     * Returns true if the array is sorted in ascending order otherwise false.
     *
     * @param numbers
     * @return
     */
    private boolean isSortedInAscending(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] < numbers[i + 1]) {
                continue;
            }
            return false;
        }

        return true;
    }

    /**
     * Returns true if the array is sorted in descending order otherwise false.
     *
     * @param numbers
     * @return
     */
    private boolean isSortedInDescending(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i - 1] > numbers[i]) {
                continue;
            }
            return false;
        }

        return true;
    }

    /**
     * @param matrix
     */
    public static void printMatrix(Object[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * @param matrix
     */
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
