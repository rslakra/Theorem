/**
 *
 */
package com.devamatre.theorem.codegladiator.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Print the non-adjacent digits, which have the max sum. The digits are printed in the reverse order. For Example:
 * <p>
 * Input:
 *
 * <pre>
 * 2
 * 5
 * -1 7 8 -5 4
 * 4
 * 3 2 1 -1
 *
 * Output:
 * 48
 * 13
 *
 * Explanation:
 * In the first test-case, the input of 5 digits {-1 7 8 -5 4} have the max sum
 * of {8, 4} and the output is printed as 48.
 *
 * And in the second test-case, the input of 4 digits {3 2 1 -1} have the max
 * sum of {3, 1} and the output is printed as 13.
 * </pre>
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created May 17, 2019 5:50:06 PM
 */
public class MaxSum {

    class Result {

        private final int value;
        private final List<Integer> listResults;

        Result(int value, List<Integer> listResults) {
            this.value = value;
            this.listResults = listResults;
        }
    }

    /**
     * @param values
     * @param index
     * @param listResults
     * @return
     */
    private Result printNonAdjecentDigitsHavingMaxSumRecursively(int[] values, int index, List<Integer> listResults) {
        if (index >= values.length) {
            return new Result(0, new ArrayList<>());
        }

        Result next = printNonAdjecentDigitsHavingMaxSumRecursively(values, index + 2, listResults);
        Result last = printNonAdjecentDigitsHavingMaxSumRecursively(values, index + 1, listResults);
        if (next.value + values[index] > last.value) {
            int maxValue = next.value + values[index];
            List<Integer> listTemp = next.listResults;
            listTemp.add(values[index]);
            return new Result(maxValue, listTemp);
        }

        return new Result(last.value, last.listResults);
    }

    /**
     * Prints the non-adjacent digits, which has the max sum value.
     *
     * @param values
     */
    private void printNonAdjecentDigitsHavingMaxSum(int[] values) {
        int lastMaxSum = 0;
        List<Integer> lastMaxSumList = new ArrayList<>();

        int maxSum = values[0];
        List<Integer> listMaxSumIndices = new ArrayList<>();
        listMaxSumIndices.add(0);

        for (int i = 1; i < values.length; i++) {
            final int sum;
            final List<Integer> currentSumList;
            if (lastMaxSum > 0) {
                sum = lastMaxSum + values[i];
                currentSumList = new ArrayList<>(lastMaxSumList);
            } else {
                sum = values[i];
                currentSumList = new ArrayList<>();
            }
            currentSumList.add(i);

            // update prior max sum and list
            lastMaxSum = maxSum;
            lastMaxSumList = new ArrayList<>(listMaxSumIndices);

            if (sum > maxSum) {
                // update max sum
                maxSum = sum;
                listMaxSumIndices = currentSumList;
            }
        }

        final boolean printInReverseOrder = true;
        if (printInReverseOrder) {
            // print in reverse order
            for (int i = listMaxSumIndices.size() - 1; i >= 0; i--) {
                System.out.print(values[listMaxSumIndices.get(i)]);
            }
        } else {
            // print in order
            listMaxSumIndices.forEach(index -> System.out.print(values[index]));
        }
        System.out.println();
    }

    /**
     * Prints the non-adjacent digits, which have the max sum.
     */
    public void printNonAdjecentDigits() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }

            System.out.println();
            printNonAdjecentDigitsHavingMaxSum(nums);
            Result result = printNonAdjecentDigitsHavingMaxSumRecursively(nums, 0, new ArrayList<>());
            System.out.println(result.listResults);
        }

        in.close();
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MaxSum maxSum = new MaxSum();
        maxSum.printNonAdjecentDigits();
    }

}
