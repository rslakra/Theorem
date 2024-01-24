package com.devamatre.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 09/20/2017 04:37:07 PM
 */
public class AngryProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int teseCases = in.nextInt();
        for (int i = 0; i < teseCases; i++) {
            int totalStudents = in.nextInt();
            int minStudents = in.nextInt();
            int[] arrivalTimes = new int[totalStudents];
            for (int j = 0; j < arrivalTimes.length; j++) {
                arrivalTimes[j] = in.nextInt();
            }

            // output logic
            int total = 0;
            for (int j = 0; j < arrivalTimes.length; j++) {
                // arrived early or on time.
                if (arrivalTimes[j] <= 0) {
                    total++;
                }
            }

            if (total >= minStudents) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
        in.close();
    }

}
