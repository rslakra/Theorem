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
package com.devamatre.theorem.hackerrank.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-14 06:13:58 PM
 * @since 1.0.0
 */
public class DynamicArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        List[] seqList = new List[n];
        for (int i = 0; i < n; i++) {
            seqList[i] = new ArrayList<>();
        }

        int[][] queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 3; j++) {
                queries[i][j] = in.nextInt();
            }
        }
        in.close();

        int lastAnswer = 0;
        for (int i = 0; i < q; i++) {
            // seq 1
            if (queries[i][0] == 1) {
                int seqIndex = (queries[i][1] ^ lastAnswer) % n;
                seqList[seqIndex].add(queries[i][2]);
            } else if (queries[i][0] == 2) {
                // seq 2
                int seqIndex = (queries[i][1] ^ lastAnswer) % n;
                int index = queries[i][2] % seqList[seqIndex].size();
                lastAnswer = (int) seqList[seqIndex].get(index);
                System.out.println(lastAnswer);
            }
        }
    }

}
