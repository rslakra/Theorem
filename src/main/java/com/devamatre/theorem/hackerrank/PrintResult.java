package com.devamatre.theorem.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 10:07:24 AM
 */
public class PrintResult {

    /**
     * @param size
     * @param values
     */
    public static void printResults(int size, int[] values) {
        int[] fractions = new int[3];
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0) {
                fractions[0] += 1;
            } else if (values[i] < 0) {
                fractions[1] += 1;
            } else {
                fractions[2] += 1;
            }
        }

        float positive = fractions[0] / (float) size;
        float negative = fractions[1] / (float) size;
        float zeros = fractions[2] / (float) size;
        System.out.printf("%.6f\n", positive);
        System.out.printf("%.6f\n", negative);
        System.out.printf("%.6f\n", zeros);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // read values
        int[] values = new int[n];
        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        scanner.close();
        printResults(n, values);

        int[] arr = {3, 4, 6, 2, 7};
        Arrays.sort(arr);
    }

}
