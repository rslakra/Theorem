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
package com.rslakra.theorem.hackerrank.text;

import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-12-06 09:28:33 AM
 * @since 1.0.0
 */
public class SuperReducedString {

    public static String superReducedString(String str) {
        int index = 0;
        while (!str.isEmpty()) {
            if ((index + 1) < str.length() && str.charAt(index) == str.charAt(index + 1)) {
                if (index == 0) {
                    str = str.substring(index + 2);
                } else {
                    str = str.substring(0, index) + str.substring(index + 2);
                }
                index = 0;
            } else {
                index++;
            }

            if (index == str.length()) {
                break;
            }
        }

        return str.isEmpty() ? "Empty String" : str;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(superReducedString(str));
        in.close();
    }

}
