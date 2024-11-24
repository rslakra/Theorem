package com.rslakra.theorem.hackerrank;

import java.util.Random;

/**
 * @author Rohtash Singh Lakra
 * @created 09/21/2017 12:33:20 PM
 */
public class AngryProfessorTest {

    static final Random RANDOM = new Random();

    public static int genRandom(int min, int max) {
        return (RANDOM.nextInt(max) + -min);
    }

    public static void main(String[] args) {
        int t = 5;
        Random nRandom = new Random();
        Random kRandom = new Random();
        for (int i = 1; i <= t; i++) {
            System.out.println(i);
            for (int j = 0; j < i; j++) {
                int n = nRandom.nextInt(50);
                int k = kRandom.nextInt(n / 2);
                System.out.println(n + " " + k);
                for (int m = 1; m <= n; m++) {
                    System.out.print(genRandom(m, n) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
