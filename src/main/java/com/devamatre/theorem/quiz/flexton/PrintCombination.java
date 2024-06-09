package com.devamatre.theorem.quiz.flexton;

/**
 * @author Rohtash Lakra (work.lakra@gmail.com)
 * @version 1.0.0
 * @since 05/29/2024 10:19 AM
 */
public class PrintCombination {

    /**
     * Given an array of size n, generate and print all possible combinations of r elements in the array.
     *
     * <pre>
     *  Example 1:
     *   Input: arr=[1,2,3,4], r=2
     *   Output:
     *   1 2
     *   1 3
     *   1 4
     *   2 3
     *   2 4
     *   3 4
     *
     *  Example 2:
     *   Input: arr=[1,2,3,4,5,6], r=3
     *   Output:
     *   1 2 3
     *   1 2 4
     *   1 2 5
     *   1 2 6
     * </pre>
     *
     * <pre>
     *  Time Complexity: O(n ^ 3)
     *  Space Complexity: O(1)
     * </pre>
     *
     * @param arr
     * @param r
     */
    public static void printCombinations(int[] arr, int r) {
        for (int i = 0; i <= arr.length - r; i++) {
            // print last element pair
            for (int j = i + r - 1; j < arr.length; j++) {
                // print r - 1 elements first
                for (int k = i; k < i + r - 1; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println(arr[j]);
            }
        }
    }

    /**
     * <pre>
     *  Time Complexity: O(n ^ 2)
     *  Space Complexity: O(k)
     * </pre>
     * @param arr
     * @param r
     */
    public static void printCombinations2(int[] arr, int r) {
        for (int i = 0; i <= arr.length - r; i++) {
            StringBuilder sBuilder = new StringBuilder();
            // print r - 1 elements first
            int midIndex = i + r - 1;
            for (int k = i; k < midIndex; k++) {
                sBuilder.append(arr[k]).append(" ");
            }
            String prefix = sBuilder.toString();

            // print last element pair
            for (int j = midIndex; j < arr.length; j++) {
                System.out.println(prefix + arr[j]);
            }
        }
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
//        printCombinations(arr, 2);
        printCombinations2(arr, 2);
        System.out.println();

        arr = new int[]{1, 2, 3, 4, 5, 6};
//        printCombinations(arr, 3);
        printCombinations2(arr, 3);
    }
}
