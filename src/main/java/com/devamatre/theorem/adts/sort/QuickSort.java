package com.devamatre.theorem.adts.sort;

import com.devamatre.theorem.adts.AlgoUtils;

/**
 * @author Rohtash Lakra
 * @created 10/11/23 3:14 PM
 */
public class QuickSort implements Sort {

    /**
     * @param input
     * @param index
     * @param size
     * @param <T>
     * @return
     */
    private static <T extends Comparable<? super T>> int getPivotIndex(T[] input, int index,
                                                                       int size) { // 3-way partition of T[index..size]
//        T current = T[index];   // pivot item in T[index]
        int idx = index;
//        for (int i = index + 1; i < size; i++) {
//            if (T[i] < current) {
//                idx++;
//                AlgoUtils.swapElements(input, idx, i);
//            }
//        }

        AlgoUtils.swapElements(input, index, idx);  // put the pivot into final position
        return idx;     // return location of pivot
    }

    /**
     * Sorts the elements of an array into the given direction.
     *
     * @param input
     * @param direction
     * @return
     */
    @Override
    public <T extends Comparable<? super T>> T[] sort(T[] input, Direction direction) {
        return null;
    }

    /**
     * Sorts the elements of an array into the given direction.
     *
     * @param input
     * @return
     */
    @Override
    public <T extends Comparable<? super T>> T[] sort(T[] input) {
        return null;
    }
}
