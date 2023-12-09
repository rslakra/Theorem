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
        System.out.println(Arrays.toString(data));
    }

    /**
     * Prints the two-dimensional array.
     *
     * @param data
     */
    public static <E> void printMatrix(E[][] data) {
        for (int i = 0; i < data.length; i++) {
            printMatrix(data[i]);
        }
    }
}
