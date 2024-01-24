package com.devamatre.theorem.hackerrank.array;

import java.util.Scanner;

public class LeftRotate {

    /**
     * @param in
     * @param values
     * @param n
     * @param k
     */
    public static void fillAndLeftRotate(final Scanner in, int[] values, int n, int k) {
        for (int i = 0; i < n; i++) {
            int index = (i + (n - k)) % n;
            values[index] = in.nextInt();
        }
    }

    /**
     * Rotate the elements of an array k times.
     *
     * @param values
     * @param k
     * @return
     */
    public static int[] leftRotation(int[] values, int k) {
        if (values.length > 0 && k > 0 && k < values.length) {
            // rotate
            int[] newValues = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                if ((i + k) < values.length) {
                    newValues[i] = values[i + k];
                } else {
                    newValues[i] = values[(i + k) - values.length];
                }
            }

            return newValues;
        }

        return values;
    }

    /**
     * @param values
     */
    public static void showResult(int[] values) {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i]);
                if (i < values.length - 1) {
                    System.out.print(" ");
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        final Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();

        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            // int index = (i + (n - k)) % n;
            values[i] = in.nextInt();
        }
        // fillAndLeftRotate(in, values, n, k);
        in.close();
        values = leftRotation(values, k);
        showResult(values);

    }

}
