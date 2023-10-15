/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code, in source 
 * and binary forms, with or without modification, are permitted provided 
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 * 	  notice, this list of conditions and the following disclaimer.
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
package com.rslakra.algorithms;

/**
 * The Fibonacci sequence is a series of numbers where a number is found by
 * adding up the two numbers before it. Starting with 0 and 1, the sequence goes
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, and so forth.
 * 
 * Written as a rule, the expression is xn = xn-1 + xn-2.
 * 
 * @author Rohtash Singh Lakra
 * @date 11/03/2016 02:13:54 PM
 *
 */
public final class FibonacciaSeries {

	/**
	 * 
	 * @param number
	 */
	public void generateFibonacciaSeries(int number) {
		if (number > 0) {
			int first = 0;
			int next = 1;
			System.out.println("Fibonaccia series for:" + number);
			System.out.println(first);
			System.out.println(next);
			int sum = 0;
			for (int i = 0; i < number - 2; i++) {
				sum = next + first;
				first = next;
				next = sum;
				System.out.println(sum);
			}
		} else {
			System.out.println("Invalid Number! number:" + number);
		}
	}

	/**
	 * 
	 * @param number
	 */
	public int recursiveFibonacciaSeries(int number) {
		if (number == 0) {
			return 0;
		} else if (number == 1) {
			return 1;
		} else {
			return (recursiveFibonacciaSeries(number - 1) + recursiveFibonacciaSeries(number - 2));
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		FibonacciaSeries fSeries = new FibonacciaSeries();
		int number = 10;
		fSeries.generateFibonacciaSeries(number);
		System.out.println();
		System.out.println(fSeries.recursiveFibonacciaSeries(number));
	}

}
