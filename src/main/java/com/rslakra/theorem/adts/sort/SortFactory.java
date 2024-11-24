package com.rslakra.theorem.adts.sort;

/**
 * @author Rohtash Lakra
 * @created 1/2/24 5:27 PM
 */
public enum SortFactory {
    INSTANCE;

    /**
     * @param sortAlgo
     * @return
     */
    public static Sort sortBuilder(SortAlgo sortAlgo) {
        switch (sortAlgo) {
            case BUBBLE_SORT:
                return new BubbleSort();

            case COUNTING_SORT:
                return new CountingSort();

            case HEAP_SORT:
                return new HeapSort();

            case INSERTION_SORT:
                return new InsertionSort();

            case MERGE_SORT:
                return new MergeSort();

            case RADIX_SORT:
                return new RadixSort();

            case SELECTION_SORT:
                return new SelectionSort();

            case QUICK_SORT:
            default:
                return new QuickSort();
        }
    }
}
