package com.rslakra.theorem.adts.sort;

import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 6/16/22 3:27 PM
 */
public interface Sort {

    enum Direction {
        ASC, DESC;
    }

    /**
     * Returns the sorting <code>direction</code>.
     * <pre>
     *  Time Complexity: <code>O(1)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @return
     */
    default Direction getDirection() {
        return Direction.ASC;
    }

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
    <T extends Comparable<? super T>> T[] sort(List<T> input, Direction direction);

    /**
     * Sorts the elements of an <code>input</code> into the given direction.
     * <pre>
     *  Time Complexity: <code>O(log N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param input
     * @return
     */
    default <T extends Comparable<? super T>> T[] sort(List<T> input) {
        return sort(input, Direction.ASC);
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
    <T extends Comparable<? super T>> T[] sort(T[] input, Direction direction);

    /**
     * Sorts the elements of an array into the given direction.
     * <pre>
     *  Time Complexity: <code>O(log N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param input
     * @return
     */
    default <T extends Comparable<? super T>> T[] sort(T[] input) {
        return sort(input, Direction.ASC);
    }
}
