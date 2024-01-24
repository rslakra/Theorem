/**
 *
 */
package com.devamatre.theorem.algos.lang;

/**
 * Find all the numbers in the 6 digits whose first 3 digit (say x) and last 3 digit (y)'s square of sum (x+y) is equal
 * to the 6 digit number.
 * <p>
 * For example: 998001
 * <p>
 * 998001 = (998 + 1) * (998 + 1)
 *
 * @author Rohtash Lakra
 */
public class FindNumber {

    public void findNumberIterative() {
        long startTime = System.currentTimeMillis();
        for (int i = 100000; i < 1000000; i++) {
            int x = i / 1000;
            int y = i - x * 1000;
            int result = (x + y);
            if (result * result == i) {
                System.out.println(i);
            }
        }

        System.out.println("Took:" + (System.currentTimeMillis() - startTime) + " millis");
    }

    /**
     *
     */
    public void findNumberSqrt() {
        long startTime = System.currentTimeMillis();
        int low = (int) Math.sqrt(100000);
        System.out.println("low:" + low);
        int high = (int) Math.sqrt(1000000);
        System.out.println("high:" + high);
        for (int i = low; i < high; i++) {
            int result = i * i;
            if (result <= 100000 || result >= 1000000) {
                continue;
            }

            int x = result / 1000;
            int y = result - x * 1000;
            int sum = (x + y);
            if (sum * sum == result) {
                System.out.println(result);
            }

        }

        System.out.println("Took:" + (System.currentTimeMillis() - startTime) + " millis");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        FindNumber findNumber = new FindNumber();
        findNumber.findNumberIterative();
        System.out.println();
        findNumber.findNumberSqrt();
    }
}
