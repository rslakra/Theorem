package com.rslakra.theorem.algos.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Rohtash Lakra
 * @created 12/6/23 8:17 PM
 */
public class LargestElement {

    /**
     * Swap elements
     *
     * @param nums
     * @param left
     * @param right
     */
    private void swapElements(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * <pre>
     *  Time Complexity: O(N log N)
     *  Time Complexity: O(1)
     * </pre>
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestElementBySorting(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }


    /**
     * <pre>
     *  Time Complexity: O(N * K)
     *  Time Complexity: O(K)
     * </pre>
     *
     * @param arr
     * @param k
     * @return
     */
    public int findKthLargestElementBySortingKElements(int[] arr, int k) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {  // swap nodes
                    swapElements(arr, i, j);
                }
            }

            if (i == k - 1) {
                return arr[k - 1];
            }
        }

        return -1;
    }

    /**
     * <pre>
     *  Time Complexity: O(N log K)
     *  Time Complexity: O(K)
     * </pre>
     *
     * @param arr
     * @param k
     * @return
     */
    public int findKthLargestElementByPriorityQueue(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(arr[i]);
                continue;
            }

            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }

        return minHeap.peek();
    }


}
