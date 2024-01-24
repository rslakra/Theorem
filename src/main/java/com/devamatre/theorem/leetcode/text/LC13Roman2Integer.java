package com.devamatre.theorem.leetcode.text;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value I             1 V             5 X             10 L             50 C             100 D
 * 500 M             1000
 * <p>
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which
 * is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
 * principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III" Output: 3
 * <p>
 * Example 2:
 * <p>
 * Input: "IV" Output: 4
 * <p>
 * Example 3:
 * <p>
 * Input: "IX" Output: 9
 * <p>
 * Example 4:
 * <p>
 * Input: "LVIII" Output: 58 Explanation: L = 50, V= 5, III = 3.
 * <p>
 * Example 5:
 * <p>
 * Input: "MCMXCIV" Output: 1994 Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * <p>
 * Author: Rohtash Singh Lakra Created: 12/12/19 7:04 PM
 */
public class LC13Roman2Integer {

    private final Map<Character, Integer> mapRomans = new HashMap<>();

    public LC13Roman2Integer() {
        mapRomans.put('I', 1);
        mapRomans.put('V', 5);
        mapRomans.put('X', 10);
        mapRomans.put('L', 50);
        mapRomans.put('C', 100);
        mapRomans.put('D', 500);
        mapRomans.put('M', 1000);
    }

    /**
     * Time Complexity: O(N) Memory Complexity: O(1)
     *
     * @param str
     * @return
     */
    public int roman2int(String str) {
        int result = 0;
        if (str != null && str.length() > 0) {
            int digit = 0;
            int i = str.length() - 1;
            while (i > 0) {
                int prev = mapRomans.get(str.charAt(i - 1));
                int curr = mapRomans.get(str.charAt(i));
                if (prev < curr) {
                    digit = curr - prev;
                    i--;
                } else {
                    digit = curr;
                }
                result += digit;
                i--;
            }

            if (i == 0) {
                digit = mapRomans.get(str.charAt(i));
                result += digit;
            }
        }

        return result;
    }

    /**
     * Time Complexity: O(N) Memory Complexity: O(1)
     *
     * @param str
     * @return
     */
    public int roman2intOptimized(String str) {
        int result = 0;
        int prev = 1000;
        int current = 0;
        for (char ch : str.toCharArray()) {
            switch (ch) {
                case 'I':
                    current = 1;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'M':
                    current = 1000;
                    break;
                default:
                    break;
            }

            if (current > prev) {
                current -= (2 * prev);
            } else if (current < prev) {
                prev = current;
            }

            result += current;
        }

        return result;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        LC13Roman2Integer obj = new LC13Roman2Integer();
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        input.close();
        System.out.println(str + " = " + obj.roman2int(str));
        System.out.println(str + " = " + obj.roman2intOptimized(str));
    }
}
