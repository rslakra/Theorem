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
package com.devamatre.theorem.firecode;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-10-30 08:50:23 AM
 * @since 1.0.0
 */
public class Strs {

    /**
     * Given a string, recursively compute a new string where the identical adjacent characters in the original string
     * are separated by a "*". Examples:
     * <p>
     * insertPairStar("cac") ==> "cac" insertPairStar("cc") ==> "c*c"
     *
     * @param str
     * @return
     */
    public static String insertPairStar(String str) {
        if (str != null) {
            StringBuilder sBuilder = new StringBuilder();
            if (str.length() > 1) {
                if (str.charAt(0) == str.charAt(1)) {
                    sBuilder.append(str.charAt(0));
                    sBuilder.append("*");
                } else {
                    sBuilder.append(str.charAt(0));
                }
                str = str.substring(1);
                String newStr = insertPairStar(str);
                if (newStr != null) {
                    sBuilder.append(newStr);
                }
            } else {
                sBuilder.append(str);
            }
            return sBuilder.toString();
        }

        return null;
    }

    /**
     * @param str
     * @param optimized
     * @return
     */
    public static String insertPairStar(String str, boolean optimized) {
        if (str == null || str.length() < 2) {
            return str;
        }

        return str.charAt(0) + (str.charAt(0) == str.charAt(1) ? "*" : "") + insertPairStar(str.substring(1));
    }

    /**
     * Write a method to compute the binary representation of a positive integer. The method should return a string with
     * 1s and 0s.
     * <p>
     * computeBinary(6) ==> "110" computeBinary(5) ==> "101"
     * <p>
     * Note: Use the minimum number of binary digits needed for the representation (Truncate unnecessary trailing 0s).
     * computeBinary(5) ==> "0101" (incorrect) computeBinary(5) ==> "101" (correct)
     *
     * @param val
     * @return
     */
    public static String computeBinary(int val) {
        // return Integer.toBinaryString(val);
        if (val == 0) {
            return "0";
        } else {
            StringBuilder binary = new StringBuilder();
            while (val != 0) {
                binary.append(val % 2);
                val = val / 2;
            }

            binary.reverse();

            return binary.toString();
        }
    }

    public static String computeBinary(int val, boolean optimized) {
        return (val < 2 ? Integer.toString(val)
                        : (computeBinary(val / 2, optimized) + computeBinary(val % 2, optimized)));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "cac";
        str = "cc";
        str = null;
        System.out.println(insertPairStar(str));
        System.out.println(insertPairStar(str, true));
        int val = 5;
        System.out.println(computeBinary(val));
        System.out.println(computeBinary(val, true));
    }

}
