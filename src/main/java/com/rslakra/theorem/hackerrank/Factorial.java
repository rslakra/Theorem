package com.rslakra.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 10:06:14 AM
 */
public class Factorial {

    static int factorial(int n) {
        if (n > 1) {
            return (n * factorial(n - 1));
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = factorial(n);
        System.out.println(result);
        in.close();
    }

}
