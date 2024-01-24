/**
 *
 */
package com.devamatre.theorem.algos.heap;

/**
 * <code>
 * https://algorithms.tutorialhorizon.com/binary-min-max-heap/
 * </code>
 *
 * @author Rohtash Lakra
 */
public class Heap<E> {

    public enum HeapType {
        MIN_HEAP, MAX_HEAP;
    }

    /**
     * DEFAULT_SIZE
     */
    private static final int DEFAULT_SIZE = 16;

    /**
     * heapType
     */
    private HeapType heapType;
    private Object[] heap;
    private int capacity;
    private int size;
    private int index;

    /**
     * @param heapType
     * @param capacity
     */
    public Heap(HeapType heapType, int capacity) {
        this.heapType = heapType;
        this.capacity = (capacity <= 0 ? DEFAULT_SIZE : capacity);
        heap = new Object[this.capacity];
    }

    /**
     * @param heapType
     */
    public Heap(HeapType heapType) {
        this(heapType, DEFAULT_SIZE);
    }

    /**
     * @param value
     */
    private void insertMaxHeap(E value) {

    }

    /**
     * @param value
     */
    private void insertMinHeap(E value) {

    }

    /**
     * @param value
     */
    public void insert(E value) {
        switch (heapType) {
            case MIN_HEAP:
                insertMinHeap(value);
                break;
            case MAX_HEAP:
                insertMaxHeap(value);
                break;

            default:
                break;
        }
    }

    /**
     * @return
     */
    public E getValue() {
        switch (heapType) {
            case MIN_HEAP:

                break;
            case MAX_HEAP:

                break;

            default:
                break;
        }

        return null;
    }

    /**
     * @param value
     * @return
     */
    public E delete(E value) {
        switch (heapType) {
            case MIN_HEAP:

                break;
            case MAX_HEAP:

                break;

            default:
                break;
        }

        return value;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }

}
