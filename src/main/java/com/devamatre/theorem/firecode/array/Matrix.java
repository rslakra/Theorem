/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.devamatre.theorem.firecode.array;

import java.util.ArrayList;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-11-05 11:46:59 AM
 * @since 1.0.0
 */
public class Matrix {

    /**
     * You are given a square 2D image matrix where each integer represents a pixel. Write a method transposeMatrix to
     * transform the matrix into its Transpose - in-place.
     * <p>
     * Example:Input image : 1 0 1 0 Modified to : 1 1 0 0
     *
     * @param matrix
     */
    public static void transposeMatrix(int[][] matrix) {
        if (matrix != null) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            for (int i = 0; i <= rows; i++) {
                for (int j = i + 1; j <= cols; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }

            }
        }
    }

    /**
     * You're given a 2D board which contains an m x n matrix of chars - char[][] board. Write a method - printPaths
     * that prints all possible paths from the top left cell to the bottom right cell. Your method should return an
     * ArrayList of Strings, where each String represents a path with characters appended in the order of movement.
     * You're only allowed to move down and right on the board. The order of String insertion in the ArrayList does not
     * matter.
     * <p>
     * <p>
     * Example:
     * <p>
     * Input Board : { {A, X}, {D, E} } Output: ["ADE", "AXE"]
     *
     * @param board
     * @return
     */
    public static ArrayList<String> printPaths(char[][] board) {
        ArrayList<String> paths = new ArrayList<>();
        StringBuilder sBuilder = new StringBuilder();
        search(board, 0, 0, sBuilder, paths);
        return paths;
    }

    public static void search(char[][] board, int i, int j, StringBuilder sBuilder, ArrayList<String> paths) {
        if (i > board.length - 1 || j > board[0].length - 1) {
            return;
        }

        sBuilder.append(board[i][j]);

        if (i == board.length - 1 && j == board[0].length - 1) {
            paths.add(sBuilder.toString());
            sBuilder.deleteCharAt(sBuilder.length() - 1);
            return;
        }

        search(board, i + 1, j, sBuilder, paths);
        search(board, i, j + 1, sBuilder, paths);
        sBuilder.deleteCharAt(sBuilder.length() - 1);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        char[][] board = new char[][]{{'a', 'x'}, {'d', 'e'}};
        System.out.println(printPaths(board));
    }

}
