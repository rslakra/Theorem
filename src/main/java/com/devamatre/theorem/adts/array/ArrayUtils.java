package com.devamatre.theorem.adts.array;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 12/08/2017 9:55 PM
 */
public enum ArrayUtils {
    INSTANCE;

    /**
     * Prints the single dimension array.
     *
     * @param data
     */
    public static <E> void printMatrix(E[] data) {
        System.out.print(Arrays.toString(data));
    }

    /**
     * Prints the two-dimensional array.
     *
     * @param data
     */
    public static <E> void printMatrix(E[][] data) {
        for (int i = 0; i < data.length; i++) {
            printMatrix(data[i]);
            System.out.println();
        }
    }

    /**
     * Prints the <code>data</code> diagonally.
     *
     * @param data
     */
    public static <E> void printDiagonally(E[][] data) {
        // print left to bottom.
        for (int row = 0; row < data.length; row++) {
            for (int i = 0; i < ((data.length * 2) - row); i++) {
                System.out.print(" ");
            }
            for (int column = 0; column <= row; column++) {
                if (row == 0 || column == 0) {
                    System.out.print(data[row][column] + " ");
                } else {
                    System.out.print(data[row - column][column] + " ");
                }
            }
            System.out.println();
        }
    }
}
