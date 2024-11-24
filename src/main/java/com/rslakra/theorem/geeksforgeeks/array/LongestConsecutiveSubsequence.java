/**
 *
 */
package com.rslakra.theorem.geeksforgeeks.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 */
public class LongestConsecutiveSubsequence {

    /**
     * @param digits
     * @return
     */
    public static int longestConsecutiveSubsequence(int[] digits) {
        int result = 0;

        if (digits != null && digits.length > 0) {
            if (digits.length == 1) {
                return 1;
            } else {
                Arrays.sort(digits);
                int startIndex = 0;
                int lastIndex = 0;
                for (int i = 1; i < digits.length; i++) {
                    if (digits[i] - digits[i - 1] == 1) {
                        lastIndex = i;
                    } else {
                        if ((lastIndex - startIndex) >= result) {
                            result = (lastIndex - startIndex) + 1;
                        }
                        startIndex = i;
                        lastIndex = i;
                    }

                    if ((lastIndex - startIndex) >= result) {
                        result = (lastIndex - startIndex) + 1;
                    }
                }
            }
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        HashMap<Integer, Integer> results = new HashMap<>();
        for (int index = 0; index < testCases; index++) {
            int size = input.nextInt();
            int[] digits = new int[size];
            for (int i = 0; i < digits.length; i++) {
                digits[i] = input.nextInt();
            }
            int result = longestConsecutiveSubsequence(digits);
            results.put(index, result);
        }

        for (int index = 0; index < testCases; index++) {
            System.out.println(results.get(index));
        }

        input.close();
    }

}
