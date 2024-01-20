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
package com.devamatre.theorem.adts.lang;

import com.devamatre.appsuite.core.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(Maths.class);

    // number to english mappings.
    private final Map<Integer, String>[] textDigits = new HashMap[3];
    private final Map<Integer, String> textPlaceValues = new HashMap<>();

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

        textPlaceValues.put(2, " ");
        textPlaceValues.put(3, "Hundred");
        textPlaceValues.put(4, "Thousand");
        textPlaceValues.put(7, "Million");
        textPlaceValues.put(10, "Billion");
        textPlaceValues.put(13, "Trillion");
        textPlaceValues.put(16, "Quadrillion");
        textPlaceValues.put(19, "Quintillion");
        textPlaceValues.put(22, "Sextillion");
        textPlaceValues.put(25, "Septillion");
        textPlaceValues.put(28, "Octillion");
        textPlaceValues.put(31, "Nonillion");
        textPlaceValues.put(34, "Decillion");
        textPlaceValues.put(37, "Undecillion");
        textPlaceValues.put(40, "Duodecillion");
        textPlaceValues.put(43, "Tredecillion");
        textPlaceValues.put(46, "Quatttuor-decillion");
        textPlaceValues.put(49, "Quindecillion");
        textPlaceValues.put(52, "Sexdecillion");
        textPlaceValues.put(55, "Septen-decillion");
        textPlaceValues.put(58, "Octodecillion");
        textPlaceValues.put(61, "Novemdecillion");
        textPlaceValues.put(64, "Vigintillion");
        textPlaceValues.put(304, "Centillion");
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
        return INSTANCE.textPlaceValues.get(digit);
    }

    /**
     * @param digit
     * @return
     */
    public static boolean hasPlaceValue(int digit) {
        return INSTANCE.textPlaceValues.containsKey(digit);
    }

    /**
     * Returns the number of digits in the number.
     *
     * @param number
     * @return
     */
    public static int countDigits(long number) {
        return (int) Math.log10(number) + 1;
    }

    /**
     * Returns the power of the <code>number</code> to the <code>exponent</code>.
     *
     * @param number
     * @param exponent
     * @return
     */
    public static double power(long number, int exponent) {
        LOGGER.debug("power({}, {})", number, exponent);
        return (exponent > 0 ? number * power(number, exponent - 1) : 1);
    }

    /**
     * @param number
     * @param exponent
     * @return
     */
    public static double powerRecursively(long number, int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (number == 0) {
            return 0;
        }

        return number * powerRecursively(number, exponent - 1);
    }

    /**
     * @param number
     * @param exponent
     * @return
     */
    public static double powerLog2Recursively(long number, int exponent) {
        LOGGER.debug("powerLog2Recursively({}, {})", number, exponent);
        if (exponent == 0) {
            return 1.0d;
        } else if (number == 0) {
            return 0.0d;
        } else if ((number & 1) != 0) { // if x is even
            return number * powerLog2Recursively(number, exponent / 2) * powerLog2Recursively(number, exponent / 2);
        }

        return powerLog2Recursively(number, exponent / 2) * powerLog2Recursively(number, exponent / 2);
    }

    /**
     * Returns the power of the <code>number</code> to the <code>exponent</code>.
     * <p>
     * Time Complexity: O(log 2 (N))
     * <p>
     * Binary exponentiation approach, the loop iterated for only 4 times which is nothing but (O log2(N) + 1) ~ (O
     * log2(N))
     *
     * @param number
     * @param exponent
     * @return
     */
    public static double powOptimized(long number, int exponent) {
        LOGGER.debug("+powOptimized({}, {})", number, exponent);
        double power = 1.0;
        // handle negative exponents
        if (exponent < 0) {
            exponent = -exponent;
            number = 1 / number;
        }

        // binary optimization approach
        while (exponent != 0) {
            // equivalent to exponent % 2 == 0
            // multiply only when the number is odd
            if ((exponent & 1) != 0) {
                power *= number;
            }

            number *= number;
            // equivalent to n = n / 2. keep dividing the number by 2
            // logical shift operator, unsigned right shift
            exponent >>>= 1;
        }

        LOGGER.debug("-powOptimized(), power:{}", power);
        return power;
    }

    /**
     * Returns the power of the <code>number</code> to the <code>exponent</code>.
     *
     * @param number
     * @param exponent
     * @return
     */
    public static String toStringPower(long number, int exponent) {
        return BigInteger.valueOf(number).pow(exponent).toString();
        // return (BigInteger.valueOf(number).shiftLeft(exponent).toString());
    }

    /**
     * find if a number is a power of 2 or not.
     *
     * @return
     */
    public static boolean isPowerOf2(long number) {
        if (number <= 0) {
            return false;
        } else if (number == 1) {
            return true;
        }

        while (number > 1) {
            if (number % 2 == 0) {
                number = number / 2;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns true if the number is power of 2 or not.
     *
     * @param number
     * @return
     */
    public static boolean isPowerOf2Optimized(long number) {
        // negate (number & number - 1)
        long negate = ~(number & number - 1);
        // compare number == number & negate
        return (number == (number & negate));
    }

    /**
     * @param nominator
     * @param denominator
     * @return
     */
    public static int gcd(int nominator, int denominator) {
        //repeat until both are not same
        while (nominator != denominator) {
            // replace the larger number by its difference with the smaller number
            if (nominator < denominator) {
                denominator = denominator - nominator;
            } else {
                nominator = nominator - denominator;
            }
        }

        return nominator; // or return second as both are same
    }

    /**
     * @param nominator
     * @param denominator
     * @return
     */
    public static int gcdEuclidean(int nominator, int denominator) {
        // swap numbers if nominator < denominator
        if (nominator < denominator) {
            int temp = nominator;
            nominator = denominator;
            denominator = temp;
        }

        // repeat until the remainder is not zero
        while (denominator != 0) {
            int remainder = nominator % denominator;
            // swap nominator with denominator, and the latter with remainder
            nominator = denominator;
            denominator = remainder;
        }

        return nominator;
    }

    /**
     * @param nominator
     * @param denominator
     * @return
     */
    public static int gcdEuclideanRecursively(int nominator, int denominator) {
        // exist point
        if (denominator == 0) {
            return nominator;
        }

        // swap numbers if nominator < denominator
        if (nominator < denominator) {
            int temp = nominator;
            nominator = denominator;
            denominator = temp;
        }

        int remainder = nominator % denominator;
        // swap nominator with denominator, and the latter with remainder
        nominator = denominator;
        denominator = remainder;

        // repeat until the remainder is not zero
        return gcdEuclideanRecursively(nominator, denominator);
    }

    /**
     * Greatest Common Divisor (GCD)
     *
     * @param nominator
     * @param denominator
     * @return
     */
    public static int gcdRecursively(int nominator, int denominator) {
        return (denominator == 0 ? nominator : gcdRecursively(denominator, nominator % denominator));
    }

    /**
     * @param value
     * @return
     */
    public static int[] gcm(int value) {
        return null;
    }

}
