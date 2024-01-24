package com.devamatre.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 10:05:00 AM
 */
public class SumMatrixDiagonals {

    /**
     * @param rows
     * @param columns
     * @param matrix
     * @return
     */
    public static int[] sumsOfMatrixDiagonals(int rows, int columns, int[][] matrix) {
        int[] diagonals = new int[2];
        // sum of 1st diagonal
        for (int i = 0, j = 0; i < rows && j < columns; i++, j++) {
            diagonals[0] += matrix[i][j];
        }

        // sum of 2st diagonal
        for (int i = 0, j = columns - 1; i < rows && j >= 0; i++, j--) {
            diagonals[1] += matrix[i][j];
        }

        return diagonals;
    }

    /**
     * @param rows
     * @param columns
     * @param matrix
     */
    public static void printResults(int rows, int columns, int[][] matrix) {
        int[] diagonals = sumsOfMatrixDiagonals(rows, columns, matrix);
        int result = Math.abs(diagonals[0] - diagonals[1]);
        System.out.println(result);
    }

    /**
     * @param rows
     * @param columns
     * @param matrix
     */
    public static void printValues(int rows, int columns, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter No. of Rows/Columns:");
        int rows = scanner.nextInt();
        int columns = rows;

        // read matrix
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT.
         * Your class should be named Solution.
         */
        printValues(rows, columns, matrix);
        printResults(rows, columns, matrix);
    }
}
