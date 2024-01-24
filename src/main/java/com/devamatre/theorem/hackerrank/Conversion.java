package com.devamatre.theorem.hackerrank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Rohtash Singh Lakra
 * @created 08/31/2017 10:05:59 AM
 */
public class Conversion {

    /**
     * In the same way that , a binary number having digits in the form of can be converted to decimal by summing the
     * result for each where , is the most significant bit, and is the least significant bit.
     *
     * @param number
     * @return
     */
    static int binaryToDecimal(int[] binaryNumber) {
        int number = 0;
        if (binaryNumber != null) {
            for (int i = 0; i < binaryNumber.length; i++) {
                number += (binaryNumber[binaryNumber.length - 1 - i] * (int) Math.pow(2, i));
            }
        }

        return number;
    }

    /**
     * To convert an integer from decimal to binary, repeatedly divide your base- number, , by . The dividend at each
     * step should be the result of the integer division at each step . The remainder at each step of division is a
     * single digit of the binary equivalent of ; if you then read each remainder in order from the last remainder to
     * the first (demonstrated below), you have the entire binary number.
     *
     * @param number
     * @return
     */
    static int[] decimalToBinary(int number) {
        int[] iBinary = null;
        if (number >= 0) {
            Stack<Integer> binary = new Stack<>();
            while (number > 0) {
                int rem = number % 2;
                binary.push(rem);
                number = number / 2;
            }

            if (binary.size() > 0) {
                iBinary = new int[binary.size()];
                for (int i = 0; i < iBinary.length; i++) {
                    iBinary[i] = binary.pop();
                }
            }
        }

        return iBinary;
    }

    static int findConsecutives(int[] binary) {
        int result = 0;
        if (binary != null) {
            if (binary[0] == 1) {
                result++;
            }

            if (binary.length > 1) {
                int sum = result;
                for (int i = 1; i < binary.length; i++) {
                    if (binary[i - 1] == binary[i] && binary[i] == 1) {
                        sum++;
                    } else if (binary[i - 1] != binary[i] && binary[i] == 1) {
                        sum++;
                    } else {
                        result = (sum > result ? sum : result);
                        sum = 0;
                    }
                }

                if (sum > result) {
                    result = sum;
                }
            }
        }

        return result;
    }

    /**
     * Radix (Base) The number of digits that can be used to represent a number in a positional number system. The
     * decimal number system (base-) has digits (); the binary (base-) number system has digits (). We think in terms of
     * base-, because the decimal number system is the only one many people need in everyday life. For situations where
     * there is a need to specify a number's radix, number having radix should be written as .
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        in.close();

        int[] binary = decimalToBinary(number);
        System.out.println(Arrays.toString(binary));
        int num = binaryToDecimal(binary);
        System.out.println(num);
        int result = findConsecutives(binary);
        System.out.println(result);
    }

}
