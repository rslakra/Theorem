/**
 *
 */
package com.devamatre.theorem.leetcode;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 9, 2019 6:07:50 PM
 */
public class Str2Int {

    /**
     * @param cChar
     * @return
     */
    private boolean isNumber(char cChar) {
        int num = cChar - '0';
        return (num >= 0 && num <= 9);
    }

    /**
     * https://leetcode.com/problems/string-to-integer-atoi/
     *
     * @param str
     * @return
     */
    public int atoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int index = 0;
        for (; index < str.length() && str.charAt(index) == ' '; index++) {

        }

        int num = 0;
        if (index < str.length()) {
            boolean isNegative = str.charAt(index) == '-';
            if (isNegative) {
                index++;
            } else if (str.charAt(index) == '+') {
                index++;
            } else if (!isNumber(str.charAt(index))) {
                return 0;
            }

            for (; index < str.length() && isNumber(str.charAt(index)); index++) {
                int digit = str.charAt(index) - '0';
                if ((num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && digit > 7))) {
                    return (isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE);
                }
                if (num < Integer.MIN_VALUE / 10 || (num == Integer.MIN_VALUE / 10 && digit < -8)) {
                    return Integer.MIN_VALUE;
                }

                num = num * 10 + digit;
            }

            if (isNegative) {
                num = -num;
            }
        }

        return num;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Str2Int str2Int = new Str2Int();
        System.out.println(str2Int.atoi(""));
        System.out.println(str2Int.atoi("+1"));
        System.out.println(str2Int.atoi("      10"));
        System.out.println(str2Int.atoi("-10"));
        System.out.println(str2Int.atoi("101 is highway"));
        System.out.println(str2Int.atoi("This is a number 10."));
        System.out.println(str2Int.atoi("-2147483648"));
        System.out.println(str2Int.atoi("-91283472332"));
    }

}
