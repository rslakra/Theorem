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
package com.rslakra.theorem.algos.lang;

import java.util.Scanner;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-10-17 08:04:39 PM
 * @since 1.0.0
 */
public class CommonFactors {

    /**
     * @param nominator
     * @param denominator
     * @return
     */
    public static int greatestCommonDivisor(int nominator, int denominator) {
        if (denominator == 0) {
            return nominator;
        } else {
            return greatestCommonDivisor(denominator, nominator % denominator);
        }
    }

    /**
     * @param nominator
     * @param denominator
     * @return
     */
    public static int highestCommonFactor(int nominator, int denominator) {
        int commonFactor = denominator == 0 ? nominator : denominator;
        while (denominator != 0) {
            if (nominator % denominator == 0) {
                break;
            }
            commonFactor = nominator % denominator;
            nominator = denominator;
            denominator = commonFactor;
        }

        return commonFactor;
    }

    /**
     * Formula:
     * <p>
     * LCM(a, b) = a * b / GCD(a, b)
     *
     * @param nominator
     * @param denominator
     * @return
     */
    public static int leastCommonDenominator(int nominator, int denominator) {
        return (nominator * denominator / greatestCommonDivisor(nominator, denominator));

    }

    /**
     * For Example:
     * <pre>
     *  6 4 12 8 30 15 54 24 84 18 108 24
     * </pre>
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int divisible = in.nextInt();
        int divisor = in.nextInt();
        in.close();
        System.out.println("GCF of " + divisible + " and " + divisor);
        System.out.println(greatestCommonDivisor(divisible, divisor));
        System.out.println(highestCommonFactor(divisible, divisor));
        System.out.println();
        System.out.println("LCM of " + divisible + " and " + divisor);
        System.out.println(leastCommonDenominator(divisible, divisor));

    }

}
