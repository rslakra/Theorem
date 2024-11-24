/**
 *
 */
package com.rslakra.theorem.algos.array;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Mar 10, 2019 10:26:52 PM
 */
public class Duplicates {

    /**
     * @param arr
     */
    public int findDuplicateIndex(int[] arr) {
        /*
         * The "tortoise and hare" step. We start at the end of the array and try to
         * find an intersection point in the cycle.
         */
        int slow = arr.length - 1;
        int fast = arr.length - 1;

        /*
         * Keep advancing 'slow' by one step and 'fast' by two steps until they meet
         * inside the loop.
         */
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        /*
         * Start up another pointer from the end of the array and march it forward until
         * it hits the pointer inside the array. If the two hit, the intersection index
         * is the duplicate element.
         */
        int lastIndex = arr.length - 1;
        do {
            slow = arr[slow];
            lastIndex = arr[lastIndex];
        } while (slow != lastIndex);

        // return the value at index as the duplicate index.
        return arr[slow];
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Duplicates obj = new Duplicates();
        int[] arr = {2, 2, 4, 1, 3};
        System.out.println(obj.findDuplicateIndex(arr));
        arr = new int[]{1, 3, 4, 2, 2};
        System.out.println(obj.findDuplicateIndex(arr));
    }

}
