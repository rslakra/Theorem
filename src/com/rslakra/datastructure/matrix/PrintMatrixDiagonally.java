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
package com.rslakra.datastructure.matrix;

import java.util.Scanner;

/**
 * @author Rohtash Lakra (rohtash.lakra@devamatre.com)
 * @author Rohtash Singh Lakra (rohtash.singh@gmail.com)
 * @created 2017-10-08 04:27:35 PM
 * @version 1.0.0
 * @since 1.0.0
 */
public class PrintMatrixDiagonally {
	/**
	 * 
	 * @param matrix
	 */
	public static void printMatrixDiagonally(int[][] matrix) {
		// print top to bottom vertically.
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column <= row; column++) {
				if (column == 0) {
					System.out.print(matrix[row][column] + " ");
				} else {
					System.out.print(matrix[row - column][column] + " ");
				}
			}
		}

		// print mid to bottom vertically.
		for (int k = 1; k < matrix.length; k++) {
			int column = k;
			for (int row = matrix.length - 1; row > 0 && column < matrix.length; row--, column++) {
				System.out.print(matrix[row][column] + " ");
			}
		}
		System.out.println();
	}

	/**
	 * 
	 * @param matrix
	 */
	public static void printMatrixDiagonallyOptimized(int[][] matrix) {
		int size = matrix.length * 2 - 1;
		int row = 0;
		int column = 0;
		for (int i = 0; i < size; i++) {
			if (i < matrix.length) {
				row = i;
				column = 0;
			} else {
				row = matrix.length - 1;
				column = (i + 1) % matrix.length;
			}

			while (row >= 0 && column < matrix.length) {
				System.out.print(matrix[row][column] + " ");
				row--;
				column++;
			}
		}
		System.out.println();
	}

	/**
	 * 
	 * @param matrix
	 */
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		int[][] matrix = new int[n][n];
		int ctr = 1;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = ctr++;
			}
		}

		System.out.println();
		printMatrix(matrix);

		System.out.println();
		printMatrixDiagonally(matrix);
		printMatrixDiagonallyOptimized(matrix);
	}

}
