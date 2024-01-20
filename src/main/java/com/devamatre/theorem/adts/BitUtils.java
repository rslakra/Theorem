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
     * Get bit is used to know whether the bit is 0 or 1 at any position. Returns the 0 or 1 bit of the
     * <code>number</code> at the provided <code>position</code>.
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
     * <p>
     * If the number has the 1 at the <code>position</code>, then it's called the number has the set bit.
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
        // take the operation and based on that perform operation
        return (operation == 1 ? setBit(number, position) : clearBit(number, position));
    }

    /**
     * Toggle a bit at the provided <code>position</code> of the provided <code>number</code>.
     *
     * @param number
     * @param position
     * @return
     */
    public static Integer toggleBitAtPosition(Integer number, Integer position) {
        return (isSetBit(number, position) ? clearBit(number, position) : setBit(number, position));
    }

    /**
     * Returns the result of & (AND) bitwise operation.
     *
     * @param left
     * @param right
     * @return
     */
    public static Integer andOf(Integer left, Integer right) {
        return (left & right);
    }

    /**
     * Returns the result of | (OR) bitwise operation.
     *
     * @param left
     * @param right
     * @return
     */
    public static Integer orOf(Integer left, Integer right) {
        return (left | right);
    }

    /**
     * Returns the result of << (left shift) bitwise operation.
     *
     * @param number
     * @param position
     * @return
     */
    public static Integer leftShift(Integer number, Integer position) {
        return (number << position);
    }

    /**
     * Returns the result of << (left shift) bitwise operation.
     *
     * @param number
     * @param position
     * @return
     */
    public static Integer rightShift(Integer number, Integer position) {
        return (number >> position);
    }

    /**
     * Performs the provided operation on the given values.
     *
     * @param operation
     * @param number
     * @param position
     * @return
     */
    public static Integer doOperation(String operation, Integer number, Integer position) {
        switch (operation) {
            case "&":
                return andOf(number, position);
            case "|":
                return orOf(number, position);
            case "<<":
                return leftShift(number, position);
            case ">>":
                return rightShift(number, position);
        }

        return 0;
    }

    /**
     * Returns the count of the number of 1’s in a binary representation of the number.
     *
     * @param number
     * @return
     */
    public static Integer countSetBits(Integer number) {
        int setBits = 0;
        for (int i = 0; i < 8; i++) {
            if (isSetBit(number, i)) {
                setBits++;
            }
        }

        return setBits;
    }

}
