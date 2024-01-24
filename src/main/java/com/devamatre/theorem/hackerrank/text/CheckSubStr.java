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
package com.devamatre.theorem.hackerrank.text;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-10-04 06:29:42 PM
 * @since 1.0.0
 */
public class CheckSubStr {

    /**
     * Check the substring exists in the string.
     *
     * @param where
     * @param find
     * @return
     */
    public static boolean hasSubstring(final String where, final String find) {
        if (where == null || find == null) {
            return false;
        }

        if (where.length() < find.length()) {
            return false;
        }

        for (int i = 0; i < where.length(); i++) {
            boolean noMatch = false;
            for (int j = 0; j < find.length(); j++) {
                if (where.charAt(i + j) != find.charAt(j)) {
                    noMatch = true;
                    break;
                }
            }

            if (!noMatch) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String where = "abate";
        String find = "bat";
        System.out.println(hasSubstring(where, find));
    }

}
