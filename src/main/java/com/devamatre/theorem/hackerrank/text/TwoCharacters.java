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

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-12-06 09:46:06 AM
 * @since 1.0.0
 */
public class TwoCharacters {

    static void printMatrix(int[][] values) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                System.out.print(values[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printMatrix(char[][] letters) {
        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < letters.length; j++) {
                System.out.print(letters[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int longestAltString(String s) {
        char[][] letters = new char[26][26];
        int[][] values = new int[26][26];
        for (char cChar : s.toCharArray()) {
            int index = (int) (cChar - 'a');
            for (int i = 0; i < letters.length; i++) {
                if (letters[index][i] != cChar && values[index][i] != -1) {
                    letters[index][i] = cChar;
                    ++values[index][i];
                } else {
                    values[index][i] = -1;
                }
                if (letters[i][index] != cChar && values[i][index] != -1) {
                    letters[i][index] = cChar;
                    ++values[i][index];
                } else {
                    values[i][index] = -1;
                }
            }

            printMatrix(letters);
            printMatrix(values);
        }
        int largestString = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (values[i][j] > largestString) {
                    largestString = values[i][j];
                }
            }
        }
        if (largestString > 1) {
            return largestString;
        } else {
            return 0;
        }
    }

    static boolean hasConsecutives(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                return true;
            }
        }

        return false;
    }

    static int twoCharacters(String str, int length) {
        HashMap<Character, Integer> sChars = new HashMap<>();
        int maxChars = 0;
        char forChar = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            char sChar = str.charAt(i);
            if (sChars.containsKey(sChar)) {
                int newValue = sChars.get(sChar) + 1;
                sChars.put(sChar, newValue);
                if (newValue > maxChars) {
                    maxChars = newValue;
                    forChar = sChar;
                }
            } else {
                sChars.put(sChar, 1);
            }
        }

        int index = 0;
        if (sChars.size() != 2) {
            while (!str.isEmpty()) {
                for (char sChar : sChars.keySet()) {
                }
                break;
            }
        }

        return (str.isEmpty() ? 0 : str.length());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String str = in.next();
        // System.out.println(twoCharacters(str, 10));
        System.out.println(longestAltString(str));
        in.close();
    }

}
