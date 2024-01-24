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

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Finds the longest common prefix.
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-09-21 06:04:23 PM
 * @since 1.0.0
 */
public class FindCommonPrefix {

    /**
     * @param leftString
     * @param rightString
     * @param allPrefixes
     * @return
     */
    static String findLongestCommonPrefix(String leftString, String rightString, boolean allPrefixes) {
        String result = null;
        if (leftString != null && rightString != null) {
            int[][] matrix = new int[leftString.length()][rightString.length()];
            Set<String> results = new HashSet<String>();
            int longest = 0;
            for (int i = 0; i < leftString.length(); i++) {
                for (int j = 0; j < rightString.length(); j++) {
                    if (leftString.charAt(i) != rightString.charAt(j)) {
                        continue;
                    }

                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = (1 + matrix[i - 1][j - 1]);
                    }

                    if (matrix[i][j] > longest) {
                        longest = matrix[i][j];
                        if (!allPrefixes) {
                            results.clear();
                        }
                    }

                    if (matrix[i][j] == longest) {
                        results.add(leftString.substring(longest - i + 1, longest + 1));
                    }
                }
            }

            if (allPrefixes) {
                StringBuilder sBuilder = new StringBuilder();
                for (String value : results) {
                    if (sBuilder.length() == 0) {
                        sBuilder.append(value);
                    } else {
                        sBuilder.append("\n").append(value);
                    }
                }
                result = sBuilder.toString();
            } else {
                result = results.iterator().next();
            }
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String leftString = in.next();
        String rightString = in.next();
        in.close();

        System.out.println(findLongestCommonPrefix(leftString, rightString, false));
        System.out.println(findLongestCommonPrefix(leftString, rightString, true));
    }

}
