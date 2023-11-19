package com.devamatre.theorem.adts.tree;

import com.devamatre.appsuite.core.ToString;

import java.util.Arrays;

/**
 * Segment Tree is a basically a binary tree used for storing the intervals or segments. Each node in the Segment Tree
 * represents an interval. So in each step, the segment is divided into half and the two children represent those two
 * halves.
 * <p>
 * Once the Segment Tree is built, its structure cannot be changed. We can update the values of nodes but we cannot
 * change its structure.
 * <p>
 * Segment tree provides two operations:
 * <p>
 * Update: To update the element of the array A and reflect the corresponding change in the Segment tree.
 * <p>
 * Query: In this operation we can query on an interval or segment and return the answer to the problem (say
 * minimum/maximum/summation in the particular segment).
 * <p>
 * <p>
 * Implementation:
 * <p>
 * Since a Segment Tree is a binary tree, a simple linear array can be used to represent the Segment Tree.
 * <p>
 * Before building the Segment Tree, one must figure <b></b>what needs to be stored in the Segment Tree's node?</b>.
 * <p>
 * For example, if the question is to find the sum of all the elements in an array from indices L to R , then at each
 * node (except leaf nodes) the sum of its children nodes is stored.
 *
 * @author Rohtash Lakra
 * @created 10/11/23 18:38 PM
 */
public class SegmentTree<T> {

    private int[] input;
    private int[] tree;
    private int capacity;

    /**
     * Building to get the sum of all the nodes between the l and r nodes.
     * <p>
     * Time Complexity: O(N)
     *
     * @param nodeIndex
     * @param startIndex
     * @param endIndex
     */
    private void buildSegmentTree(int nodeIndex, int startIndex, int endIndex) {
        // If there is one element in array, store it in current node of segment tree and return
        if (startIndex == endIndex) {
            // leaf node contains only single element
            tree[nodeIndex] = input[startIndex];
        } else {
            int mid = TreeUtils.getMidIndex(startIndex, endIndex);    // find interval/segment nodeIndex
            // recursive on the left node
            buildSegmentTree(TreeUtils.leftNodeIndex(nodeIndex), startIndex, mid);
            // recursive on the right node
            buildSegmentTree(TreeUtils.rightNodeIndex(nodeIndex), mid + 1, endIndex);
            // interval node should have the sum of its children nodes
            tree[nodeIndex] = tree[TreeUtils.leftNodeIndex(nodeIndex)] + tree[TreeUtils.rightNodeIndex(nodeIndex)];
        }
    }

    /**
     * @param input
     */
    public void buildSegmentTree(int[] input) {
        this.input = input;
        // Allocate memory for segment tree
        this.capacity = TreeUtils.getMemoryAllotmentByInputSize(input.length); // Maximum size of segment tree
        this.tree = new int[capacity]; // Memory allocation

        buildSegmentTree(0, 0, input.length - 1);
    }

    /**
     * Time Complexity: O(log N)
     *
     * @param nodeIndex
     * @param startIndex
     * @param endIndex
     * @param updateIndex
     * @param value
     */
    private void updateSegmentTree(int nodeIndex, int startIndex, int endIndex, int updateIndex, int value) {
        if (startIndex == endIndex) {
            // leaf node contains only single element
            input[updateIndex] = value;
            tree[nodeIndex] = value;
        } else {
            int mid = TreeUtils.getMidIndex(startIndex, endIndex);    // find interval/segment nodeIndex
            if (startIndex <= updateIndex && updateIndex <= mid) {    // check if updateIndex is of the left child
                // recursive on the left node
                updateSegmentTree(TreeUtils.leftNodeIndex(nodeIndex), startIndex, mid, updateIndex, value);
            } else {     // updateIndex is of the right child
                // recursive on the right node
                updateSegmentTree(TreeUtils.rightNodeIndex(nodeIndex), mid + 1, endIndex, updateIndex, value);
            }

            // interval node should have the sum of its children nodes
            tree[nodeIndex] = tree[TreeUtils.leftNodeIndex(nodeIndex)] + tree[TreeUtils.rightNodeIndex(nodeIndex)];
        }
    }

    /**
     * @param index
     * @param value
     */
    public void update(int index, int value) {
        // Check for erroneous input index
        if (index < 0 || index > input.length - 1) {
            System.out.println("Invalid Index! index: " + index);
            return;
        }
        updateSegmentTree(0, 0, input.length, index, value);
    }

    /**
     * @param index
     * @return
     */
    public int exists(int index) {
        return -1;
    }


    /**
     * To query on a given range, check 3 conditions:
     * <pre>
     *  1. Range represented by a node is completely outside the given range
     *  2. Range represented by a node is completely inside the given range
     *  3. Range represented by a node is partially inside and partially outside the given range
     * </pre>
     * <p>
     * If the range represented by a node is completely outside the given range, simply return 0. If the range
     * represented by a node is completely within the given range, return the value of the node which is the sum of all
     * the elements in the range represented by the node. And if the range represented by a node is partially inside and
     * partially outside the given range, return sum of the left child and the right child.
     * <p>
     * Time Complexity: O(log N)
     *
     * @param nodeIndex
     * @param startIndex
     * @param endIndex
     * @param queryStartIndex
     * @param queryEndIndex
     */
    private int getRangeSum(int nodeIndex, int startIndex, int endIndex, int queryStartIndex, int queryEndIndex) {
        // 1. range represented by a node is completely outside the given range
        if (endIndex < queryStartIndex || startIndex > queryEndIndex) {
            return 0;
        }

        // 2. range represented by a node is completely inside the given range
        if (queryStartIndex <= startIndex && queryEndIndex >= endIndex) {
            return tree[nodeIndex];
        }

        // 3. Range represented by a node is partially inside and partially outside the given range
        int mid = TreeUtils.getMidIndex(startIndex, endIndex);    // find interval/segment nodeIndex
        // recursive on the left node
        int
            leftValue =
            getRangeSum(TreeUtils.leftNodeIndex(nodeIndex), startIndex, mid, queryStartIndex, queryEndIndex);
        // recursive on the right node
        int
            rightValue =
            getRangeSum(TreeUtils.rightNodeIndex(nodeIndex), mid + 1, endIndex, queryStartIndex, queryEndIndex);
        return (leftValue + rightValue);
    }

    /**
     * Returns the sum of the elements between the range (start and end).
     *
     * @param start
     * @param end
     * @return
     */
    public int getRangeSum(int start, int end) {
        // validate the input index
        if (start < 0 || end > input.length - 1 || start > end) {
            System.out.println("Invalid Indices! start:" + start + ", end:" + end);
            return 0;
        }

        return getRangeSum(0, 0, input.length - 1, start, end);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return ToString.of(SegmentTree.class, false, ToString.DELIMITER)
            .add("input", Arrays.toString(input))
            .add("tree", Arrays.toString(tree))
            .toString();
    }
}
