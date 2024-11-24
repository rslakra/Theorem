/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.rslakra.theorem.firecode;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-11-02 03:00:17 PM
 * @since 1.0.0
 */
public class Maths {

    /**
     * Returns the GCD of the given numbers.
     *
     * @param left
     * @param right
     * @return
     */
    public static long gcd(long left, long right) {
        if (right == 0) {
            return left;
            // } else if (right == 0) {
            // return left;
        }

        return gcd(right, left % right);
    }

    /**
     * Write a method - pow(x,n) that returns the value of x raised to the power of n (xn). n can be negative!
     * <p>
     * Examples: pow(2,3) ==> 8.0
     *
     * @param x
     * @param n
     * @return
     */
    public static double pow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (x == 0) {
            return x;
        } else if (n < 0) {
            return pow(1 / x, -n);
        } else if (n % 2 > 0) {
            return (x * pow(x * x, n / 2));
        } else {
            return (pow(x * x, n / 2));
        }
    }

    /**
     * Write a method - pow(x,n) that returns the value of x raised to the power of n (xn). n can be negative!
     * <p>
     * Examples: pow(2,3) ==> 8.0
     *
     * @param x
     * @param n
     * @return
     */
    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            x = 1 / x;
            n *= -1;
        }

        return (x * power(x, n - 1));
    }

    /**
     * Write a method - pow(x,n) that returns the value of x raised to the power of n (xn). n can be negative!
     * <p>
     * Examples: pow(2,3) ==> 8.0
     * <p>
     * Time Complexity: O(log(y)/log(y))
     *
     * @param x
     * @param y
     * @return
     */
    public static double powRecursive(double x, int y) {
        if (y == 0) {
            return 1;
        } else if (y % 2 == 0) {
            return powRecursive(x, y / 2) * powRecursive(x, y / 2);
        } else {
            return x * powRecursive(x, y / 2) * powRecursive(x, y / 2);
        }
    }

    /**
     * Write a method - pow(x,n) that returns the value of x raised to the power of n (xn). n can be negative!
     * <p>
     * Examples: pow(2,3) ==> 8.0
     * <p>
     * Time Complexity: O(log(y)/log(y))
     *
     * @param x
     * @param y
     * @return
     */
    public static double powerRecursive(double x, int y) {
        return (y > 0 ? powRecursive(x, Math.abs(y)) : (double) 1 / powRecursive(x, Math.abs(y)));
    }

    /**
     * Write a method - pow(x,n) that returns the value of x raised to the power of n (xn). n can be negative!
     * <p>
     * Examples: pow(2,3) ==> 8.0
     * <p>
     * Time Complexity: O(log(y)/O(1))
     *
     * @param x
     * @param y
     * @return
     */
    public static double powIterative(double x, int y) {
        double result = 1;
        while (y > 0) {
            // if y is odd, multiple x with result
            if ((y & 1) == 1) {
                result *= x;
            }

            // y must be even now, so y = y / 2
            y = y >> 1;
            // change x to x ^ 2
            x *= x;
        }

        return result;
    }

    /**
     * Write a method - pow(x,n) that returns the value of x raised to the power of n (xn). n can be negative!
     * <p>
     * Examples: pow(2,3) ==> 8.0
     * <p>
     * Time Complexity: O(log(y)/O(1))
     *
     * @param x
     * @param y
     * @return
     */
    public static double powerIterative(double x, int y) {
        return (y > 0 ? powIterative(x, Math.abs(y)) : (double) 1 / powIterative(x, Math.abs(y)));
    }

    /**
     * Write a method - isPowOfTwo to test whether or not a given positive integer is a power of 2. Your method should
     * run in constant O(1) time and use O(1) space.
     * <p>
     * <p>
     * Examples:
     * <p>
     * isPowOfTwo(5) ==> false isPowOfTwo(8) ==> true
     *
     * @param num
     * @return
     */
    public static boolean isPowOfTwo(int num) {
        /* If a number n is a power of 2, bitwise & of n and n-1 will be zero */
        return (num == 0 || (num & num - 1) == 0);
    }

    /**
     * The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ... The next number is found by
     * adding up the two numbers before it.
     * <p>
     * Your goal is to write an optimal method - betterFibonacci that returns the nth Fibonacci number in the sequence.
     * n is 0 indexed, which means that in the sequence 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ..., n == 0 should return 0 and
     * n == 3 should return 2. Your method should exhibit a runtime complexity of O(n) and use constant O(1) space. With
     * this implementation, your method should be able to compute larger sequences where n > 40.
     * <p>
     * Examples:
     * <p>
     * fib(0) ==> 0
     * <p>
     * fib(1) ==> 1
     * <p>
     * fib(3) ==> 2
     *
     * @param n
     * @return
     */
    public static int betterFibonacci(int n) {
        if (n < 2) {
            return n;
        }

        return (betterFibonacci(n - 2) + betterFibonacci(n - 1));
    }

    /**
     * Write a method that checks if a given integer is a palindrome - without allocating additional heap space
     * Examples: -1 ==> false 0 ==> true 1221 ==> true
     *
     * @param x
     * @return
     */
    public static Boolean isIntPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        int num = 0;
        int temp = x;
        while (temp != 0) {
            num = num * 10 + (temp % 10);
            temp = temp / 10;
        }
        return (num == x);
    }

    /**
     * Write a method to determine whether a postive number is Happy.
     * <p>
     * A number is Happy (Yes, it is a thing!) if it follows a sequence that ends in 1 after following the steps given
     * below : Beginning with the number itself, replace it by the sum of the squares of its digits until either the
     * number becomes 1 or loops endlessly in a cycle that does not include 1.
     * <p>
     * For instance, 19 is a happy number. Sequence: 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02 + 02 = 1
     * <p>
     * Example:
     * <p>
     * Input : 19 Output: true
     *
     * @param n
     * @return
     */
    public static boolean isHappyNumber(int n) {
        if (n == 1) {
            return true;
        }

        HashSet<Integer> set = new HashSet<>();
        int sum = n;
        while (sum != 1) {
            if (set.contains(sum)) {
                break;
            } else {
                set.add(sum);
            }
            Stack<Integer> digits = new Stack<>();
            while (sum != 0) {
                digits.push(sum % 10);
                sum = sum / 10;
            }

            sum = 0;
            while (!digits.isEmpty()) {
                sum += Math.pow(digits.pop(), 2);
            }
        }

        return (sum == 1);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        double[][] numbers = {{-2, -2}, {-2, -1}, {-2, 0}, {2, -2}, {2, -1}, {2, 0}, {2, 1}, {2, 1},
                              {2, 3}, {2, 4}};
        for (int i = 0; i < numbers.length; i++) {
            double x = numbers[i][0];
            int n = (int) numbers[i][1];
            System.out.println("      Math.pow(" + x + ", " + n + "):" + Math.pow(x, n));
            System.out.println("           pow(" + x + ", " + n + "):" + pow(x, n));
            System.out.println("         power(" + x + ", " + n + "):" + power(x, n));
            System.out.println("powerRecursive(" + x + ", " + n + "):" + powerRecursive(x, n));
            System.out.println("powerIterative(" + x + ", " + n + "):" + powerIterative(x, n));
            System.out.println();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(betterFibonacci(i));
        }

        int n = 1221;
        System.out.println(isIntPalindrome(n));

        n = 19;
        System.out.println(isHappyNumber(n));

        int left = 24, right = 18;
        System.out.println(gcd(left, right));
    }

}
