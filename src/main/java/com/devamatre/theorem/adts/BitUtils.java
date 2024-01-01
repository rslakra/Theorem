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

public enum BitUtils {

    INSTANCE;

    /**
     * Get bit is used to know whether the bit is 0 or 1 at any position.
     * Returns the 0 or 1 bit of the <code>number</code> at the provided <code>position</code>.
     * <p>
     * For example, we have the number 5 (0101),we check the position from the right side.
     * <p>
     * For example, the indexing starts from the right size:
     * <pre>
     *  Number (5) = |0|1|0|1|
     *  Positions  = |3|2|1|0|
     * </pre>
     *
     * @param number
     * @param position
     * @return
     */
    public static Integer getBit(Integer number, Integer position) {
        // create bitMask with position
        Integer bitMask = 1 << position;
        // do AND operation with bitMask and number
        return (bitMask & number);
    }

    /**
     * Returns true if the bit of the <code>number</code> at the provided <code>position</code> is 1 otherwise false.
     *
     * <url>https://stackoverflow.com/a/77740833/2171938</url>
     *
     * @param number
     * @param position
     * @return
     */
    public static boolean isSetBit(Integer number, Integer position) {
        return (getBit(number, position) != 0);
    }

    /**
     * Set bit is used to set the bit as 1 at any position.
     * <p>
     * The bit to be set of the <code>number</code> at the provided <code>position</code> to 1.
     *
     * @param number
     * @param position
     * @return
     */
    public static Integer setBit(Integer number, Integer position) {
        // create bitMask with position
        Integer bitMask = 1 << position;
        // do OR operation with bitMask and number
        return (bitMask | number);
    }

    /**
     * Clear bit is used to set the bit as 0 at any position.
     * <p>
     * Clears the bit of the <code>number</code> at the provided <code>position</code>.
     *
     * @param number
     * @param position
     * @return
     */
    public static Integer clearBit(Integer number, Integer position) {
        // create bitMask with position
        Integer bitMask = 1 << position;
        // negate bitMask
        Integer negateBitMask = ~(bitMask);
        // do AND operation with negateBitMask and number
        return (negateBitMask & number);
    }

    /**
     * Update bit is used to toggle the bit at any position from 0 to 1 or vice-versa.
     * <p>
     * Updates the bit to be set of the <code>number</code> at the provided <code>position</code>.
     *
     * @param number
     * @param position
     * @return
     */
    public static Integer updateBit(Integer number, Integer position, Integer operation) {
        // create bitMask with position
        Integer bitMask = 1 << position;
        if (operation == 1) {
            return (bitMask | number);
        } else {
            // negate bitMask
            Integer negateBitMask = ~(bitMask);
            // do AND operation with negateBitMask and number
            return (negateBitMask & number);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        int a = 1;
        int b = 2;
        int c = 3;

        System.out.println("a&b: " + (a & b));
        System.out.println("a&c: " + (a & c));
        System.out.println("b&c: " + (b & c));
        System.out.println();

        System.out.println("a|b: " + (a | b));
        System.out.println("a|c: " + (a | c));
        System.out.println("b|c: " + (b | c));
        System.out.println();

        System.out.println("a>>b: " + (a >> b));
        System.out.println("a>>c: " + (a >> c));
        System.out.println("b>>c: " + (b >> c));
        System.out.println();

        System.out.println("a<<b: " + (a << b));
        System.out.println("a<<c: " + (a << c));
        System.out.println("b<<c: " + (b << c));
        System.out.println();

        int d = 2;
        d |= a;
        System.out.println("d|=a: " + d);
        d |= b;
        System.out.println("d|=b: " + d);
        d |= c;
        System.out.println("d|=c: " + d);
        System.out.println();

    }

}
