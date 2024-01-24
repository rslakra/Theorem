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
package com.devamatre.theorem.hackerrank.algos;

import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-03 05:48:39 PM
 * @since 1.0.0
 */
public class ElectronicShop {

    static int getMoneySpent(int[] keyboards, int[] drives, int s) {
        // Complete this function
        int moneySpent = -1;
        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                int totalSpent = keyboards[i] + drives[j];
                if (totalSpent <= s && totalSpent > moneySpent) {
                    moneySpent = totalSpent;
                }
            }
        }

        return moneySpent;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for (int i = 0; i < n; i++) {
            keyboards[i] = in.nextInt();
        }
        int[] drives = new int[m];
        for (int i = 0; i < m; i++) {
            drives[i] = in.nextInt();
        }
        in.close();
        // The maximum amount of money she can spend on a keyboard and USB
        // drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}
