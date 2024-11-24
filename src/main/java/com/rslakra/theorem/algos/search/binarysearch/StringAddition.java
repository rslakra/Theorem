package com.rslakra.theorem.algos.search.binarysearch;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Jan 23, 2021 14:09:45
 */
public class StringAddition {

    /**
     * @param index
     * @return
     */
    private int toInt(String str, int index) {
        return str.charAt(index) - '0';
    }

    /**
     * https://binarysearch.com/problems/String-Addition
     *
     * @param a
     * @param b
     * @return
     */
    public String solve(String a, String b) {
        int[] sum = new int[(a.length() > b.length() ? a.length() : b.length()) + 1];
        if (a.length() > b.length()) {
            sum = solve(sum, b, a);
        } else {
            sum = solve(sum, a, b);
        }

        if (sum[0] == 0) {
            sum = Arrays.copyOfRange(sum, 1, sum.length);
        }

        String str = Arrays.toString(sum);
        str = str.replace(", ", "");
        str = str.substring(1, str.length() - 1);
        return str;
    }

    /**
     * @param sum
     * @param small
     * @param large
     * @return
     */
    public int[] solve(int[] sum, String small, String large) {
        int lIndex = large.length();
        int sIndex = small.length();
        for (; lIndex > 0 && sIndex > 0; lIndex--, sIndex--) {
            int total = sum[lIndex] + toInt(large, lIndex - 1) + toInt(small, sIndex - 1);
            sum[lIndex] = total % 10;
            sum[lIndex - 1] = total / 10;
        }

        while (lIndex > 0) {
            int total = sum[lIndex] + toInt(large, lIndex - 1);
            sum[lIndex] = total % 10;
            sum[lIndex - 1] = total / 10;
            lIndex--;
        }

        return sum;
    }


    public static void main(String[] args) {
        StringAddition stringAddition = new StringAddition();
        String a = "13";
        String b = "33";
        System.out.println(a + " + " + b + " = " + stringAddition.solve(a, b));
        System.out.println();

        a = "93";
        b = "39";
        System.out.println(a + " + " + b + " = " + stringAddition.solve(a, b));
        System.out.println();

        a = "9999";
        b = "999";
        System.out.println(a + " + " + b + " = " + stringAddition.solve(a, b));
        System.out.println();

        a = "39876";
        b = "39";
        System.out.println(a + " + " + b + " = " + stringAddition.solve(a, b));
        System.out.println();

    }
}
