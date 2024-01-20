package com.devamatre.theorem.adts.sort;

import com.devamatre.appsuite.core.exception.InvalidRequestException;
import com.devamatre.theorem.adts.tree.CountSortTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @created 10/18/23 9:14 AM
 */
public class CountingSort extends AbstractSort implements Sort {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountingSort.class);

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


    /**
     * Returns the index of the key;
     *
     * @param value
     * @return
     */
    private int key(int value) {
        return value;
    }

    /**
     * @param input
     * @param k
     * @return
     */
    private int[] sortAsc(int[] input, int k) {
        int[] count = new int[k + 1];
        int[] output = new int[input.length];
        // for each key, add 1 into the value
        for (int i = 0; i < input.length; i++) {
            int j = key(input[i]);
            count[j] += 1;
        }

        // for each key, do the sum with last sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // arrange input with count
        for (int i = 0; i < input.length; i++) {
            int j = key(input[i]);
            count[j] -= 1;
            output[count[j]] = input[i];
        }

        return output;
    }

    /**
     * @param input
     * @param k
     * @return
     */
    private int[] sortAscWithMap(int[] input, int k) {
        CountSortTree tree = new CountSortTree();
        int[] output = new int[input.length];
        // for each key, add 1 into the value
        for (int i = 0; i < input.length; i++) {
            int j = key(input[i]);
            tree.addNode(input[i]);
        }

        LOGGER.debug("tree: {}", tree);

        // for each key, do the sum with last sum
        for (int i = 1; i < input.length; i++) {
            int j = key(input[i]);
//            count.put(j, count.get(j) + count.get(j - 1));
        }

        // arrange input with count
        for (int i = 0; i < input.length; i++) {
            int j = key(input[i]);
//            count.put(j, count.get(j) - 1);
//            output[count.get(j)] = input[i];
        }

        return output;
    }

    /**
     * @param input
     * @param k
     * @return
     */
    private int[] sortDesc(int[] input, int k) {
        int[] count = new int[k + 1];
        int[] output = new int[input.length];
        // for each key, add 1 into the value
        for (int i = 0; i < input.length; i++) {
            int j = key(input[i]);
            count[j] += 1;
        }

        // for each key, do the sum with last sum
        for (int i = count.length - 2; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // arrange input with count
        for (int i = 0; i < input.length; i++) {
            int j = key(input[i]);
            count[j] -= 1;
            output[count[j]] = input[i];
        }

        return output;
    }

    /**
     * @param input
     * @param k
     * @param direction
     * @return
     */
    public int[] sort(int[] input, int k, Direction direction) {
        if (Direction.ASC == direction) {
            return sortAsc(input, k);
        } else if (Direction.DESC == direction) {
            return sortDesc(input, k);
        }

        throw new InvalidRequestException("Invalid Direction! direction:" + direction);
    }

    /**
     * @param input
     * @param k
     * @param direction
     * @return
     */
    public int[] sortWithMap(int[] input, int k, Direction direction) {
        if (Direction.ASC == direction) {
            return sortAscWithMap(input, k);
        } else if (Direction.DESC == direction) {
            return sortDesc(input, k);
        }

        throw new InvalidRequestException("Invalid Direction! direction:" + direction);
    }
}
