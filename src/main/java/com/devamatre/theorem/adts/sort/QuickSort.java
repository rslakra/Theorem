package com.devamatre.theorem.adts.sort;

import com.devamatre.theorem.adts.AlgoUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @created 10/11/23 3:14 PM
 */
public class QuickSort extends AbstractSort implements Sort {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuickSort.class);

    /**
     * Returns the index of the pivot value.
     *
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param input
     * @param low
     * @param high
     * @param <T>
     * @return
     */
    private <T extends Comparable<? super T>> int partitionAsc(T[] input, int low, int high) {
        LOGGER.debug("+partitionAsc({}, {}, {})", input, low, high);
        // 3-way partition of T[low ... high]
        // pivot value
        T pivot = input[high];
        LOGGER.debug("pivot:{}", pivot);
        // pivot index
        int pivotIndex = low - 1;
        // iterate elements and compare elements with pivot
        for (int i = low; i < high; i++) {
            // current index value < pivot, swap elements
            if (input[i].compareTo(pivot) < 0) {
                pivotIndex++;
                AlgoUtils.swapElements(input, i, pivotIndex);
            }
        }

        // put the pivot into final position
        pivotIndex++;
        AlgoUtils.swapElements(input, high, pivotIndex);

        // return pivot's location
        LOGGER.debug("-partitionAsc(), pivotIndex:{}", pivotIndex);
        return pivotIndex;
    }

    /**
     * Sorts the elements in the ascending order.
     *
     * <pre>
     *  Time Complexity: <code>O(N log N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param input
     * @param low
     * @param high
     * @param <T>
     * @return
     */
    private <T extends Comparable<? super T>> T[] quickSortAsc(T[] input, int low, int high) {
        LOGGER.debug("+quickSortAsc({}, {}, {})", input, low, high);
        if (low < high) {
            int pivotIndex = partitionAsc(input, low, high);
            LOGGER.debug("pivotIndex:{}", pivotIndex);
            quickSortAsc(input, low, pivotIndex - 1);
            quickSortAsc(input, pivotIndex + 1, high);
        }

        LOGGER.debug("-quickSortAsc(), input:{}", Arrays.toString(input));
        return input;
    }

    /**
     * Returns the index of the pivot value.
     *
     * <pre>
     *  Time Complexity: <code>O(N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param input
     * @param low
     * @param high
     * @param <T>
     * @return
     */
    private <T extends Comparable<? super T>> int partitionDesc(T[] input, int low, int high) {
        LOGGER.debug("+partitionDesc({}, {}, {})", input, low, high);
        // 3-way partition of T[low ... high]
        // pivot value
        T pivot = input[high];
        LOGGER.debug("pivot:{}", pivot);
        // pivot index
        int pivotIndex = low - 1;
        // iterate elements and compare elements with pivot
        for (int i = low; i < high; i++) {
            // current index value < pivot, swap elements
            if (input[i].compareTo(pivot) > 0) {
                pivotIndex++;
                AlgoUtils.swapElements(input, i, pivotIndex);
            }
        }

        // put the pivot into final position
        pivotIndex++;
        AlgoUtils.swapElements(input, high, pivotIndex);

        // return pivot's location
        LOGGER.debug("-partitionDesc(), pivotIndex:{}", pivotIndex);
        return pivotIndex;
    }

    /**
     * Sorts the elements in the descending order.
     *
     * <pre>
     *  Time Complexity: <code>O(N log N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>     *
     *
     * @param input
     * @param low
     * @param high
     * @param <T>
     * @return
     */
    private <T extends Comparable<? super T>> T[] quickSortDesc(T[] input, int low, int high) {
        LOGGER.debug("+quickSortDesc({}, {}, {})", input, low, high);
        if (low < high) {
            int pivotIndex = partitionDesc(input, low, high);
            LOGGER.debug("pivotIndex:{}", pivotIndex);
            quickSortDesc(input, low, pivotIndex - 1);
            quickSortDesc(input, pivotIndex + 1, high);
        }

        LOGGER.debug("-quickSortDesc(), input:{}", Arrays.toString(input));
        return input;
    }

    /**
     * Sorts the elements of an array into the given direction.
     *
     * <pre>
     *  Time Complexity: <code>O(N log N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param input
     * @param direction
     * @return
     */
    @Override
    public <T extends Comparable<? super T>> T[] sort(T[] input, Direction direction) {
        if (Direction.DESC == direction) {
            return quickSortDesc(input, 0, input.length - 1);
        }

        return quickSortAsc(input, 0, input.length - 1);
    }

    /**
     * Sorts the elements of an array into the given direction.
     * <pre>
     *  Time Complexity: <code>O(N log N)</code>
     *  Space Complexity: <code>O(1)</code>
     * </pre>
     *
     * @param input
     * @return
     */
    @Override
    public <T extends Comparable<? super T>> T[] sort(T[] input) {
        return sort(input, Direction.ASC);
    }
}
