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
package com.devamatre.theorem.algos.array;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 03/26/2017 05:34:02 PM
 */
public class MoveElements {

    /**
     * Moves all zero elements at the end and count non-zero elements.
     *
     * @param values
     * @return
     */
    public static int moveZerosAtEndAndCountNonZeroElements(int[] values) {
        int nonZeroElements = 0;
        if (values != null) {
            int lastIndex = values.length - 1;
            for (int i = 0; i < values.length; i++) {
                if (values[i] == 0) {
                    for (int j = lastIndex; j > i; j--) {
                        if (values[j] != 0) {
                            int temp = values[i];
                            values[i] = values[j];
                            values[j] = temp;
                            nonZeroElements++;
                            lastIndex = j;
                            break;
                        }
                    }
                } else {
                    nonZeroElements++;
                }
            }
        }

        return nonZeroElements;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // int[] values = { 0, 2, 6, 0, 3, -1, 8, -2, 0, 0 };
        // int[] values = { 0, 0, 3, -1, 8, -2};
        int[] values = {2, 6, 3, -1, 8, -2, 0, 0};
        System.out.println(Arrays.toString(values));
        System.out.println(moveZerosAtEndAndCountNonZeroElements(values));
        System.out.println(Arrays.toString(values));
    }

}
