/**
 *
 */
package com.devamatre.theorem.geeksforgeeks.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Rohtash Lakra
 */
public class LargestNumberInKSwaps {

    /**
     * @param digits
     * @param startIndex
     * @return
     */
    public static int findBigIndex(char[] digits, int startIndex) {
        int bigIndex = -1;
        for (int i = startIndex; i < digits.length; i++) {
            if (bigIndex > -1 && digits[i] > digits[bigIndex]) {
                bigIndex = i;
            } else if (bigIndex == -1 && (i + 1 < digits.length) && digits[i + 1] > digits[i]) {
                bigIndex = i + 1;
            }
        }

        return bigIndex;
    }

    /**
     * @param digits
     * @param leftIndex
     * @param rightIndex
     */
    public static void swap(char[] digits, int leftIndex, int rightIndex) {
        if (digits != null && rightIndex < digits.length && leftIndex < rightIndex) {
            char temp = digits[leftIndex];
            digits[leftIndex] = digits[rightIndex];
            digits[rightIndex] = temp;
        }
    }

    /**
     * @param digits
     * @return
     */
    public static String largestNumberInKSwaps(char[] digits, int k) {
        String result = null;
        if (digits != null) {
            if (digits.length > 1) {
                int index = 0;
                int startIndex = 0;
                while (startIndex < digits.length && index < k) {
                    int bigIndex = findBigIndex(digits, startIndex);
                    if (bigIndex > -1 && digits[bigIndex] > digits[startIndex]) {
                        swap(digits, startIndex, bigIndex);
                        index++;
                    }

                    startIndex++;
                }
            }

            result = new String(digits);
        }

        return result;
    }

    public static String largestNumberWithKSwaps(char[] digits, int k) {
        String result = null;
        if (digits != null) {
            if (digits.length > 1) {
                HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
                for (int i = 0; i < digits.length; i++) {
                    int iDigit = Character.getNumericValue(digits[i]);
                    ArrayList<Integer> indexes = map.get(iDigit);
                    if (indexes == null) {
                        indexes = new ArrayList<>();
                        map.put(iDigit, indexes);
                    }
                    indexes.add(i);
                }

                int index = 0;
                for (int i = 0; i < digits.length && index < k; i++) {
                    int iDigit = Character.getNumericValue(digits[i]);
                    for (int j = 9; j > iDigit; j--) {
                        if (map.containsKey(j)) {
                            ArrayList<Integer> indexes = map.get(j);
                            // get last element
                            int bigIndex = indexes.get(indexes.size() - 1);
                            if (bigIndex > i) {
                                // remove last element
                                indexes.remove(indexes.size() - 1);
                                if (indexes.isEmpty()) {
                                    map.remove(j);
                                    // } else {
                                    // Collections.sort(indexes);
                                    // map.put(j, indexes);
                                }

                                // reload indexes from map
                                indexes = map.get(iDigit);
                                // remove first index
                                indexes.remove(0);
                                // add last element.
                                indexes.add(bigIndex);

                                Collections.sort(indexes);
                                map.put(iDigit, indexes);

                                swap(digits, i, bigIndex);
                                index++;

                                break;
                            }
                        }
                    }
                }
            }

            result = new String(digits);
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        HashMap<Integer, String> results = new HashMap<>();
        for (int index = 0; index < testCases; index++) {
// input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int k = input.nextInt();
            String digits = input.next();
            String result = null;
// result = largestNumberInKSwaps(digits.toCharArray(), k);
            result = largestNumberWithKSwaps(digits.toCharArray(), k);
            results.put(index, result);
        }

        for (int index = 0; index < testCases; index++) {
            System.out.println(results.get(index));
        }

        input.close();
    }
}
