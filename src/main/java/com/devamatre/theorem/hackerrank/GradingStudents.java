package com.devamatre.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 10:06:29 AM
 */
public class GradingStudents {

    static int roundToNearestUpper(int number, int multiplyOf, boolean toUpper) {
        double roundToNearest = Math.ceil(number - number % multiplyOf);
        return (int) (toUpper ? (roundToNearest + multiplyOf) : roundToNearest);
    }

    static int[] solve(int[] grades) {
        int[] results = new int[grades.length];
        // Complete this function
        // round process
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 38) {
                results[i] = grades[i];
            } else {
                // round to next multiply of 5.
                int round = roundToNearestUpper(grades[i], 5, true);
                if (round - grades[i] < 3) {
                    results[i] = round;
                } else {
                    results[i] = grades[i];
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            grades[i] = in.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
        in.close();
    }

}
