package com.devamatre.theorem.leetcode.range;

/**
 * https://leetcode.com/problems/range-sum-query-mutable/
 * <p>
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * <p>
 * Example:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9 update(1, 2) sumRange(0, 2) -> 8
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The array is only modifiable by the update function. You may assume the number of calls to update and sumRange
 * function is distributed evenly. 0 <= i <= j <= nums.length - 1
 *
 * @author Rohtash Lakra
 * @version 1.0.0
 * @since Dec 12, 2020 12:07:11
 */
public class LC307RangeSumQueryMutable {

    static enum Approach {
        BRUTE_FORCE,
        PREFIX_SUM,
        SEGMENT_TREE;
    }

    static interface RangeSumQuery {

        public void update(int i, int value);

        public int sumRange(int i, int j);
    }

    private RangeSumQuery rangeSumQuery;

    /**
     * @param nums
     */
    public LC307RangeSumQueryMutable(Approach approach, int[] nums) {
        switch (approach) {
            case BRUTE_FORCE:
                // Approach 1 - Brute Force
                rangeSumQuery = new BruteForceApproach(nums);
                break;
            case PREFIX_SUM:
                // Approach 2 - Prefix Sum
                rangeSumQuery = new PrefixSumApproach(nums);
                break;
            case SEGMENT_TREE:
                // Approach 3 - Segment Tree
                rangeSumQuery = new SegmentTreeApproach(nums);
                break;
            default:
                System.err.println("Invalid Approach: " + approach);
                break;
        }
    }

    /**
     * @param i
     * @param value
     */
    public void update(int i, int value) {
        rangeSumQuery.update(i, value);
    }

    /**
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        return rangeSumQuery.sumRange(i, j);
    }

    /**
     * Space Complexity: O(N)
     * <p>
     * Approach 1 - Brute Force
     */
    private class BruteForceApproach implements RangeSumQuery {

        private int[] nums;

        public BruteForceApproach(int[] nums) {
            this.nums = nums;
        }

        /**
         * Time Complexity: O(1)
         *
         * @param i
         * @param value
         */
        @Override
        public void update(int i, int value) {
            if (i >= 0 && i < nums.length) {
                nums[i] = value;
            }
        }

        /**
         * Time Complexity: O(N)
         *
         * @param i
         * @param j
         * @return
         */
        @Override
        public int sumRange(int i, int j) {
            int sum = 0;
            if (i <= j && i >= 0 && j < nums.length) {
                for (int index = i; index <= j; index++) {
                    sum += nums[index];
                }
            }

            return sum;
        }

    }

    // Approach 2 - Prefix Sum
    private class PrefixSumApproach implements RangeSumQuery {

        private int[] nums;
        private int[] prefixSum;

        public PrefixSumApproach(int[] nums) {
            this.nums = nums;
            prefixSum = new int[nums.length];
            prefixSum[0] = nums[0];
            updatePrefixSum(1);
        }

        /**
         * Time Complexity: O(N)
         *
         * @param index
         */
        private void updatePrefixSum(int index) {
            if (index > 0 && index < nums.length) {
                for (int i = index; i < nums.length; i++) {
                    prefixSum[i] = prefixSum[i - 1] + nums[i];
                }
            }
        }

        /**
         * Time Complexity: O(N)
         *
         * @param i
         * @param value
         */
        @Override
        public void update(int i, int value) {
            if (i >= 0 && i < nums.length) {
                nums[i] = value;
                updatePrefixSum(i == 0 ? 1 : i);
            }
        }

        /**
         * Time Complexity: O(N)
         *
         * @param i
         * @param j
         * @return
         */
        @Override
        public int sumRange(int i, int j) {
            if (i <= j && i >= 0 && j < nums.length) {
                if (i == 0) {
                    return prefixSum[j];
                } else {
                    return prefixSum[j] - prefixSum[i - 1];
                }
            }

            return 0;
        }

    }

    // Approach 3 - Segment Tree
    private class SegmentTreeApproach implements RangeSumQuery {

        // Node
        class Node {

            private int value;
            private int startIndex;
            private int endIndex;
            private Node left;
            private Node right;

            public Node(int value, int startIndex, int endIndex) {
                this.value = value;
                this.startIndex = startIndex;
                this.endIndex = endIndex;
                left = null;
                right = null;
            }
        }


        private Node root;

        /**
         * @param node
         * @param nums
         * @param index
         */
        private void buildTree(Node node, int[] nums, int index) {
            // leaf node
            if (node.startIndex == node.endIndex) {
                node.value = nums[index];
            } else {
                int mid = node.startIndex + (node.endIndex - node.startIndex) / 2;
                if (index <= mid) {
                    node.left = new Node(0, node.startIndex, mid);
                    buildTree(node.left, nums, index + 1);
                } else {
                    node.right = new Node(0, mid + 1, node.endIndex);
                    buildTree(node.right, nums, index + 1);
                }

                // do some of both values.
                if (node.left != null && node.right != null) {
                    node.value = node.left.value + node.right.value;
                } else if (node.left == null && node.right != null) {
                    System.out.println(node.value);
                }
//                node.value = node.left.value + node.right.value;
            }
        }

        /**
         * @param nums
         */
        public SegmentTreeApproach(int[] nums) {
            int index = 0;
            root = new Node(0, 0, nums.length - 1);
            buildTree(root, nums, index);
            System.out.println(root);
        }

        /**
         * @param i
         * @param value
         */
        @Override
        public void update(int i, int value) {

        }

        /**
         * @param i
         * @param j
         * @return
         */
        @Override
        public int sumRange(int i, int j) {
            return 0;
        }

    }

    /**
     * Rests the range sum query.
     */
    public void testRangeSumQuery() {
        int sIndex = 0;
        int eIndex = 0;
        System.out.println("start\tend\tsum");
        sIndex = 0;
        eIndex = 1;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 0;
        eIndex = 2;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 0;
        eIndex = 3;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 0;
        eIndex = 4;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 1;
        eIndex = 2;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 1;
        eIndex = 3;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 1;
        eIndex = 4;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));

        System.out.println();
        System.out.println("update");
        rangeSumQuery.update(2, 9);
        System.out.println();

        sIndex = 0;
        eIndex = 1;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 0;
        eIndex = 2;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 0;
        eIndex = 3;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 0;
        eIndex = 4;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 1;
        eIndex = 2;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 1;
        eIndex = 3;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
        sIndex = 1;
        eIndex = 4;
        System.out.println(sIndex + "\t\t" + eIndex + "\t" + rangeSumQuery.sumRange(sIndex, eIndex));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        LC307RangeSumQueryMutable rangeSumQuery = null;
// // Approach 1 - Brute Force
// rangeSumQuery = new LC307RangeSumQueryMutable(Approach.BRUTE_FORCE, nums);
// rangeSumQuery.testRangeSumQuery();
// System.out.println();
//
// // Approach 2 - Prefix Sum
// nums = new int[]{1, 2, 3, 4, 5};
// rangeSumQuery = new LC307RangeSumQueryMutable(Approach.PREFIX_SUM, nums);
// rangeSumQuery.testRangeSumQuery();
// System.out.println();

        // Approach 3 - Segment Tree
// int nums = new int[]{1, 2, 3, 4, 5};
        nums = new int[]{1, 2, 3};
        rangeSumQuery = new LC307RangeSumQueryMutable(Approach.SEGMENT_TREE, nums);
        rangeSumQuery.testRangeSumQuery();
    }

}
