/**
 *
 */
package com.rslakra.theorem.leetcode.array;

/**
 * @author Rohtash Lakra
 */
public class LC62UniquePaths {

    /**
     * @param row
     * @param column
     * @return
     */
    public int findUniquePathsI(int row, int column) {
        int[][] matrix = new int[row][column];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                }
            }
        }

        return matrix[row - 1][column - 1];
    }

    /**
     * @param row
     * @param column
     * @return
     */
    public int findUniquePathsRecursion(int row, int column) {
        int[][] matrix = new int[row][column];
        if (matrix[0][0] == 0) {
            matrix[0][0] = findUniquePathsIRecursion(matrix, 0, 0);
        }

        return matrix[0][0];
    }

    /**
     * @param matrix
     * @param row
     * @param column
     * @return
     */
    public int findUniquePathsIRecursion(int[][] matrix, int row, int column) {
        if (row == matrix.length - 1 && column == matrix[0].length - 1) {
            if (matrix[row][column] == 0) {
                matrix[row][column] = 1;
            }

            return matrix[row][column];
        }

        return (matrix[row + 1][column] + matrix[row][column + 1]);
        // return findUniquePathsIRecursion(matrix, row + 1, column + 1);
    }

    /**
     * Problem #63
     * <p>
     * A com.devamatre.algorithms is located at the top-left corner of a m x n grid (marked 'Start' in the diagram
     * below).
     * <p>
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
     * corner of the grid (marked 'Finish' in the diagram below).
     * <p>
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     * <p>
     * <p>
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     * <p>
     * Note: m and n will be at most 100.
     * <p>
     * Example 1:
     * <p>
     * Input: [ [0,0,0], [0,1,0], [0,0,0] ] Output: 2 Explanation: There is one obstacle in the middle of the 3x3 grid
     * above. There are two ways to reach the bottom-right corner: 1. Right -> Right -> Down -> Down 2. Down -> Down ->
     * Right -> Right
     * <p>
     * [0 0] [1 1] [0 0]
     * <p>
     * <p>
     * [1 1] [0 0] [0 0]
     *
     * @param matrix
     * @return
     */
    public int findUniquePathsII(int[][] matrix) {
        if (matrix != null) {
            // step 1
            if (matrix[0][0] == 1) {
                return 0;
            }

            matrix[0][0] = 1;

            int rows = matrix.length;
            int cols = matrix[0].length;

            // step 2 - columns
            for (int i = 1; i < cols; i++) {
                if (matrix[0][i] == 1) {
                    matrix[0][i] = 0;
                } else {
                    matrix[0][i] = matrix[0][i - 1];
                }
            }

            // step 3 - row
            for (int i = 1; i < rows; i++) {
                if (matrix[i][0] == 1) {
                    matrix[i][0] = 0;
                } else {
                    matrix[i][0] = matrix[i - 1][0];
                }
            }

            // step 4 - remaining row and columns
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] == 1) {
                        matrix[i][j] = 0;
                    } else {
                        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                    }
                }
            }

            return matrix[rows - 1][cols - 1];
        }

        return 0;
    }

    /**
     * Problem #980
     *
     * @param matrix
     * @return
     */
    public int findUniquePathsIII(int[][] matrix) {
        if (matrix != null) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                }
            }
        }
        return 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        LC62UniquePaths paths = new LC62UniquePaths();
        System.out.println("Unique Paths - II");
        int row = 3;
        int column = 2;
        System.out.println(paths.findUniquePathsI(row, column));
        System.out.println(paths.findUniquePathsRecursion(row, column));
        System.out.println();
        row = 7;
        column = 3;
        System.out.println(paths.findUniquePathsI(row, column));
        System.out.println(paths.findUniquePathsRecursion(row, column));
        System.out.println();

        System.out.println("Unique Paths - II");
        /**
         * <code>
         * [0 0]
         * [1 1]
         * [0 0]
         * </code>
         */
        int[][] matrix = new int[][]{{0, 0}, {1, 1}, {0, 0}};
        System.out.println(paths.findUniquePathsII(matrix));
        System.out.println();
    }

}
