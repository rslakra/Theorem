package com.devamatre.theorem.adts.sort;

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
    public default Direction getDirection() {
        return Direction.ASC;
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
    public <T extends Comparable<? super T>> T[] sort(T[] input, Direction direction);

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
    public <T extends Comparable<? super T>> T[] sort(T[] input);
}
