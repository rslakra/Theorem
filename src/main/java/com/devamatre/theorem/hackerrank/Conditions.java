package com.devamatre.theorem.hackerrank;

import java.util.Scanner;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 10:05:46 AM
 */
public class Conditions {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        scan.close();

        if (number % 2 == 0) {
            if (number >= 2 && number <= 5) {
                System.out.println("Not Weird");
            } else if (number >= 6 && number <= 20) {
                System.out.println("Weird");
            } else if (number > 20) {
                System.out.println("Not Weird");
            }
        } else {
            System.out.println("Weird");
        }
    }

}
