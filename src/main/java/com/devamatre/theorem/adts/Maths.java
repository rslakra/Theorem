/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code, in source
 * and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.adts;

import com.devamatre.appsuite.core.BeanUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra
 * @created 05/15/2017 01:24:49 PM
 */
public enum Maths {

    INSTANCE;
    public static final String SPACE = " ";

    public static final BigDecimal ZERO = BigDecimal.ZERO;
    public static final BigDecimal ONE = BigDecimal.ONE;
    public static final BigDecimal TWO = BigDecimal.valueOf(2);
    public static final BigDecimal THREE = BigDecimal.valueOf(3);
    public static final BigDecimal FOUR = BigDecimal.valueOf(4);
    public static final BigDecimal FIVE = BigDecimal.valueOf(5);
    public static final BigDecimal SIX = BigDecimal.valueOf(6);
    public static final BigDecimal SEVEN = BigDecimal.valueOf(7);
    public static final BigDecimal EIGHT = BigDecimal.valueOf(8);
    public static final BigDecimal NINE = BigDecimal.valueOf(9);
    public static final BigDecimal TEN = BigDecimal.TEN;
    public static final BigDecimal FIFTEEN = BigDecimal.valueOf(15);
    public static final BigDecimal TWENTY = BigDecimal.valueOf(20);
    public static final BigDecimal TWENTY_FIVE = BigDecimal.valueOf(25);
    public static final BigDecimal THIRTY = BigDecimal.valueOf(30);
    public static final BigDecimal FORTY = BigDecimal.valueOf(40);
    public static final BigDecimal FIFTY = BigDecimal.valueOf(50);
    public static final BigDecimal SIXTY = BigDecimal.valueOf(60);

    // number to english mappings.
    private final Map<Integer, String>[] textDigits = new HashMap[3];
    private final Map<Integer, String> placeValues = new HashMap<>();

    Maths() {
        for (int i = 0; i < textDigits.length; i++) {
            textDigits[i] = new HashMap<>(10);
        }
        //  textDigits[0] = units
        textDigits[0].put(0, "Zero");
        textDigits[0].put(1, "One");
        textDigits[0].put(2, "Two");
        textDigits[0].put(3, "Three");
        textDigits[0].put(4, "Four");
        textDigits[0].put(5, "Five");
        textDigits[0].put(6, "Six");
        textDigits[0].put(7, "Seven");
        textDigits[0].put(8, "Eight");
        textDigits[0].put(9, "Nine");

        //  textDigits[1] = tens - fully divisible
        textDigits[1].put(0, "");
        textDigits[1].put(1, "Ten");
        textDigits[1].put(2, "Twenty");
        textDigits[1].put(3, "Thirty");
        textDigits[1].put(4, "Forty");
        textDigits[1].put(5, "Fifty");
        textDigits[1].put(6, "Sixty");
        textDigits[1].put(7, "Seventy");
        textDigits[1].put(8, "Eighty");
        textDigits[1].put(9, "Ninety");

        //  textDigits[2] = tens - fully not divisible
        textDigits[2].put(0, "");
        textDigits[2].put(1, "Eleven");
        textDigits[2].put(2, "Twelve");
        textDigits[2].put(3, "Thirteen");
        textDigits[2].put(4, "Fourteen");
        textDigits[2].put(5, "Fifteen");
        textDigits[2].put(6, "Sixteen");
        textDigits[2].put(7, "Seventeen");
        textDigits[2].put(8, "Eighteen");
        textDigits[2].put(9, "Nineteen");

        placeValues.put(2, " ");
        placeValues.put(3, "Hundred");
        placeValues.put(4, "Thousand");
        placeValues.put(7, "Million");
        placeValues.put(10, "Billion");
        placeValues.put(13, "Trillion");
        placeValues.put(16, "Quadrillion");
        placeValues.put(19, "Quintillion");
        placeValues.put(22, "Sextillion");
        placeValues.put(25, "Septillion");
        placeValues.put(28, "Octillion");
        placeValues.put(31, "Nonillion");
        placeValues.put(34, "Decillion");
        placeValues.put(37, "Undecillion");
        placeValues.put(40, "Duodecillion");
        placeValues.put(43, "Tredecillion");
        placeValues.put(46, "Quatttuor-decillion");
        placeValues.put(49, "Quindecillion");
        placeValues.put(52, "Sexdecillion");
        placeValues.put(55, "Septen-decillion");
        placeValues.put(58, "Octodecillion");
        placeValues.put(61, "Novemdecillion");
        placeValues.put(64, "Vigintillion");
        placeValues.put(304, "Centillion");
    }

    /**
     * Returns true if the
     *
     * @param element
     * @param <E>
     * @return
     */
    public static <E extends Comparable<? super E>> boolean isEmptyOrMinusOne(E element) {
        if (BeanUtils.isEmpty(element)) { // is null/empty data
            return true;
        } else if (BeanUtils.isKindOf(element, Integer.class)
                   && ((Integer) element).compareTo(-1) == 0) { // is data -1 integer.
            return true;
        }

        return false;
    }

    /**
     * Returns the english units based on the provided digit.
     *
     * @param digit
     * @return
     */
    public static String getDigits(int digit) {
        return INSTANCE.textDigits[0].get(digit);
    }

    /**
     * Returns the english tens based on the provided digit.
     *
     * @param digit
     * @return
     */
    public static String getDigits(int digit, boolean fullyDivisible) {
        return (fullyDivisible ? INSTANCE.textDigits[1].get(digit) : INSTANCE.textDigits[2].get(digit));
    }

    /**
     * Returns the english place value based on the provided digit.
     *
     * @param digit
     * @return
     */
    public static String getPlaceValue(int digit) {
        return INSTANCE.placeValues.get(digit);
    }

    /**
     * @param digit
     * @return
     */
    public static boolean hasPlaceValue(int digit) {
        return INSTANCE.placeValues.containsKey(digit);
    }

    /**
     * @param first
     * @param second
     * @return
     */
    public static int gcd(int first, int second) {
        //repeat until both are not same
        while (first != second) {
            // replace the larger number by its difference with the smaller number
            if (first < second) {
                second = second - first;
            } else {
                first = first - second;
            }
        }

        return first; // or return second as both are same
    }

    /**
     * @param first
     * @param second
     * @return
     */
    public static int gcdEuclidean(int first, int second) {
        // swap numbers if first < second
        if (first < second) {
            int temp = first;
            first = second;
            second = temp;
        }

        // repeat until the remainder is not zero
        while (second != 0) {
            int remainder = first % second;
            // swap first with second, and the latter with remainder
            first = second;
            second = remainder;
        }

        return first;
    }


    /**
     * @param first
     * @param second
     * @return
     */
    public static int gcdEuclideanRecursively(int first, int second) {
        // exist point
        if (second == 0) {
            return first;
        }

        // swap numbers if first < second
        if (first < second) {
            int temp = first;
            first = second;
            second = temp;
        }

        int remainder = first % second;
        // swap first with second, and the latter with remainder
        first = second;
        second = remainder;

        // repeat until the remainder is not zero
        return gcdEuclideanRecursively(first, second);
    }


    /**
     * @param disk
     * @param source
     * @param target
     * @param auxilary
     */
    public static void powerOfHanoi(int disk, int[] source, int[] target, int[] auxilary) {
        if (disk == 1) {

        }
    }

    /**
     * Returns the power of the number.
     *
     * @param number
     * @param exponent
     * @return
     */
    public static double power(int number, int exponent) {
        System.out.println("power(" + number + ", " + exponent + ")");
        return (exponent > 0 ? number * power(number, exponent - 1) : 1);
    }

    /**
     * @param number
     * @param exponent
     * @return
     */
    public static String pow(int number, int exponent) {
        return BigInteger.valueOf(number).pow(exponent).toString();
        // return (BigInteger.valueOf(number).shiftLeft(exponent).toString());
    }

    public static int[] gcm(int value) {
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int number = 2;
        int pow = 128;
        System.err.println("Power " + pow + " of " + number + "=" + Maths.power(number, pow));
        System.err.println("Power " + pow + " of " + number + "=" + Maths.pow(number, pow));

    }

}
