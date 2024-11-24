package com.rslakra.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 02:44:18 PM
 */
public class DivisibleSumPairs {

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int sumPairs = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                if ((ar[i] + ar[j]) % k == 0) {
                    sumPairs++;
                }
            }
        }

        return sumPairs;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        in.close();

        int result = divisibleSumPairs(n, k, ar);
        System.out.println(result);
    }

}
