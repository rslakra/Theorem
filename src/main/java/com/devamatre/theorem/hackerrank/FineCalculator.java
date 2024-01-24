package com.devamatre.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 09/20/2017 03:24:25 PM
 */
public class FineCalculator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int dayAcutal = in.nextInt();
        int monthActual = in.nextInt();
        int yearActual = in.nextInt();
        int dayExpected = in.nextInt();
        int monthExpected = in.nextInt();
        int yearExpected = in.nextInt();
        in.close();

        int fine = 0;
        if (yearActual > yearExpected) {
            fine = 10000;
        } else if (yearActual == yearExpected) {
            if ((monthActual - monthExpected) > 0) {
                fine = 500 * (monthActual - monthExpected);
            } else if ((dayAcutal - dayExpected) > 0) {
                fine = 15 * (dayAcutal - dayExpected);
            }
        }
        System.out.println(fine);

    }

}
