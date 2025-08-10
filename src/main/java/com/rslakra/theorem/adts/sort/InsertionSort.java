package com.rslakra.theorem.adts.sort;

/**
 * @author Rohtash Lakra
 * @created 12/11/23 5:31 PM
 */
public class InsertionSort extends AbstractSort implements Sort {
    
    
    /**
     *
     * @param input
     * @return
     * @param <T>
     */
    private  <T extends Comparable<? super T>> T[] sortAsc(T[] input) {
        for (int i = 1; i < input.length; i++) {
            T temp = input[i];
            int j = i;
            for (; j > 0 && temp.compareTo(input[j - 1]) < 0; j--) {
                input[j] = input[j - 1];
            }
            input[j] = temp;
        }
        
        return input;
    }
    
    /**
     *
     * @param input
     * @return
     * @param <T>
     */
    private <T extends Comparable<? super T>> T[] sortDesc(T[] input) {
        for (int i = 1; i < input.length; i++) {
            T temp = input[i];
            int j = i;
            for (; j > 0 && temp.compareTo(input[j - 1]) > 0; j--) {
                input[j] = input[j - 1];
            }
            input[j] = temp;
        }
        
        return input;
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
        if (Direction.ASC == direction) {
            return sortAsc(input);
        }
        
        return sortDesc(input);
    }

}
