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

import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-08-20 07:32:56 PM
 * @since 1.0.0
 */
public class Solution {

    static String toString(char[] chars) {
        return new String(chars);
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] lines = new String[n];
        for (int i = 0; i < n; i++) {
            lines[i] = in.nextLine();
        }
        in.close();

        char[] evens = null;
        char[] odds = null;
        for (int i = 0; i < lines.length; i++) {
            int eIndex = 0;
            int oIndex = 0;
            evens = new char[lines[i].length()];
            odds = new char[lines[i].length()];
            for (int j = 0; j < lines[i].length(); j++) {
                if (j == 0 || (j % 2 == 0)) {
                    evens[eIndex] = lines[i].charAt(j);
                    eIndex++;
                } else {
                    odds[oIndex] = lines[i].charAt(j);
                    oIndex++;
                }
            }

            System.out.println(String.valueOf(evens) + " " + String.valueOf(odds));
        }
    }
}
