package com.rslakra.theorem.adts.sort;

import com.rslakra.theorem.adts.AlgoUtils;

/**
 * @author Rohtash Lakra
 * @created 12/11/23 5:31 PM
 */
public class SelectionSort extends AbstractSort implements Sort {

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
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (Direction.ASC == direction) {
                    if (input[i].compareTo(input[j]) > 0) {
                        AlgoUtils.swapElements(input, i, j);
                    }
                } else {
                    if (input[i].compareTo(input[j]) < 0) {
                        AlgoUtils.swapElements(input, i, j);
                    }
                }
            }
        }

        return input;
    }

}
