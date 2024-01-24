package com.devamatre.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 02:23:21 PM
 */
public class BirthdayChocolate {

    static int solve(int n, int[] squares, int day, int month) {
        int ways = 0;
        if (n <= 100 && day <= 31 && month <= 12) {
            for (int i = 0; i <= squares.length - month; i++) {
                int sum = 0;
                for (int j = i; j < (i + month); j++) {
                    sum += squares[j];
                }

                if (sum == day) {
                    ways++;
                }
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] squares = new int[n];
        for (int i = 0; i < n; i++) {
            squares[i] = in.nextInt();
        }
        int day = in.nextInt();
        int month = in.nextInt();
        in.close();

        int result = solve(n, squares, day, month);
        System.out.println(result);
    }

}
