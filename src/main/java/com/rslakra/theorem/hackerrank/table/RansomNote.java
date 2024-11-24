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
package com.rslakra.theorem.hackerrank.table;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-27 06:59:59 AM
 * @since 1.0.0
 */
public class RansomNote {

    public static boolean isReplica(HashMap<String, Integer> data, String[] ransom) {
        boolean replica = true;
        for (int i = 0; i < ransom.length; i++) {
            if (data.keySet().contains(ransom[i])) {
                int value = (data.get(ransom[i]) - 1);
                if (value == 0) {
                    data.remove(ransom[i]);
                } else {
                    data.put(ransom[i], value);
                }
            } else {
                replica = false;
                break;
            }
        }

        return replica;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        final HashMap<String, Integer> data = new HashMap<String, Integer>();
        String[] magazine = new String[m];
        for (int i = 0; i < m; i++) {
            magazine[i] = in.next();
            int ctr = 0;
            if (data.keySet().contains(magazine[i])) {
                ctr = data.get(magazine[i]);
            }
            ctr++;
            data.put(magazine[i], ctr);
        }
        String[] ransom = new String[n];
        for (int i = 0; i < n; i++) {
            ransom[i] = in.next();
        }
        in.close();

        if (m >= n) {
            System.out.println(isReplica(data, ransom) ? "Yes" : "No");
        } else {
            System.out.println("No");
        }

    }

}
