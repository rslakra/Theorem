package com.rslakra.theorem.algos.sort;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Jan 02, 2021 18:01:12
 */
public class LCDStringSort {

    public static final int RADIX256 = 256;

    /**
     * LSD string sort stably sorts fixed-length strings.
     * <p>
     * Sort a[] on leading W characters.
     *
     * @param strings
     * @param W
     * @param R
     */
    public static void sort(String[] strings, int W, int R) {
        int size = strings.length;
        String[] aux = new String[size];
        // Sort by key-indexed counting on dth char.
        for (int d = W - 1; d >= 0; d--) {
            // Compute frequency counts.
            int[] count = new int[R + 1];
            for (int i = 0; i < size; i++) {
                count[strings[i].charAt(d) + 1]++;
            }

            // Transform counts to indices.
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // Distribute.
            for (int i = 0; i < size; i++) {
                aux[count[strings[i].charAt(d)]++] = strings[i];
            }

            // Copy back.
            for (int i = 0; i < size; i++) {
                strings[i] = aux[i];
            }

        }
    }

    /**
     * LSD string sort stably sorts fixed-length strings.
     *
     * @param strings
     * @param W
     */
    public static void sort(String[] strings, int W) {
        sort(strings, W, RADIX256);
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] names = {"Lakra", "Kumar", "Malik"};
        System.out.println(Arrays.toString(names));
        sort(names, 5);
        System.out.println(Arrays.toString(names));
    }
}
