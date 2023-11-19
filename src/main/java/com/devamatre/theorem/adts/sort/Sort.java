package com.devamatre.theorem.adts.sort;

/**
 * @author Rohtash Lakra
 * @created 6/16/22 3:27 PM
 */
public interface Sort {

    enum Direction {
        ASC,
        DESC;
    }

    /**
     * @return
     */
    public default Direction getDirection() {
        return Direction.ASC;
    }

    /**
     * Sorts the elements of an array into the given direction.
     *
     * @param input
     * @param direction
     * @return
     */
    public <T extends Comparable<? super T>> T[] sort(T[] input, Direction direction);

    /**
     * Sorts the elements of an array into the given direction.
     *
     * @param input
     * @return
     */
    public <T extends Comparable<? super T>> T[] sort(T[] input);
}
