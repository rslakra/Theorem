package com.rslakra.theorem.leetcode.array;

public class LC1027LongestArithmeticSubsequence {

    /**
     * Create a map for each index. And Check if the map at index contains the difference.
     *
     * <pre>
     *  Input: A = [9,4,7,2,10]
     *  Output: 3
     *  Explanation:
     *  The longest arithmetic subsequence is [4,7,10].
     * </pre>
     *
     * <pre>
     *  Map<difference, noOfElements>
     *  map(0) = {}
     *  map(1) = {
     *      -5, 2
     *  }
     *  map(2) = {
     *      -2, 2
     *      3, 2
     *  }
     *  map(3) = {
     *      -7, 2
     *      -2, 2
     *      -5, 2
     *  }
     *  map(4) = {
     *      1, 2
     *      6, 2
     *      3, 3
     *      8, 2
     *  }
     * </pre>
     * The largest value is 3, 3 in map(4) so return that value 3 as output (build 4, 7, 10)
     *
     * @param A
     * @return
     */
    public int longestArithSeqLength(int[] A) {
        return -1;
    }
}
