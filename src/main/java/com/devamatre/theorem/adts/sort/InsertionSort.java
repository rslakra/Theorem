package com.devamatre.theorem.adts.sort;

/**
 * @author Rohtash Lakra
 * @created 12/11/23 5:31 PM
 */
public class InsertionSort extends AbstractSort implements Sort {

    /**
     * Sorts the elements of the provided <code>input</code> array into the provided <code>direction</code>..
     *
     * <pre>
     *  Time Complexity: <code>O(log N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param input
     * @param direction
     * @return
     */
    @Override
    public <T extends Comparable<? super T>> T[] sort(T[] input, Direction direction) {
        for (int i = 1; i < input.length; i++) {
            T temp = input[i];
            int j = i;
            if (Direction.ASC == direction) {
                for (; j > 0 && temp.compareTo(input[j - 1]) < 0; j--) {
                    input[j] = input[j - 1];
                }
            } else {
                for (; j > 0 && temp.compareTo(input[j - 1]) > 0; j--) {
                    input[j] = input[j - 1];
                }
            }
            input[j] = temp;
        }

        return input;
    }

}
