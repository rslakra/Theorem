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
package com.rslakra.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-08-20 08:58:38 PM
 * @since 1.0.0
 */
public class BitwiseAND {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int maxPossibleValue(int n, int k) {
        int maxPossible = 0;

        if (k <= n) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1 + i; j <= n; j++) {
                    int value = (i & j);
                    if (value > maxPossible && value < k) {
                        maxPossible = value;
                    }
                }
            }
        }

        return maxPossible;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int t = SCANNER.nextInt();
        SCANNER.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String[] nk = SCANNER.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            System.out.println(maxPossibleValue(n, k));
        }

        SCANNER.close();
    }

}
