package com.devamatre.theorem.adts.heap;

import com.devamatre.theorem.adts.AlgoUtils;
import com.devamatre.theorem.adts.tree.TreeUtils;

/**
 * @author Rohtash Lakra
 * @created 10/9/23 1:16 PM
 */
public enum HeapUtils {
    INSTANCE;

    /**
     * It maintains the property of max heap (i.e. each element value should be greater than or equal to any of its
     * child and smaller than or equal to its parent)
     * <p>
     * Time Complexity: O(log N)
     * <p>
     * https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial
     * <p>
     * Steps:
     * <pre>
     *  1. Shift down A[i] in A[1 .. N]
     *  2. Get Left node index
     *  3. Get Right node index
     *  4. max key index equals to current index
     *  5. if leftIndex < size and leftIndex > index, assign largest = leftIndex
     *  5. if rightIndex < size and rightIndex < largest, assign largest = rightIndex
     *  6. if largest != index, then
     *  6.1. Swap A[index] with A[largest]
     *  6.2. maxHeapify(A, largest, size)
     * </pre>
     * <p>
     *
     * @param index
     * @param size
     */
    public static <T extends Comparable<? super T>> void maxHeapify(T[] input, int index, int size) {
        int leftIndex = TreeUtils.leftNodeIndex(index);     // left child
        int rightIndex = TreeUtils.rightNodeIndex(index);   // right child
        int largest = index;    // largest/max key index
        // check left child
        if (leftIndex <= size && input[leftIndex].compareTo(input[largest]) == 1) {
            largest = leftIndex;
        }

        // check right child
        if (rightIndex <= size && input[rightIndex].compareTo(input[largest]) == 1) {
            largest = rightIndex;
        }

        //swap elements, if needed
        if (largest != index) {
            AlgoUtils.swapElements(input, index, largest);
            maxHeapify(input, largest, size);
        }
    }

    /**
     * Note: An array can be used to simulate a tree in the following way.
     * <p>
     * If we are storing one element at index ```i``` in array ```arr```,then its parent will be stored at index
     * ```i/2``` (unless it's a root, as root has no parent) and can be accessed by arr[i/2], and its left child can be
     * accessed by arr[2 * i] and its right child can be accessed by arr[2 * i + 1]. Index of root will be 1 in an
     * array.
     * <p>
     * Time Complexity: <code>O(N)</code>
     */
    public static <T extends Comparable<? super T>> void buildMaxHeap(T[] input) {
        for (int i = input.length / 2; i >= 0; i--) {
            maxHeapify(input, i, input.length - 1);
        }
    }

    /**
     * Initially we will build a max heap of elements in an ```arr```.
     * <p>
     * Now the root element that is ```arr[1]``` contains maximum element of ```arr```. After that, we will exchange
     * this element with the last element of and will again build a max heap excluding the last element which is already
     * in its correct position and will decrease the length of heap by one.
     * <p>
     * We will repeat the step 2, until we get all the elements in their correct position.
     * <p>
     * We will get a sorted array.
     * <p>
     * Time Complexity: O(N log N)
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void heapSortAsc(T[] arr) {
        int heapSize = arr.length - 1;
        buildMaxHeap(arr);
        for (int i = heapSize; i >= 1; i--) {
            AlgoUtils.swapElements(arr, 0, i);
            heapSize--;
            maxHeapify(arr, 0, heapSize);
        }
    }

    /**
     * It maintains the property of max heap (i.e. each element value should be less than or equal to any of its child
     * and larger than or equal to its parent)
     * <p>
     * Time Complexity: O(log N)
     * <p>
     * https://www.hackerearth.com/practice/data-structures/trees/heapspriority-queues/tutorial
     *
     * @param arr
     * @param index
     * @param size
     */
    public static <T extends Comparable<? super T>> void minHeapify(T[] arr, int index, int size) {
        int leftIndex = TreeUtils.leftNodeIndex(index);     // left child
        int rightIndex = TreeUtils.rightNodeIndex(index);   // right child
        int smallest = index;    // smallest/mmin key index

        // check left child
        if (leftIndex <= size && arr[leftIndex].compareTo(arr[smallest]) == -1) {
            smallest = leftIndex;
        }

        // check right child
        if (rightIndex <= size && arr[rightIndex].compareTo(arr[smallest]) == -1) {
            smallest = rightIndex;
        }

        //swap elements, if needed
        if (smallest != index) {
            AlgoUtils.swapElements(arr, index, smallest);
            minHeapify(arr, smallest, size);
        }
    }

    /**
     * Note: An array can be used to simulate a tree in the following way.
     * <p>
     * If we are storing one element at index ```i``` in array ```arr```,then its parent will be stored at index
     * ```i/2``` (unless it's a root, as root has no parent) and can be accessed by arr[i/2], and its left child can be
     * accessed by arr[2 * i] and its right child can be accessed by arr[2 * i + 1]. Index of root will be 1 in an
     * array.
     * <p>
     * Time Complexity: <code>O(N)</code>
     *
     * @param arr
     */
    public static <T extends Comparable<? super T>> void buildMinHeap(T[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            minHeapify(arr, i, arr.length - 1);
        }
    }

    /**
     * Initially we will build a max heap of elements in an ```arr```.
     * <p>
     * Now the root element that is ```arr[1]``` contains maximum element of ```arr```. After that, we will exchange
     * this element with the last element of and will again build a max heap excluding the last element which is already
     * in its correct position and will decrease the length of heap by one.
     * <p>
     * We will repeat the step 2, until we get all the elements in their correct position.
     * <p>
     * We will get a sorted array.
     * <p>
     * Time Complexity: O(N log N)
     *
     * @param arr
     * @param <T>
     */
    public static <T extends Comparable<? super T>> void heapSortDesc(T[] arr) {
        int heapSize = arr.length - 1;
        buildMinHeap(arr);
        for (int i = heapSize; i >= 1; i--) {
            AlgoUtils.swapElements(arr, 0, i);
            heapSize--;
            minHeapify(arr, 0, heapSize);
        }
    }
}
