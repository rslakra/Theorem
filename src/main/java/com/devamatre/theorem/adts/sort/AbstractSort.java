package com.devamatre.theorem.adts.sort;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/2/24 5:11 PM
 */
public abstract class AbstractSort implements Sort {

    /**
     * Sorts the elements of the provided <code>input</code> into the provided <code>direction</code>..
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
    public <T extends Comparable<? super T>> T[] sort(List<T> input, Direction direction) {
        return null;
    }

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
        return null;
    }

}