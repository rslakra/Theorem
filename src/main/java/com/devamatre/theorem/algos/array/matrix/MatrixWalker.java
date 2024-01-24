package com.devamatre.theorem.matrix;

import java.util.Arrays;

/**
 * You are given a matrix represented by an r x c two-dimensional array of integers. Starting at the root matrix[row =
 * 0][column = 0] and walking from the perimeter of the matrix towards the center, you want to touch each element once
 * in the matrix by traversing it clockwise in spiral order. Return a 1-dimensional array of all the elements from the
 * matrix in the order you visited them.
 * <p>
 * Write a function walkMatrix that takes an r x c 2D array and returns a 1D array of all the elements in the matrix
 * printed in clockwise order.
 * <p>
 * Note: Do not consider the result array when calculating your space complexity.
 * <p>
 * // Input const matrix = [ [0, 1, 2, 3], [11, 12, 13, 4], [10, 15, 14, 5], [9, 8, 7, 6], ];
 * <p>
 * // Output: walkMatrix(matrix) [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 4/5/23 9:48 PM
 * <p>
 * Apr 05, 2023 21:48:11
 */
public class MatrixWalker {

    public int[] walkMatrix(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int startRow = 0;
        int endRow = rowCount - 1;
        int startColumn = 0;
        int endColumn = colCount - 1;
        int[] result = new int[rowCount * colCount];
        int index = 0;

        // repeat till your walk around
        while (endRow >= startRow && endColumn >= startColumn) {

            // walk 1st row
            for (int column = startColumn; column <= endColumn; column++) {
                result[index++] = matrix[startRow][column];
            }
            startRow++;

            // walk endColumn
            for (int row = startRow; row <= endRow; row++) {
                result[index++] = matrix[row][endColumn];
            }
            endColumn--;

            // walk endRow
            if (endRow >= startRow) {
                for (int column = endColumn; column >= startColumn; column--) {
                    result[index++] = matrix[endRow][column];
                }
            }
            endRow--;

            // walk firstColumn
            if (endColumn >= startColumn) {
                for (int row = endRow; row >= startRow; row--) {
                    result[index++] = matrix[row][startColumn];
                }
            }
            startColumn++;
        }

        return result;
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        MatrixWalker matrixWalker = new MatrixWalker();
        int[][] matrix =
            {
                {0, 1, 2, 3},
                {11, 12, 13, 4},
                {10, 15, 14, 5},
                {9, 8, 7, 6}
            };
        int[] result = matrixWalker.walkMatrix(matrix);
        System.out.println(Arrays.toString(result));
    }
}
