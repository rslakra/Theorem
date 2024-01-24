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
package com.devamatre.theorem.geeksforgeeks;

import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-24 01:21:22 PM
 * @since 1.0.0
 */
public class BSTArrayAsSorted {

    /**
     * Prints the BST Array as sorted order.
     *
     * @param values
     * @param sIndex
     * @param eIndex
     */
    public static void inOrder(int[] values, int sIndex, int eIndex) {
        if (sIndex <= eIndex) {
            inOrder(values, (sIndex * 2 + 1), eIndex);
            System.out.print(values[sIndex] + " ");
            inOrder(values, (sIndex * 2 + 2), eIndex);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < values.length; i++) {
            values[i] = in.nextInt();
        }
        in.close();
        inOrder(values, 0, values.length - 1);
    }

}
