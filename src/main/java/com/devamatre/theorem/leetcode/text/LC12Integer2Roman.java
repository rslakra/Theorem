package com.devamatre.theorem.leetcode.text;

import java.util.HashMap;
import java.util.Map;

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
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: 3 Output: "III"
 * <p>
 * Example 2:
 * <p>
 * Input: 4 Output: "IV"
 * <p>
 * Example 3:
 * <p>
 * Input: 9 Output: "IX"
 * <p>
 * Example 4:
 * <p>
 * Input: 58 Output: "LVIII" Explanation: L = 50, V = 5, III = 3.
 * <p>
 * Example 5:
 * <p>
 * Input: 1994 Output: "MCMXCIV" Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * <p>
 * Author: Rohtash Singh Lakra Created: 12/22/19 6:19 PM
 */
public class LC12Integer2Roman {

    private final Map<Integer, Character> mapRomans = new HashMap<>();

    public LC12Integer2Roman() {
        mapRomans.put(1, 'I');
        mapRomans.put(5, 'V');
        mapRomans.put(10, 'X');
        mapRomans.put(50, 'L');
        mapRomans.put(100, 'C');
        mapRomans.put(500, 'D');
        mapRomans.put(1000, 'M');
    }

    /**
     * @param num
     * @return
     */
    private int countDigits(int num) {
        return (num == 0 ? 1 : (int) Math.log10(10) + 1);
    }

    /**
     * @param number
     * @param repeat
     * @return
     */
    public String toRepeatString(final int number, final int repeat) {
        StringBuilder romanBuilder = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            romanBuilder.append(mapRomans.get(number));
        }

        return romanBuilder.toString();
    }

    /**
     * @param num
     * @return
     */
    public String intToRoman(final int num) {
        if (mapRomans.containsKey(num)) {
            return String.valueOf(mapRomans.get(num));
        } else if (num >= 1000) {
            int quotient = num / 1000;
            return toRepeatString(1000, quotient);
//            return (String.valueOf(mapRomans.get(1000)) + intToRoman(num - 1000));
        } else if (num > 900) {
            int quotient = num / 900;
            return (String.valueOf(mapRomans.get(100)) + String.valueOf(mapRomans.get(1000)));
        } else if (num == 900) {
            return (String.valueOf(mapRomans.get(100)) + String.valueOf(mapRomans.get(1000)));
        } else if (num >= 500) {
            return (String.valueOf(mapRomans.get(500)) + intToRoman(num - 500));
        } else if (num == 400) {
            return (String.valueOf(mapRomans.get(100)) + String.valueOf(mapRomans.get(500)));
        } else if (num >= 100) {
            return (String.valueOf(mapRomans.get(100)) + intToRoman(num - 100));
        } else if (num == 90) {
            return (String.valueOf(mapRomans.get(10)) + String.valueOf(mapRomans.get(100)));
        } else if (num >= 50) {
            return (String.valueOf(mapRomans.get(50)) + intToRoman(num - 50));
        } else if (num == 40) {
            return (String.valueOf(mapRomans.get(10)) + String.valueOf(mapRomans.get(50)));
        } else if (num >= 10) {
            return (String.valueOf(mapRomans.get(10)) + intToRoman(num - 10));
        } else if (num == 9) {
            return (String.valueOf(mapRomans.get(1)) + String.valueOf(mapRomans.get(10)));
        } else if (num >= 5) {
            return (String.valueOf(mapRomans.get(5)) + intToRoman(num - 5));
        } else if (num == 4) {
            return (String.valueOf(mapRomans.get(1)) + String.valueOf(mapRomans.get(5)));
        } else if (num >= 1) {
            return (String.valueOf(mapRomans.get(1)) + intToRoman(num - 1));
        }
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC12Integer2Roman numConverter = new LC12Integer2Roman();
// Scanner input = new Scanner(System.in);
// String str = input.nextLine();
// input.close();
        int number = 3;
        System.out.println(number + " = " + numConverter.intToRoman(number));
        System.out.println();

        //
        number = 4;
        System.out.println(number + " = " + numConverter.intToRoman(number));
        System.out.println();

        //
        number = 9;
        System.out.println(number + " = " + numConverter.intToRoman(number));
        System.out.println();

        //
        number = 58;
        System.out.println(number + " = " + numConverter.intToRoman(number));
        System.out.println();

        //
        number = 1994;
        System.out.println(number + " = " + numConverter.intToRoman(number));
        System.out.println();

    }

}
