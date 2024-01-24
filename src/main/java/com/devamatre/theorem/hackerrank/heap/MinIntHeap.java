/******************************************************************************
 ` * Copyright (C) Devamatre Technologies 2017
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code or the 
 * snippet is not permitted without prior express written consent of Devamatre. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the 
 * offenders will be liable for any damages. All rights, including  but not
 * limited to rights created by patent grant or registration of a utility model 
 * or design, are reserved. Technical specifications and features are binding 
 * only insofar as they are specifically and expressly agreed upon in a written 
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 *      http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.hackerrank.heap;

import java.util.Arrays;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-10-02 06:10:46 PM
 * @since 1.0.0
 */
public class MinIntHeap {

    private int capacity;
    private int size;
    private int[] items;

    /**
     * @param capacity
     */
    public MinIntHeap(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }

    /**
     *
     */
    public MinIntHeap() {
        this(5);
    }

    /**
     * Returns the size ofthe heap.
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the parent index.
     *
     * @param childIndex
     * @return
     */
    public int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    /**
     * Returns the left child index.
     *
     * @param parentIndex
     * @return
     */
    public int getLeftChildIndex(int parentIndex) {
        return (parentIndex * 2 + 1);
    }

    /**
     * Returns the right child index.
     *
     * @param parentIndex
     * @return
     */
    public int getRightChildIndex(int parentIndex) {
        return (parentIndex * 2 + 2);
    }

    /**
     * Returns true if the parent exists at index otherwise false.
     *
     * @param index
     * @return
     */
    public boolean hasParent(int index) {
        return (getParentIndex(index) >= 0);
    }

    /**
     * Returns true if the left child exists at index otherwise false.
     *
     * @param index
     * @return
     */
    public boolean hasLeftChild(int index) {
        return (getLeftChildIndex(index) < size);
    }

    /**
     * Returns true if the right child exists at index otherwise false.
     *
     * @param index
     * @return
     */
    public boolean hasRightChild(int index) {
        return (getRightChildIndex(index) < size);
    }

    /**
     * Returns the parent item on the index.
     *
     * @param index
     * @return
     */
    public int getParent(int index) {
        return items[getParentIndex(index)];
    }

    /**
     * Returns the left child at the index.
     *
     * @param index
     * @return
     */
    public int getLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    /**
     * Returns the right child at the index.
     *
     * @param index
     * @return
     */
    public int getRightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    /**
     * Increase the heap by doubling the size.
     */
    private void ensureCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    /**
     * Swaps the items of the given indices.
     *
     * @param sourceIndex
     * @param targetIndex
     */
    private void swapItems(int sourceIndex, int targetIndex) {
        int temp = items[sourceIndex];
        items[sourceIndex] = items[targetIndex];
        items[targetIndex] = temp;
    }

    /**
     * Returns the top item.
     *
     * @return
     */
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("No Items Found!");
        }

        return items[0];
    }

    /**
     * Removes the top item and return that.
     *
     * @return
     */
    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("No Items Found!");
        }

        int value = items[0];
        items[0] = items[size - 1];
        // resetting with default value.
        items[size - 1] = 0;
        size--;
        heapifyDown();
        return value;
    }

    /**
     *
     */
    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swapItems(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    /**
     * Adds the item into the heap.
     *
     * @param item
     */
    public void addItem(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    /**
     *
     */
    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > items[index]) {
            swapItems(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void printHeap() {
        System.out.println(Arrays.toString(items));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        MinIntHeap heap = new MinIntHeap();
        heap.printHeap();

        heap.addItem(10);
        heap.addItem(15);
        heap.addItem(20);
        heap.addItem(17);
        heap.printHeap();

        heap.addItem(8);
        heap.printHeap();

        heap.addItem(25);
        heap.printHeap();

        System.out.println(heap.peek());
        heap.poll();
        System.out.println(heap.peek());
        heap.printHeap();

    }

}
