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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-01 06:50:18 PM
 * @since 1.0.0
 */
public class SockMerchant {

    static int sockMerchant(int n, int[] colors) {
        // Complete this function
        int pairs = 0;
        Map<Integer, Integer> mapPairs = new HashMap<Integer, Integer>();
        for (int i = 0; i < colors.length; i++) {
            if (mapPairs.containsKey(colors[i])) {
                int value = mapPairs.get(colors[i]);
                mapPairs.put(colors[i], ++value);
                if (value % 2 == 0) {
                    pairs++;
                }
            } else {
                mapPairs.put(colors[i], 1);
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        in.close();
        int result = sockMerchant(n, ar);
        System.out.println(result);
    }

}
