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
package com.devamatre.theorem.algos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An animated solution of the Tower of Hanoi puzzle for T(4,3). The Tower of Hanoi (also called the Tower of Brahma or
 * Lucas' Tower, and sometimes pluralized) is a mathematical game or puzzle. It consists of three rods, and a number of
 * disks of different sizes which can slide onto any rod. For Example: * * * * *
 * <p>
 * https://en.wikipedia.org/wiki/Tower_of_Hanoi
 *
 * @author Rohtash Lakra
 * @created 11/03/2016 02:31:05 PM
 */
public class TowerOfHanoi {

    // LOGGER
    private static final Logger LOGGER = LoggerFactory.getLogger(TowerOfHanoi.class);

    /**
     * Tower of Hanoi.
     *
     * @param disks
     * @param A
     * @param B
     * @param C
     */
    public void towerOfHanoi(int disks, int A, int B, int C) {
        if (disks > 0) {
            towerOfHanoi(disks - 1, A, C, B);
            LOGGER.debug(String.format("Move disk from %d to %d", A, C));
            towerOfHanoi(disks - 1, B, A, C);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        TowerOfHanoi toh = new TowerOfHanoi();
        for (int i = 0; i < 10; i++) {
            LOGGER.debug("Tower of Hanoi with " + i + " disks.");
            toh.towerOfHanoi(i, 1, 2, 3);
            LOGGER.debug("\n");
        }
    }

}
