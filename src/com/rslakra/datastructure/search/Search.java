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
package com.rslakra.datastructure.search;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 02/18/2017 01:36:46 PM
 *
 */
public class Search {

	/**
	 * 
	 * @param values
	 * @param what
	 * @return
	 */
	public static int binarySearch(int[] values, int lowIndex, int highIndex, int what) {
		if (highIndex > lowIndex) {
			int midIndex = lowIndex + (highIndex - lowIndex) / 2;
			if (what > values[midIndex]) {
				return binarySearch(values, midIndex + 1, highIndex, what);
			} else if (what < values[midIndex]) {
				return binarySearch(values, lowIndex, midIndex, what);
			} else {
				return midIndex;
			}
		}

		return (what == values[highIndex] ? highIndex : -1);
	}

	public static void main(String[] args) {
		int[] values = { 2, 4, 6, 9, 11, 38 };
		System.out.println(binarySearch(values, 0, values.length - 1, 11));

	}

}
