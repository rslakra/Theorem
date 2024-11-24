package com.rslakra.theorem.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since 04/19/2024 2:47 PM
 */
public class LC703KthLargest {

    abstract class KthLargest {

        public KthLargest(int k, int[] nums) {

        }

        public int add(int val) {
            return -1;
        }
    }

    /**
     * List based implementation.
     */
    private class KthLargestList extends KthLargest {

        private List<Integer> list = new ArrayList<>();
        private int k;

        public KthLargestList(int k, int[] nums) {
            super(k, nums);
            this.k = k;
            list.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            Collections.sort(list);
        }

        /**
         * <pre>
         *  Time Complexity: O(n log n)
         *  Space Complexity: O(n)
         * </pre>
         *
         * @param val
         * @return
         */
        @Override
        public int add(int val) {
            list.add(val);
            Collections.sort(list);
            while (list.size() > k) {
                list.remove(0);
            }

            return list.get(0);
        }
    }

    /**
     * Array based implementation.
     */
    private class KthLargestArray extends KthLargest {

        private int[] data;

        public KthLargestArray(int k, int[] nums) {
            super(k, nums);
            this.data = new int[k + 1];
            Arrays.fill(data, Integer.MIN_VALUE);
            Arrays.sort(nums);
            int index = nums.length - 1;
            for (int i = data.length - 1; i >= 0; i--) {
                if (index == -1) {
                    break;
                }
                data[i] = nums[index];
            }
        }

        /**
         * <pre>
         *  Time Complexity: O(n log n)
         *  Space Complexity: O(n)
         * </pre>
         *
         * @param val
         * @return
         */
        @Override
        public int add(int val) {
            data[0] = val;
            Arrays.sort(data);
            return data[1];
        }
    }

    /**
     * Priority Queue based implementation.
     */
    private class KthLargestPriorityQueue extends KthLargest {
        private PriorityQueue<Integer> priorityQueue;
        private int k;

        public KthLargestPriorityQueue(int k, int[] nums) {
            super(k, nums);
            this.k = k;
            priorityQueue = new PriorityQueue<>(k);
            for (int i = 0; i < nums.length; i++) {
                priorityQueue.add(nums[i]);
            }
        }

        /**
         * <pre>
         *  Time Complexity: O(k)
         *  Space Complexity: O(n)
         * </pre>
         *
         * @param val
         * @return
         */
        @Override
        public int add(int val) {
            priorityQueue.add(val);
            while (priorityQueue.size() > k) {
                priorityQueue.poll();
            }

            return priorityQueue.peek();
        }
    }

    private KthLargest kthLargest;

    /**
     * @param k
     * @param nums
     */
    public LC703KthLargest(int k, int[] nums) {
        kthLargest = new KthLargestList(k, nums);
//        kthLargest = new KthLargestArray(k, nums);
//        kthLargest = new KthLargestPriorityQueue(k, nums);
    }

    public int add(int val) {
        return kthLargest.add(val);
    }
}
