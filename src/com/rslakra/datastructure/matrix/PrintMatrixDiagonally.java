/******************************************************************************
 * Copyright (C) Devamatre Technologies 2017
 * 
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 * 
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
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
