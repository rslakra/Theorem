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

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-12-05 06:28:19 PM
 * @since 1.0.0
 */
public class SequenceEquation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> seq = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            seq.put(in.nextInt(), i);
        }
        in.close();

        for (int i = 1; i <= n; i++) {
            System.out.println(seq.get(seq.get(i)));
        }
    }

}
